/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioBean {

    private boolean formAtivo = false;

     private long indexPerguntaItem = 0;
    
    private GchFormulario gchFormulario = new GchFormulario();
    private List<GchFormulario> gchTodosFormularios;
    
   
    
    private List<PerguntasAlternativas> PergAlt;
       
    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;
    
    private GchAlternativasperguntas alternativasPerguntas = new GchAlternativasperguntas();
    public List<GchAlternativasperguntas> todasAlternativasPerguntas;
    
    
    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;
    
    public GchFormularioBean() {
        
        
        
    }
    
    
    public void IsSelected(long alt){
        
        System.out.println("alt"+alt);
   
  
        
    }
    
    public void AgoraVai(AjaxBehaviorEvent event){
        
        GchAlternativas alt = (GchAlternativas) event.getComponent().getAttributes().get("teste");
        
        System.out.println("Recebeu o id");
        
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
         
       
         GchPerguntas novaPergunta = new GchPerguntas();
         
         novaPergunta.setPerCodigo(indexPerguntaItem);         
         
         this.gchFormulario.addPergunta((novaPergunta));
         
         
         
    }

    public void removerPergunta(int index) {
    
        System.out.println("indice"+index);
        
        this.gchFormulario.getPerguntas().remove(index);
    }
    
  
    
    
    public void VincularAlternativaPergunta(List<GchAlternativas> alternativas,GchPerguntas pergunta){
        
        if(!alternativas.isEmpty()){
           
            for(GchAlternativas a: alternativas){
                
                alternativasPerguntas.setAltCodigo(a.getAltCodigo());
                alternativasPerguntas.setPerCodigo(pergunta);
                alternativasPerguntas.setGchAlternativas(a);
                
                todasAlternativasPerguntas.add(alternativasPerguntas);
            }
             
        }
        
        
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
        
//      gchFormulario =  gchFormularioService.findById(1);
//        
//        System.out.println("codigo formulario"+gchFormulario.getFormNome());
//      
//      
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

    public GchAlternativasperguntas getAlternativasPerguntas() {
        return alternativasPerguntas;
    }

    public void setAlternativasPerguntas(GchAlternativasperguntas alternativasPerguntas) {
        this.alternativasPerguntas = alternativasPerguntas;
    }

    public List<PerguntasAlternativas> getPergAlt() {
        return PergAlt;
    }

    public void setPergAlt(List<PerguntasAlternativas> PergAlt) {
        this.PergAlt = PergAlt;
    }

    public long getIndexPerguntaItem() {
        return indexPerguntaItem;
    }

    public void setIndexPerguntaItem(long indexPerguntaItem) {
        this.indexPerguntaItem = indexPerguntaItem;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    
}
