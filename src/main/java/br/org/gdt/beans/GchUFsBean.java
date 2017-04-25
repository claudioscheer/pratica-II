/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchUfs;
import br.org.gdt.service.GchUFsService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@RequestScoped
public class GchUFsBean {
        
    private boolean formAtivo = false;

    private GchUfs gchUfs = new GchUfs();
    private List<GchUfs> todosGchUfs;

    @ManagedProperty("#{gchUFsService}")
    private GchUFsService gchUFsService;

    public GchUFsBean() {

    }

    public void save() {
        if (gchUfs.getUfCodigo()> 0) {
            gchUFsService.update(gchUfs);
        } else {
            gchUFsService.save(gchUfs);
        }
        todosGchUfs = gchUFsService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchUfs = new GchUfs();
    }

    public void add() {
        this.formAtivo = true;
        this.gchUfs = new GchUfs();
    }

    public String excluir(GchUfs gchUfs) {
        gchUFsService.delete(gchUfs.getUfCodigo());
        todosGchUfs.remove(gchUfs);
        return "eventos";
    }

    public String prepareEdit(GchUfs gchUfs) {
        this.formAtivo = true;
        this.gchUfs = gchUfs;
        return "eventos";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchUfs getGchUFs() {
        return gchUfs;
    }

    public void setGchUFs(GchUfs gchUFs) {
        this.gchUfs = gchUFs;
    }

    public List<GchUfs> getTodosGchUFs() {
        if (todosGchUfs == null) {

            todosGchUfs = gchUFsService.findAll();

        }

        return todosGchUfs;
    }

    public void setTodosGchUFs(List<GchUfs> todosGchUfs) {
        this.todosGchUfs = todosGchUfs;
    }

    public GchUFsService getGchUFsService() {
        return gchUFsService;
    }

    public void setGchUFsService(GchUFsService gchUfsService) {
        this.gchUFsService = gchUfsService;
    }

    
    
}
