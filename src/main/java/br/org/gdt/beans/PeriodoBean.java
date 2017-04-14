package br.org.gdt.beans;

import br.org.gdt.model.Periodo;
import br.org.gdt.service.PeriodoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PeriodoBean {

    private boolean formAtivo = false;

    private Periodo periodo = new Periodo();
    private List<Periodo> todosPeriodos;

    @ManagedProperty("#{periodoService}")
    private PeriodoService periodoService;

    public PeriodoBean() {

    }

    public void save() {
        if (periodo.getId() > 0) {
            periodoService.update(periodo);
        } else {
            periodoService.save(periodo);
        }
        todosPeriodos = periodoService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.periodo = new Periodo();
    }

    public void add() {
        this.formAtivo = true;
        this.periodo = new Periodo();
    }

    public String excluir(Periodo periodo) {
        periodoService.delete(periodo.getId());
        todosPeriodos.remove(periodo);
        return "periodo";
    }

    public String prepareEdit(Periodo periodo) {
        this.formAtivo = true;
        this.periodo = periodo;
        return "periodo";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Periodo> getTodosPeriodos() {
        if (periodo == null) {
            todosPeriodos = periodoService.findAll();
        }
        return todosPeriodos;
    }

    public void setTodosPeriodos(List<Periodo> todosPeriodos) {
        this.todosPeriodos = todosPeriodos;
    }

    public PeriodoService getPeriodoService() {
        return periodoService;
    }

    public void setPeriodoService(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

}
