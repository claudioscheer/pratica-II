package br.org.gdt.beans;

import br.org.gdt.enums.EstadoCivil;
import br.org.gdt.enums.Insalubridade;
import br.org.gdt.enums.NomeBanco;
import br.org.gdt.enums.Periculosidade;
import br.org.gdt.enums.PossuiDependentes;
import br.org.gdt.enums.SeguroDesemprego;
import br.org.gdt.enums.Sexo;
import br.org.gdt.enums.TipoBeneficio;
import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.CsbffCargos;
import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.CsbffEscalaHoras;
import br.org.gdt.model.CsbffPessoaBeneficio;
import br.org.gdt.model.CsbffPessoaDependente;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffBeneficiosService;
import br.org.gdt.service.CsbffCargosService;
import br.org.gdt.service.CsbffDependentesService;
import br.org.gdt.service.CsbffEscalaHorasService;
import br.org.gdt.service.CsbffPessoaBeneficioService;
import br.org.gdt.service.RecPessoaService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CsbffDadosProfissionaisBean implements Serializable {

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    @ManagedProperty("#{csbffBeneficiosService}")
    private CsbffBeneficiosService csbffBeneficiosService;
    private List<TipoBeneficio> csbffTipoBeneficiosList;
    private TipoBeneficio tipoBeneficio;
    private CsbffPessoaDependente csbffPessoaDependente;
    private CsbffDependentes csbffDependentes;
    private List<CsbffBeneficios> csbffBeneficiosList;
    private CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    private CsbffEscalaHoras csbffEscalaHoras;
//    private List<CsbffEscalaHoras> todosCsbffEscalaHoras;
    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;
    private List<CsbffCargos> csbffCargosList;
    private CsbffCargos csbffCargos;
    private CsbffPessoaBeneficioService csbffPessoaBeneficioService;
    private CsbffPessoaBeneficio csbffPessoaBeneficio;
    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
    private SeguroDesemprego seguroDesemprego;
    private RecPessoa admissaoDescricao;
    @ManagedProperty("#{csbffDependentesService}")
    private CsbffDependentesService csbffDependentesService;
    private CsbffBeneficios beneficioNome;
    private boolean adicionandoEscala = false;
    private CsbffEscalaHoras diaDaSemana;
    private boolean adicionandoBenficio = false;
    private List<CsbffEscalaHoras> csbffEscalaHorasList;
    private RecPessoa recContrato;

    public CsbffDadosProfissionaisBean() {

    }

    public CsbffDadosProfissionaisBean(CsbffEscalaHoras diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public List<CsbffCargos> getCargos() {
//        return new ArrayList<>();//buscAR do banco
        List<CsbffCargos> cargos = csbffCargosService.findAll();//ISSO BUSCA DO BANCO!!!!!
        return cargos;
    }

    public List<CsbffCargos> getCsbffCargosList() {
        return csbffCargosList;
    }

    public void setCsbffCargosList(List<CsbffCargos> csbffCargosList) {
        this.csbffCargosList = csbffCargosList;
    }

    public List<CsbffBeneficios> getCsbffBeneficiosList() {
        List<CsbffBeneficios> csbffBeneficiosList = csbffBeneficiosService.findAll();
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

    public void setSeguroDesemprego(SeguroDesemprego seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public String buscarPessoa() {
        recPessoa = (RecPessoa) recPessoaService.findByRecCpf(recCpf);
        return null;
    }

    public void alimentaCBO() {
        recPessoa.setCargoCbo(csbffCargos);
    }

    public Sexo[] getGeneros() {
        return Sexo.values();
    }

    public NomeBanco[] getNomeBanco() {
        return NomeBanco.values();
    }

    public PossuiDependentes[] getPossuiDependentes() {
        return PossuiDependentes.values();
    }

    public SeguroDesemprego[] getSeguroDesemprego() {
        return SeguroDesemprego.values();
    }

    public EstadoCivil[] getEstadoCivil() {
        return EstadoCivil.values();
    }

    public Insalubridade[] getInsalubridade() {
        return Insalubridade.values();
    }

    public Periculosidade[] getPericulosidade() {
        return Periculosidade.values();
    }

    public TipoBeneficio[] getTipoBeneficio() {
        return TipoBeneficio.values();
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

//    public String saveDadosProfissionais() {
//        if (recPessoa.getRecIdpessoa() > 0) {
//            recPessoaService.update(recPessoa);
//        }
//        recPessoaList = recPessoaService.findAll();
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
////        String recContrato = ("Sim");
//        return "listaadmissao";
//
//    }
//    public String saveDadosProfissionais() {
//        if (recPessoa.getRecIdpessoa() > 0) {
//            recPessoaService.update(recPessoa);
//        }
//        recPessoaList = recPessoaService.findAll();
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
////        String recContrato = ("Sim");
//        return "listaadmissao";
//
//    }
    public String saveDadosProfissionais() {
        String MsgNotificacao = "";
        try {
            if (recPessoa.getRecIdpessoa() > 0) {
                recPessoaService.update(recPessoa);
                MsgNotificacao = "Os dados do colaborador foram inseridos com Sucesso!";
            }
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");
        } catch (Exception ex) {
            MsgNotificacao = "Os dados não foram inseridos ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("listaadmissao.xhtml");
        } catch (IOException ex) {
        }
        
//        recPessoa.setRecContrato(false);
        return "listaadmissao";

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

    public void removerBeneficioPessoa(CsbffPessoaBeneficio bp) {
        this.recPessoa.getCsbffPessoaBeneficioList().remove(bp);
    }

    public void addBeneficioPessoa() {
        CsbffPessoaBeneficio pb = new CsbffPessoaBeneficio();
        pb.setRecIdpessoa(this.recPessoa);
        pb.setBeneficioCodigo(this.csbffBeneficios);
        if (this.recPessoa.getCsbffPessoaBeneficioList() == null) {
            this.recPessoa.setCsbffPessoaBeneficioList(new ArrayList<>());
        }
        this.recPessoa.getCsbffPessoaBeneficioList().add(pb);
    }

//    public String cancel() {
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
//        return null;
//
//    }

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

    public CsbffPessoaDependente getCsbffPessoaDependente() {
        return csbffPessoaDependente;
    }

    public void setCsbffPessoaDependente(CsbffPessoaDependente csbffPessoaDependente) {
        this.csbffPessoaDependente = csbffPessoaDependente;
    }

    public CsbffDependentes getCsbffDependentes() {
        return csbffDependentes;
    }

    public void setCsbffDependentes(CsbffDependentes csbffDependentes) {
        this.csbffDependentes = csbffDependentes;
    }

    public List<TipoBeneficio> getCsbffTipoBeneficiosList() {
        return csbffTipoBeneficiosList;
    }

    public void setCsbffTipoBeneficiosList(List<TipoBeneficio> csbffTipoBeneficiosList) {
        this.csbffTipoBeneficiosList = csbffTipoBeneficiosList;
    }

    public CsbffBeneficios getCsbffBeneficios() {
        return csbffBeneficios;
    }

    public void setCsbffBeneficios(CsbffBeneficios csbffBeneficios) {
        this.csbffBeneficios = csbffBeneficios;
    }

    public CsbffBeneficiosService getCsbffBeneficiosService() {
        return csbffBeneficiosService;
    }

    public void setCsbffBeneficiosService(CsbffBeneficiosService csbffBeneficiosService) {
        this.csbffBeneficiosService = csbffBeneficiosService;
    }

    public CsbffCargosService getCsbffCargosService() {
        return csbffCargosService;
    }

    public void setCsbffCargosService(CsbffCargosService csbffCargosService) {
        this.csbffCargosService = csbffCargosService;
    }

    public void setCsbffCargos(CsbffCargos csbffCargos) {
        this.csbffCargos = csbffCargos;
    }

    public CsbffCargos getCsbffCargos() {
        return csbffCargos;
    }

    public CsbffPessoaBeneficioService getCsbffPessoaBeneficioService() {
        return csbffPessoaBeneficioService;
    }

    public void setCsbffPessoaBeneficioService(CsbffPessoaBeneficioService csbffPessoaBeneficioService) {
        this.csbffPessoaBeneficioService = csbffPessoaBeneficioService;
    }

    public CsbffPessoaBeneficio getCsbffPessoaBeneficio() {
        return csbffPessoaBeneficio;
    }

    public void setCsbffPessoaBeneficio(CsbffPessoaBeneficio csbffPessoaBeneficio) {
        this.csbffPessoaBeneficio = csbffPessoaBeneficio;
    }

    public RecPessoa getAdmissaoDescricao() {
        return admissaoDescricao;
    }

    public void setAdmissaoDescricao(RecPessoa admissaoDescricao) {
        this.admissaoDescricao = admissaoDescricao;
    }

    public CsbffDependentesService getCsbffDependentesService() {
        return csbffDependentesService;
    }

    public void setCsbffDependentesService(CsbffDependentesService csbffDependentesService) {
        this.csbffDependentesService = csbffDependentesService;
    }

    public String getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(String recCpf) {
        System.out.println("cpp " + recCpf);
        this.recCpf = recCpf;
    }

    public List<CsbffPessoaBeneficio> getCsbffPessoaBeneficioList() {
        return csbffPessoaBeneficioList;
    }

    public void setCsbffPessoaBeneficioList(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
    }

    public CsbffBeneficios getBeneficioNome() {
        return beneficioNome;
    }

    public void setBeneficioNome(CsbffBeneficios beneficioNome) {
        this.beneficioNome = beneficioNome;
    }

    public boolean isAdicionandoBenficio() {
        return adicionandoBenficio;
    }

    public void setAdicionandoBenficio(boolean adicionandoBenficio) {
        this.adicionandoBenficio = adicionandoBenficio;
    }

    public RecPessoa getRecContrato() {
        return recContrato;
    }

    public void setRecContrato(RecPessoa recContrato) {
        this.recContrato = recContrato;
    }

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        return csbffEscalaHoras;
    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public CsbffEscalaHorasService getCsbffEscalaHorasService() {
        return csbffEscalaHorasService;
    }

    public void setCsbffEscalaHorasService(CsbffEscalaHorasService csbffEscalaHorasService) {
        this.csbffEscalaHorasService = csbffEscalaHorasService;
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
        return csbffEscalaHorasList;
    }

    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.csbffEscalaHorasList = csbffEscalaHorasList;
    }

}
