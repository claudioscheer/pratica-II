package br.org.gdt.beans;

import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.RecPessoaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecPessoaBean {
    
    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoas;
    
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    
    public RecPessoaBean() {
    }
    
        public List<RecPessoa> ListarTodas() {
        if (recPessoas == null) {
            recPessoas = recPessoaService.ListarTodas();
        }
        return recPessoas;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getRecPessoas() {
        return recPessoas;
    }

    public void setRecPessoas(List<RecPessoa> recPessoas) {
        this.recPessoas = recPessoas;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }
        
        
        
}