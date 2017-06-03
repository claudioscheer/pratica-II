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
import br.org.gdt.model.GchRespostas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.GchAlternativasPerguntaService;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
import br.org.gdt.service.RecPessoaService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioAlternativasBean {

    private String selectedRadioValue = "";

    private String radioValue = null;

    private List<GchAlternativas> todasAlternativas = new ArrayList<>();

    private GchAlternativas gchAlternativas;

    private Map<GchAlternativas, Boolean> radio = new HashMap<GchAlternativas, Boolean>();

    private List<GchPerguntas> todasPerguntas = new ArrayList<>();

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchRespostaService}")
    private GchRespostasService gchRespostasService;

    @ManagedProperty("#{gchAlternativaPerguntasService}")
    private GchAlternativasPerguntaService gchAlternativasPerguntaService;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    private List<GchRespostas> gchRespostasList = new ArrayList<>();

    private GchFormulario gchFormularios = new GchFormulario();

    private GchRespostas gchRespostas = new GchRespostas();

    private int idPessoa = 4;
    private long idFormulario = 2;

    public GchFormularioAlternativasBean() {

    }

    public void save() {

        for (GchRespostas gchResposta : gchRespostasList) {

            gchResposta.setFormCodigo(1);

            RecPessoa pessoa = recPessoaService.BuscarId(idPessoa);

            gchResposta.setRecIdpessoa(pessoa);

            gchRespostasService.update(gchResposta);

        }

        gchRespostasList = new ArrayList<>();

    }

    public List<GchPerguntas> buscaPerguntas() {

        gchFormularios = gchFormularioService.findById(idFormulario);

        return gchFormularios.getPerguntas();

    }

    public List<GchAlternativas> buscaAlternativas(GchPerguntas gchPerguntas) {

        List<GchAlternativasperguntas> gchAlternativasPergunta = gchAlternativasPerguntaService.buscaAlternativasPerguntas(gchPerguntas.getPerCodigo());

        List<GchAlternativas> gchAlternativasList = new ArrayList<>();

        for (GchAlternativasperguntas item : gchAlternativasPergunta) {

            gchAlternativasList.add(item.getGchAlternativas());

        }

        return gchAlternativasList;

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

        if (gchFormularios == null) {

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

    public GchPerguntasService getGchPerguntasService() {
        return gchPerguntasService;
    }

    public void setGchPerguntasService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    public List<GchPerguntas> getTodasPerguntas() {
        return todasPerguntas;
    }

    public void setTodasPerguntas(List<GchPerguntas> todasPerguntas) {
        this.todasPerguntas = todasPerguntas;
    }

    public GchAlternativasPerguntaService getGchAlternativasPerguntaService() {
        return gchAlternativasPerguntaService;
    }

    public void setGchAlternativasPerguntaService(GchAlternativasPerguntaService gchAlternativasPerguntaService) {
        this.gchAlternativasPerguntaService = gchAlternativasPerguntaService;
    }

    public String getSelectedRadioValue() {
        return selectedRadioValue;
    }

    public void setSelectedRadioValue(String selectedRadioValue) {
        this.selectedRadioValue = selectedRadioValue;
    }

    public String getRadioValue() {

        return radioValue;
    }

    public void setRadioValue(String radioValue) {

        String[] value = radioValue.split("-");

        GchRespostas gchRespostaAux = new GchRespostas();

        gchRespostaAux.setPerCodigo(Long.parseLong(value[1]));

        gchRespostaAux.setAltCodigo(gchAlternativasService.findById(Long.parseLong(value[0])));

        gchRespostasList.add(gchRespostaAux);

        this.radioValue = radioValue;
    }

    public GchRespostas getGchRespostas() {
        return gchRespostas;
    }

    public void setGchRespostas(GchRespostas gchRespostas) {
        this.gchRespostas = gchRespostas;
    }

    public List<GchRespostas> getGchRespostasList() {
        return gchRespostasList;
    }

    public void setGchRespostasList(List<GchRespostas> gchRespostasList) {
        this.gchRespostasList = gchRespostasList;
    }

    public GchRespostasService getGchRespostasService() {
        return gchRespostasService;
    }

    public void setGchRespostasService(GchRespostasService gchRespostasService) {
        this.gchRespostasService = gchRespostasService;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

}
