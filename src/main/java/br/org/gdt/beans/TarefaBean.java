package br.org.gdt.beans;

import br.org.gdt.model.Tarefa;
import br.org.gdt.service.TarefaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TarefaBean {

    private Tarefa tarefa;
    private List<Tarefa> tarefas;
 
    @ManagedProperty("#{tarefaService}")
    private TarefaService tarefaService;

    private boolean formAtivo = false;

    public TarefaBean() {
        tarefa = new Tarefa();
    }

    public void refresh() {
        System.out.println("---> " + tarefa.getBloco().getId());
        this.tarefas = tarefaService.findByBloco(tarefa.getBloco());
    }

    public void salvar() {
        this.formAtivo = false;

        if (tarefa.getId() > 0) {
            tarefaService.update(tarefa);
        } else {
            tarefaService.save(tarefa);
        }
        refresh();
    }

    public void cancel() {
        this.formAtivo = false;
    }

    public void add() {
        this.formAtivo = true;
    }

    public void excluir(Tarefa tarefa) {
        tarefaService.delete(tarefa.getId());
        refresh();
    }

    public void prepareEdit(Tarefa tarefa) {
        this.formAtivo = true;
        this.tarefa = tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public TarefaService getTarefaService() {
        return tarefaService;
    }

    public void setTarefaService(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public List<Tarefa> getTarefas() {
        if (tarefas == null) {
            refresh();
        }
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
