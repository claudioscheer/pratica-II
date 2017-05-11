/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.enums.DiasATrabalhar;
import br.org.gdt.model.CsbffEscalaHoras;
import br.org.gdt.service.CsbffEscalaHorasService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Juliano
 */
@ManagedBean
@RequestScoped
public class CsbffEscalaHorasBean implements Serializable {

    private boolean formAtivo = false;

    private CsbffEscalaHoras csbffEscalaHoras = new CsbffEscalaHoras();
    private List<CsbffEscalaHoras> todosCsbffEscalaHoras;

    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    
    public CsbffEscalaHorasBean() {
    }
    public void save() {
//        System.out.println("SAVE:" + recPessoa.getRecIdpessoa());
//        
//    
//        recPessoaService.save(recPessoa);
//        todosRecPessoa = recPessoaService.findAll();
//        this.formAtivo = true;

        if (csbffEscalaHoras.getEscalaCodigo()>0) {
            csbffEscalaHorasService.update(csbffEscalaHoras);
        } else {
            csbffEscalaHorasService.save(csbffEscalaHoras);
        }

        todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
        this.formAtivo = false;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }
     public DiasATrabalhar[] getDiasATrabalhar(){
        return DiasATrabalhar.values();
    }
    

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        return csbffEscalaHoras;
    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public List<CsbffEscalaHoras> getTodosCsbffEscalaHoras() {
//        if (todosCsbffEscalaHoras == null) {
//            todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
//        }
        return todosCsbffEscalaHoras;
    }

    public void setTodosCsbffEscalaHoras(List<CsbffEscalaHoras> todosCsbffEscalaHoras) {
        this.todosCsbffEscalaHoras = todosCsbffEscalaHoras;
    }

    public CsbffEscalaHorasService getCsbffEscalaHorasService() {
        return csbffEscalaHorasService;
    }

    public void setCsbffEscalaHorasService(CsbffEscalaHorasService csbffEscalaHorasService) {
        this.csbffEscalaHorasService = csbffEscalaHorasService;
    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffEscalaHoras = new CsbffEscalaHoras();

    }
}
