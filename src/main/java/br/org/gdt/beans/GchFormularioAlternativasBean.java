/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioAlternativasBean {

    private List<GchAlternativas> todasAlternativas = new ArrayList<>();

    private GchAlternativas gchAlternativas = new GchAlternativas();

    private Map<GchAlternativas, Boolean> radio = new HashMap<GchAlternativas, Boolean>();
    
    
    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

     @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

     private GchFormulario gchFormularios;
     
    
    public GchFormularioAlternativasBean() {

    }



    public void save() {
    }

    public List<GchAlternativas> getTodasAlternativas() {
        return todasAlternativas;
    }

    public void setTodasAlternativas(List<GchAlternativas> todasAlternativas) {
        this.todasAlternativas = todasAlternativas;
    }

    public GchAlternativas getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    public GchFormulario getGchFormularios() {
        
        if (gchFormularios == null){
        
            gchFormularios = gchFormularioService.findById(1);
            
        }
        
        return gchFormularios;
    }

    public void setGchFormularios(GchFormulario gchFormularios) {
        this.gchFormularios = gchFormularios;
    }

    public Map<GchAlternativas, Boolean> getRadio() {
        return radio;
    }

    public void setRadio(Map<GchAlternativas, Boolean> radio) {
        this.radio = radio;
    }

    
    
    

}
