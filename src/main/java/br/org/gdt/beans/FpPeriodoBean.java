package br.org.gdt.beans;

import br.org.gdt.model.FpPeriodo;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpPeriodoService;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FpPeriodoBean {

    private boolean formAtivo = false;

    private FpPeriodo fpPeriodo = new FpPeriodo();
    private List<FpPeriodo> todosFpPeriodo;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    public void save() {
        String mensagemErro = this.datasSaoValidas();
        if (!mensagemErro.isEmpty()) {
            
            Helper.mostrarNotificacao("Período", mensagemErro, "error");
            return;
        }

        if (fpPeriodo.getPerId() > 0) {
            fpPeriodoService.update(fpPeriodo);
        } else {
            fpPeriodoService.save(fpPeriodo);
        }
        todosFpPeriodo = fpPeriodoService.findAll();
        this.formAtivo = false;
    }

    private String datasSaoValidas() {
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.setTime(fpPeriodo.getPerDataInicial());

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(fpPeriodo.getPerDataFinal());

        if (dataFinal.before(dataInicial)) {
            return "A Data final precisa ser maior que a Data inicial.";
        }

        int diasEntreDatas = ((int) ((dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis()) / (1000 * 60 * 60 * 24))) + 1;
        int somaDiasUteisNaoUteis = fpPeriodo.getPerDiasUteis() + fpPeriodo.getPerDiasNaoUteis();

        if (diasEntreDatas != somaDiasUteisNaoUteis) {
            return "As datas não conferem com os dias informados.";
        }

        return "";
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpPeriodo = new FpPeriodo();
    }

    public void add() {
        this.formAtivo = true;
        this.fpPeriodo = new FpPeriodo();
    }

    public void prepareEdit(FpPeriodo fpPeriodo) {
        if (fpPeriodo.isPerPago()) {
            Helper.mostrarNotificacao("Período", "Período já está pago, não pode ser editado.", "error");
            return;
        }

        this.formAtivo = true;
        this.fpPeriodo = fpPeriodo;
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
        todosFpPeriodo = todosFpPeriodo.stream()
                .sorted((x, y) -> Integer.compare(x.getPerMes(), y.getPerMes()))
                .collect(Collectors.toList());
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
