/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.CsbffPessoaDependente;
import br.org.gdt.service.CsbffDependentesService;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@SessionScoped
public class DependenteBean implements Serializable{
    
    
     private boolean formAtivo = false;

    private CsbffDependentes csbffdependente = new CsbffDependentes();
    private List<CsbffDependentes> todosdependentes;

    @ManagedProperty("#{csbffDependenteService}")
    private CsbffDependentesService csbffDependenteService;

    CsbffPessoaDependente csbffPessoaDependente = null;
    
    

    
    
    public void save() {
         System.out.println("testando ");
        
        csbffdependente.setCsbffPessoaDependente(csbffPessoaDependente);
        csbffdependente.setDependenteTipo(BigInteger.valueOf(1));
        csbffdependente.setDependenteImpostoDeRenda(false);
        csbffDependenteService.save(csbffdependente);

    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffdependente = new CsbffDependentes();
    }

    public void add() {
        this.formAtivo = true;
        this.csbffdependente = new CsbffDependentes();
    }

    public String excluir(CsbffDependentes dependente) {
        csbffDependenteService.delete(dependente.getDependenteCod());
        todosdependentes.remove(dependente);
        return "dependente";
    }
 
    public String prepareEdit(CsbffDependentes dependente) {
        this.formAtivo = true;
        this.csbffdependente = dependente;
        return "dependente";
    }

    public CsbffDependentes getCargoCodigo(){
        
        return csbffdependente;
    }
    
    
    public void setCargoCodigo(CsbffDependentes dependente) {
        this.csbffdependente = dependente;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffDependentes getCsbffdependente() {
        return csbffdependente;
    }

    public void setCsbffdependente(CsbffDependentes csbffdependente) {
        this.csbffdependente = csbffdependente;
    }

    public CsbffDependentesService getCsbffDependenteService() {
        return csbffDependenteService;
    }

    public void setCsbffDependenteService(CsbffDependentesService csbffDependenteService) {
        this.csbffDependenteService = csbffDependenteService;
    }

    public List<CsbffDependentes> getTodosdependentes() {
        return todosdependentes;
    }

    public void setTodosdependentes(List<CsbffDependentes> todosdependentes) {
        this.todosdependentes = todosdependentes;
    }

    

    

}
