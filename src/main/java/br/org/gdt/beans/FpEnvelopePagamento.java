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
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

@ManagedBean
@SessionScoped
public class FpEnvelopePagamento implements java.io.Serializable {

    private boolean mostrarTodasFolhasPeriodo = false;
    private FpPeriodo fpPeriodo = new FpPeriodo();
    private RecPessoa recPessoa = new RecPessoa();
    private FpFolhaPeriodo fpFolhaPeriodo = new FpFolhaPeriodo();
    private FpTipoFolha fpTipoFolha;

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
    }

    public void recalcularFolhaPeriodo() {
        try {
            DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario = new DadosCalculadosDoFuncionario();
            dadosCalculadosDoFuncionario.setRecalcular(true);
            dadosCalculadosDoFuncionario.setPeriodo(fpPeriodo);

            if (recPessoa.getRecIdpessoa() <= 0) {
                Helper.mostrarNotificacao("Dados inválidos", "Selecione um colaborador.", "info");
                return;
            }
            dadosCalculadosDoFuncionario.setPessoa(recPessoa);
            dadosCalculadosDoFuncionario.setEventos(fpFolhaPeriodo.getForEventos());

            fpFolhaPeriodo = calcularFolha.calcularFolhaPagamentoFuncionario(dadosCalculadosDoFuncionario);

            Helper.mostrarNotificacao("Calcular folha", "Folha de pagamento recalculada.", "info");
        } catch (Exception e) {
            Helper.mostrarNotificacao("Calcular folha", e.getMessage(), "info");
        }
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
