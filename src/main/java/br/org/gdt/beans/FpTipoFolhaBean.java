package br.org.gdt.beans;

import br.org.gdt.model.FpEvento;
import br.org.gdt.model.FpTipoFolha;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpTipoFolhaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpTipoFolhaBean {

    private boolean formAtivo = false;

    private long eventoCodigo;

    private FpTipoFolha fpTipoFolha = new FpTipoFolha();
    private List<FpTipoFolha> todosFpTiposFolha;

    @ManagedProperty("#{fpTipoFolhaService}")
    private FpTipoFolhaService fpTipoFolhaService;

    @ManagedProperty("#{fpEventoService}")
    private FpEventoService fpEventoService;

    public FpTipoFolhaBean() {

    }

    public void save() {
        if (fpTipoFolha.getTipoEventos().size() <= 0) {
            Helper.setMensagemDeErro("Nenhum evento relacionado.");
            return;
        }
        
        if (fpTipoFolha.getTipoId() > 0) {
            fpTipoFolhaService.update(fpTipoFolha);
        } else {
            fpTipoFolhaService.save(fpTipoFolha);
        }
        todosFpTiposFolha = fpTipoFolhaService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpTipoFolha = new FpTipoFolha();
    }

    public void add() {
        this.formAtivo = true;
        this.fpTipoFolha = new FpTipoFolha();
        this.eventoCodigo = 0;
    }

    public void addEvento() {
        FpEvento fpEvento = fpEventoService.findById(eventoCodigo);
        if (fpEvento == null) {
            Helper.mostrarNotificacao("Evento", "O evento não existe.", "error");
        } else if (fpEvento.isEveEventoVariavel()) {
            Helper.mostrarNotificacao("Evento", "O evento não pode ser variável.", "error");
        } else {
            boolean hasEvento = false;
            for (FpEvento e : fpTipoFolha.getTipoEventos()) {
                if (e.getEveId() == fpEvento.getEveId()) {
                    hasEvento = true;
                    break;
                }
            }
            if (hasEvento) {
                Helper.mostrarNotificacao("Evento", "Evento já adicionado.", "info");
            } else {
                this.fpTipoFolha.getTipoEventos().add(fpEvento);
                this.eventoCodigo = 0;
            }
        }
    }

    public void removerEvento(int index) {
        this.fpTipoFolha.getTipoEventos().remove(index);
    }

    public String excluir(FpTipoFolha fpTipoFolha) {
        fpTipoFolhaService.delete(fpTipoFolha.getTipoId());
        todosFpTiposFolha.remove(fpTipoFolha);
        return "tiposfolha";
    }

    public String prepareEdit(FpTipoFolha fpTipoFolha) {
        this.formAtivo = true;
        this.fpTipoFolha = fpTipoFolha;
        return "tiposfolha";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public FpTipoFolha getFpTipoFolha() {
        return fpTipoFolha;
    }

    public void setFpTipoFolha(FpTipoFolha fpTipoFolha) {
        this.fpTipoFolha = fpTipoFolha;
    }

    public List<FpTipoFolha> getTodosFpTiposFolha() {
        if (todosFpTiposFolha == null) {
            todosFpTiposFolha = fpTipoFolhaService.findAll();
        }
        return todosFpTiposFolha;
    }

    public void setTodosFpTiposFolha(List<FpTipoFolha> todosFpTiposFolha) {
        this.todosFpTiposFolha = todosFpTiposFolha;
    }

    public FpTipoFolhaService getFpTipoFolhaService() {
        return fpTipoFolhaService;
    }

    public void setFpTipoFolhaService(FpTipoFolhaService fpTipoFolhaService) {
        this.fpTipoFolhaService = fpTipoFolhaService;
    }

    public FpEventoService getFpEventoService() {
        return fpEventoService;
    }

    public void setFpEventoService(FpEventoService fpEventoService) {
        this.fpEventoService = fpEventoService;
    }

    public long getEventoCodigo() {
        return eventoCodigo;
    }

    public void setEventoCodigo(long eventoCodigo) {
        this.eventoCodigo = eventoCodigo;
    }

}
