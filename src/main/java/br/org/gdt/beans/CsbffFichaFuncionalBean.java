package br.org.gdt.beans;

import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.FichaFuncional.FichaFuncional;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CsbffFichaFuncionalBean {

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    private boolean colaboradorInativo;
    @ManagedProperty("#{fichaFuncional}")
    private FichaFuncional fichaFuncional;

    public CsbffFichaFuncionalBean() {

    }

    public void buscarCpf() {
        recPessoa = recPessoaService.findByRecCpf(recCpf);
        String MsgNotificacao = "";
        while (recPessoa == null) {
            MsgNotificacao = "A pessoa não existe.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "error");
            return;
        }
        if (recPessoa.colaboradorInativo == true) {
            MsgNotificacao = "O colaborador está inativo.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "info");
        }
        if (recPessoa == null) {
            recPessoa = new RecPessoa();

        }

    }

    public List<RecPessoa> getPessoas() {
        List<RecPessoa> pessoas = recPessoaService.findAll();

        return pessoas;
    }

    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("listaadmissao.xhtml");
        } catch (IOException ex) {

        }
    }
    public void imprimirFichaFuncional() throws Exception {
//        try {
//            List<FpFolhaPeriodo> folhasPeriodo = new ArrayList<>();
//            folhasPeriodo.add(fpFolhaPeriodo);
 
            fichaFuncional.gerarFichaFuncional(recPessoa);
//        } catch (Exception e) {
//            Helper.mostrarNotificacao("Erro", e.getMessage(), "error");
//        }
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
        this.recCpf = recCpf;
    }

    public boolean isColaboradorInativo() {
        return colaboradorInativo;
    }

    public void setColaboradorInativo(boolean colaboradorInativo) {
        this.colaboradorInativo = colaboradorInativo;
    }

    public FichaFuncional getFichaFuncional() {
        return fichaFuncional;
    }

    public void setFichaFuncional(FichaFuncional fichaFuncional) {
        this.fichaFuncional = fichaFuncional;
    }

}
