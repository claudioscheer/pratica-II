package br.org.gdt.beans;

import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.FpTabela;
import br.org.gdt.service.FpTabelaService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FpTabelaBean {

    private boolean formAtivo = false;

    private int indexFaixaItem = 0;

    private FpTabela fpTabela = new FpTabela();
    private List<FpTabela> todasFpTabela;

    @ManagedProperty("#{fpTabelaService}")
    private FpTabelaService fpTabelaService;

    public FpTabelaBean() {
    }

    public void save() {
        if (fpTabela.getTabFaixas().size() <= 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhuma faixa inserida.", null));
            return;
        }

        if (fpTabela.getTabId() > 0) {
            fpTabelaService.update(fpTabela);
        } else {
            fpTabelaService.save(fpTabela);
        }
        todasFpTabela = fpTabelaService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpTabela = new FpTabela();
    }

    public void addNovaFaixa() {
        this.fpTabela.addFaixa(new FpFaixa(++indexFaixaItem));
    }

    public void removerFaixa(int index) {
        this.fpTabela.getTabFaixas().remove(index);
        boolean b = new CsbffBeneficios().getBeneficioCodigo().doubleValue() > 0;
    }

    public void add() {
        this.formAtivo = true;
        this.fpTabela = new FpTabela();
        this.addNovaFaixa();
    }

    public String excluir(FpTabela fpTabela) {
        fpTabelaService.delete(fpTabela.getTabId());
        todasFpTabela.remove(fpTabela);
        return "tabelas";
    }

    public String prepareEdit(FpTabela fpTabela) {
        this.formAtivo = true;
        this.fpTabela = fpTabela;
        return "tabelas";
    }

    public FpTabela getFpTabela() {
        return fpTabela;
    }

    public void setFpTabela(FpTabela fpTabela) {
        this.fpTabela = fpTabela;
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

}
