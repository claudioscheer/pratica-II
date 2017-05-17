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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
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

    public List<GchAlternativas> getAlternativasVinculadas() {
        return alternativasVinculadas;
    }

    public void setAlternativasVinculadas(List<GchAlternativas> alternativasVinculadas) {
        this.alternativasVinculadas = alternativasVinculadas;
    }

    private List<PerguntasAlternativas> PergAlt;
////
//    @ManagedProperty("#{gchAlternativaCertoService}")
//    private GchCadastroAlternativaServiceCerto gchAlternativasService;
////
//    private GchAlternativasperguntas alternativasPerguntas = new GchAlternativasperguntas();
//    public List<GchAlternativasperguntas> todasAlternativasPerguntas;
//
    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    public GchFormularioBean() {
        gchFormulario.addPergunta(new GchPerguntas(1)); 
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

    public void alimentarVariaveis() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("MontarPerguntasAlternativas()");

    }

    public void SalvarFormulario() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        //Busca parametros concatenados 
        String parametrosCapa = params.get("formFormulario:TxbParametrosCapa");
        String parametrosPerguntas = params.get("formFormulario:TxbParametrosPergunta");
        String parametrosAlternativas = params.get("formFormulario:TxbParametrosAlternativas");

        String inputsCapa[] = parametrosCapa.split("§");
        String Perguntas[] = parametrosPerguntas.split("§");
        String Alternativas[] = parametrosAlternativas.split("¬");

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

                GchAlternativas novaAlternativa = new GchAlternativas();

                //Busca todas alternativas de cada pergunta e armazena no array
                altPergunta = Alternativas[i].split("§");

                //Percorre alternativas da pergunta
                for (int j = 0; j < altPergunta.length; j++) {

//                     novaAlternativa.setAltCodigo(Long.parseLong(altPergunta[j]));
                    novaAlternativa = gchAlternativasService.findById(Long.parseLong(altPergunta[j]));

                    altperg = new GchAlternativasperguntas();

                    altperg.setAltCodigo(novaAlternativa);
//                    altperg.setPerAltCodigo(Long.parseLong(altPergunta[j])); //essa nao precisa ter pq essa vai ser alimentado pelo sequence
                    //To ligado, vamos testar? Gruda
                    altperg.setPerCodigo(pergunta);
                    //aqui nao teria que ter classe inteira GchAlternativa?
                    //Tipo so ta passando o codigo isso costuma dar problema

                    //Poisé, eu to achanado que só precisaria desse altperg que é do tipo alternativasperguntas
                    //Tipo assim
                    //agora tu vai ter que passar a classe inteira 
                    //como tu fez com o setPerCodigo
                    listaAlternativaPergunta.add(altperg);

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

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

}
