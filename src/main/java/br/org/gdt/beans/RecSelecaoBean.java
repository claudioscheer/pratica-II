package br.org.gdt.beans;

import br.org.gdt.model.RecSelecao;
import br.org.gdt.service.RecSelecaoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecSelecaoBean {
    
    private RecSelecao selecao = new RecSelecao();
    private List<RecSelecao> selecoes;
    
    @ManagedProperty("#{recSelecaoService}")
    private RecSelecaoService recSelecaoService;
    
    public RecSelecaoBean() {
    }
    
    public void Salvar(){
        
    }

    public RecSelecao getSelecao() {
        return selecao;
    }

    public void setSelecao(RecSelecao selecao) {
        this.selecao = selecao;
    }

    public List<RecSelecao> getSelecoes() {
        return selecoes;
    }

    public void setSelecoes(List<RecSelecao> selecoes) {
        this.selecoes = selecoes;
    }

    public RecSelecaoService getRecSelecaoService() {
        return recSelecaoService;
    }

    public void setRecSelecaoService(RecSelecaoService recSelecaoService) {
        this.recSelecaoService = recSelecaoService;
    }
}
