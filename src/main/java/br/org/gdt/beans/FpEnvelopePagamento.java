package br.org.gdt.beans;

import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.folhapagamento.CalcularFolha;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.RecPessoaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpEnvelopePagamento {

    private boolean mostrarTodasFolhasPeriodo = false;
    private FpPeriodo fpPeriodo = new FpPeriodo();
    private RecPessoa recPessoa = new RecPessoa();
    private FpFolhaPeriodo fpFolhaPeriodo = new FpFolhaPeriodo();

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
            Helper.mostrarNotificacao("Folha período", "Folha não encontrada para esta pessoa.", "info");
            folhaPeriodo = new FpFolhaPeriodo();
        }
        fpFolhaPeriodo = folhaPeriodo;
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
