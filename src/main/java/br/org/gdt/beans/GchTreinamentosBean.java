/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchMunicipios;
import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.service.GchTreinamentosService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


/**
 *
 * @author Diego
 */
@ManagedBean
@RequestScoped
public class GchTreinamentosBean {

    private boolean formAtivo = false;

    private GchTreinamentos gchTreinamentos = new GchTreinamentos();
    private List<GchTreinamentos> todosGchTreinamentos;

    @ManagedProperty("#{gchTreinamentosService}")
    private GchTreinamentosService gchTreinamentosService;

    private GchMunicipios gchMunicipio;
    
    private long curCodigoCombo;
    private long munCodigoCombo;
    
    public GchTreinamentosBean() {

    }

    public void save(ActionEvent event) {
//        gchTreinamentos.setTreiNome("Diego");
//        gchTreinamentos.setTreiDescricao("Diego");
//        gchTreinamentos.setCurCodigo(new GchCursos(Long.valueOf(1), "String" , "String", new Date()));
//        gchTreinamentos.setTreiCodigo(Long.valueOf(2));
//        gchTreinamentos.setTreiDataInicio(new Date());
//        gchTreinamentos.setTreiDataFim(new Date());
//        gchTreinamentos.setTreiDatainclusao(new Date());
//        gchTreinamentos.setMunCodigo(new GchMunicipios(Long.valueOf(1), "Diego"));

        System.out.println(gchTreinamentos.getTreiNome());
        System.out.println(gchTreinamentos.getTreiDescricao());
        System.out.println(gchTreinamentos.getCurCodigo());
        System.out.println(gchTreinamentos.getTreiCodigo());
        System.out.println(gchTreinamentos.getTreiDataInicio());
        System.out.println(gchTreinamentos.getTreiDataFim());

//        if (gchTreinamentos.getTreiCodigo() > 0) {
//            gchTreinamentosService.update(gchTreinamentos);
//        } else {
        gchTreinamentos.setTreiDatainclusao(new Date());
        gchTreinamentosService.save(gchTreinamentos);
//        }
        todosGchTreinamentos = gchTreinamentosService.findAll();
        this.formAtivo = false;
    }

    
    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentos = new GchTreinamentos();
    }

    public void add() {
        System.out.println("Aqui tambem ta tretando");
        this.formAtivo = true;
        this.gchTreinamentos = new GchTreinamentos();
    }

    public String excluir(GchTreinamentos gchTreinamentos) {
        gchTreinamentosService.delete(gchTreinamentos.getTreiCodigo());
        todosGchTreinamentos.remove(gchTreinamentos);
        return "treinamentos";
    }

    public String prepareEdit(GchTreinamentos gchTreinamentos) {
        this.formAtivo = true;
        this.gchTreinamentos = gchTreinamentos;
        return "treinamentos";
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

        System.out.println("Aqui");

        if (todosGchTreinamentos == null) {

            System.out.println("Aqui tambem");

            todosGchTreinamentos = new ArrayList<>();

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

    public long getCurCodigoCombo() {
        return curCodigoCombo;
    }

    public void setCurCodigoCombo(long curCodigoCombo) {
        this.curCodigoCombo = curCodigoCombo;
    }

    public long getMunCodigoCombo() {
        return munCodigoCombo;
    }

    public void setMunCodigoCombo(long munCodigoCombo) {
        this.munCodigoCombo = munCodigoCombo;
    }

    public GchMunicipios getGchMunicipio() {
        return gchMunicipio;
    }

    public void setGchMunicipio(GchMunicipios gchMunicipio) {
        this.gchMunicipio = gchMunicipio;
    }


}
