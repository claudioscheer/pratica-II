/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.enums.PossuiDependentes;
import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.CsbffPessoaDependente;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.CsbffDependentesService;
import br.org.gdt.service.CsbffPessoaDependenteService;
import br.org.gdt.service.RecPessoaService;
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
public class DependenteBean {

    private boolean formAtivo = true;
    private String recCpf;
    private String NomeCompleto;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    private CsbffDependentes csbffdependente = new CsbffDependentes();
    private List<CsbffDependentes> todosdependentes;

    @ManagedProperty("#{csbffDependentesService}")
    private CsbffDependentesService csbffDependenteService;
    private RecPessoa recPessoa = new RecPessoa();

    @ManagedProperty("#{csbffPessoaDependenteService}")
    private CsbffPessoaDependenteService csbffPessoaDependenteService;
    private CsbffPessoaDependente csbffPessoaDependente = new CsbffPessoaDependente();

    public DependenteBean() {
     

    }

    public void buscarCpf() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>  CPF:  " + recCpf);
        recPessoa = recPessoaService.findByRecCpf(recCpf);
        NomeCompleto = recPessoa.getRecNomecompleto();
        if (recPessoa == null) {
            recPessoa = new RecPessoa();
        }
    }

    public String pg(CsbffDependentes dependente) {
        this.csbffdependente = dependente;
        return "dependente.xhtml";
    }

    public void save() {
        
        
        if(csbffdependente.getDependenteCod() > 0){
           csbffDependenteService.update(csbffdependente);
            add();
        

        }else{
            
        
        csbffDependenteService.save(csbffdependente);
//        csbffPessoaDependente.setColabDepCodigo(recPessoa.getRecIdpessoa());
        csbffPessoaDependente.setDependenteCod(csbffdependente);
        csbffPessoaDependente.setRecIdpessoa(recPessoa);
        csbffPessoaDependente.setPossuiDependentes(PossuiDependentes.Sim);
        //csbffPessoaDependente = getCsbffPessoaDependente();
        //csbffdependente.setCsbffPessoaDependente(csbffPessoaDependente);

        csbffPessoaDependenteService.save(csbffPessoaDependente);

        
            add();
        }
        
        
        
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

    public CsbffDependentes getCargoCodigo() {

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
        return recPessoaService.findAllDependentesPessoa(recPessoa);
    }

    public void setTodosdependentes(List<CsbffDependentes> todosdependentes) {
        this.todosdependentes = todosdependentes;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public String getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(String recCpf) {
        this.recCpf = recCpf;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public CsbffPessoaDependenteService getCsbffPessoaDependenteService() {
        return csbffPessoaDependenteService;
    }

    public void setCsbffPessoaDependenteService(CsbffPessoaDependenteService csbffPessoaDependenteService) {
        this.csbffPessoaDependenteService = csbffPessoaDependenteService;
    }

    public CsbffPessoaDependente getCsbffPessoaDependente() {
        return csbffPessoaDependente;
    }

    public void setCsbffPessoaDependente(CsbffPessoaDependente csbffPessoaDependente) {
        this.csbffPessoaDependente = csbffPessoaDependente;
    }

}
