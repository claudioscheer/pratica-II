package br.org.gdt.beans;

import br.org.gdt.model.FpPeriodo;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpPeriodoService;
import java.util.Calendar;
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
        if (!this.datasSaoValidas()) {
            Helper.setMensagemDeErro("As datas são inválidas.");
            return;
        }

        if (fpPeriodo.getPerId() > 0) {
            fpPeriodoService.update(fpPeriodo);
        } else {
            fpPeriodo.setPerAtivo(true);
            fpPeriodoService.save(fpPeriodo);
        }
        todosFpPeriodo = fpPeriodoService.findAll();
        this.formAtivo = false;
    }

    private boolean datasSaoValidas() {
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.setTime(fpPeriodo.getPerDataInicial());
        dataInicial.set(Calendar.DAY_OF_MONTH, 1);

        Calendar dataAtual = Calendar.getInstance();
        dataAtual.set(Calendar.DAY_OF_MONTH, 1);
        dataAtual.add(Calendar.MONTH, -1);

        if (!dataAtual.before(dataInicial)) {
            return false;
        }

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(fpPeriodo.getPerDataFinal());

        return dataFinal.after(dataInicial);
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpPeriodo = new FpPeriodo();
    }

    public void add() {
        if (fpPeriodoService.temPeriodoAtivo()) {
            Helper.mostrarNotificacao("Período", "Já há um período ativo.", "info");
            return;
        }

        this.formAtivo = true;
        this.fpPeriodo = new FpPeriodo();
    }

    public String desativar(FpPeriodo fpPeriodo) {
        fpPeriodo.setPerAtivo(false);
        fpPeriodoService.update(fpPeriodo);
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
