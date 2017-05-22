package br.org.gdt.beans;

import br.org.gdt.enums.DiasATrabalhar;
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
import br.org.gdt.model.GchMunicipios;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.CsbffBeneficiosService;
import br.org.gdt.service.CsbffCargosService;
import br.org.gdt.service.CsbffEscalaHorasService;
import br.org.gdt.service.CsbffPessoaBeneficioService;
import br.org.gdt.service.GchMunicipiosService;
import br.org.gdt.service.RecPessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CsbffAdmissaoBean implements Serializable {

    /**
     * @param seguroDesemprego the seguroDesemprego to set
     */
    public void setSeguroDesemprego(SeguroDesemprego seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }

    /**
     * @param tipoBeneficio the tipoBeneficio to set
     */
    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    private boolean formAtivo = false;
    private boolean adicionandoBeneficio = false;
    private int cpf;
    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> todosRecPessoa;
//    private boolean adicionarBeneficio = false;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    @ManagedProperty("#{gchMunicipiosService}")
    private GchMunicipiosService gchMunicipiosService;
    @ManagedProperty("#{csbffBeneficiosService}")
    private CsbffBeneficiosService csbffBeneficiosService;
    private List<TipoBeneficio> csbffTipoBeneficiosList;
    private TipoBeneficio tipoBeneficio;
    private CsbffPessoaDependente csbffPessoaDependente;
    private CsbffDependentes csbffDependentes;
    private List<CsbffBeneficios> csbffBeneficiosList;
    private List<CsbffBeneficios> beneficiosColaborador;
    private CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    private CsbffEscalaHoras csbffEscalaHoras;
    private List<CsbffEscalaHoras> todosCsbffEscalaHoras;
    @ManagedProperty("#{csbffEscalaHorasService}")
    private CsbffEscalaHorasService csbffEscalaHorasService;
    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;
    private List<CsbffCargos> csbffCargosList;
    private CsbffCargos csbffCargos;
    private CsbffPessoaBeneficioService csbffPessoaBeneficioService;
    private CsbffPessoaBeneficio csbffPessoaBeneficio;
    private List<CsbffPessoaBeneficio> todosCsbffPessoaBeneficio;
    private SeguroDesemprego seguroDesemprego;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
//    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
//    public void adicionarBeneficio() {
//        this.csbffTipoBeneficio.addBeneficio(new CsbffTipoBeneficio());
//    }
//    public void addBeneficio(CsbffTipoBeneficio csbffTipoBeneficio) {
//        if (csbffTipoBeneficio != null) {
//            csbffTipoBeneficio.setTipoBeneficio(tipoBeneficio);
//            this.getCsbffTipoBeneficiosList().add(tipoBeneficio);
//        }
    public CsbffAdmissaoBean(SeguroDesemprego seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }


    public CsbffAdmissaoBean(CsbffPessoaBeneficioService csbffPessoaBeneficioService) {
        this.csbffPessoaBeneficioService = csbffPessoaBeneficioService;
    }

    public CsbffAdmissaoBean(List<CsbffBeneficios> beneficiosColaborador) {
        this.beneficiosColaborador = beneficiosColaborador;
    }

    public CsbffAdmissaoBean(CsbffCargosService csbffCargosService, List<CsbffCargos> csbffCargosList, CsbffCargos csbffCargos) {
        this.csbffCargosService = csbffCargosService;
        this.csbffCargosList = csbffCargosList;
        this.csbffCargos = csbffCargos;
    }

    public CsbffAdmissaoBean(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public CsbffAdmissaoBean(CsbffBeneficios csbffBeneficios) {
        this.csbffBeneficios = csbffBeneficios;
    }

    public CsbffAdmissaoBean(CsbffDependentes csbffDependentes) {
        this.csbffDependentes = csbffDependentes;
    }

    public CsbffAdmissaoBean() {

    }

    public CsbffAdmissaoBean(CsbffPessoaDependente csbffPessoaDependente) {
        this.csbffPessoaDependente = csbffPessoaDependente;
    }

    public CsbffAdmissaoBean(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public List<CsbffCargos> getCargos() {
//        return new ArrayList<>();//buscAR do banco
        List<CsbffCargos> cargos = csbffCargosService.findAll();//ISSO BUSCA DO BANCO!!!!!
        return cargos;
    }

    public List<CsbffBeneficios> getBeneficios() {
//        return new ArrayList<>();//buscAR do banco
        List<CsbffBeneficios> beneficios = csbffBeneficiosService.findAll();//ISSO BUSCA DO BANCO!!!!!
        return beneficios;
    }

    public void buscarPessoa() {
        recPessoa = (RecPessoa) recPessoaService.findByCpf(cpf);
        //recPessoa = recPessoaService.findByCpf(recPessoa.());
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

    public List<GchMunicipios> getMunicipios() {
        //buscar do banco
        List<GchMunicipios> muns = gchMunicipiosService.findAll();

        return muns;
    }

    public List<RecPessoa> getPessoas() {
        List<RecPessoa> pessoas = new ArrayList<>();
        pessoas.add(new RecPessoa(""));
        pessoas.addAll(recPessoaService.findAll());
        return pessoas;
    }

    public void save() {

        if (recPessoa.getRecIdpessoa() > 0) {
            recPessoaService.update(recPessoa);
        } else {
            recPessoaService.save(recPessoa);
        }
        todosRecPessoa = recPessoaService.findAll();
        this.formAtivo = false;
    }

    public void removerBeneficioPessoa(int index) {

        this.recPessoa.getCsbffPessoaBeneficioList().remove(index);
    }

//    public void addBeneficioPessoa(CsbffPessoaBeneficio beneficioNome) {
//        if (recPessoa.getCsbffBeneficiosList()== null) {
//            recPessoa.setCsbffPessoaBeneficioList(new ArrayList<>());
//        }
//        recPessoa.getCsbffPessoaBeneficioList().add(beneficioNome);
//    }
//    public String addBeneficioPessoa() {
//
//        save();
//        csbffPessoaBeneficio = new CsbffPessoaBeneficio();
//        return null;
//
//    }
    public void addNovaEscala(CsbffEscalaHoras csbffEscalaHoras) {
        if (csbffEscalaHoras.getEscalaCodigo() > 0) {
            csbffEscalaHorasService.update(csbffEscalaHoras);
        } else {
            csbffEscalaHorasService.save(csbffEscalaHoras);
        }
        todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
        this.formAtivo = true;
    }

    public void removerEscala(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras.getCsbffEscalaHorasList().remove(csbffEscalaHoras);
    }

    public void addBeneficioPessoa() {
        this.csbffBeneficios = new CsbffBeneficios();
        this.recPessoa.getCsbffPessoaBeneficioList().add(csbffPessoaBeneficio);

//        if (csbffPessoaBeneficio.getPessoaBeneficioCodigo() > 0) {
//            csbffPessoaBeneficioService.update(csbffPessoaBeneficio);
//        } else {
//            csbffPessoaBeneficioService.save(csbffPessoaBeneficio);
//
//        }
//
//        todosCsbffPessoaBeneficio = csbffPessoaBeneficioService.findAll();
//        this.formAtivo = true;
    }

    public void removerCsbffBeneficios(int index) {
        this.recPessoa.getCsbffBeneficiosList().remove(index);
    }

    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();

    }

    public String prepareEdit(RecPessoa pessoas) {
        this.formAtivo = true;
        this.recPessoa = pessoas;
        return "pessoas";
    }

    public String excluir(RecPessoa pessoas) {
        recPessoaService.delete(pessoas.getRecIdpessoa());
        todosRecPessoa.remove(pessoas);
        return "pessoas";
    }

    public String buscarCpf() {
        if (cpf != 0) {
            todosRecPessoa = recPessoaService.findByCpf(cpf);
        }
        return "consultaadmissao";
    }
//    public void saveEscala() {
//
//        if (csbffEscalaHoras.getEscalaCodigo()>0) {
//            csbffEscalaHorasService.update(csbffEscalaHoras);
//        } else {
//            csbffEscalaHorasService.save(csbffEscalaHoras);
//        }
//
//        todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
//        this.formAtivo = false;
//    }

//    public void add() {
//        this.formAtivo = true;
//        this.adicionandoBeneficio = false;
//        this.csbffTipoBeneficio = new CsbffTipoBeneficio();
//    }
//    public void removerEscalaHoras(int index){
//        recPessoa.getCsbffEscalaHoras().remove(index);
//    }
//    public CsbffEscalaHoras getCsbffEscalaHoras() {
//        return csbffEscalaHoras;
//    }
//    public void cancel() {
//        this.formAtivo = false;
//        this.csbffEscalaHoras = new CsbffEscalaHoras();
//
//    }
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

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        if (csbffEscalaHoras == null) {
            csbffEscalaHoras = new CsbffEscalaHoras();
        }
        return csbffEscalaHoras;

    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

    public List<CsbffEscalaHoras> getTodosCsbffEscalaHoras() {
//        if (todosCsbffEscalaHoras == null) {
//            todosCsbffEscalaHoras = csbffEscalaHorasService.findAll();
//        }
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

    public List<RecPessoa> getTodosRecPessoa() {
        return todosRecPessoa;
    }

    public void setTodosRecPessoa(List<RecPessoa> todosRecPessoa) {
        this.todosRecPessoa = todosRecPessoa;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public GchMunicipiosService getGchMunicipiosService() {
        return gchMunicipiosService;
    }

    public void setGchMunicipiosService(GchMunicipiosService gchMunicipiosService) {
        this.gchMunicipiosService = gchMunicipiosService;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

//    public CsbffTipoBeneficio getCsbffTipoBeneficio() {
//        return csbffTipoBeneficio;
//    }
//
//    public void setCsbffTipoBeneficio(CsbffTipoBeneficio csbffTipoBeneficio) {
//        this.csbffTipoBeneficio = csbffTipoBeneficio;
//    }
    public boolean isAdicionandoBeneficio() {
        return adicionandoBeneficio;
    }

    public void setAdicionandoBeneficio(boolean adicionandoBeneficio) {
        this.adicionandoBeneficio = adicionandoBeneficio;
    }

//    public boolean isAdicionarBeneficio() {
//        return adicionarBeneficio;
//    }
//
//    public void setAdicionarBeneficio(boolean adicionarBeneficio) {
//        this.adicionarBeneficio = adicionarBeneficio;
//    }
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

    public List<CsbffBeneficios> getCsbffBeneficiosList() {
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
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

    public List<CsbffCargos> getCsbffCargosList() {
        return csbffCargosList;
    }

    public void setCsbffCargosList(List<CsbffCargos> csbffCargosList) {
        this.csbffCargosList = csbffCargosList;
    }

    public CsbffCargos getCsbffCargos() {
        return csbffCargos;
    }

    public void setCsbffCargos(CsbffCargos csbffCargos) {
        this.csbffCargos = csbffCargos;
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

    public List<CsbffPessoaBeneficio> getTodosCsbffPessoaBeneficio() {
        return todosCsbffPessoaBeneficio;
    }

    public void setTodosCsbffPessoaBeneficio(List<CsbffPessoaBeneficio> todosCsbffPessoaBeneficio) {
        this.todosCsbffPessoaBeneficio = todosCsbffPessoaBeneficio;
    }

    public List<CsbffBeneficios> getBeneficiosColaborador() {
        return beneficiosColaborador;
    }

    public void setBeneficiosColaborador(List<CsbffBeneficios> beneficiosColaborador) {
        this.beneficiosColaborador = beneficiosColaborador;
    }
    
}
