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
import br.org.gdt.service.GchAlternativasPerguntaService;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
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
public class GchRespostaFormulario {

    private GchFormulario gchFormulario;
    private List<GchPerguntas> gchPerguntas;
    private List<GchAlternativas> gchAlternativas;

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;

    @ManagedProperty("#{gchRespostaService}")
    private GchRespostasService gchRespostasService;

    @ManagedProperty("#{gchAlternativaPerguntasService}")
    private GchAlternativasPerguntaService gchAlternativasperguntasService;
    
    public GchRespostaFormulario(GchFormulario gchFormulario, List<GchPerguntas> gchPerguntas, List<GchAlternativas> gchAlternativas) {
        this.gchFormulario = gchFormulario;
        this.gchPerguntas = gchPerguntas;
        this.gchAlternativas = gchAlternativas;
    }

    public GchFormulario getGchFormulario() {
        return gchFormulario;
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchPerguntas> getGchPerguntas() {
        if (this.gchPerguntas == null) {

           gchPerguntas = gchPerguntasService.buscaPergutasFormulario(1);

        }

        return gchPerguntas;

    }

//    public List<GchAlternativas> buscaAlternativas(GchPerguntas gchPergunta){
//    
//        GchAlternativasperguntas gchAlternativasPerguntas = gchAlternativasperguntasService.buscaAlternativasPerguntas(gchPergunta.getPerCodigo());
//        
//        return gchAlternativasPerguntas.getGchAlternativas()
//        
//    
//    }
    
    public void setGchPerguntas(List<GchPerguntas> gchPerguntas) {

        this.gchPerguntas = gchPerguntas;

    }

    public List<GchAlternativas> getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(List<GchAlternativas> gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    public GchPerguntasService getGchPerguntasService() {
        return gchPerguntasService;
    }

    public void setGchPerguntasService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    public GchRespostasService getGchRespostasService() {
        return gchRespostasService;
    }

    public void setGchRespostasService(GchRespostasService gchRespostasService) {
        this.gchRespostasService = gchRespostasService;
    }

    public GchAlternativasPerguntaService getGchAlternativasperguntasService() {
        return gchAlternativasperguntasService;
    }

    public void setGchAlternativasperguntasService(GchAlternativasPerguntaService gchAlternativasperguntasService) {
        this.gchAlternativasperguntasService = gchAlternativasperguntasService;
    }

   

}
