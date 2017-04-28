package br.org.gdt.beans;

import br.org.gdt.model.FpEventoVariavel;
import br.org.gdt.service.FpEventoVariavelService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpEventoVariavelBean {

    private boolean formAtivo = false;
    private long codigoFuncionario = 0;

    private FpEventoVariavel fpEventoVariavel = new FpEventoVariavel();
    private List<FpEventoVariavel> todosFpEventoVariavel;

    @ManagedProperty("#{fpEventoVariavelService}")
    private FpEventoVariavelService fpEventoVariavelService;

    public FpEventoVariavelBean() {

    }

    public void save() {
        if (fpEventoVariavel.getEvvId() > 0) {
            fpEventoVariavelService.update(fpEventoVariavel);
        } else {
            fpEventoVariavelService.save(fpEventoVariavel);
        }
        todosFpEventoVariavel = fpEventoVariavelService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpEventoVariavel = new FpEventoVariavel();
    }

    public void buscarEventos() {
        this.formAtivo = true;
        this.fpEventoVariavel = new FpEventoVariavel();
    }

    public String excluir(FpEventoVariavel fpEventoVariavel) {
        fpEventoVariavelService.delete(fpEventoVariavel.getEvvId());
        todosFpEventoVariavel.remove(fpEventoVariavel);
        return "eventosvariaveis";
    }

    public String prepareEdit(FpEventoVariavel fpEventoVariavel) {
        this.formAtivo = true;
        this.fpEventoVariavel = fpEventoVariavel;
        return "eventosvariaveis";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public long getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(long codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public FpEventoVariavel getFpEventoVariavel() {
        return fpEventoVariavel;
    }

    public void setFpEventoVariavel(FpEventoVariavel fpEventoVariavel) {
        this.fpEventoVariavel = fpEventoVariavel;
    }

    public List<FpEventoVariavel> getTodosFpEventoVariavel() {
        if (todosFpEventoVariavel == null) {
            todosFpEventoVariavel = fpEventoVariavelService.findAll();
        }
        return todosFpEventoVariavel;
    }

    public void setTodosFpEventoVariavel(List<FpEventoVariavel> todosFpEventoVariavel) {
        this.todosFpEventoVariavel = todosFpEventoVariavel;
    }

    public FpEventoVariavelService getFpEventoVariavelService() {
        return fpEventoVariavelService;
    }

    public void setFpEventoVariavelService(FpEventoVariavelService fpEventoVariavelService) {
        this.fpEventoVariavelService = fpEventoVariavelService;
    }

}
