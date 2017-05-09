/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.RecHabilidade;
import br.org.gdt.service.RecHabilidadeService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Anderson
 */
@ManagedBean
@RequestScoped
public class RecHabilidadeBean {
    private boolean formAtivo = false;
    private RecHabilidade habilidade = new RecHabilidade();
    private List<RecHabilidade> habilidades;
    @ManagedProperty("#{recHabilidadeService}")
    private RecHabilidadeService recHabilidadeService;

    public RecHabilidadeBean() {
    }

    public void Salvar() {
        if (habilidade.getRecIdhabilidade() > 0) {
            recHabilidadeService.Alterar(habilidade);
        } else {
            recHabilidadeService.Inserir(habilidade);
        }
        habilidades = recHabilidadeService.ListarTodas();
    }

    public String PreparaEdicao(RecHabilidade habilidade) {
        this.formAtivo = true;
        this.habilidade = habilidade;
        return "habilidades";
    }

    public String Excluir(RecHabilidade habilidade) {
        recHabilidadeService.Excluir(habilidade.getRecIdhabilidade());
        habilidades.remove(habilidade);
        return "habilidades";
    }

    public List<RecHabilidade> ListarTodas() {
        if (habilidades == null) {
            habilidades = recHabilidadeService.ListarTodas();
        }
        return habilidades;
    }

    public void Adicionar() {
        this.formAtivo = true;
        this.habilidade = new RecHabilidade();        
    }
    
    public void cancel() {
        this.formAtivo = false;
        this.habilidade = new RecHabilidade();
    }
    
    public RecHabilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(RecHabilidade habilidade) {
        this.habilidade = habilidade;
    }

    public List<RecHabilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<RecHabilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public RecHabilidadeService getRecHabilidadeService() {
        return recHabilidadeService;
    }

    public void setRecHabilidadeService(RecHabilidadeService recHabilidadeService) {
        this.recHabilidadeService = recHabilidadeService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
