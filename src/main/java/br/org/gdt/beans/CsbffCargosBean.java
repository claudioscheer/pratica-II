/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffCargos;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffCargosService;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@SessionScoped
public class CsbffCargosBean {

    private boolean formAtivo = false;
    private int numeroCBO;
    private String nomeCBO;
    private CsbffCargos codigoColaborador;
    private CsbffCargos csbffcargos = new CsbffCargos();
    private List<CsbffCargos> todosCargos;

    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;
    private RecPessoa recPessoa;

    public CsbffCargosBean() {

    }

    public String pg(CsbffCargos cargo) {
        this.csbffcargos = cargo;
        return "form_cargo";

    }

    public String buscaNomeCBO() {

        if (nomeCBO != null) {
            todosCargos = csbffCargosService.findByCargos(numeroCBO);

        }
        return "cargo_consulta";
    }

    public String buscaPorCbo() {
        //System.out.println("BuscaPorCBO");
        if (numeroCBO != 0) {
            todosCargos = csbffCargosService.findByCargos(numeroCBO);

        } else {
            todosCargos = csbffCargosService.findAll();

        }
        numeroCBO = 0;
        return "cargo_consulta";
    }

    public String save() {

//        System.out.println("Salvando: " + csbffcargos.getCargoNome());
        String MsgNotificacao = "";
        try {
            if (csbffcargos.getCargoCodigo() > 0) {
                csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(1));
                csbffcargos.setCargoDataDeCriacao(new Date());
                csbffcargos.setCargoDataUltimaAlteracao(new Date());
                csbffCargosService.update(csbffcargos);

            } else {

                csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(1));
                csbffcargos.setCargoDataDeCriacao(new Date());
                csbffcargos.setCargoDataUltimaAlteracao(new Date());
                csbffCargosService.save(csbffcargos);

            }
            MsgNotificacao = "O cargo foi cadastrado com sucesso!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");
            this.formAtivo = true;
            this.csbffcargos = new CsbffCargos();

            todosCargos = null;
            return "cargo_consulta";
        } catch (Exception ex) {
            MsgNotificacao = "O cargo não pode ser cadastrado. ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
        return "cargo_consulta";
    }

    public String buscaPorId(int idcargo) {
        if (idcargo != 0) {
            csbffcargos = csbffCargosService.findById(idcargo);

        }
        return "form_cargo";
    }

    public String prepareEdit(CsbffCargos cargos) {
        this.formAtivo = true;
        this.csbffcargos = cargos;
        return "cargo_consulta";
    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("cargo_consulta.xhtml");
        } catch (IOException ex) {

        }
    }

    public String add() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();
        return "form_cargo";
    }

    public String add2() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();
        return "cargo_consulta";
    }

    public String excluir(CsbffCargos cargos) {
        csbffCargosService.delete(cargos.getCargoCodigo());
        todosCargos.remove(cargos);
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
        System.out.println("FindALLTodosCargos");
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

    public int getNumeroCBO() {
        return numeroCBO;
    }

    public void setNumeroCBO(int numeroCBO) {
        this.numeroCBO = numeroCBO;
    }

    public String getNomeCBO() {
        return nomeCBO;
    }

    public void setNomeCBO(String nomeCBO) {
        this.nomeCBO = nomeCBO;
    }

    public CsbffCargos getCodigoColaborador() {
        return codigoColaborador;
    }

    public void setCodigoColaborador(CsbffCargos codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }
}
