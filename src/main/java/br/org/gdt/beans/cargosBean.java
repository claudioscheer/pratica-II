/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffCargos;
import br.org.gdt.service.FpHorasTrabalhadasService;
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
public class cargosBean {
  
    



    private boolean formAtivo = false;

    private CsbffCargos csbffcargos = new CsbffCargos();
    private List<CsbffCargos> todasFpHorasTrabalhadas;

    @ManagedProperty("#{fpHorasTrabalhadasService}")
    private FpHorasTrabalhadasService fpHorasTrabalhadasService;

    public cargosBean() {
    }

    public void save() {
    
    
}
}
