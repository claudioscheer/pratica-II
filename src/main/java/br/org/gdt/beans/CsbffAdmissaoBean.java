package br.org.gdt.beans;

import br.org.gdt.enums.Sexo;
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
public class CsbffAdmissaoBean implements Serializable{

    private boolean formAtivo = false;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> todosRecPessoa;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    @ManagedProperty("#{gchMunicipiosService}")
    private GchMunicipiosService gchMunicipiosService;

    public CsbffAdmissaoBean() {

    }

    public Sexo[] getGeneros() {
        return Sexo.values();
    }

    public List<GchMunicipios> getMunicipios() {
        //buscar do banco
        List<GchMunicipios> muns = gchMunicipiosService.findAll();

        return muns;
    }

    public List<RecPessoa> getPessoas() {
        List<RecPessoa> pessoas = new ArrayList<>();
        pessoas.add(new RecPessoa("SELECIONE"));
        pessoas.addAll(recPessoaService.findAll());
        return pessoas;
    }

    public void save() {
//        System.out.println("SAVE:" + recPessoa.getRecIdpessoa());
//        
//    
//        recPessoaService.save(recPessoa);
//        todosRecPessoa = recPessoaService.findAll();
//        this.formAtivo = true;
        
        if (recPessoa.getRecIdpessoa()> 0) {
            recPessoaService.update(recPessoa);
        } else {
            recPessoaService.save(recPessoa);
        }

        todosRecPessoa = recPessoaService.findAll();
        this.formAtivo = false;
    }
    

    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa( );
        
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

}
