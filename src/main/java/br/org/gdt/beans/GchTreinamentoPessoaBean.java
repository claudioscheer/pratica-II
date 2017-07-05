/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.GerenciadorEmail;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchTreinamentoPessoaService;
import br.org.gdt.service.GchTreinamentosService;
import br.org.gdt.service.RecPessoaService;
import com.oracle.jrockit.jfr.ContentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.mail.Address;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class GchTreinamentoPessoaBean {

    private boolean formAtivo = false;

    private Map<RecPessoa, Boolean> checked = new HashMap<RecPessoa, Boolean>();

    private List<RecPessoa> pessoasVinculadas;

    private GchTreinamentospessoas gchTreinamentospessoas = new GchTreinamentospessoas();
    private List<GchTreinamentospessoas> todosGchTreinamentosPessoas;

    @ManagedProperty("#{gchTreinamentosService}")
    private GchTreinamentosService gchTreinamentosService;

    @ManagedProperty("#{gchTreinamentoPessoaService}")
    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    private List<RecPessoa> todosColaboradores;

    private RecPessoa inputHidden;

    private RecPessoa recPessoa;

    private RecPessoa id = new RecPessoa();

    private long idTreinamento;

    public GchTreinamentoPessoaBean() {

    }

    public void save(boolean isPoupup) {

        if (!isPoupup) {

            if (podeVincularPessoa()) {
                salvar();
            }

        } else {
            salvar();
        }

    }

    public void salvar() {

        if (recPessoa != null) {

            gchTreinamentospessoas.setRecIdpessoa(recPessoa);
            gchTreinamentospessoas.setTreiPesDataInicio(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio());
            gchTreinamentospessoas.setTreiPesDataFim(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim());

            boolean existe = todosGchTreinamentosPessoas.stream().filter(o -> o.getRecIdpessoa().equals(gchTreinamentospessoas.getRecIdpessoa())).findFirst().isPresent();

            if (!existe) {

                gchTreinamentospessoasService.update(gchTreinamentospessoas);
                todosGchTreinamentosPessoas = null;
                recPessoa = null;

            } else {

                RequestContext.getCurrentInstance().execute("PF('erroMessage').show();");

            }

        }
    }

//    public void save() {
//
//        if (gchTreinamentospessoas != null) {
//
//            Iterator<RecPessoa> keyIterrator = checked.keySet().iterator();
//
//            while (keyIterrator.hasNext()) {
//
//                RecPessoa pessoa = keyIterrator.next();
//                Boolean value = checked.get(pessoa);
//
//                if (value) {
//
//                    gchTreinamentospessoas.setRecIdpessoa(pessoa);
//                    gchTreinamentospessoas.setTreiPesDataInicio(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio());
//                    gchTreinamentospessoas.setTreiPesDataFim(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim());
//
//                    gchTreinamentospessoasService.update(gchTreinamentospessoas);
//                }
//            }
//
//            this.formAtivo = false;
//            gchTreinamentospessoas = new GchTreinamentospessoas();
//            checked = new HashMap<RecPessoa, Boolean>();
//
//            FacesContext context = FacesContext.getCurrentInstance();
//            try {
//                context.getExternalContext().redirect("Treinamentos.xhtml");
//            } catch (IOException ex) {
//
//            }
//
//        }
//
//    }
    public void removeMarcado() {

        checked.replace(id, false);

        id = new RecPessoa();
    }

    public List<RecPessoa> completePessoa(String query) {

        todosColaboradores = recPessoaService.buscarNomes(query);

        return todosColaboradores;

    }

    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();
        checked = new HashMap<RecPessoa, Boolean>();
        pessoasVinculadas = new ArrayList<>();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Treinamentos.xhtml");
        } catch (IOException ex) {

        }
    }

    public void add() {

        this.formAtivo = true;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();

    }

    public String excluir(GchTreinamentospessoas gchTreinamentosPessoas) {
        gchTreinamentospessoasService.delete(gchTreinamentosPessoas.getTreiPescodigo());
        todosGchTreinamentosPessoas.remove(gchTreinamentosPessoas);
        Helper.mostrarNotificacao("Sucesso", "<b>" + gchTreinamentosPessoas.getRecIdpessoa().getRecNomecompleto() + "</b> foi removido com sucesso!", "success");
        return "VincularPessoasTreinamento";
    }

    public void adicionaPessoa(RecPessoa recPessoa) {

        if (recPessoa.getRecIdpessoa() == 0) {
            return;
        }

        pessoasVinculadas.add(recPessoa);

    }

    public String prepareEdit(GchTreinamentos gchTreinamentos) {
        this.formAtivo = true;

        if (gchTreinamentos != null) {

            todosGchTreinamentosPessoas = null;
            this.gchTreinamentospessoas.setTreiCodigo(gchTreinamentos);

            idTreinamento = gchTreinamentos.getTreiCodigo();

//            List<GchTreinamentospessoas> gchTreinemntoPessoasList =  gchTreinamentospessoasService.verificaPessoasVinculadoTreinamento(gchTreinamentos.getTreiCodigo());
//            
//            for (GchTreinamentospessoas gchTreinamentospessoa : gchTreinemntoPessoasList){
//            
//                checked.replace(gchTreinamentospessoa.getRecIdpessoa(), true);
//                
//            }
        }

        return "VincularPessoasTreinamento";
    }

    public boolean podeVincularPessoa() {

        if (recPessoa != null) {

            List<GchTreinamentospessoas> list = gchTreinamentospessoasService.verificaPessoa(gchTreinamentospessoas.getTreiCodigo().getTreiCodigo(), recPessoa.getRecIdpessoa());

            for (GchTreinamentospessoas t : list) {

                if (!verificaPessoa(t) && !t.getTreiCodigo().equals(gchTreinamentospessoas.getTreiCodigo())) {

                    RequestContext.getCurrentInstance().execute("PF('confirmDlg').show();");

                    return false;
                }

            }
        }
        return true;
    }

    private boolean verificaPessoa(GchTreinamentospessoas t) {

        boolean podeVincular = true;

        if (t.getTreiPesDataInicio().equals(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio())
                || t.getTreiPesDataFim().equals(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim())) {

            podeVincular = false;

        }

        if (gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio().before(t.getTreiPesDataInicio())
                && gchTreinamentospessoas.getTreiCodigo().getTreiDataFim().after(t.getTreiPesDataInicio())) {

            podeVincular = false;

        }

        if (gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio().before(t.getTreiPesDataFim())
                && gchTreinamentospessoas.getTreiCodigo().getTreiDataFim().after(t.getTreiPesDataFim())) {

            podeVincular = false;

        }

        return podeVincular;
    }

    public String buscaTreinamentoPorId(long id) {

        gchTreinamentospessoas = null;
        if (id != 0) {

            gchTreinamentospessoas.setTreiCodigo(gchTreinamentosService.findById(id));

            return "VincularPessoasTreinamento";
        }
        return null;
    }

    public String enviarEmail(){
    
//        GerenciadorEmail email = new GerenciadorEmail();
    
        String destinatarios = "";
        String assunto = "Treinamento";
        String mensagem = "Você foi vinculado ao treinamento";
        
        for (GchTreinamentospessoas pessoa : todosGchTreinamentosPessoas){
        
            if (destinatarios.isEmpty()){
            
                destinatarios = pessoa.getRecIdpessoa().getRecEmail();
                
            }else{
            
                destinatarios += "," + pessoa.getRecIdpessoa().getRecEmail();
            
            }
        
        }
        
        
        boolean enviou = new GerenciadorEmail().enviarEmail(destinatarios, assunto, mensagem);
        
        if (enviou){
        
            Helper.mostrarNotificacao("Sucesso", "Notificação por e-mail enviado com sucesso!", "success");
        
        }else{
        
            Helper.mostrarNotificacao("Erro", "Não foi possível realizar o envio da notificação por e-mail.", "error");
            
        }
        
        return "VincularPessoasTreinamento";
        
    }
    
    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchTreinamentospessoas getGchTreinamentospessoas() {
        return gchTreinamentospessoas;
    }

    public void setGchTreinamentospessoas(GchTreinamentospessoas gchTreinamentospessoas) {
        this.gchTreinamentospessoas = gchTreinamentospessoas;
    }

    public List<GchTreinamentospessoas> getTodosGchTreinamentosPessoas() {

        if (todosGchTreinamentosPessoas == null) {

            todosGchTreinamentosPessoas = gchTreinamentospessoasService.pessoasTreinamento(idTreinamento);

        }

        return todosGchTreinamentosPessoas;
    }

    public void setTodosGchTreinamentosPessoas(List<GchTreinamentospessoas> todosGchTreinamentosPessoas) {
        this.todosGchTreinamentosPessoas = todosGchTreinamentosPessoas;
    }

    public GchTreinamentoPessoaService getGchTreinamentospessoasService() {
        return gchTreinamentospessoasService;
    }

    public void setGchTreinamentospessoasService(GchTreinamentoPessoaService gchTreinamentospessoasService) {
        this.gchTreinamentospessoasService = gchTreinamentospessoasService;
    }

    public Map<RecPessoa, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<RecPessoa, Boolean> checked) {

        this.checked = checked;
    }

    public List<RecPessoa> getPessoasVinculadas() {
        if (pessoasVinculadas == null) {
            pessoasVinculadas = recPessoaService.findAll();

        }

        return pessoasVinculadas;
    }

    public void setPessoasVinculadas(List<RecPessoa> pessoasVinculadas) {
        this.pessoasVinculadas = pessoasVinculadas;
    }

    public GchTreinamentosService getGchTreinamentosService() {
        return gchTreinamentosService;
    }

    public void setGchTreinamentosService(GchTreinamentosService gchTreinamentosService) {
        this.gchTreinamentosService = gchTreinamentosService;
    }

    public RecPessoa getId() {
        return id;
    }

    public void setId(RecPessoa id) {
        this.id = id;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public long getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(long idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public RecPessoa getInputHidden() {
        return inputHidden;
    }

    public void setInputHidden(RecPessoa inputHidden) {
        this.inputHidden = inputHidden;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getTodosColaboradores() {
        return todosColaboradores;
    }

    public void setTodosColaboradores(List<RecPessoa> todosColaboradores) {
        this.todosColaboradores = todosColaboradores;
    }

}
