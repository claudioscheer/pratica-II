/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchFormularioService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@RequestScoped
public class GchFormularioBean {

    private boolean formAtivo = false;

     private long indexPerguntaItem = 0;
    
    private GchFormulario gchFormulario = new GchFormulario();
    private List<GchFormulario> gchTodosFormularios;

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;
    
    public GchFormularioBean() {
        
        
    }
    
    public void cancel() {
        this.formAtivo = false;
        this.gchFormulario = new GchFormulario();
    }

    public void add() {

        this.formAtivo = true;
        this.gchFormulario = new GchFormulario();

    }
     public void addNovaPergunta() {
        this.gchFormulario.addPergunta((new GchPerguntas(++indexPerguntaItem)));
    }

    public void removerPergunta(int index) {
        this.gchFormulario.getPerguntas().remove(index);
    }
    
    public String excluir(GchFormulario gchFormulario) {

        String MsgNotificacao = "";

        try {

            if(gchFormulario != null){
           
                gchFormularioService.delete(gchFormulario.getFormCodigo());
                gchTodosFormularios.remove(gchFormulario);
                MsgNotificacao = "O formulário " + gchFormulario.getFormNome() + "foi excluído com sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
                
            }
            
        } catch (Exception ex) {
            MsgNotificacao = "Uma Exceção não tratada impediu a exclusão do formulário!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");
        }

        return "Formularios";
    }
    
    
    
    public GchFormulario getGchFormulario() {
        return gchFormulario;
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchFormulario> getGchTodosFormularios() {

        if (gchTodosFormularios == null) {

            gchTodosFormularios = gchFormularioService.findAll();

        }

        return gchTodosFormularios;
    }

    public void setGchTodosFormularios(List<GchFormulario> gchTodosFormularios) {
        this.gchTodosFormularios = gchTodosFormularios;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    
}
