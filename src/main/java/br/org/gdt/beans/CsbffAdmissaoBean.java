package br.org.gdt.beans;

import br.org.gdt.enums.EstadoCivil;
import br.org.gdt.enums.Insalubridade;
import br.org.gdt.enums.NomeBanco;
import br.org.gdt.enums.Periculosidade;
import br.org.gdt.enums.PossuiDependentes;
import br.org.gdt.enums.SeguroDesemprego;
import br.org.gdt.enums.Sexo;
import br.org.gdt.enums.TipoBeneficio;
import br.org.gdt.model.CsbffTipoBeneficio;
import br.org.gdt.model.GchMunicipios;
import br.org.gdt.model.RecPessoa;
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
     * @param tipoBeneficio the tipoBeneficio to set
     */
    public void setTipoBeneficio(CsbffTipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    private boolean formAtivo = false;
    private int cpf;
    private CsbffTipoBeneficio csbffTipoBeneficio;
    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> todosRecPessoa;
    private boolean adicionarBeneficio = false;
    
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    @ManagedProperty("#{gchMunicipiosService}")
    private GchMunicipiosService gchMunicipiosService;
    private CsbffTipoBeneficio tipoBeneficio;
    private List<TipoBeneficio> tipoBeneficioList;

    public CsbffAdmissaoBean(CsbffTipoBeneficio csbffTipoBeneficio, List<RecPessoa> todosRecPessoa, RecPessoaService recPessoaService, GchMunicipiosService gchMunicipiosService, CsbffTipoBeneficio tipoBeneficio, List<TipoBeneficio> tipoBeneficioList) {
        this.csbffTipoBeneficio = csbffTipoBeneficio;
        this.todosRecPessoa = todosRecPessoa;
        this.recPessoaService = recPessoaService;
        this.gchMunicipiosService = gchMunicipiosService;
        this.tipoBeneficio = tipoBeneficio;
        this.tipoBeneficioList = tipoBeneficioList;
    }

 
   
    public CsbffAdmissaoBean() {
        this.csbffTipoBeneficio = new CsbffTipoBeneficio();

    }

    public void removerBeneficio(int index) {
        this.csbffTipoBeneficio.getCsbffBeneficiosList().remove(index);
    }
//    public void addBeneficio() {
//        this.csbffTipoBeneficio.getTipoBeneficio().add(null);
//        
//    }
   
    
//        public void addNovaFaixa() {
//        this.CsbffTipoBeneficio.addFaixa(new FpFaixa());
//    }
   
    public void add() {
        this.formAtivo = true;
        this.adicionarBeneficio = false;
        this.csbffTipoBeneficio = new CsbffTipoBeneficio();
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
//    public void addNovoBeneficio() {
//        this.addNovoBeneficio(new formAtivo(++indexBeneficio));
//    }
//    public void add() {
//        this.formAtivo = true;
//        this.recPessoa = new RecPessoa();
//        this.addNovoBeneficio();
//    }

    public void save() {
//        System.out.println("SAVE:" + recPessoa.getRecIdpessoa());
//        
//    
//        recPessoaService.save(recPessoa);
//        todosRecPessoa = recPessoaService.findAll();
//        this.formAtivo = true;

        if (recPessoa.getRecIdpessoa() > 0) {
            recPessoaService.update(recPessoa);
        } else {
            recPessoaService.save(recPessoa);
        }

        todosRecPessoa = recPessoaService.findAll();
        this.formAtivo = false;
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

        if (cpf != 0){
            todosRecPessoa = recPessoaService.findByCpf(cpf);
        }
        return "consultaadmissao";

    }
         


//    public void add() {
//        this.formAtivo = true;
//        this.recPessoa = new RecPessoa();
//    }
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

//    public List<CsbffTipoBeneficio> getCsbffBeneficiosList() {
//        return csbffBeneficiosList;
//    }
//
//    public void setCsbffBeneficiosList(List<CsbffTipoBeneficio> csbffBeneficiosList) {
//        this.csbffBeneficiosList = csbffBeneficiosList;
//    }
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public CsbffTipoBeneficio getCsbffTipoBeneficio() {
        return csbffTipoBeneficio;
    }

    public void setCsbffTipoBeneficio(CsbffTipoBeneficio csbffTipoBeneficio) {
        this.csbffTipoBeneficio = csbffTipoBeneficio;
    }

}
