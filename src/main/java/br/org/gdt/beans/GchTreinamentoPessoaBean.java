/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.GchTreinamentoPessoaService;
import br.org.gdt.service.GchTreinamentosService;
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

    private List<RecPessoa> pessoasVinculadas = new ArrayList<>();

    private GchTreinamentospessoas gchTreinamentospessoas = new GchTreinamentospessoas();
    private List<GchTreinamentospessoas> todosGchTreinamentosPessoas;

    @ManagedProperty("#{gchTreinamentosService}")
    private GchTreinamentosService gchTreinamentosService;

    @ManagedProperty("#{gchTreinamentoPessoaService}")
    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    private RecPessoa id = new RecPessoa(); // gettter / setter

    public GchTreinamentoPessoaBean() {

    }

    public void save() {

//        if (gchTreinamentos.getTreiCodigo() > 0) {
//            gchTreinamentosService.update(gchTreinamentos);
//        } else {
        System.out.println("Aqui estou salvando: ");
        if (gchTreinamentospessoas != null) {
            System.out.println("Teste teste: " + gchTreinamentospessoas.getTreiCodigo().getTreiNome());

            Iterator<RecPessoa> keyIterrator = checked.keySet().iterator();

            while (keyIterrator.hasNext()) {

                RecPessoa pessoa = keyIterrator.next();
                Boolean value = checked.get(pessoa);

                System.out.println(pessoa.getRecNomecompleto() + " - " + value);

                if (value) {

                    gchTreinamentospessoas.setRecIdpessoa(pessoa);
                    gchTreinamentospessoas.setTreiPesDataInicio(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio());
                    gchTreinamentospessoas.setTreiPesDataFim(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim());

                    gchTreinamentospessoasService.update(gchTreinamentospessoas);
                }
            }

//        System.out.println("Salvar: " + pessoasVinculadas.get(0).getRecNomecompleto());
//        gchTreinamentospessoas.setRecIdpessoa(pessoasVinculadas.get(0));
//        }
            this.formAtivo = false;
            gchTreinamentospessoas = new GchTreinamentospessoas();
            checked = new HashMap<RecPessoa, Boolean>();

            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect("Treinamentos.xhtml");
            } catch (IOException ex) {

            }

        }
//        return "Treinamentos.xhtml";
    }

    
    public void removeMarcado(){
            
        checked.replace(id, false);
    
        id = new RecPessoa();
    }
    
    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();
        checked = new HashMap<RecPessoa, Boolean>();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Treinamentos.xhtml");
        } catch (IOException ex) {

        }
    }

    public void add() {
        System.out.println("Aqui tambem ta tretando");
        this.formAtivo = true;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();
    }

    public String excluir(GchTreinamentospessoas gchTreinamentosPessoas) {
        gchTreinamentospessoasService.delete(gchTreinamentosPessoas.getTreiPescodigo());
        todosGchTreinamentosPessoas.remove(gchTreinamentosPessoas);
//        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "Treinamentos.xhtml?faces-redirect=true");
        return "Treinamentos";
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
            System.out.println("Ta certo");
            this.gchTreinamentospessoas.setTreiCodigo(gchTreinamentos);
        } else {

            System.out.println("Esta nulo o treinamento");
        }

        return "VincularPessoasTreinamento";
    }

    public void podeVincularPessoa(AjaxBehaviorEvent event) {

        System.out.println("Aqui ");

        FacesContext facesContext = FacesContext.getCurrentInstance();

        RecPessoa pessoa = (RecPessoa) event.getComponent().getAttributes().get("pessoa");

        id = pessoa;
        
        boolean marcou = checked.get(pessoa);

        if (marcou) {

            List<GchTreinamentospessoas> list = gchTreinamentospessoasService.verificaPessoa(gchTreinamentospessoas.getTreiCodigo().getTreiCodigo(), pessoa.getRecIdpessoa());

            for (GchTreinamentospessoas t : list) {

                if (!verificaPessoa(t)) {

                    RequestContext.getCurrentInstance().execute("PF('confirmDlg').show();");

                    break;
                }

            }

        }

    }

    private boolean verificaPessoa(GchTreinamentospessoas t) {

        boolean podeVincular = true;

        if (t.getTreiPesDataInicio().equals(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio())
                || t.getTreiPesDataFim().equals(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim())) {

            podeVincular = false;

        }

        if (t.getTreiPesDataInicio().before(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio())
                && t.getTreiPesDataFim().after(gchTreinamentospessoas.getTreiCodigo().getTreiDataInicio())) {

            podeVincular = false;

        }

        if (t.getTreiPesDataInicio().after(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim())
                && t.getTreiPesDataFim().before(gchTreinamentospessoas.getTreiCodigo().getTreiDataFim())) {

            podeVincular = false;

        }

        return podeVincular;
    }

    public String buscaTreinamentoPorId(long id) {

        System.out.println("Id Treinamento" + id);
        gchTreinamentospessoas = null;
        if (id != 0) {

            gchTreinamentospessoas.setTreiCodigo(gchTreinamentosService.findById(id));

////            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "VincularPessoasTreinamento.xhtml?faces-redirect=true");
//            FacesContext context = FacesContext.getCurrentInstance();
//            try {
//                context.getExternalContext().redirect("VincularPessoasTreinamento.xhtml");
//            } catch (IOException ex) {
//
//            }
            return "VincularPessoasTreinamento";
        }
        return null;
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

        System.out.println("Marcando: " + checked.values());

        this.checked = checked;
    }

    public List<RecPessoa> getPessoasVinculadas() {
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

}
