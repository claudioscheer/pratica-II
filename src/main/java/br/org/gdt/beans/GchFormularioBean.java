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
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchAlternativasPerguntaService;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioBean {

    public GchFormulario getGchFormulario() {
        return gchFormulario;
    }

    private boolean formAtivo = false;

    private long indexPerguntaItem = 0;
    private List<GchAlternativas> alternativasVinculadas;
    private GchFormulario gchFormulario = new GchFormulario();
    private List<GchFormulario> gchTodosFormularios;

    public String getNotificacao() {
        return Notificacao;
    }

    public void setNotificacao(String Notificacao) {
        this.Notificacao = Notificacao;
    }
    
    
    private String Notificacao = "";
    

    public List<GchAlternativas> getAlternativasVinculadas() {
        return alternativasVinculadas;
    }

    public void setAlternativasVinculadas(List<GchAlternativas> alternativasVinculadas) {
        this.alternativasVinculadas = alternativasVinculadas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.gchFormularioService);
        hash = 83 * hash + Objects.hashCode(this.gchAlternativasService);
        hash = 83 * hash + Objects.hashCode(this.gchAlternativasPerguntaService);
        hash = 83 * hash + Objects.hashCode(this.gchPerguntasService);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GchFormularioBean other = (GchFormularioBean) obj;
        if (!Objects.equals(this.gchFormularioService, other.gchFormularioService)) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasService, other.gchAlternativasService)) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasPerguntaService, other.gchAlternativasPerguntaService)) {
            return false;
        }
        if (!Objects.equals(this.gchPerguntasService, other.gchPerguntasService)) {
            return false;
        }
        return true;
    }

    private List<PerguntasAlternativas> PergAlt;

    public GchAlternativasPerguntaService getGchAlternativasPerguntaService() {
        return gchAlternativasPerguntaService;
    }

    public void setGchAlternativasPerguntaService(GchAlternativasPerguntaService gchAlternativasPerguntaService) {
        this.gchAlternativasPerguntaService = gchAlternativasPerguntaService;
    }

    public GchPerguntasService getGchPerguntasService() {
        return gchPerguntasService;
    }

    public void setGchPerguntasService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;
    
    @ManagedProperty("#{gchAlternativaPerguntasService}")
    private GchAlternativasPerguntaService gchAlternativasPerguntaService;
    
     @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;
    
    

    public GchFormularioBean() {
    
    }

    public void VerificaNotificacao() {

        if(!Notificacao.isEmpty()){
            
            Helper.mostrarNotificacao("Sucesso",Notificacao,"sucess");
            
            Notificacao = "";
        }    
            
        
    }

    public void IsSelected(long alt) {

        System.out.println("alt" + alt);

    }

    public void cancel() {
        this.formAtivo = false;
        this.gchFormulario = new GchFormulario();
    }

    public void add() {

        this.formAtivo = true;
        this.gchFormulario = new GchFormulario();

    }

    public void alimentarVariaveis() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("MontarPerguntasAlternativas()");

    }

    public String SalvarFormulario() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        //Busca parametros concatenados 
        String parametrosCapa           = params.get("formFormulario:TxbParametrosCapa");
        String parametrosPerguntas      = params.get("formFormulario:TxbParametrosPergunta");
        String parametrosAlternativas   = params.get("formFormulario:TxbParametrosAlternativas");

        String inputsCapa[]     = parametrosCapa.split("§");
        String Perguntas[]      = parametrosPerguntas.split("§");
        String Alternativas[]   = parametrosAlternativas.split("¬");

        GchFormulario formulario = new GchFormulario();

        Date date = null;
        
        try {

            // -------------- Inputs da Capa --------------------------//
            
            formulario.setFormNome(inputsCapa[0]); //Nome do Formulário
            formulario.setFormDescricao(inputsCapa[1]); // Descricao do Formulário

            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

            date = (Date) formatter.parse(inputsCapa[2]);
            
            formulario.setFormPrazoResposta(date);
            
            gchFormularioService.save(formulario);
 

        } catch (ParseException ex) {
            Logger.getLogger(GchFormularioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

//      Somente continua se a quantidade de linhas de perguntas for igual a de alternativas
        if (Perguntas.length == Alternativas.length) {

            GchPerguntas pergunta;
            String[] altPergunta;
            GchAlternativasperguntas altperg;
            
            // ----------- Informações das perguntas ------------------//
            
            for (int i = 0; i < Perguntas.length; i++) {


                pergunta = new GchPerguntas();

                pergunta.setPerDescricao(Perguntas[i]);
                pergunta.setFormulario(formulario);
                
                gchPerguntasService.save(pergunta);
                   
                /* Busca todas alternativas de cada pergunta e armazena no array
                - O ponto de quebra é o caractere § e o mesmo é concatenado no arquivo ControleFormularios.Js
                */
                altPergunta = Alternativas[i].split("§");
                
                //Percorre alternativas da pergunta
                for(int j = 0; j < altPergunta.length; j++) {

                    GchAlternativas novaAlternativa = gchAlternativasService.findById(Long.parseLong(altPergunta[j]));

                    altperg = new GchAlternativasperguntas();

                  
                    altperg.setGchAlternativas(novaAlternativa);
                    altperg.setPerCodigo(pergunta);
               
                   
                    
                    gchAlternativasPerguntaService.save(altperg);

                }
            }

            //Salvou com sucesso, retorna para página de listagem
            Notificacao = "O formulário "+gchFormulario.getFormNome()+" foi cadastrado com sucesso!";
            
            gchFormulario = new GchFormulario();  
       
        }
        
         return "Formularios";
    }

    public void addNovaPergunta() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("AddNovaPergunta()");

    }

    public void removerPergunta(int index) {

        System.out.println("indice" + index);

        this.gchFormulario.getPerguntas().remove(index);
    }

    public String excluir(GchFormulario gchFormulario) {

        String MsgNotificacao = "";

        try {

            if (gchFormulario != null) {

                gchFormularioService.delete(gchFormulario.getFormCodigo());
                gchTodosFormularios.remove(gchFormulario);
                MsgNotificacao = "O formulário " + gchFormulario.getFormNome() + "foi excluído com sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

            }

        } catch (Exception ex) {
            MsgNotificacao = "Uma Exceção não tratada impediu a exclusão do formulário!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");
        }

        return "Formularios";
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchFormulario> getGchTodosFormularios() {

        gchTodosFormularios = gchFormularioService.findAll();
       
        return gchTodosFormularios;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public long getIndexPerguntaItem() {
        return indexPerguntaItem;
    }

    public void setIndexPerguntaItem(long indexPerguntaItem) {
        this.indexPerguntaItem = indexPerguntaItem;
    }

    public List<PerguntasAlternativas> getPergAlt() {
        return PergAlt;
    }

    public void setPergAlt(List<PerguntasAlternativas> PergAlt) {
        this.PergAlt = PergAlt;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

}
