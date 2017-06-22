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
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffDependentesService;
import br.org.gdt.service.CsbffPessoaDependenteService;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@SessionScoped
public class DependenteBean {

    private boolean formAtivo = false;
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

//    public void buscarCpf() {
//        recPessoa = recPessoaService.findByRecCpf(recCpf);
//        NomeCompleto = recPessoa.getRecNomecompleto();
//        if (recPessoa == null) {
//            recPessoa = new RecPessoa();
//        }
//    }
    public void buscarCpf() {
        recPessoa = recPessoaService.findByRecCpf(recCpf);
//        NomeCompleto = recPessoa.getRecNomecompleto();

        String MsgNotificacao = "";
        while (recPessoa == null) {
            MsgNotificacao = "A pessoa não existe.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "error");
            return;
        }
        if (recPessoa.colaboradorInativo == true) {
            MsgNotificacao = "O colaborador está inativo.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "info");
        }
        if (recPessoa == null) {
            recPessoa = new RecPessoa();

        }

        todosdependentes = csbffDependenteService.BuscaDependentePessoa(recPessoa.getRecIdpessoa());

    }

    public String pg(CsbffDependentes dependente) {
        this.csbffdependente = dependente;
        return "dependente.xhtml";
    }

    public String save() {
        String MsgNotificacao = "";
        try {
            if (csbffdependente.getDependenteCod() > 0) {

                csbffDependenteService.update(csbffdependente);

                add();
            } else {

                if (recPessoa.getRecIdpessoa() == 0) {
                    recPessoa = recPessoaService.findByRecCpf(recCpf);
                }
                csbffdependente.setVinculoPessoa(recPessoa.getRecIdpessoa());
                csbffDependenteService.save(csbffdependente);

            }

            todosdependentes = csbffDependenteService.BuscaDependentePessoa(recPessoa.getRecIdpessoa());
            MsgNotificacao = "O dependente foi adicionado ao colaborador!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");           
        } catch (Exception ex) {
            MsgNotificacao = "O colaborador não pode ser adicionado. ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");
        }
        this.csbffdependente = new CsbffDependentes();
        return "dependente";

    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffdependente = new CsbffDependentes();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("listaadmissao.xhtml");
        } catch (IOException ex) {

        }
    }
//    public void cancel() {
//        this.formAtivo = false;
//        this.csbffdependente = new CsbffDependentes();
//    }

    public void add() {
        this.formAtivo = true;
        this.csbffdependente = new CsbffDependentes();
    }

//    public String excluir(CsbffDependentes dependente) {
//        csbffDependenteService.delete(dependente.getDependenteCod());
//        todosdependentes.remove(dependente);
//        return "dependente";
//    }
    public String excluir(CsbffDependentes dependente) {
        String MsgNotificacao = "";
        try {
            csbffDependenteService.delete(dependente.getDependenteCod());
            todosdependentes.remove(dependente);

            MsgNotificacao = "O dependente foi excluido!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");
        } catch (Exception ex) {
            MsgNotificacao = "O dependente não pode ser excluído!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");

        }
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

        if (todosdependentes == null && recPessoa.getRecIdpessoa() != 0) {
            todosdependentes = csbffDependenteService.BuscaDependentePessoa(recPessoa.getRecIdpessoa());
        }
        return todosdependentes;
    }

    public void setTodosdependentes(List<CsbffDependentes> todosdependentes) {
        this.todosdependentes = todosdependentes;
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

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

}
