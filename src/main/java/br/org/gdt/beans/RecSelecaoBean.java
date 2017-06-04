package br.org.gdt.beans;

import br.org.gdt.model.RecSelecao;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecSelecaoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecSelecaoBean {

    private boolean formAtivo = false;

    private RecSelecao selecao = new RecSelecao();
    private List<RecSelecao> selecoes;

    @ManagedProperty("#{recSelecaoService}")
    private RecSelecaoService recSelecaoService;

    public RecSelecaoBean() {
    }

    public void Salvar() {
        if (ValidarCampos()) {
            if (selecao.getRecIdselecao() > 0) {
                recSelecaoService.Alterar(selecao);
            } else {
                recSelecaoService.Inserir(selecao);
            }
            selecoes = recSelecaoService.ListarTodas();
        }else{
            return;
        }       
    }

    public List<RecSelecao> ListarTodas() {
        if (selecoes == null) {
            selecoes = recSelecaoService.ListarTodas();
        }
        return selecoes;
    }

    public String PreparaEdicao(RecSelecao selecao) {
        this.formAtivo = true;
        this.selecao = selecao;
        return "selecao";
    }

    public String Excluir(RecSelecao selecao) {
        recSelecaoService.Excluir(selecao.getRecIdselecao());
        return "selecao";
    }

    public void Cancelar() {
        this.formAtivo = false;
        this.selecao = new RecSelecao();
    }

    public void Adicionar() {
        this.formAtivo = true;
        this.selecao = new RecSelecao();
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

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public boolean ValidarCampos() {
        if (selecao.getRecIdpessoa() == null) {
            Helper.mostrarNotificacao("Candidato", "Selecione um Candidato", "error");
            return false;
        }
        if (selecao.getRecIdvaga() == null) {
            Helper.mostrarNotificacao("Vaga", "Selecione uma Vaga", "error");
            return false;
        }
        return true;
    }
}
