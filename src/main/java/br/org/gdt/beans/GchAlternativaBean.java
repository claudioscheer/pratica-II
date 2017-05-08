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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchAlternativaBean {

    private boolean formAtivo = false;

    private Map<GchAlternativas, Boolean> checked = new HashMap<GchAlternativas, Boolean>();

    private List<GchAlternativas> alternativasVinculadas = new ArrayList<>();
    
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

        String MsgNotificacao = "";
        try {
            if (gchAlternativas.getAltCodigo() > 0) {

                gchAlternativasService.update(gchAlternativas);

                MsgNotificacao = "A alternativa " + gchAlternativas.getAltDescricao() + " foi atualizada com sucesso!";

            } else {

                gchAlternativasService.save(gchAlternativas);

                MsgNotificacao = "A alternatuva " + gchAlternativas.getAltDescricao() + " foi cadastrada com sucesso!";
            }

            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

        } catch (Exception ex) {

            MsgNotificacao = "Houve uma falha ao cadastrar a alternativa " + gchAlternativas.getAltDescricao() + ex.getMessage() + " , tente novamente mais tarde!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

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

}
