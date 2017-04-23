/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchMunicipios;
import br.org.gdt.service.GchMunicipiosService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class GchMunicipiosBean {

    private boolean formAtivo = false;

    private GchMunicipios gchMunicipios = new GchMunicipios();
    private List<GchMunicipios> todosGchMunicipios;

    @ManagedProperty("#{gchMunicipiosService}")
    private GchMunicipiosService gchMunicipiosService;

    public GchMunicipiosBean() {

    }

    public void save() {
        if (gchMunicipios.getMunCodigo() > 0) {
            gchMunicipiosService.update(gchMunicipios);
        } else {
            gchMunicipiosService.save(gchMunicipios);
        }
        todosGchMunicipios = gchMunicipiosService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchMunicipios = new GchMunicipios();
    }

    public void add() {
        this.formAtivo = true;
        this.gchMunicipios = new GchMunicipios();
    }

    public String excluir(GchMunicipios gchMunicipios) {
        gchMunicipiosService.delete(gchMunicipios.getMunCodigo());
        todosGchMunicipios.remove(gchMunicipios);
        return "eventos";
    }

    public String prepareEdit(GchMunicipios gchMunicipios) {
        this.formAtivo = true;
        this.gchMunicipios = gchMunicipios;
        return "eventos";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchMunicipios getGchMunicipios() {
        return gchMunicipios;
    }

    public void setGchMunicipios(GchMunicipios gchMunicipios) {
        this.gchMunicipios = gchMunicipios;
    }

    public List<GchMunicipios> getTodosGchMunicipios() {
        if (todosGchMunicipios == null) {

            todosGchMunicipios = gchMunicipiosService.findUfCodigo(43);

        }

        return todosGchMunicipios;
    }

    public List<GchMunicipios> getMunicipiosEstado(int ufCodigo){
    
        return gchMunicipiosService.findUfCodigo(ufCodigo);
        
    }
    
    public void setTodosGchMunicipios(List<GchMunicipios> todosGchMunicipios) {
        this.todosGchMunicipios = todosGchMunicipios;
    }

    public GchMunicipiosService getGchMunicipiosService() {
        return gchMunicipiosService;
    }

    public void setGchMunicipiosService(GchMunicipiosService gchMunicipiosService) {
        this.gchMunicipiosService = gchMunicipiosService;
    }

}
