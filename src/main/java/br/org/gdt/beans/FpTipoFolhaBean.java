package br.org.gdt.beans;

import br.org.gdt.model.FpTipoFolha;
import br.org.gdt.service.FpTipoFolhaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpTipoFolhaBean {

    private boolean formAtivo = false;

    private FpTipoFolha fpTipoFolha = new FpTipoFolha();
    private List<FpTipoFolha> todosFpTiposFolha;

    @ManagedProperty("#{fpTipoFolhaService}")
    private FpTipoFolhaService fpTipoFolhaService;

    public FpTipoFolhaBean() {

    }

    public void save() {
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

}
