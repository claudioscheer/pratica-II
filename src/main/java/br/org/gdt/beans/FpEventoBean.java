package br.org.gdt.beans;

import br.org.gdt.model.FpEvento;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FpEventoBean {

    private boolean formAtivo = false;

    private FpEvento fpEvento = new FpEvento();
    private List<FpEvento> todosFpEvento;

    @ManagedProperty("#{fpEventoService}")
    private FpEventoService fpEventoService;

    public void save() {
        if (fpEvento.getEveId() > 0) {
            fpEventoService.update(fpEvento);
        } else {
            fpEvento.setEvePermiteExcluir(true);
            fpEventoService.save(fpEvento);
        }
        todosFpEvento = fpEventoService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpEvento = new FpEvento();
    }

    public void add() {
        this.formAtivo = true;
        this.fpEvento = new FpEvento();
    }

    public void excluir(FpEvento fpEvento) {
        if (!fpEvento.isEvePermiteExcluir()) {
            Helper.mostrarNotificacao("Evento", "Evento não pode ser excluído.", "error");
        } else {
            fpEventoService.delete(fpEvento.getEveId());
            todosFpEvento.remove(fpEvento);
        }
    }

    public void prepareEdit(FpEvento fpEvento) {
        this.formAtivo = true;
        this.fpEvento = fpEvento;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public FpEvento getFpEvento() {
        return fpEvento;
    }

    public void setFpEvento(FpEvento fpEvento) {
        this.fpEvento = fpEvento;
    }

    public List<FpEvento> getTodosFpEvento() {
        if (todosFpEvento == null) {
            todosFpEvento = fpEventoService.findAll();
        }
        return todosFpEvento;
    }

    public void setTodosFpEvento(List<FpEvento> todosFpEvento) {
        this.todosFpEvento = todosFpEvento;
    }

    public FpEventoService getFpEventoService() {
        return fpEventoService;
    }

    public void setFpEventoService(FpEventoService fpEventoService) {
        this.fpEventoService = fpEventoService;
    }

}
