/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.gdt.beans;

import br.org.gdt.model.RecHabilidade;
import br.org.gdt.model.RecRequisicaoVaga;
import br.org.gdt.model.RecVaga;
import br.org.gdt.service.RecHabilidadeService;
import br.org.gdt.service.RecRequisicaoVagaService;
import br.org.gdt.service.RecVagaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author João
 */ 
@ManagedBean
@RequestScoped
public class RecRequisicaoBean
{
    private boolean formAtivo = false;

    ///DADOS DA 
    private RecRequisicaoVaga recRecVaga = new RecRequisicaoVaga();
    private List<RecRequisicaoVaga> ListRec_Requisicao;
    @ManagedProperty("#{recRequisicaoService}")
    private RecRequisicaoVagaService recRequisicaoVagaService;

    public RecRequisicaoBean() {
    }

    public void Salvar() {
        if (recRecVaga.getRecIdRecquisicaoVaga() > 0) {
            recRequisicaoVagaService.Alterar(recRecVaga);
        } else {            
            recRequisicaoVagaService.Inserir(recRecVaga);
        }
        ListRec_Requisicao = recRequisicaoVagaService.ListarTodas();
    }

    public List<RecRequisicaoVaga> ListarTodas() {
        if (ListRec_Requisicao == null) {
            ListRec_Requisicao = recRequisicaoVagaService.ListarTodas();
        }
        return ListRec_Requisicao;
    }

    public String PreparaEdicao(RecRequisicaoVaga recRecVaga) {
        this.formAtivo = true;
        this.recRecVaga = recRecVaga;
        return "Rec_vaga_lista";
    }

    public String Excluir(RecRequisicaoVaga recRecVaga){
        recRequisicaoVagaService.Excluir(recRecVaga.getRecIdRecquisicaoVaga());
        return "Rec_vaga_lista";
    }

    public void Cancelar() {
        this.formAtivo = false;
        this.recRecVaga = new RecRequisicaoVaga();
    }

    public void Adicionar() {
        this.formAtivo = true;
        this.recRecVaga = new RecRequisicaoVaga();
    }

    public RecRequisicaoVagaService getRecRecVagaService() {
        return recRequisicaoVagaService;
    }

    public void setRecVagaService(RecRequisicaoVagaService recRecVagaService) {
        this.recRequisicaoVagaService = recRecVagaService;
    }

    public List<RecRequisicaoVaga> getRecVagas() {
        return ListRec_Requisicao;
    }

    public void setRecVagas(List<RecRequisicaoVaga> ListRec_Requisicao) {
        this.ListRec_Requisicao = ListRec_Requisicao;
    }

    public RecRequisicaoVaga getVaga() {
        return recRecVaga;
    }

    public void setVaga(RecRequisicaoVaga Rec_vaga) {
        this.recRecVaga = Rec_vaga;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public RecRequisicaoVaga getRecRecVaga()
    {
        return recRecVaga;
    }

    public void setRecRecVaga(RecRequisicaoVaga recRecVaga)
    {
        this.recRecVaga = recRecVaga;
    }

    public List<RecRequisicaoVaga> getListRec_Requisicao()
    {
        return ListRec_Requisicao;
    }

    public void setListRec_Requisicao(List<RecRequisicaoVaga> ListRec_Requisicao)
    {
        this.ListRec_Requisicao = ListRec_Requisicao;
    }

    public RecRequisicaoVagaService getRecRequisicaoVagaService()
    {
        return recRequisicaoVagaService;
    }

    public void setRecRequisicaoVagaService(RecRequisicaoVagaService recRequisicaoVagaService)
    {
        this.recRequisicaoVagaService = recRequisicaoVagaService;
    }

  
}
