package br.org.gdt.beans;

import br.org.gdt.enums.DiasATrabalhar;
import br.org.gdt.model.CsbffEscalaHoras;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.CsbffEscalaHorasService;
import br.org.gdt.service.RecPessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CsbffEscalaHorasBean implements Serializable {

    public void setDiasATrabalhar(DiasATrabalhar diasATrabalhar) {
        this.diasATrabalhar = diasATrabalhar;
    }

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;
//    CsbffEscalaHoras diaDaSemana;
    private CsbffEscalaHoras csbffEscalaHoras = new CsbffEscalaHoras();

    //    private List<CsbffEscalaHoras> todosCsbffEscalaHoras;
    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    private boolean adicionandoEscala = false;
    private List<CsbffEscalaHoras> csbffEscalaHorasList;
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    private DiasATrabalhar diasATrabalhar;

    public CsbffEscalaHorasBean() {

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

    public void addNovaEscala() {
        CsbffEscalaHoras eh = new CsbffEscalaHoras();
        eh.setRecIdpessoa(this.recPessoa);
        eh.setEscalaCodigo(this.csbffEscalaHoras);
        if (this.recPessoa.getCsbffEscalaHorasList() == null) {
            this.recPessoa.setCsbffEscalaHorasList(new ArrayList<>());
        }
        this.recPessoa.getCsbffEscalaHorasList().add(eh);
    }

    public void removerEscala(CsbffEscalaHoras eh) {
        this.recPessoa.getCsbffEscalaHorasList().remove(eh);
    }

//    public String salvarEscalas() {
//        if (csbffEscalaHoras.getEscalaCodigo() > 0) {
//            csbffEscalaHorasService.update(csbffEscalaHoras);
//        }
//        todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
//        this.csbffEscalaHoras = new CsbffEscalaHoras();
//        return "dadosprofissionais";
//    }
    public String salvarEscalas() {
        if (recPessoa.getRecIdpessoa() > 0) {
            recPessoaService.update(recPessoa);
        }
        recPessoaList = recPessoaService.findAll();
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();
//        String recContrato = ("Sim");
        return "dadosprofissionais";
    }

    public String cancelEscala() {
        this.formAtivo = false;
        this.adicionandoEscala = false;
        this.csbffEscalaHoras = new CsbffEscalaHoras();
        return null;
    }

    public String cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();
        return null;

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
        System.out.println("cpp " + recCpf);
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

}
