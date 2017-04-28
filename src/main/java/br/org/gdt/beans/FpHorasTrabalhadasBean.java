package br.org.gdt.beans;

import br.org.gdt.model.FpHorasTrabalhadas;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpHorasTrabalhadasService;
import br.org.gdt.service.FpPeriodoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpHorasTrabalhadasBean {

    private boolean formAtivo = false;

    private FpHorasTrabalhadas fpHorasTrabalhadas = new FpHorasTrabalhadas();
    private List<FpHorasTrabalhadas> todasFpHorasTrabalhadas;

    @ManagedProperty("#{fpHorasTrabalhadasService}")
    private FpHorasTrabalhadasService fpHorasTrabalhadasService;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    public FpHorasTrabalhadasBean() {
    }

    public void save() {
        if (fpHorasTrabalhadas.getHorId() > 0) {
            fpHorasTrabalhadasService.update(fpHorasTrabalhadas);
        } else {
            fpHorasTrabalhadas.setHorFpPeriodo(fpPeriodoService.getPeriodoAtivo());
            fpHorasTrabalhadasService.save(fpHorasTrabalhadas);
        }
        todasFpHorasTrabalhadas = fpHorasTrabalhadasService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.fpHorasTrabalhadas = new FpHorasTrabalhadas();
    }

    public void add() {
        if (!fpPeriodoService.temPeriodoAtivo()) {
            Helper.mostrarNotificacao("Períodos", "Não há nenhum período em aberto.", "info");
            return;
        }

        this.formAtivo = true;
        this.fpHorasTrabalhadas = new FpHorasTrabalhadas();
    }

    public String excluir(FpHorasTrabalhadas fpHorasTrabalhadas) {
        fpHorasTrabalhadasService.delete(fpHorasTrabalhadas.getHorId());
        todasFpHorasTrabalhadas.remove(fpHorasTrabalhadas);
        return "horastrabalhadas";
    }

    public String prepareEdit(FpHorasTrabalhadas fpHorasTrabalhadas) {
        this.formAtivo = true;
        this.fpHorasTrabalhadas = fpHorasTrabalhadas;
        return "horastrabalhadas";
    }

    public FpHorasTrabalhadas getFpHorasTrabalhadas() {
        return fpHorasTrabalhadas;
    }

    public void setFpHorasTrabalhadas(FpHorasTrabalhadas fpHorasTrabalhadas) {
        this.fpHorasTrabalhadas = fpHorasTrabalhadas;
    }

    public List<FpHorasTrabalhadas> getTodasFpHorasTrabalhadas() {
        if (todasFpHorasTrabalhadas == null) {
            todasFpHorasTrabalhadas = fpHorasTrabalhadasService.findAll();
        }
        return todasFpHorasTrabalhadas;
    }

    public void setTodasFpHorasTrabalhadas(List<FpHorasTrabalhadas> fpHorasTrabalhadases) {
        this.todasFpHorasTrabalhadas = fpHorasTrabalhadases;
    }

    public FpHorasTrabalhadasService getFpHorasTrabalhadasService() {
        return fpHorasTrabalhadasService;
    }

    public void setFpHorasTrabalhadasService(FpHorasTrabalhadasService fpHorasTrabalhadasService) {
        this.fpHorasTrabalhadasService = fpHorasTrabalhadasService;
    }

    public FpPeriodoService getFpPeriodoService() {
        return fpPeriodoService;
    }

    public void setFpPeriodoService(FpPeriodoService fpPeriodoService) {
        this.fpPeriodoService = fpPeriodoService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
