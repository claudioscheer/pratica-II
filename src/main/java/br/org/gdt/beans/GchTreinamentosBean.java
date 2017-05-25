/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchMunicipios;
import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchTreinamentosService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    private String dataInicio;
    private String dataFim;

    public GchTreinamentosBean() {

    }

    public String save() {

        String MsgNotificacao = "";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {

            gchTreinamentos.setTreiDataInicio(formatter.parse(dataInicio));
            gchTreinamentos.setTreiDataFim(formatter.parse(dataFim));

            if (gchTreinamentos.getTreiCodigo() > 0) {

                gchTreinamentosService.update(gchTreinamentos);
                MsgNotificacao = "O treinamento " + gchTreinamentos.getTreiNome() + " foi atualizado com sucesso!";

            } else {

                gchTreinamentos.setTreiDatainclusao(new Date());
                gchTreinamentosService.save(gchTreinamentos);
                MsgNotificacao = "O treinamento " + gchTreinamentos.getTreiNome() + " foi cadastrado com sucesso!";
            }

            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

        } catch (Exception ex) {

            MsgNotificacao = "Não foi possível cadastrar o treinamento " + gchTreinamentos.getTreiNome();
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Treinamentos.xhtml");
        } catch (IOException ex) {

        }

        return "Treinamentos";

    }

    public boolean buscaTreinamentosPorCurso(long id) {

        List<GchTreinamentos> retorno = new ArrayList<>();

        retorno = gchTreinamentosService.BuscaTreinamentoPorCurso(id);

        if (retorno.isEmpty()) {

            return true;

        } else {

            return false;
        }

    }

    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentos = new GchTreinamentos();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Treinamentos.xhtml");
        } catch (IOException ex) {

        }
    }

    public void add() {
        System.out.println("Aqui tambem ta tretando");
        this.formAtivo = true;
        this.gchTreinamentos = new GchTreinamentos();
    }

    public String excluir(GchTreinamentos gchTreinamentos) {
        gchTreinamentosService.delete(gchTreinamentos.getTreiCodigo());
        todosGchTreinamentos.remove(gchTreinamentos);
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Treinamentos.xhtml");
        } catch (IOException ex) {

        }
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

    public String buscaTreinamentoPorId(int id) {

        System.out.println("Id Treinamento" + id);

        if (id != 0) {

            gchTreinamentos = gchTreinamentosService.findById(id);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            dataInicio = formatter.format(gchTreinamentos.getTreiDataInicio());
            dataFim = formatter.format(gchTreinamentos.getTreiDataFim());

            return "CadastroTreinamentos";

        }
        return null;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

}
