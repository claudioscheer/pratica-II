/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean

@RequestScoped
public class GchAlternativaBean {

    private boolean formAtivo = false;

    private Map<GchAlternativas, Boolean> checked = new HashMap<GchAlternativas, Boolean>();

    private List<GchAlternativas> alternativasVinculadas = new ArrayList<>();

    private String codigo;

    private List<GchAlternativasperguntas> altPerLista = new ArrayList<>();

    public List<GchAlternativasperguntas> getAltPerLista() {
        return altPerLista;
    }

    public void setAltPerLista(List<GchAlternativasperguntas> altPerLista) {
        this.altPerLista = altPerLista;
    }

    private GchAlternativas gchAlternativas = new GchAlternativas();
    private List<GchAlternativas> gchTodasAlternativas;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    public GchAlternativaBean() {

    }

    public List<String> completeText(String query) {

        System.out.println("Agora vai");

        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;
    }

    public void onItemSelect(SelectEvent event) {
//    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selecionado", event.getObject().toString()));

        System.out.println("OLAAAA");
        //

    }

    public String VincularAlternativa(FacesContext event) {

        Map<String, String> parameterMap = (Map<String, String>) event.getExternalContext().getRequestParameterMap();

        String param = parameterMap.get("valorPerguntas");

        System.out.println("Valor recebido por parametro" + param);

        return "1";
    }

    public String VinculaPerguntaAlternativa() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String param = params.get("valorPerguntas");

        System.out.println("valor recebido" + param);

        FacesContext context = FacesContext.getCurrentInstance();
        String a = (String) UIComponent.getCurrentComponent(context).getAttributes().get("teste");

//        String action = params.get("formFormulario:j_idt70:"+index+":alternativas_hinput");
        GchAlternativasperguntas altPergunta = new GchAlternativasperguntas();

//        altPergunta.setAltCodigo(alt.getAltCodigo());
        GchPerguntas pergunta = new GchPerguntas();

//        pergunta.setPerCodigo(perg.getPerCodigo());
//        pergunta.setPerDescricao(perg.getPerDescricao());
//        altPergunta.setPerCodigo(pergunta);
        altPerLista.add(altPergunta);

        System.out.println("Entrou");

        return null;
    }

    public List<GchAlternativas> CompleteAlternativas(String query) {

        String filterValue = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("teste");

        List<GchAlternativas> TodasAlternativas = gchAlternativasService.findAll();
        List<GchAlternativas> AlternativasFiltradas = new ArrayList<GchAlternativas>();

        for (int i = 0; i < TodasAlternativas.size(); i++) {
            GchAlternativas alternativa = TodasAlternativas.get(i);
            if (alternativa.getAltDescricao().toLowerCase().startsWith(query)) {

                AlternativasFiltradas.add(alternativa);
            }
        }

        return AlternativasFiltradas;
    }

    public String cancel() {
        this.formAtivo = false;
        this.gchAlternativas = new GchAlternativas();
        return "Alternativas";
    }

    public void add() {

        this.formAtivo = true;
        this.gchAlternativas = new GchAlternativas();

    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public void setGchAlternativas(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public String save() {

        System.out.println("Chegou");

        String MsgNotificacao = "";
        try {
            if (gchAlternativas.getAltCodigo() > 0) {

                gchAlternativasService.update(gchAlternativas);

                MsgNotificacao = "A alternativa <b>" + gchAlternativas.getAltDescricao() + " </b>foi atualizada com sucesso!";

            } else {

                gchAlternativasService.save(gchAlternativas);

                MsgNotificacao = "A alternativa <b>" + gchAlternativas.getAltDescricao() + " </b>foi cadastrada com sucesso!";
            }

            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

        } catch (Exception ex) {

            MsgNotificacao = "Houve uma falha ao cadastrar a alternativa <b>" + gchAlternativas.getAltDescricao() + ex.getMessage() + " , </b>tente novamente mais tarde!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

        gchTodasAlternativas = null; //Limpa a variavel e garante que a lista de alternativas seja atualizada corretamente
        
        return "Alternativas";

    }

    public String buscaPorId(int idAlternativa) {

        System.out.println("Id do curso" + idAlternativa);

        if (idAlternativa != 0) {

            gchAlternativas = gchAlternativasService.findById(idAlternativa);

            return "CadastroAlternativas";

        }

        return null;

    }

    public String excluir(GchAlternativas gchAlternativas) {

        String MsgNotificacao = "";

        try {

            if (gchAlternativas != null) {

                gchAlternativasService.delete(gchAlternativas.getAltCodigo());
                gchTodasAlternativas.remove(gchAlternativas);
                MsgNotificacao = "A alternativa <b>" + gchAlternativas.getAltDescricao() + " </b>foi excluída com sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

            }

        } catch (Exception ex) {

            //Excessão de Fk Perguntas
            if (ex.toString().indexOf("fk_rlxnrgqkge2ynq1dulrv80omv") > 0) {

                MsgNotificacao = "Esta alternativa já está vinculada a <b>perguntas</b> de um formulário e não pode ser excluída!";

            } else {

                //Excessao de fk REspostas
                if (ex.toString().indexOf("fk_6flos8clp2yfpo91p7pdarwgn") > 0) {
                    MsgNotificacao = "Esta alternativa já está vinculada a <b>respostas</b> de um formulário e não pode ser excluída!";
                } else {

                    MsgNotificacao = "Uma Exceção não tratada impediu a exclusão da alternativa!" + ex.toString();
                }

            }

            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

        return "Alternativas";
    }

    public GchAlternativas getGchAlternativa() {
        return gchAlternativas;
    }

    public void setGchAlternativa(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public List<GchAlternativas> getGchTodasAlternativas() {
        if (gchTodasAlternativas == null) {
            gchTodasAlternativas = gchAlternativasService.findAll();
        }

        return gchTodasAlternativas;
    }

    public void setGchTodasAlternativas(List<GchAlternativas> gchTodasAlternativas) {
        this.gchTodasAlternativas = gchTodasAlternativas;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    public Map<GchAlternativas, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<GchAlternativas, Boolean> checked) {
        this.checked = checked;
    }

    public List<GchAlternativas> getAlternativasVinculadas() {
        return alternativasVinculadas;
    }

    public void setAlternativasVinculadas(List<GchAlternativas> alternativasVinculadas) {
        this.alternativasVinculadas = alternativasVinculadas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
