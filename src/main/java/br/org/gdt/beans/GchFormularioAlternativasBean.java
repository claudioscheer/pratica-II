/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchFormularioPessoa;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.model.GchRespostas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchAlternativasPerguntaService;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioPessoaService;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioAlternativasBean {

    private String selectedRadioValue = "";

    private String radioValue = null;

    private String idParm;

    private List<GchAlternativas> todasAlternativas = new ArrayList<>();

    private GchAlternativas gchAlternativas;

    private Map<GchAlternativas, String> radio = new HashMap<GchAlternativas, String>();

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

    @ManagedProperty("#{gchFormularioPessoaService}")
    private GchFormularioPessoaService gchFormularioPessoaService;

    private List<GchRespostas> gchRespostasList = new ArrayList<>();

    private GchFormulario gchFormularios;

    private GchRespostas gchRespostas = new GchRespostas();

    private int idPessoa;
    private int idFormulario;

    private boolean respondeu;

    
    
    public GchFormularioAlternativasBean() {

    

        
    }
    
    public void Verifica(){
        
        recuperaParametro();

        respondeu = gchFormularioPessoaService.VerificaSeJaRespondeu(idPessoa, idFormulario);
        
        if (respondeu) {

            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect("Erro-FormRespondio.xhtml");
            } catch (IOException ex) {

            }
        }
        
        
    }
 
    public String save() {

        Iterator<GchAlternativas> keyIterrator = radio.keySet().iterator();

        RecPessoa pessoa = recPessoaService.BuscarId(idPessoa);

        while (keyIterrator.hasNext()) {

            GchAlternativas alternativa = keyIterrator.next();
            String value = radio.get(alternativa);

            GchRespostas gchResposta = new GchRespostas();

            gchResposta.setFormCodigo(idFormulario);
            gchResposta.setRecIdpessoa(pessoa);
            gchResposta.setAltCodigo(alternativa);
            gchResposta.setPerCodigo(alternativa.getPerCodigo());

            gchRespostasService.update(gchResposta);

        }

        radio = new HashMap<GchAlternativas, String>();

        //Altera a flag respondido para true no banco
        int idpesForm = gchFormularioPessoaService.BuscaPkFormularioPessoa(idPessoa, idFormulario);

        GchFormularioPessoa pessoaFormulario = new GchFormularioPessoa();

        pessoaFormulario.setFormPesCodigo(idpesForm);
        pessoaFormulario.setFormRespondido(true);
        pessoaFormulario.setFormulario(gchFormularios);
        pessoaFormulario.setRecIdpessoa(pessoa);

        gchFormularioPessoaService.update(pessoaFormulario);

         return "SucessoEnviarFormulario";
    }

    public List<GchPerguntas> buscaPerguntas() {

        if (idFormulario == 0) {

            recuperaParametro();

        }

        return gchPerguntasService.buscaPergutasFormulario(idFormulario);

    }

    public void recuperaParametro() {

        if (idParm != null) {

            byte[] bytes = Base64.getDecoder().decode(idParm);

            String parametro = new String(bytes);

            String[] parametros = parametro.split("&");

            idFormulario = Integer.parseInt(parametros[0]);
            idPessoa = Integer.parseInt(parametros[1]);

        }

    }

    public List<GchAlternativas> buscaAlternativas(GchPerguntas gchPerguntas) {

        List<GchAlternativasperguntas> gchAlternativasPergunta = gchAlternativasPerguntaService.buscaAlternativasPerguntas(gchPerguntas.getPerCodigo());

        List<GchAlternativas> gchAlternativasList = new ArrayList<>();

        for (GchAlternativasperguntas item : gchAlternativasPergunta) {

            GchAlternativas gchAlternativasAux = item.getGchAlternativas();
            gchAlternativasAux.setPerCodigo(gchPerguntas.getPerCodigo());
            gchAlternativasList.add(gchAlternativasAux);

        }

        return gchAlternativasList;

    }

    public String preparedEdit(GchFormulario gchFormulario) {

        idFormulario = (int) gchFormulario.getFormCodigo();
        idPessoa = 0;

        return "ResponderFormulario";

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

    public boolean isRespondeu() {
        return respondeu;
    }

    public void setRespondeu(boolean respondeu) {
        this.respondeu = respondeu;
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

    public GchFormularioPessoaService getGchFormularioPessoaService() {
        return gchFormularioPessoaService;
    }

    public void setGchFormularioPessoaService(GchFormularioPessoaService gchFormularioPessoaService) {
        this.gchFormularioPessoaService = gchFormularioPessoaService;
    }

    public GchFormulario getGchFormularios() {

        recuperaParametro();

         
        
        gchFormularios = gchFormularioService.findById(idFormulario);

        return gchFormularios;
    }

    public void setGchFormularios(GchFormulario gchFormularios) {
        this.gchFormularios = gchFormularios;
    }

    public Map<GchAlternativas, String> getRadio() {
        return radio;
    }

    public void setRadio(Map<GchAlternativas, String> radio) {
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

    public String getIdParm() {
        return idParm;
    }

    public void setIdParm(String idParm) {
        this.idParm = idParm;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

}
