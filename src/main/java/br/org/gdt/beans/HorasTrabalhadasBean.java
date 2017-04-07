package br.org.gdt.beans;

import br.org.gdt.model.HorasTrabalhadas;
import br.org.gdt.service.HorasTrabalhadasService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HorasTrabalhadasBean {

    private boolean formAtivo = false;

    private HorasTrabalhadas horasTrabalhadas = new HorasTrabalhadas();
    private List<HorasTrabalhadas> todasHorasTrabalhadas;

    @ManagedProperty("#{horasTrabalhadasService}")
    private HorasTrabalhadasService horasTrabalhadasService;

    public HorasTrabalhadasBean() {
    }

    public void save() {
        if (horasTrabalhadas.getId() > 0) {
            horasTrabalhadasService.update(horasTrabalhadas);
        } else {
            horasTrabalhadasService.save(horasTrabalhadas);
        }
        todasHorasTrabalhadas = horasTrabalhadasService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.horasTrabalhadas = new HorasTrabalhadas();
    }

    public void add() {
        this.formAtivo = true;
        this.horasTrabalhadas = new HorasTrabalhadas();
    }

    public String excluir(HorasTrabalhadas horasTrabalhadas) {
        horasTrabalhadasService.delete(horasTrabalhadas.getId());
        todasHorasTrabalhadas.remove(horasTrabalhadas);
        return "horastrabalhadas";
    }

    public String prepareEdit(HorasTrabalhadas horasTrabalhadas) {
        this.formAtivo = true;
        this.horasTrabalhadas = horasTrabalhadas;
        return "horastrabalhadas";
    }

    public HorasTrabalhadas getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(HorasTrabalhadas horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String addTarefa(HorasTrabalhadas horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        return "horastrabalhadas";
    }

    public List<HorasTrabalhadas> getTodasHorasTrabalhadas() {
        if (todasHorasTrabalhadas == null) {
            todasHorasTrabalhadas = horasTrabalhadasService.findAll();
        }
        return todasHorasTrabalhadas;
    }

    public void setTodasHorasTrabalhadas(List<HorasTrabalhadas> horasTrabalhadas) {
        this.todasHorasTrabalhadas = horasTrabalhadas;
    }

    public HorasTrabalhadasService getHorasTrabalhadasService() {
        return horasTrabalhadasService;
    }

    public void setHorasTrabalhadasService(HorasTrabalhadasService horasTrabalhadasService) {
        this.horasTrabalhadasService = horasTrabalhadasService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
