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
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean

@ViewScoped
public class GchAlternativaBean {

    private boolean formAtivo = false;

    private Map<GchAlternativas, Boolean> checked = new HashMap<GchAlternativas, Boolean>();

    private List<GchAlternativas> alternativasVinculadas;
    
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
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
     
    public void onItemSelect(SelectEvent event) {
//    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selecionado", event.getObject().toString()));
        
        System.out.println("OLAAAA");
        //
        
    }
    
    public String VinculaPerguntaAlternativa(){
        
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	 
      FacesContext context = FacesContext.getCurrentInstance();
      String a = (String) UIComponent.getCurrentComponent(context).getAttributes().get("teste");
        
//        String action = params.get("formFormulario:j_idt70:"+index+":alternativas_hinput");
        
        GchAlternativasperguntas altPergunta = new GchAlternativasperguntas();
        
//        altPergunta.setAltCodigo(alt.getAltCodigo());
        
        GchPerguntas pergunta = new GchPerguntas();
        
//        pergunta.setPerCodigo(perg.getPerCodigo());
//        pergunta.setPerDescricao(perg.getPerDescricao());
    
        altPergunta.setPerCodigo(pergunta);
    
        altPerLista.add(altPergunta);
        
        System.out.println("Entrou");
        
        return null;
    }
    
    public List<GchAlternativas> CompleteAlternativas(String query) {
        List<GchAlternativas> TodasAlternativas = gchAlternativasService.findAll();
        List<GchAlternativas> AlternativasFiltradas = new ArrayList<GchAlternativas>();
         
        for (int i = 0; i < TodasAlternativas.size(); i++) {
            GchAlternativas alternativa = TodasAlternativas.get(i);
            if(alternativa.getAltDescricao().toLowerCase().startsWith(query)) {
                
                AlternativasFiltradas.add(alternativa);
            }
        }
        
        return AlternativasFiltradas;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchAlternativas = new GchAlternativas();
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
        
//        String MsgNotificacao = "";
//        try {
//            if (gchAlternativas.getAltCodigo() > 0) {
//
//                gchAlternativasService.update(gchAlternativas);
//
//                MsgNotificacao = "A alternativa " + gchAlternativas.getAltDescricao() + " foi atualizada com sucesso!";
//
//            } else {
//
//                gchAlternativasService.save(gchAlternativas);
//
//                MsgNotificacao = "A alternatuva " + gchAlternativas.getAltDescricao() + " foi cadastrada com sucesso!";
//            }
//
//            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
//
//        } catch (Exception ex) {
//
//            MsgNotificacao = "Houve uma falha ao cadastrar a alternativa " + gchAlternativas.getAltDescricao() + ex.getMessage() + " , tente novamente mais tarde!";
//            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
//        }

        return "Alternativas";

    }

    public void vincularAlternativas(){
        
        System.out.println("Teste teste: " + gchAlternativas.getAltCodigo());

        Iterator<GchAlternativas> keyIterrator = checked.keySet().iterator();

        while (keyIterrator.hasNext()) {

            GchAlternativas alt = keyIterrator.next();
            Boolean value = checked.get(alt);

            System.out.println(alt.getAltDescricao() + " - " + value);

            if (value) {

                System.out.println("Está marcado");
                
                GchAlternativasperguntas altperg = new GchAlternativasperguntas();
                
                altperg.setAltCodigo(alt.getAltCodigo());
                altperg.setGchAlternativas(gchAlternativas);
                
                GchPerguntas pergunta = new GchPerguntas();
                
                pergunta.setPerCodigo(Long.MIN_VALUE);
                
                altperg.setPerCodigo(pergunta);
                altperg.setAlpCodigo(Long.MIN_VALUE);
                
                altPerLista.add(altperg);
                

            }
        }

        
        
        
//        System.out.println("Salvar: " + pessoasVinculadas.get(0).getRecNomecompleto());
//        gchTreinamentospessoas.setRecIdpessoa(pessoasVinculadas.get(0));
//        }
//        todosGchTreinamentosPessoas = null;
//        this.formAtivo = false;
//        gchTreinamentospessoas = null;
//        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "Treinamentos.xhtml");
        
        
    }
    
    
    public String excluir(GchAlternativas gchAlternativas) {

        String MsgNotificacao = "";

        try {

            if (gchAlternativas != null) {

                gchAlternativasService.delete(gchAlternativas.getAltCodigo());
                gchTodasAlternativas.remove(gchAlternativas);
                MsgNotificacao = "A alternativa " + gchAlternativas.getAltDescricao() + " foi excluída com sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

            }

        } catch (Exception ex) {
            MsgNotificacao = "Uma Exceção não tratada impediu a exclusão da alternativa!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");
        }

        return "Formularios";
    }

    public GchAlternativas getGchAlternativa() {
        return gchAlternativas;
    }

    public void setGchAlternativa(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public List<GchAlternativas> getGchTodasAlternativas() {

        try {

            System.out.println("Entrou na Bean");

            if (gchTodasAlternativas == null) {

                gchTodasAlternativas = gchAlternativasService.findAll();

            }

            System.out.println("Saindo da Bean");

        } catch (Exception ex) {

            System.out.println("DEu excecãooooo " + ex.toString());

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
