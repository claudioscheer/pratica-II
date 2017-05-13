/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffCargos;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.CsbffCargosService;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@SessionScoped
public class cargosBean {

    private boolean formAtivo = false;
    private int nomeCBO;
    private CsbffCargos codigoColaborador;
    private CsbffCargos csbffcargos = new CsbffCargos();
    private List<CsbffCargos> todosCargos;

    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;
    private RecPessoa recPessoa;

    public cargosBean() {
        csbffcargos = new CsbffCargos();
       
    }

    public String pg(CsbffCargos cargo) {
        this.csbffcargos = cargo;
        select(cargo);
        return "form_cargo";
    }

    public void select(CsbffCargos carg) {
        this.csbffcargos = carg;
        codigoColaborador = carg;
        altera(carg);

//        zeraSession();
    }

    public String altera(CsbffCargos carg) {
//        csbffcargos = carg;
        codigoColaborador = carg;

        csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(4));
        csbffcargos.setCargoDataDeCriacao(new Date());
        csbffcargos.setCargoDataUltimaAlteracao(new Date());
        csbffCargosService.update(codigoColaborador);
       
//         System.out.println("**************"+ codigoColaborador + "*****************");
//         csbffcargos = new CsbffCargos();
        return "cargo_consulta";
    }


    public String buscaPorCbo() {

        if (nomeCBO != 0) {
            todosCargos = csbffCargosService.findByCargos(nomeCBO);
        }
        return "cargo_consulta";

    }
    
    
    public void zeraSession(){
        CsbffCargos conta = new CsbffCargos();

 this.csbffcargos = new CsbffCargos(); //isso vai limpar os campos referenciados na view!

        
    }

    public void save() {
        
         if (csbffcargos.getCargoCodigo() > 0) {
             csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(1));
        csbffcargos.setCargoDataDeCriacao(new Date());
        csbffcargos.setCargoDataUltimaAlteracao(new Date());
            csbffCargosService.update(csbffcargos);
            csbffcargos = new CsbffCargos();
            zeraSession();
        } else {
//            fpEvento.setEvePermiteExcluir(true);
//            fpEvento.setEveFormula("$#");
csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(1));
        csbffcargos.setCargoDataDeCriacao(new Date());
        csbffcargos.setCargoDataUltimaAlteracao(new Date());
          csbffCargosService.save(csbffcargos);
          csbffcargos = new CsbffCargos();
          zeraSession();
        }
        
        
        
//
//        System.out.println("teste teste");
//        
//        csbffCargosService.update(csbffcargos);

    }

    public String novo() {

        save();
        csbffcargos = new CsbffCargos();

        return "cargo_consulta";

    }

    public String buscaPorId(int idcargo) {

        System.out.println("Id do curso" + idcargo);

        if (idcargo != 0) {

            csbffcargos = csbffCargosService.findById(idcargo);

        }
        return "form_cargo";

    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();
    }

    public String add() {
        this.formAtivo = true;
        this.csbffcargos = new CsbffCargos();
        return "form_cargo";
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

    public CsbffCargos getCargoCodigo() {

        return csbffcargos;
    }

    public void setCargoCodigo(CsbffCargos cargos) {
        this.csbffcargos = cargos;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffCargos getCsbffcargos() {
        return csbffcargos;
    }

    public void setCsbffcargos(CsbffCargos csbffcargos) {
        this.csbffcargos = csbffcargos;
    }

    public List<CsbffCargos> getTodosCargos() {
        if (todosCargos == null) {
            todosCargos = csbffCargosService.findAll();
        }
        return todosCargos;
    }

    public void setTodosCargos(List<CsbffCargos> todosCargos) {
        this.todosCargos = todosCargos;
    }

    public CsbffCargosService getCsbffCargosService() {
        return csbffCargosService;
    }

    public void setCsbffCargosService(CsbffCargosService csbffCargosService) {
        this.csbffCargosService = csbffCargosService;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public int getNomeCBO() {
        return nomeCBO;
    }

    public void setNomeCBO(int nomeCBO) {
        this.nomeCBO = nomeCBO;
    }
}
