package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.resources.DependenciasFolhaPagamento;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.folhapagamento.CalcularFolhaPagamento;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.FpPeriodoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpCalcularBean {

    private FpTipoFolha fpTipoFolha;
    private FpPeriodo fpPeriodo = new FpPeriodo();
    private List<FpPeriodo> todosFpPeriodo;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    @ManagedProperty("#{dependenciasFolhaPagamento}")
    private DependenciasFolhaPagamento dependenciasFolhaPagamento;

    @ManagedProperty("#{fpCalcularFolhaPagamento}")
    private CalcularFolhaPagamento fpCalcularFolhaPagamento;

    public FpCalcularBean() {

    }

    public void selecionarTipoFolha() {
    }

    public void selecionarPeriodo() {
    }

    public void salvarDadosDependentes() {
        dependenciasFolhaPagamento.salvarTudo();
    }

    public void calcularFolhaPagamento() {
        if (fpPeriodo.getPerId() == 0) {
            Helper.mostrarNotificacao("Calcular folha", "Selecione um período. Se necessário, cadastre um novo.", "info");
            return;
        }

        fpPeriodo = fpPeriodoService.findById(fpPeriodo.getPerId());
        
    }

    public FpTipoFolha getFpTipoFolha() {
        return fpTipoFolha;
    }

    public void setFpTipoFolha(FpTipoFolha fpTipoFolha) {
        this.fpTipoFolha = fpTipoFolha;
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

    public void setTodosFpPeriodo(List<FpPeriodo> todosFpPeriodo) {
        this.todosFpPeriodo = todosFpPeriodo;
    }

    public FpPeriodoService getFpPeriodoService() {
        return fpPeriodoService;
    }

    public void setFpPeriodoService(FpPeriodoService fpPeriodoService) {
        this.fpPeriodoService = fpPeriodoService;
    }

    public DependenciasFolhaPagamento getDependenciasFolhaPagamento() {
        return dependenciasFolhaPagamento;
    }

    public void setDependenciasFolhaPagamento(DependenciasFolhaPagamento dependenciasFolhaPagamento) {
        this.dependenciasFolhaPagamento = dependenciasFolhaPagamento;
    }

    public CalcularFolhaPagamento getFpCalcularFolhaPagamento() {
        return fpCalcularFolhaPagamento;
    }

    public void setFpCalcularFolhaPagamento(CalcularFolhaPagamento fpCalcularFolhaPagamento) {
        this.fpCalcularFolhaPagamento = fpCalcularFolhaPagamento;
    }

}
