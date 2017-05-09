package br.org.gdt.beans;

import br.org.gdt.enums.AbrangenciaBeneficio;
import br.org.gdt.enums.TipoBeneficio;
import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.service.CsbffBeneficiosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CsbffBeneficioBean {

    private boolean formAtivo = false;

    private CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    private List<CsbffBeneficios> todosCsbffBeneficios;

    @ManagedProperty("#{csbffBeneficiosService}")
    private CsbffBeneficiosService csbffBeneficiosService;

    
    private TipoBeneficio tipoBeneficioCombo;
    
    
    
    public CsbffBeneficioBean() {

    }
    public List<CsbffBeneficios> getBeneficios() {
        List<CsbffBeneficios> beneficios = new ArrayList<>();
        beneficios.add(new CsbffBeneficios());
        beneficios.addAll(csbffBeneficiosService.findAll());
        return beneficios;
    }

    public String prepareEdit(CsbffBeneficios beneficio) {
        this.formAtivo = true;
        this.csbffBeneficios = beneficio;
        return "beneficio";
    }
    public TipoBeneficio[] getTipoBeneficio(){
        return TipoBeneficio.values();
    }
    public AbrangenciaBeneficio[] getAbrangenciaBeneficio(){
        return AbrangenciaBeneficio.values();
    }
     public String excluir(CsbffBeneficios beneficio) {
        csbffBeneficiosService.delete(beneficio.getBeneficioCodigo());
        todosCsbffBeneficios.remove(beneficio);
        return "beneficio";
    }
    

    public void save() {
        if (csbffBeneficios.getBeneficioCodigo() > 0) {
            csbffBeneficiosService.update(csbffBeneficios);
        } else {
            csbffBeneficiosService.save(csbffBeneficios);
        }

        todosCsbffBeneficios = csbffBeneficiosService.findAll();
        this.formAtivo = true;
            
//        csbffBeneficios.setBeneficioCodigo(0);
//        String abrangencia = null;
//        csbffBeneficios.setAbrangencia(abrangencia);
//        csbffBeneficios.setBeneficioNome(abrangencia);
//        csbffBeneficiosService.save(csbffBeneficios);
    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffBeneficios = new CsbffBeneficios();
    }
   

    public void add() {
        this.formAtivo = true;
        this.csbffBeneficios = new CsbffBeneficios();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.formAtivo ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.csbffBeneficios);
        hash = 53 * hash + Objects.hashCode(this.todosCsbffBeneficios);
        hash = 53 * hash + Objects.hashCode(this.csbffBeneficiosService);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CsbffBeneficioBean other = (CsbffBeneficioBean) obj;
        if (this.formAtivo != other.formAtivo) {
            return false;
        }
        if (!Objects.equals(this.csbffBeneficios, other.csbffBeneficios)) {
            return false;
        }
        if (!Objects.equals(this.todosCsbffBeneficios, other.todosCsbffBeneficios)) {
            return false;
        }
        if (!Objects.equals(this.csbffBeneficiosService, other.csbffBeneficiosService)) {
            return false;
        }
        return true;
    }
   

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffBeneficios getCsbffBeneficios() {
        return csbffBeneficios;
    }

    public void setCsbffBeneficios(CsbffBeneficios csbffBeneficios) {
        this.csbffBeneficios = csbffBeneficios;
    }

    public List<CsbffBeneficios> getTodosCsbffBeneficios() {
        return todosCsbffBeneficios;
    }

    public void setTodosCsbffBeneficios(List<CsbffBeneficios> todosCsbffBeneficios) {
        this.todosCsbffBeneficios = todosCsbffBeneficios;
    }

    public CsbffBeneficiosService getCsbffBeneficiosService() {
        return csbffBeneficiosService;
    }

    public void setCsbffBeneficiosService(CsbffBeneficiosService csbffBeneficiosService) {
        this.csbffBeneficiosService = csbffBeneficiosService;
    }

    public TipoBeneficio getTipoBeneficioCombo() {
        return tipoBeneficioCombo;
    }

    public void setTipoBeneficioCombo(TipoBeneficio tipoBeneficioCombo) {
        this.tipoBeneficioCombo = tipoBeneficioCombo;
    }

 
    
}
