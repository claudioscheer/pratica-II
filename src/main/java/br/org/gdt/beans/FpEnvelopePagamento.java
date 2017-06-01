package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.folhapagamento.CalcularFolha;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.RecPessoaService;
import br.org.gdt.service.folhapagamento.DadosCalculadosDoFuncionario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FpEnvelopePagamento implements java.io.Serializable {

    private boolean mostrarTodasFolhasPeriodo = false;
    private FpPeriodo fpPeriodo = new FpPeriodo();
    private RecPessoa recPessoa = new RecPessoa();
    private FpFolhaPeriodo fpFolhaPeriodo = new FpFolhaPeriodo();
    private FpTipoFolha fpTipoFolha;
    private List<FpEventoPeriodo> todosEventosFolhaPeriodo = new ArrayList<>();

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    @ManagedProperty("#{calcularFolha}")
    private CalcularFolha calcularFolha;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    @ManagedProperty("#{fpEventoService}")
    private FpEventoService fpEventoService;

    @ManagedProperty("#{fpFolhaPeriodoService}")
    private FpFolhaPeriodoService fpFolhaPeriodoService;

    public FpEnvelopePagamento() {

    }

    public void mostrarTodasFolhasPeriodo() {
        if (fpPeriodo.getPerId() <= 0) {
            Helper.mostrarNotificacao("Período", "Selecione um período.", "info");
            return;
        }

        mostrarTodasFolhasPeriodo = true;
    }

    public void selecionarTipoFolha() {
    }

    public void selecionarPeriodo() {
    }

    public void selecionarPessoa() {
        RecPessoa pessoa = recPessoaService.BuscarId((int) recPessoa.getRecIdpessoa());
        if (pessoa == null) {
            Helper.mostrarNotificacao("Dados inválidos", "A pessoa não existe.", "info");
            recPessoa = new RecPessoa();
            return;
        }
        recPessoa = pessoa;
    }

    public void buscarFolhaPeriodo() {
        if (recPessoa.getRecIdpessoa() <= 0) {
            Helper.mostrarNotificacao("Pessoa", "Selecione uma pessoa.", "info");
            return;
        }

        if (fpPeriodo.getPerId() <= 0) {
            Helper.mostrarNotificacao("Período", "Selecione um período.", "info");
            return;
        }

        FpFolhaPeriodo folhaPeriodo = fpFolhaPeriodoService.findByPessoaEPeriodo(fpPeriodo, recPessoa);
        if (folhaPeriodo == null) {
            Helper.mostrarNotificacao("Folha", "Folha não encontrada para esta pessoa.", "info");
            folhaPeriodo = new FpFolhaPeriodo();
        }
        fpFolhaPeriodo = folhaPeriodo;
        todosEventosFolhaPeriodo = folhaPeriodo.getForEventos().stream()
                .filter(x -> !x.getEvpEvento().isEveNaoAlteraFolha())
                .collect(Collectors.toList());
    }

    public void recalcularFolhaPeriodo() {
        try {
            DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario = new DadosCalculadosDoFuncionario();
            dadosCalculadosDoFuncionario.setPeriodo(fpPeriodo);
            dadosCalculadosDoFuncionario.setRecalculando(true);

            if (recPessoa.getRecIdpessoa() <= 0) {
                Helper.mostrarNotificacao("Dados inválidos", "Selecione um colaborador.", "info");
                return;
            }
            dadosCalculadosDoFuncionario.setPessoa(recPessoa);

            List<FpEventoPeriodo> eventosVerificados = verificarEventosAjustadosManualmente();
            eventosVerificados.forEach(x -> x.setJaCalculado(false));

            dadosCalculadosDoFuncionario.setEventos(eventosVerificados);

            fpFolhaPeriodo = calcularFolha.calcularFolhaPagamentoFuncionario(dadosCalculadosDoFuncionario);
            todosEventosFolhaPeriodo = fpFolhaPeriodo.getForEventos().stream()
                    .filter(x -> !x.getEvpEvento().isEveNaoAlteraFolha())
                    .collect(Collectors.toList());

            Helper.mostrarNotificacao("Calcular folha", "Folha de pagamento recalculada.", "info");
        } catch (Exception e) {
            Helper.mostrarNotificacao("Calcular folha", e.getMessage(), "info");
        }
    }

    private List<FpEventoPeriodo> verificarEventosAjustadosManualmente() {

        fpFolhaPeriodo.getForEventos().forEach((eventoOriginal) -> {
            Optional<FpEventoPeriodo> optionalEventoAlterado = todosEventosFolhaPeriodo.stream()
                    .filter(x -> x.getEvpEvento().getEveId() == eventoOriginal.getEvpEvento().getEveId())
                    .findFirst();

            if (!optionalEventoAlterado.isPresent()) {
                return;
            }

            FpEventoPeriodo eventoAlterado = optionalEventoAlterado.get();

            eventoOriginal.setEventoAlteradoManualmente(eventoOriginal.getEvpValorReferencia() != eventoAlterado.getEvpValorReferencia()
                    || eventoOriginal.getEvpValor() != eventoAlterado.getEvpValor());
        });

        return fpFolhaPeriodo.getForEventos();
    }

    public void gerarFolhaPagamento() {
        try {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("pessoa", "Claudio Roberto Scheer Junior");

            Helper.gerarBaixarRelatorioPDF("folha-pagamento", "/folhapagamento/relatorio/folha.jasper", parametros, fpFolhaPeriodo.getForEventos());
        } catch (Exception e) {
            Helper.mostrarNotificacao("Relatório", e.getMessage(), "error");
        }
    }

    public boolean isMostrarTodasFolhasPeriodo() {
        return mostrarTodasFolhasPeriodo;
    }

    public void setMostrarTodasFolhasPeriodo(boolean mostrarTodasFolhasPeriodo) {
        this.mostrarTodasFolhasPeriodo = mostrarTodasFolhasPeriodo;
    }

    public FpPeriodo getFpPeriodo() {
        return fpPeriodo;
    }

    public void setFpPeriodo(FpPeriodo fpPeriodo) {
        this.fpPeriodo = fpPeriodo;
    }

    public List<FpPeriodo> getTodosFpPeriodo() {
//        if (todosFpPeriodo == null) {
//            todosFpPeriodo = fpPeriodoService.findAll();
//        }
//        return todosFpPeriodo;
        return fpPeriodoService.findAll();
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public FpFolhaPeriodo getFpFolhaPeriodo() {
        return fpFolhaPeriodo;
    }

    public void setFpFolhaPeriodo(FpFolhaPeriodo fpFolhaPeriodo) {
        this.fpFolhaPeriodo = fpFolhaPeriodo;
    }

    public FpTipoFolha getFpTipoFolha() {
        return fpTipoFolha;
    }

    public void setFpTipoFolha(FpTipoFolha fpTipoFolha) {
        this.fpTipoFolha = fpTipoFolha;
    }

    public List<FpEventoPeriodo> getTodosEventosFolhaPeriodo() {
        return todosEventosFolhaPeriodo;
    }

    public void setTodosEventosFolhaPeriodo(List<FpEventoPeriodo> todosEventosFolhaPeriodo) {
        this.todosEventosFolhaPeriodo = todosEventosFolhaPeriodo;
    }

    public FpPeriodoService getFpPeriodoService() {
        return fpPeriodoService;
    }

    public void setFpPeriodoService(FpPeriodoService fpPeriodoService) {
        this.fpPeriodoService = fpPeriodoService;
    }

    public CalcularFolha getCalcularFolha() {
        return calcularFolha;
    }

    public void setCalcularFolha(CalcularFolha calcularFolha) {
        this.calcularFolha = calcularFolha;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public FpEventoService getFpEventoService() {
        return fpEventoService;
    }

    public void setFpEventoService(FpEventoService fpEventoService) {
        this.fpEventoService = fpEventoService;
    }

    public FpFolhaPeriodoService getFpFolhaPeriodoService() {
        return fpFolhaPeriodoService;
    }

    public void setFpFolhaPeriodoService(FpFolhaPeriodoService fpFolhaPeriodoService) {
        this.fpFolhaPeriodoService = fpFolhaPeriodoService;
    }

}
