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
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import com.sun.faces.facelets.tag.jsf.core.LoadBundleHandler;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioBean {

    private boolean formAtivo = false;

    private long indexPerguntaItem = 0;

    private GchFormulario gchFormulario = new GchFormulario();
    private List<GchFormulario> gchTodosFormularios;

    private List<PerguntasAlternativas> PergAlt;
//
//    @ManagedProperty("#{gchAlternativaCertoService}")
//    private GchCadastroAlternativaServiceCerto gchAlternativasService;
////
//    private GchAlternativasperguntas alternativasPerguntas = new GchAlternativasperguntas();
//    public List<GchAlternativasperguntas> todasAlternativasPerguntas;
//
    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    public GchFormularioBean() {

    }

    public void Salvar() {

    }

    public void IsSelected(long alt) {

        System.out.println("alt" + alt);

    }

    public void AgoraVai(AjaxBehaviorEvent event) {

        Object alt = event.getComponent().getAttributes().get("teste");

    }

    public void cancel() {
        this.formAtivo = false;
        this.gchFormulario = new GchFormulario();
    }

    public void add() {

        this.formAtivo = true;
        this.gchFormulario = new GchFormulario();

    }

    public void SalvarFormulario() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        //Busca parametros concatenados 
        String parametrosCapa           = params.get("formFormulario:TxbParametrosCapa");
        String parametrosPerguntas      = params.get("formFormulario:TxbParametrosPergunta");
        String parametrosAlternativas   = params.get("formFormulario:TxbParametrosAlternativas");

        String inputsCapa   []  = parametrosCapa.split("§");
        String Perguntas    []  = parametrosPerguntas.split("§");
        String Alternativas []  = parametrosAlternativas.split("¬");

        GchFormulario formulario = new GchFormulario();

        Date date = null;
        
        try {

            //Roda inputs da capa
            formulario.setFormNome(inputsCapa[0]); //Nome do Formulário
            formulario.setFormDescricao(inputsCapa[1]); // Descricao do Formulário

            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

            date = (Date) formatter.parse(inputsCapa[2]);
            formulario.setFormPrazoResposta(date);
            
        } catch (ParseException ex) {
            Logger.getLogger(GchFormularioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Somente executa o processo se tiver recebebido as informaçõs de acordo
        if (Perguntas.length == Alternativas.length) {
            
            GchPerguntas pergunta;
            String[] altPergunta;
            GchAlternativasperguntas altperg;

            List<GchAlternativasperguntas> listaAlternativaPergunta = new ArrayList<>();
            List<GchPerguntas> listaPerguntas = new ArrayList<>();
            List<GchAlternativas> AlternativaPergunta = new ArrayList<>();
          
            //Roda input das perguntas
            for (int i = 0; i < Perguntas.length; i++) {

                String codigoPergunta = String.valueOf(i + 1);

                pergunta = new GchPerguntas();
                
                pergunta.setPerCodigo(Long.parseLong(codigoPergunta));
                pergunta.setPerDescricao(Perguntas[i]);
               
               
                //Busca todas alternativas de cada pergunta e armazena no array
                altPergunta = Alternativas[i].split("§");

                //Percorre alternativas da pergunta
                for (int j = 0; j < altPergunta.length; j++) {

                    altperg = new GchAlternativasperguntas();

                    GchAlternativas novaAlternativa = new GchAlternativas();
                    
                    novaAlternativa.setAltCodigo(Long.valueOf(altPergunta[j]));
                    
                    AlternativaPergunta.add(novaAlternativa);
                    
//                    
//                    altperg.setAltCodigo(Long.valueOf(altPergunta[j]));
//                    altperg.setPerCodigo(pergunta);
//                    altperg.setAlpCodigo(indexPerguntaItem);
//                    
//                    listaAlternativaPergunta.add(altperg);

                }

                pergunta.setGchAlternativas(AlternativaPergunta);
                
                AlternativaPergunta.clear();
                
                listaPerguntas.add(pergunta);

            }

            formulario.setPerguntas(listaPerguntas);
            
            //Salva no banco de dados
            gchFormularioService.save(formulario);
           
            
        }
    }

    public void addNovaPergunta() {

        this.gchFormulario.addPergunta(new GchPerguntas(++indexPerguntaItem));

    }

    public void removerPergunta(int index) {

        System.out.println("indice" + index);

        this.gchFormulario.getPerguntas().remove(index);
    }

    public void VincularAlternativaPergunta(List<GchAlternativas> alternativas, GchPerguntas pergunta) {

//        if (!alternativas.isEmpty()) {
//
//            for (GchAlternativas a : alternativas) {
//
//                alternativasPerguntas.setAltCodigo(a.getAltCodigo());
//                alternativasPerguntas.setPerCodigo(pergunta);
//                alternativasPerguntas.setGchAlternativas(a);
//
//                todasAlternativasPerguntas.add(alternativasPerguntas);
//            }
//
//        }
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

    public GchFormulario getGchFormulario() {

//      gchFormulario =  gchFormularioService.findById(1);
//        
//        System.out.println("codigo formulario"+gchFormulario.getFormNome());
//      
//      
        return gchFormulario;
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchFormulario> getGchTodosFormularios() {

        if (gchTodosFormularios == null) {

            gchTodosFormularios = gchFormularioService.findAll();

        }

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

}
