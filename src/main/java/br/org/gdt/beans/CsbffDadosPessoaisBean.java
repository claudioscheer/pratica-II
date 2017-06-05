package br.org.gdt.beans;

import br.org.gdt.enums.EstadoCivil;
import br.org.gdt.enums.Sexo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CsbffDadosPessoaisBean implements Serializable {

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    public CsbffDadosPessoaisBean() {

    }

    public Sexo[] getGeneros() {
        return Sexo.values();
    }

    public EstadoCivil[] getEstadoCivil() {
        return EstadoCivil.values();
    }

    public void buscarCpf() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>  CPF:  " + recCpf);
        recPessoa = recPessoaService.findByRecCpf(recCpf);
        if (recPessoa == null) {
            recPessoa = new RecPessoa();
        }
    }

    public List<RecPessoa> getPessoas() {
        List<RecPessoa> pessoas = recPessoaService.findAll();

        return pessoas;
    }

//    public String saveDadosPessoais() {
//        if (recPessoa.getRecIdpessoa() > 0) {
//            recPessoaService.update(recPessoa);
//        }
//        recPessoaList = recPessoaService.findAll();
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
//         return "dadosprofissionais";
//    }

//    public String cancel() {
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
//        return null;
//
//    }
    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("listaadmissao.xhtml");
        } catch (IOException ex) {

        }
    }

    public String saveDadosPessoais() {
        String MsgNotificacao = "";
        try {
            if (recPessoa.getRecIdpessoa() > 0) {
                recPessoaService.update(recPessoa);
                MsgNotificacao = "Os dados do colaborador foram atualizados com Sucesso!";
            }
            
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
        } catch (Exception ex) {
            MsgNotificacao = "Os dados não foram inseridos ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");

        }
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("dadosprofissionais.xhtml");
        } catch (IOException ex) {
        }
        
        return "listaadmissao";
    }
    public String editaConsulta(RecPessoa pessoas) {
//        this.formAtivo = true;
        this.recPessoa = pessoas;
        selectConsulta(pessoas);
        return "dadospessoais";
    }

    public void selectConsulta(RecPessoa pessoas) {
        this.recPessoa = pessoas;

        alteraConsulta(pessoas);

    }

    public String alteraConsulta(RecPessoa pessoas) {

        recPessoaService.update(pessoas);

        return "pessoas";
    }

    public String excluir(RecPessoa pessoas) {
        recPessoaService.delete(pessoas.getRecIdpessoa());
        recPessoaList.remove(pessoas);
        return "pessoas";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public String getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(String recCpf) {
        System.out.println("cpp " + recCpf);
        this.recCpf = recCpf;
    }

}
