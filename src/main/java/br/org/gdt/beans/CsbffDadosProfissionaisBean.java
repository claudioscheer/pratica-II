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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CsbffDadosProfissionaisBean {

    private boolean formAtivo = false;
    private String recCpf;
    private boolean habilitar;

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
    private List<CsbffBeneficios> beneficios;
    private CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;
    private List<CsbffCargos> csbffCargosList;
    private CsbffCargos csbffCargos;
    private boolean adicionandoBenficio = false;
    private RecPessoa recContrato;
    private SeguroDesemprego seguroDesemprego;
//    private RecPessoa admissaoDescricao;

    @ManagedProperty("#{csbffDependentesService}")
    private CsbffDependentesService csbffDependentesService;
    private CsbffBeneficios beneficioNome;

    @ManagedProperty("#{csbffPessoaBeneficioService}")
    private CsbffPessoaBeneficioService csbffPessoaBeneficioService;
    private CsbffPessoaBeneficio csbffPessoaBeneficio = new CsbffPessoaBeneficio();
    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
    private CsbffPessoaBeneficio pessoaBeneficioCodigo;

    private boolean adicionandoEscala = false;
    private CsbffEscalaHoras csbffEscalaHoras;
    private CsbffEscalaHoras diaDaSemana;
    private List<CsbffEscalaHoras> csbffEscalaHorasList;

    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    private CsbffEscalaHoras escalaCodigo;
    private boolean recFuncionario;
    private boolean colaboradorInativo;

    public CsbffDadosProfissionaisBean() {

    }

    public void selecionarInsalubridade() {
        if (recPessoa.getInsalubridade() != null && recPessoa.getInsalubridade() != Insalubridade.Não) {
            recPessoa.setRecPericulosidade(null);
        }
    }

    public void selecionarPericulosidade() {
        if (recPessoa.getRecPericulosidade() != null && recPessoa.getRecPericulosidade() != Periculosidade.Não) {
            recPessoa.setInsalubridade(null);
        }
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

//    public void alimentaCBO() {
//        recPessoa.setCargoCbo(csbffCargos);
//    }
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

    public String demitirColaborador() {

        String MsgNotificacao = "";
        try {
            recPessoa.setColaboradorInativo(true);
            recPessoa.setRecDtaDemissao(new Date());
            recPessoa.setRecFuncionario(false);
            recPessoaService.update(recPessoa);

            MsgNotificacao = "O colaborador foi demitido e inativado!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");
        } catch (Exception ex) {
            MsgNotificacao = "O colaborador não pode ser demitido.";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
        return "listaadmissao";

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

    public String editarEscala(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
        selectEscala(csbffEscalaHoras);
        return "escalacolaborador";
    }

    public String alteraEscala(CsbffEscalaHoras csbffEscalaHoras) {
        escalaCodigo = csbffEscalaHoras;
        csbffEscalaHorasService.update(csbffEscalaHoras);

        return "escalacolaborador";
    }

    public void selectEscala(CsbffEscalaHoras csbffEscalaHoras) {

        this.csbffEscalaHoras = csbffEscalaHoras;
        escalaCodigo = csbffEscalaHoras;
        alteraEscala(csbffEscalaHoras);

    }

    public String removerBeneficioPessoa(CsbffPessoaBeneficio csbffPessoaBeneficio) {

        this.recPessoa.getCsbffPessoaBeneficioList().remove(csbffPessoaBeneficio);

        return "dadosprofissionais";
    }

    public void addBeneficioPessoa() {
        if (this.csbffBeneficios == null) {
            Helper.mostrarNotificacao("Benefício", "Selecione um benefício.", "error");
            return; 
        }

        CsbffPessoaBeneficio pessoaBeneficio = new CsbffPessoaBeneficio();
        pessoaBeneficio.setRecIdpessoa(this.recPessoa);
        pessoaBeneficio.setBeneficioCodigo(this.csbffBeneficios);

        if (this.recPessoa.getCsbffPessoaBeneficioList() == null) {
            this.recPessoa.setCsbffPessoaBeneficioList(new ArrayList<>());
        }

        if (this.recPessoa.getCsbffPessoaBeneficioList().stream()
                .filter(x -> x.getBeneficioCodigo().getBeneficioCodigo() == this.csbffBeneficios.getBeneficioCodigo())
                .count() > 0) {
            Helper.mostrarNotificacao("Benefício", "Este benefício já foi adicionado.", "error");
            return;
        }

        this.recPessoa.getCsbffPessoaBeneficioList().add(pessoaBeneficio);
    }

    public String saveDadosProfissionais() {
        String MsgNotificacao = "";
        try {
            if (recPessoa.getRecIdpessoa() > 0) {
//                this.recFuncionario = true;
                recPessoa.setRecFuncionario(true);
                recPessoaService.update(recPessoa);
//            }else{
//                recPessoaService.save(recPessoa);
            }
            MsgNotificacao = "Os dados do colaborador foram atualizados com Sucesso!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");
        } catch (Exception ex) {
            MsgNotificacao = "Os dados não foram atualizados ";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

        recPessoaList = recPessoaService.findAll();
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

//    public RecPessoa getAdmissaoDescricao() {
//        return admissaoDescricao;
//    }
//
//    public void setAdmissaoDescricao(RecPessoa admissaoDescricao) {
//        this.admissaoDescricao = admissaoDescricao;
//    }

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
        this.recCpf = recCpf;
    }

    public List<CsbffEscalaHoras> getCsbffEscalaHorasList() {
        return csbffEscalaHorasList;
    }

    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.csbffEscalaHorasList = csbffEscalaHorasList;
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

    public CsbffEscalaHoras getEscalaCodigo() {
        return escalaCodigo;
    }

    public void setEscalaCodigo(CsbffEscalaHoras escalaCodigo) {
        this.escalaCodigo = escalaCodigo;
    }

    public List<CsbffBeneficios> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<CsbffBeneficios> beneficios) {
        this.beneficios = beneficios;
    }

    public boolean isRecFuncionario() {
        return recFuncionario;
    }

    public void setRecFuncionario(boolean recFuncionario) {
        this.recFuncionario = recFuncionario;
    }

    public boolean isColaboradorInativo() {
        return colaboradorInativo;
    }

    public void setColaboradorInativo(boolean colaboradorInativo) {
        this.colaboradorInativo = colaboradorInativo;
    }

    public CsbffPessoaBeneficio getPessoaBeneficioCodigo() {
        return pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(CsbffPessoaBeneficio pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public boolean isHabilitar() {
        return habilitar;
    }

    public void setHabilitar(boolean habilitar) {
        this.habilitar = habilitar;
    }

}
