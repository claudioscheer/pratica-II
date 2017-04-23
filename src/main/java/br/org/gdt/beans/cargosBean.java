/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffCargos;
import br.org.gdt.service.CsbffCargosService;
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
    private List<CsbffCargos> todosCargos;

    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;

    public cargosBean() {
    }

    public void save() {
        csbffCargosService.save(csbffcargos);

    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();
    }

    public void add() {
        this.formAtivo = true;
        this.csbffcargos = new CsbffCargos();
    }

    public String excluir(CsbffCargos cargos) {
        csbffCargosService.delete(cargos.getCargoCodigo());
        todosCargos.remove(cargos);
        return "cargos";
    }
 
    public String prepareEdit(CsbffCargos cargos) {
        this.formAtivo = true;
        this.csbffcargos = cargos;
        return "cargos";
    }

    public CsbffCargos getCargoCodigo(){
        
        return csbffcargos;
    }
    
    
    public void setCargoCodigo(CsbffCargos cargos) {
        this.csbffcargos = cargos;
    }

    
    
    
//    public List<FpHorasTrabalhadas> getTodasFpHorasTrabalhadas() {
//        if (todasFpHorasTrabalhadas == null) {
//            todasFpHorasTrabalhadas = fpHorasTrabalhadasService.findAll();
//        }
//        return todasFpHorasTrabalhadas;
//    }
//
//    public void setTodasFpHorasTrabalhadas(List<FpHorasTrabalhadas> fpHorasTrabalhadases) {
//        this.todasFpHorasTrabalhadas = fpHorasTrabalhadases;
//    }
//
//    public FpHorasTrabalhadasService getFpHorasTrabalhadasService() {
//        return fpHorasTrabalhadasService;
//    }
//
//    public void setFpHorasTrabalhadasService(FpHorasTrabalhadasService fpHorasTrabalhadasService) {
//        this.fpHorasTrabalhadasService = fpHorasTrabalhadasService;
//    }
//
//    public boolean isFormAtivo() {
//        return formAtivo;
//    }
//
//    public void setFormAtivo(boolean formAtivo) {
//        this.formAtivo = formAtivo;
//    }
}
