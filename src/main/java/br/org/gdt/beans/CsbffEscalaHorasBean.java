package br.org.gdt.beans;

import br.org.gdt.enums.DiasATrabalhar;
import static br.org.gdt.enums.DiasATrabalhar.SegundaFeira;
import br.org.gdt.model.CsbffEscalaHoras;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffEscalaHorasService;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class CsbffEscalaHorasBean {

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;
    private CsbffEscalaHoras csbffEscalaHoras = new CsbffEscalaHoras();
    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    private boolean adicionandoEscala = false;
    private List<CsbffEscalaHoras> csbffEscalaHorasList;
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    private DiasATrabalhar diasATrabalhar;
    private List<CsbffEscalaHoras> todasCsbffEscalaHoras;
    private boolean colaboradorInativo;

    public CsbffEscalaHorasBean() {

    }

    public void setDiasATrabalhar(DiasATrabalhar diasATrabalhar) {
        this.diasATrabalhar = diasATrabalhar;
    }

    public CsbffEscalaHorasBean(List<CsbffEscalaHoras> todasCsbffEscalaHoras) {
        this.todasCsbffEscalaHoras = todasCsbffEscalaHoras;
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

    public void addNovaEscala() {
        String MsgNotificacao = "";

//        CsbffEscalaHoras eh = new CsbffEscalaHoras();
        csbffEscalaHoras.setRecIdpessoa(this.recPessoa);
        csbffEscalaHoras.setEscalaCodigo(this.csbffEscalaHoras);

//        if (csbffEscalaHoras.diaDaSemana != null) {
//
//            MsgNotificacao = "Este dia já possui uma escala.";
//            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "info");
//        }
        if (this.recPessoa.getCsbffEscalaHorasList() == null) {
            this.recPessoa.setCsbffEscalaHorasList(new ArrayList<>());
        }
        csbffEscalaHoras.setEscalaDataVigente(new Date());
        this.recPessoa.getCsbffEscalaHorasList().add(csbffEscalaHoras);
        //this.csbffEscalaHorasService.update(csbffEscalaHoras);

    }

    public String removerEscala(CsbffEscalaHoras eh) {

        //this.csbffEscalaHorasService.delete(eh.getEscalaCodigo());
//            recPessoaService.delete(eh.getEscalaCodigo());
        this.recPessoa.getCsbffEscalaHorasList().remove(eh);

//        RequestContext.getCurrentInstance().update("csbffEscalaHorasList");
        return "escalacolaborador";
    }

    public String salvarEscalas() {
        String MsgNotificacao = "";
        try {
            if (recPessoa.getRecIdpessoa() > 0) {
                recPessoaService.update(recPessoa);
                MsgNotificacao = "Os dados da escala foram alterados com Sucesso!";
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");

//            } else {
//                recPessoaService.save(recPessoa);
//                MsgNotificacao = "Os dados da escala foram salvos com Sucesso!";
//                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
            }
        } catch (Exception ex) {
            MsgNotificacao = "Os dados não foram alterados ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
//        FacesContext context = FacesContext.getCurrentInstance();
//        try {
//            context.getExternalContext().redirect("dadosprofissionais.xhtml");
//        } catch (IOException ex) {
//        }

//        recPessoa.setRecContrato(false);
//        recPessoaList = recPessoaService.findAll();
//        todasCsbffEscalaHoras = csbffEscalaHorasService.findAll();
        return "escalacolaborador";

    }

    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();
        this.csbffEscalaHoras = new CsbffEscalaHoras();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("escalacolaborador.xhtml");
        } catch (IOException ex) {

        }
    }

    public DiasATrabalhar[] getDiasATrabalhar() {
        return DiasATrabalhar.values();
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

    public CsbffEscalaHorasService getCsbffEscalaHorasService() {
        return csbffEscalaHorasService;
    }

    public void setCsbffEscalaHorasService(CsbffEscalaHorasService csbffEscalaHorasService) {
        this.csbffEscalaHorasService = csbffEscalaHorasService;
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

    public boolean isAdicionandoEscala() {
        return adicionandoEscala;
    }

    public void setAdicionandoEscala(boolean adicionandoEscala) {
        this.adicionandoEscala = adicionandoEscala;
    }

    public List<CsbffEscalaHoras> getCsbffEscalaHorasList() {
        return csbffEscalaHorasList;
    }

    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.csbffEscalaHorasList = csbffEscalaHorasList;
    }

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        return csbffEscalaHoras;
    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public List<CsbffEscalaHoras> getTodasCsbffEscalaHoras() {
        if (todasCsbffEscalaHoras == null) {
            todasCsbffEscalaHoras = csbffEscalaHorasService.findAll();
        }
        return todasCsbffEscalaHoras;
    }

    public void setTodasCsbffEscalaHoras(List<CsbffEscalaHoras> todasCsbffEscalaHoras) {
        this.todasCsbffEscalaHoras = todasCsbffEscalaHoras;
    }

    public boolean isColaboradorInativo() {
        return colaboradorInativo;
    }

    public void setColaboradorInativo(boolean colaboradorInativo) {
        this.colaboradorInativo = colaboradorInativo;
    }

}
