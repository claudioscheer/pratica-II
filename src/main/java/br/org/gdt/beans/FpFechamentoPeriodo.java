package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.enums.LogModulo;
import br.org.gdt.model.FpEvento;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.folhapagamento.CalcularFolha;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.LogService;
import br.org.gdt.service.RecPessoaService;
import br.org.gdt.service.folhapagamento.DadosCalculadosDoFuncionario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FpFechamentoPeriodo {

    private FpPeriodo fpPeriodo = new FpPeriodo();
    private List<FpPeriodo> todosFpPeriodo;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    @ManagedProperty("#{logService}")
    private LogService logService;

    public FpFechamentoPeriodo() {
    }

    public void selecionarPeriodo() {
        FpPeriodo periodo = fpPeriodoService.findById(fpPeriodo.getPerId());
        if (periodo == null) {
            periodo = new FpPeriodo();
        }
        fpPeriodo = periodo;
    }

    public void fecharPeriodo() {
        fpPeriodo.setPerPago(true);
        fpPeriodoService.update(fpPeriodo);
        Helper.mostrarNotificacao("Período", "Período fechado.", "success");
        fpPeriodo = new FpPeriodo();
    }

    public FpPeriodo getFpPeriodo() {
        return fpPeriodo;
    }

    public void setFpPeriodo(FpPeriodo fpPeriodo) {
        this.fpPeriodo = fpPeriodo;
    }

    public List<FpPeriodo> getTodosFpPeriodo() {
        if (todosFpPeriodo == null) {
            todosFpPeriodo = fpPeriodoService.findAllPeriodoNaoFechado();
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

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

}
