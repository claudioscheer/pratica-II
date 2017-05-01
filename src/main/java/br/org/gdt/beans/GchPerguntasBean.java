/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchPerguntas;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchPerguntasService;
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

public class GchPerguntasBean {
    @ManagedProperty("#{gchPerguntaService}")   
    
    private boolean formAtivo = false;

    private GchPerguntas gchPerguntas = new GchPerguntas();
    private List<GchPerguntas> gchTodasPerguntas;

    
    
    private GchPerguntasService gchPerguntasService;
    
    public GchPerguntasBean() {
        
        
    }
    
    public void cancel() {
        this.formAtivo = false;
        this.gchPerguntas = new GchPerguntas();
    }

    public GchPerguntas getGchPerguntas() {
        return gchPerguntas;
    }

    public void setGchPerguntas(GchPerguntas gchPerguntas) {
        this.gchPerguntas = gchPerguntas;
    }

    public GchPerguntasService getGchPerguntasService() {
        return gchPerguntasService;
    }

    public void setGchPerguntasService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    public void add() {

        this.formAtivo = true;
        this.gchPerguntas = new GchPerguntas();

    }
    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void excluir(GchPerguntas gchPerguntas) {

        String MsgNotificacao = "";

        try {

            if(gchPerguntas != null){
           
                gchPerguntasService.delete(gchPerguntas.getPerCodigo());
                gchTodasPerguntas.remove(gchPerguntas);
                MsgNotificacao = "A pergunta " + gchPerguntas.getPerDescricao() + "foi excluída com sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
                
            }
            
        } catch (Exception ex) {
            MsgNotificacao = "Uma Exceção não tratada impediu a exclusão da pergunta!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");
        }

    }
    
    public GchPerguntas getGchPergunta() {
        return gchPerguntas;
    }

    public void setGchPergunta(GchPerguntas gchPerguntas) {
        this.gchPerguntas = gchPerguntas;
    }

    public List<GchPerguntas> getGchTodasPerguntas() {

        if (gchTodasPerguntas == null) {

            gchTodasPerguntas = gchPerguntasService.findAll();

        }

        return gchTodasPerguntas;
    }

    public void setGchTodasPerguntas(List<GchPerguntas> gchTodasPerguntas) {
        this.gchTodasPerguntas = gchTodasPerguntas;
    }

    public GchPerguntasService getGchPerguntaService() {
        return gchPerguntasService;
    }

    public void setGchPerguntaService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    
}
