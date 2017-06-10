package br.org.gdt.beans;

import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.FpTabela;
import br.org.gdt.model.FpTabelaVigencia;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpTabelaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FpTabelaBean {

    private boolean formAtivo = false;
    private boolean adicionandoVigencia = false;

    private FpTabelaVigencia fpTabelaVigencia = new FpTabelaVigencia();
    private FpTabela fpTabela = new FpTabela();
    private List<FpTabela> todasFpTabela;

    @ManagedProperty("#{fpTabelaService}")
    private FpTabelaService fpTabelaService;

    public void save() {
        if (fpTabela.getTabVigencias().size() <= 0) {
            Helper.mostrarNotificacao("Tabela", "Adicione pelo menos uma vigência.", "error");
            return;
        }

        if (fpTabela.getTabId() > 0) {
            fpTabelaService.update(fpTabela);
        } else {
            fpTabela.setTabPermiteExcluir(true);
            fpTabelaService.save(fpTabela);
        }
        todasFpTabela = fpTabelaService.findAll();
        this.formAtivo = false;
    }

    public void saveTabelaVigencia() {
        if (fpTabelaVigencia.getTabVigenciaFaixas().size() <= 0) {
            Helper.mostrarNotificacao("Tabela", "Adicione pelo menos uma faixa.", "error");
            return;
        }

        if (fpTabelaVigencia.getTabVigenciaId() <= 0) {
            this.fpTabela.addTabVigencia(fpTabelaVigencia);
        }
        this.adicionandoVigencia = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpTabela = new FpTabela();
    }

    public void cancelTabelaVigencia() {
        this.adicionandoVigencia = false;
        this.fpTabelaVigencia = new FpTabelaVigencia();
    }

    public void addNovaVigencia() {
        this.adicionandoVigencia = true;
        this.fpTabelaVigencia = new FpTabelaVigencia();
        this.addNovaFaixa();
    }

    public void removerVigencia(int index) {
        this.fpTabela.getTabVigencias().remove(index);
    }

    public void addNovaFaixa() {
        this.fpTabelaVigencia.addFaixa(new FpFaixa());
    }

    public void removerFaixa(int index) {
        this.fpTabelaVigencia.getTabVigenciaFaixas().remove(index);
    }

    public void add() {
        this.formAtivo = true;
        this.adicionandoVigencia = false;
        this.fpTabela = new FpTabela();
    }

    public void excluir(FpTabela fpTabela) {
        if (!fpTabela.isTabPermiteExcluir()) {
            Helper.mostrarNotificacao("Tabela", "A tabela não pode ser excluída.", "error");
        } else {
            fpTabelaService.delete(fpTabela.getTabId());
            todasFpTabela.remove(fpTabela);
        }
    }

    public void prepareEdit(FpTabela fpTabela) {
        this.formAtivo = true;
        this.fpTabela = fpTabela;
    }

    public void editarVigencia(FpTabelaVigencia fpTabelaVigencia) {
        this.adicionandoVigencia = true;
        this.fpTabelaVigencia = fpTabelaVigencia;
    }

    public FpTabela getFpTabela() {
        return fpTabela;
    }

    public void setFpTabela(FpTabela fpTabela) {
        this.fpTabela = fpTabela;
    }

    public FpTabelaVigencia getFpTabelaVigencia() {
        return fpTabelaVigencia;
    }

    public void setFpTabelaVigencia(FpTabelaVigencia fpTabelaVigencia) {
        this.fpTabelaVigencia = fpTabelaVigencia;
    }

    public List<FpTabela> getTodasFpTabela() {
        if (todasFpTabela == null) {
            todasFpTabela = fpTabelaService.findAll();
        }
        return todasFpTabela;
    }

    public void setTodasFpTabela(List<FpTabela> tabelas) {
        this.todasFpTabela = tabelas;
    }

    public FpTabelaService getFpTabelaService() {
        return fpTabelaService;
    }

    public void setFpTabelaService(FpTabelaService fpTabelaService) {
        this.fpTabelaService = fpTabelaService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public boolean isAdicionandoVigencia() {
        return adicionandoVigencia;
    }

    public void setAdicionandoVigencia(boolean adicionandoVigencia) {
        this.adicionandoVigencia = adicionandoVigencia;
    }

}
