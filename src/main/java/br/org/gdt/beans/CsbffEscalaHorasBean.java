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

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;
    CsbffEscalaHoras diaDaSemana;

    private CsbffEscalaHoras csbffEscalaHoras;
    private List<CsbffEscalaHoras> todosCsbffEscalaHoras;
    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    private boolean adicionandoEscala = false;
    private List<CsbffEscalaHoras> csbffEscalaHorasList;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

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

//    public void removerEscala(CsbffEscalaHoras eh) {
//        this.recPessoa.getCsbffEscalaHorasList().remove(eh);
////        csbffEscalaHorasService.delete(csbffEscalaHoras.getEscalaCodigo());
////        todosCsbffEscalaHoras.remove(csbffEscalaHoras);
//    }
        public void removerEscala(CsbffEscalaHoras eh) {
        this.recPessoa.getCsbffEscalaHorasList().remove(eh);
    }


//    public void addEscalaColaborador() {
//        this.formAtivo = true;
//        this.adicionandoEscala = false;
//        this.csbffEscalaHoras = new CsbffEscalaHoras();
//
//    }
//    public String salvarEscalas() {
////        if (recPessoa.getCsbffEscalaHorasList().size() <= 0) {
////            Helper.mostrarNotificacao("Escala", "Preencha todos os campos.", "info");
////            return;
////        }
//        if (csbffEscalaHoras.getEscalaCodigo() > 0) {
////            this.recPessoa.getCsbffEscalaHorasList().add(new CsbffEscalaHoras());
//            csbffEscalaHorasService.update(csbffEscalaHoras);
////            csbffEscalaHorasService.save(csbffEscalaHoras);
//        }
//        todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
//        this.csbffEscalaHoras = new CsbffEscalaHoras();
//        this.formAtivo = false;
//        return "dadosprofissionais";
//
//    }
      public void salvarEscalas() {
//        CsbffEscalaHoras eh = new CsbffEscalaHoras();
        csbffEscalaHoras.setRecIdpessoa(this.recPessoa);
        csbffEscalaHoras.setEscalaCodigo(this.csbffEscalaHoras);
        if (this.recPessoa.getCsbffEscalaHorasList()== null) {
            this.recPessoa.setCsbffEscalaHorasList(new ArrayList<>());
        }
        this.recPessoa.getCsbffEscalaHorasList().add(csbffEscalaHoras);
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

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        if (csbffEscalaHoras == null) {
            csbffEscalaHoras = new CsbffEscalaHoras();
        }
        return csbffEscalaHoras;

    }

    public List<CsbffEscalaHoras> getTodosCsbffEscalaHoras() {
        if (todosCsbffEscalaHoras == null) {
            todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
        }
        return todosCsbffEscalaHoras;
    }

    public void setTodosCsbffEscalaHoras(List<CsbffEscalaHoras> todosCsbffEscalaHoras) {
        this.todosCsbffEscalaHoras = todosCsbffEscalaHoras;
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

    public CsbffEscalaHoras getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(CsbffEscalaHoras diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public List<CsbffEscalaHoras> getCsbffEscalaHorasList() {
        List<CsbffEscalaHoras> csbffEscalaHorasList = csbffEscalaHorasService.findAll();
        return csbffEscalaHorasList;
    }

    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.csbffEscalaHorasList = csbffEscalaHorasList;
    }

}
