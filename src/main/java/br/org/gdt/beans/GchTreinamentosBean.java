/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.service.GchTreinamentosService;
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
public class GchTreinamentosBean {
    private boolean formAtivo = false;

    private GchTreinamentos gchTreinamentos = new GchTreinamentos();
    private List<GchTreinamentos> todosGchTreinamentos;
    
    @ManagedProperty("#{gchTreinamentosService}")
    private GchTreinamentosService gchTreinamentosService;

    public GchTreinamentosBean() {

    }

    public void save() {
        if (gchTreinamentos.getTreiCodigo() > 0) {
            gchTreinamentosService.update(gchTreinamentos);
        } else {
            gchTreinamentosService.save(gchTreinamentos);
        }
        todosGchTreinamentos = gchTreinamentosService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentos = new GchTreinamentos();
    }

    public void add() {
        this.formAtivo = true;
        this.gchTreinamentos = new GchTreinamentos();
    }

    public String excluir(GchTreinamentos gchTreinamentos) {
        gchTreinamentosService.delete(gchTreinamentos.getTreiCodigo());
        todosGchTreinamentos.remove(gchTreinamentos);
        return "eventos";
    }

    public String prepareEdit(GchTreinamentos gchTreinamentos) {
        this.formAtivo = true;
        this.gchTreinamentos = gchTreinamentos;
        return "eventos";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchTreinamentos getGchTreinamentos() {
        return gchTreinamentos;
    }

    public void setGchTreinamentos(GchTreinamentos gchTreinamentos) {
        this.gchTreinamentos = gchTreinamentos;
    }

    public List<GchTreinamentos> getTodosGchTreinamentos() {
        if (todosGchTreinamentos == null){
        
            todosGchTreinamentos = gchTreinamentosService.findAll();
        
        }
        
        return todosGchTreinamentos;
    }

    public void setTodosGchTreinamentos(List<GchTreinamentos> todosGchTreinamentos) {
        this.todosGchTreinamentos = todosGchTreinamentos;
    }

    public GchTreinamentosService getGchTreinamentosService() {
        return gchTreinamentosService;
    }

    public void setGchTreinamentosService(GchTreinamentosService gchTreinamentosService) {
        this.gchTreinamentosService = gchTreinamentosService;
    }
        
}
