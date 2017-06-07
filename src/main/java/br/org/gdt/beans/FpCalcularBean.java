package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.enums.LogModulo;
import br.org.gdt.model.FpEvento;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.folhapagamento.CalcularFolha;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.LogService;
import br.org.gdt.service.RecPessoaService;
import br.org.gdt.service.folhapagamento.DadosCalculadosDoFuncionario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpCalcularBean {

    private boolean gerarTodasPessoas;
    private FpPeriodo fpPeriodo = new FpPeriodo();
    private RecPessoa recPessoa = new RecPessoa();
    private FpTipoFolha fpTipoFolha;
    private List<FpPeriodo> todosFpPeriodo;
    private FpEventoPeriodo fpEventoPeriodo = new FpEventoPeriodo();
    private List<FpEventoPeriodo> todosFpEventoPeriodo = new ArrayList<>();

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

    @ManagedProperty("#{logService}")
    private LogService logService;

    public FpCalcularBean() {
    }

    public void selecionarEvento() {
        FpEvento fpEvento = fpEventoService.findById(fpEventoPeriodo.getEvpEvento().getEveId());
        if (fpEvento == null) {
            Helper.mostrarNotificacao("Evento variável", "O evento não existe.", "error");
            fpEvento = new FpEvento();
        }
        fpEventoPeriodo.setEvpEvento(fpEvento);
    }

    public void selecionarTipoFolha() {
    }

    public void selecionarPeriodo() {
    }

    public void adicionarEvento() {
        if (fpEventoPeriodo.getEvpEvento().getEveId() <= 0) {
            Helper.mostrarNotificacao("Evento variável", "Selecione um evento.", "error");
            return;
        }

        if (todosFpEventoPeriodo.stream()
                .filter(x -> x.getEvpEvento().getEveId() == fpEventoPeriodo.getEvpEvento().getEveId())
                .count() > 0) {
            Helper.mostrarNotificacao("Evento variável", "Evento já adicionado.", "error");
            return;
        }

        fpEventoPeriodo.setEvpEventoPadrao(false);
        todosFpEventoPeriodo.add(fpEventoPeriodo);
        fpEventoPeriodo = new FpEventoPeriodo();
    }

    public void removerEvento(FpEventoPeriodo fpEventoPeriodo) {
        todosFpEventoPeriodo = todosFpEventoPeriodo.stream()
                .filter(x -> x.getEvpEvento().getEveId() != fpEventoPeriodo.getEvpEvento().getEveId())
                .collect(Collectors.toList());
    }

    public void editarEvento(FpEventoPeriodo eventoPeriodo) {
        removerEvento(eventoPeriodo);
        this.fpEventoPeriodo = eventoPeriodo;
    }

    public void selecionarPessoa() {
        RecPessoa pessoa = recPessoaService.BuscarId((int) recPessoa.getRecIdpessoa());
        if (pessoa == null) {
            Helper.mostrarNotificacao("Dados inválidos", "A pessoa não existe.", "error");
            recPessoa = new RecPessoa();
            return;
        }
        recPessoa = pessoa;
    }

    public void calcularFolhaPagamento() {
        if (fpPeriodo.getPerId() <= 0) {
            Helper.mostrarNotificacao("Calcular folha", "Selecione um período. Se necessário, cadastre um novo.", "error");
            return;
        }
        fpPeriodo = fpPeriodoService.findById(fpPeriodo.getPerId());
        if (gerarTodasPessoas) {
            try {
                calcularFolha.calcularParaTodosFuncionarios(fpPeriodo);
                logService.log(LogModulo.FolhaPagamento, "Folhas de pagamento calculadas.");
                Helper.mostrarNotificacao("Calcular folha", "Folhas de pagamento calculadas.", "success");
            } catch (RuntimeException e) {
                Helper.mostrarNotificacao("Calcular folha", e.getMessage(), "error");
            }
        } else {
            try {

                todosFpEventoPeriodo.forEach(x -> x.setJaCalculado(false));

                DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario = new DadosCalculadosDoFuncionario();
                dadosCalculadosDoFuncionario.setDeletarJaCalculada(true);
                dadosCalculadosDoFuncionario.setPeriodo(fpPeriodo);

                if (recPessoa.getRecIdpessoa() <= 0) {
                    Helper.mostrarNotificacao("Dados inválidos", "Selecione um colaborador.", "error");
                    return;
                }
                dadosCalculadosDoFuncionario.setPessoa(recPessoa);
                dadosCalculadosDoFuncionario.setEventos(todosFpEventoPeriodo);

                calcularFolha.calcularFolhaPagamentoFuncionario(dadosCalculadosDoFuncionario);

                logService.log(LogModulo.FolhaPagamento, "Folha de pagamento calculada para pessoa " + recPessoa.getRecIdpessoa() + ".");
                todosFpEventoPeriodo = new ArrayList<>();
                recPessoa = new RecPessoa();
                fpEventoPeriodo = new FpEventoPeriodo();
                Helper.mostrarNotificacao("Calcular folha", "Folha de pagamento calculada.", "success");
            } catch (Exception e) {

                todosFpEventoPeriodo = new ArrayList<>();
                Helper.mostrarNotificacao("Calcular folha", e.getMessage(), "error");
            }
        }
    }

    public void buscarEventosPessoaPeriodo() {
        if (fpPeriodo.getPerId() <= 0) {
            Helper.mostrarNotificacao("Calcular folha", "Selecione um período. Se necessário, cadastre um novo.", "error");
            return;
        }
        if (recPessoa.getRecIdpessoa() <= 0) {
            Helper.mostrarNotificacao("Dados inválidos", "Selecione um colaborador.", "error");
            return;
        }
        FpFolhaPeriodo fpFolhaPeriodo = fpFolhaPeriodoService.findByPessoaEPeriodo(fpPeriodo, recPessoa);
        if (fpFolhaPeriodo == null) {
            todosFpEventoPeriodo = new ArrayList<>();
        } else {
            List<FpEventoPeriodo> eventosPadraoPeriodo = fpFolhaPeriodo.getForEventos().stream()
                    .filter(x -> !x.isEvpEventoPadrao())
                    .collect(Collectors.toList());
            eventosPadraoPeriodo.forEach(x -> x.setEvpValor(0));
            todosFpEventoPeriodo = eventosPadraoPeriodo;
        }
    }

    public boolean isGerarTodasPessoas() {
        return gerarTodasPessoas;
    }

    public void setGerarTodasPessoas(boolean gerarTodasPessoas) {
        this.gerarTodasPessoas = gerarTodasPessoas;
    }

    public FpPeriodo getFpPeriodo() {
        return fpPeriodo;
    }

    public void setFpPeriodo(FpPeriodo fpPeriodo) {
        this.fpPeriodo = fpPeriodo;
    }

    public FpTipoFolha getFpTipoFolha() {
        return fpTipoFolha;
    }

    public void setFpTipoFolha(FpTipoFolha fpTipoFolha) {
        this.fpTipoFolha = fpTipoFolha;
    }

    public List<FpPeriodo> getTodosFpPeriodo() {
//        if (todosFpPeriodo == null) {
//            todosFpPeriodo = fpPeriodoService.findAll();
//        }
//        return todosFpPeriodo;
        return fpPeriodoService.findAllPeriodoNaoPago();
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public void setTodosFpPeriodo(List<FpPeriodo> todosFpPeriodo) {
        this.todosFpPeriodo = todosFpPeriodo;
    }

    public FpEventoPeriodo getFpEventoPeriodo() {
        if (fpEventoPeriodo.getEvpEvento() == null) {
            fpEventoPeriodo.setEvpEvento(new FpEvento());
        }
        return fpEventoPeriodo;
    }

    public void setFpEventoPeriodo(FpEventoPeriodo fpEventoPeriodo) {
        this.fpEventoPeriodo = fpEventoPeriodo;
    }

    public List<FpEventoPeriodo> getTodosFpEventoPeriodo() {
        return todosFpEventoPeriodo;
    }

    public void setTodosFpEventoPeriodo(List<FpEventoPeriodo> todosFpEventoPeriodo) {
        this.todosFpEventoPeriodo = todosFpEventoPeriodo;
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

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

}
