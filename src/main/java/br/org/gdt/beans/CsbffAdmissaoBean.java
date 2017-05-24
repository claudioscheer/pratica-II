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
import br.org.gdt.service.CsbffDependentesService;
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

    private CsbffCargos csbffcargos = new CsbffCargos();
    private boolean formAtivo = false;
    private boolean adicionandoBeneficio = false;
    private int recCpf;
    private RecPessoa recIdpessoa;
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
    private RecPessoa admissaoDescricao;
    private CsbffCargos cargoCbo;
    @ManagedProperty("#{csbffDependentesService}")
    private CsbffDependentesService csbffDependentesService;
    private RecPessoa recSexo;
    private RecPessoa recEstadocivil;
    private RecPessoa recRg;

    public CsbffAdmissaoBean() {
        csbffcargos = new CsbffCargos();
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

    public void buscarPessoa() {
        recPessoa = (RecPessoa) recPessoaService.findByRecCpf(recCpf);
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
//        List<RecPessoa> pessoas = new ArrayList<>();
//        pessoas.add(new RecPessoa(""));
//        pessoas.addAll(recPessoaService.findAll());
//        return pessoas;

        List<RecPessoa> pessoas = recPessoaService.findAll();
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
        this.csbffPessoaBeneficio = new CsbffPessoaBeneficio();
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

    public String editaConsulta(RecPessoa pessoas) {
//        this.formAtivo = true;
        this.recPessoa = pessoas;
        selectConsulta(pessoas);
        return "pessoas";
    }

    public void selectConsulta(RecPessoa pessoas) {
        this.recPessoa = pessoas;
        recIdpessoa = pessoas;
        alteraConsulta(pessoas);

    }

    public String alteraConsulta(RecPessoa pessoas) {
        recIdpessoa = pessoas;
        recPessoaService.update(pessoas);

        return "pessoas";
    }

    public String excluir(RecPessoa pessoas) {
        recPessoaService.delete(pessoas.getRecIdpessoa());
        todosRecPessoa.remove(pessoas);
        return "pessoas";
    }

    public String buscarRecCpf() {
        if (recCpf != 0) {
            todosRecPessoa = recPessoaService.findByRecCpf(recCpf);
        } else {
            todosRecPessoa = recPessoaService.findAll();
        }
        return "consultaadmissao";

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

    public int getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(int recCpf) {
        this.recCpf = recCpf;
    }

    public boolean isAdicionandoBeneficio() {
        return adicionandoBeneficio;
    }

    public void setAdicionandoBeneficio(boolean adicionandoBeneficio) {
        this.adicionandoBeneficio = adicionandoBeneficio;
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

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public RecPessoa getAdmissaoDescricao() {
        return admissaoDescricao;
    }

    public void setAdmissaoDescricao(RecPessoa admissaoDescricao) {
        this.admissaoDescricao = admissaoDescricao;
    }

    public CsbffCargos getCargoCbo() {
        return cargoCbo;
    }

    public void setCargoCbo(CsbffCargos cargoCbo) {
        this.cargoCbo = cargoCbo;
    }

    public CsbffCargos getCargoCodigo() {
        return csbffcargos;
    }

    public void setCargoCodigo(CsbffCargos cargos) {
        this.csbffcargos = cargos;
    }

    public CsbffCargos getCsbffcargos() {
        return csbffcargos;
    }

    public void setCsbffcargos(CsbffCargos csbffcargos) {
        this.csbffcargos = csbffcargos;
    }

    public CsbffDependentesService getCsbffDependentesService() {
        return csbffDependentesService;
    }

    public void setCsbffDependentesService(CsbffDependentesService csbffDependentesService) {
        this.csbffDependentesService = csbffDependentesService;
    }

    public CsbffAdmissaoBean(int recCpf, RecPessoa recIdpessoa, List<RecPessoa> todosRecPessoa, RecPessoaService recPessoaService, GchMunicipiosService gchMunicipiosService, CsbffBeneficiosService csbffBeneficiosService, List<TipoBeneficio> csbffTipoBeneficiosList, TipoBeneficio tipoBeneficio, CsbffPessoaDependente csbffPessoaDependente, CsbffDependentes csbffDependentes, List<CsbffBeneficios> csbffBeneficiosList, List<CsbffBeneficios> beneficiosColaborador, CsbffEscalaHoras csbffEscalaHoras, List<CsbffEscalaHoras> todosCsbffEscalaHoras, CsbffEscalaHorasService csbffEscalaHorasService, CsbffCargosService csbffCargosService, List<CsbffCargos> csbffCargosList, CsbffCargos csbffCargos, CsbffPessoaBeneficioService csbffPessoaBeneficioService, CsbffPessoaBeneficio csbffPessoaBeneficio, List<CsbffPessoaBeneficio> todosCsbffPessoaBeneficio, SeguroDesemprego seguroDesemprego, RecPessoa admissaoDescricao, CsbffCargos cargoCbo, CsbffDependentesService csbffDependentesService, RecPessoa recSexo, RecPessoa recEstadocivil) {
        this.recCpf = recCpf;
        this.recIdpessoa = recIdpessoa;
        this.todosRecPessoa = todosRecPessoa;
        this.recPessoaService = recPessoaService;
        this.gchMunicipiosService = gchMunicipiosService;
        this.csbffBeneficiosService = csbffBeneficiosService;
        this.csbffTipoBeneficiosList = csbffTipoBeneficiosList;
        this.tipoBeneficio = tipoBeneficio;
        this.csbffPessoaDependente = csbffPessoaDependente;
        this.csbffDependentes = csbffDependentes;
        this.csbffBeneficiosList = csbffBeneficiosList;
        this.beneficiosColaborador = beneficiosColaborador;
        this.csbffEscalaHoras = csbffEscalaHoras;
        this.todosCsbffEscalaHoras = todosCsbffEscalaHoras;
        this.csbffEscalaHorasService = csbffEscalaHorasService;
        this.csbffCargosService = csbffCargosService;
        this.csbffCargosList = csbffCargosList;
        this.csbffCargos = csbffCargos;
        this.csbffPessoaBeneficioService = csbffPessoaBeneficioService;
        this.csbffPessoaBeneficio = csbffPessoaBeneficio;
        this.todosCsbffPessoaBeneficio = todosCsbffPessoaBeneficio;
        this.seguroDesemprego = seguroDesemprego;
        this.admissaoDescricao = admissaoDescricao;
        this.cargoCbo = cargoCbo;
        this.csbffDependentesService = csbffDependentesService;
        this.recSexo = recSexo;
        this.recEstadocivil = recEstadocivil;
    }

    
    public RecPessoa getRecSexo() {
        return recSexo;
    }

    public void setRecSexo(RecPessoa recSexo) {
        this.recSexo = recSexo;
    }

    public RecPessoa getRecEstadocivil() {
        return recEstadocivil;
    }

    public void setRecEstadocivil(RecPessoa recEstadocivil) {
        this.recEstadocivil = recEstadocivil;
    }

    public RecPessoa getRecRg() {
        return recRg;
    }

    public void setRecRg(RecPessoa recRg) {
        this.recRg = recRg;
    }

      
}
