package br.org.gdt.beans;

import br.org.gdt.model.FpPeriodo;
import br.org.gdt.service.FpPeriodoService;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpPeriodoBean {

    private boolean formAtivo = false;

    private FpPeriodo fpPeriodo = new FpPeriodo();
    private List<FpPeriodo> todosFpPeriodo;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    public FpPeriodoBean() {

    }

    public void save() {
        if (fpPeriodo.getPerId() > 0) {
            fpPeriodoService.update(fpPeriodo);
        } else {
            fpPeriodoService.save(fpPeriodo);
        }
        todosFpPeriodo = fpPeriodoService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpPeriodo = new FpPeriodo();
    }

    public void add() {
        this.formAtivo = true;
        this.fpPeriodo = new FpPeriodo();
    }

    public String excluir(FpPeriodo fpPeriodo) {
        fpPeriodoService.delete(fpPeriodo.getPerId());
        todosFpPeriodo.remove(fpPeriodo);
        return "periodos";
    }

    public String prepareEdit(FpPeriodo fpPeriodo) {
        this.formAtivo = true;
        this.fpPeriodo = fpPeriodo;
        return "periodos";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
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
