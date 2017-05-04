package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.model.FpEventoVariavel;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoVariavelService;
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

    public FpCalcularBean() {

    }

    public void selecionarTipoFolha() {
    }

    public void selecionarPeriodo() {
        int a = 0;   
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
        if (todosFpPeriodo == null) {
            todosFpPeriodo = fpPeriodoService.findAll();
        }
        return todosFpPeriodo;
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

}
