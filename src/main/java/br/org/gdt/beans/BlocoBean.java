package br.org.gdt.beans;

import br.org.gdt.model.Bloco;
import br.org.gdt.service.BlocoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BlocoBean {

    private boolean formAtivo = false;

    private Bloco bloco = new Bloco();
    private List<Bloco> blocos;

    @ManagedProperty("#{blocoService}")
    private BlocoService blocoService;

    public BlocoBean() {
    }

    public void save() {
        if (bloco.getId() > 0) {
            blocoService.update(bloco);
        } else {
            blocoService.save(bloco);
        }
        blocos = blocoService.findAll();
    }

    public void cancel() {
        this.formAtivo = false;
        this.bloco = new Bloco();
    }

    public void add() {
        this.formAtivo = true;
        this.bloco = new Bloco();
    }

    public String excluir(Bloco bloco) {
        blocoService.delete(bloco.getId());
        return "bloco_list";
    }

    public String prepareEdit(Bloco bloco) {
        this.formAtivo = true;
        this.bloco = bloco;
        return "bloco_list";
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public String addTarefa(Bloco bloco) {
        this.bloco = bloco;
        return "tarefa_list";
    }

    public List<Bloco> getBlocos() {
        if (blocos == null) {
            blocos = blocoService.findAll();
        }
        return blocos;
    }

    public void setBlocos(List<Bloco> blocos) {
        this.blocos = blocos;
    }

    public BlocoService getBlocoService() {
        return blocoService;
    }

    public void setBlocoService(BlocoService blocoService) {
        this.blocoService = blocoService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
