package br.org.gdt.beans;

import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.service.CsbffBeneficiosService;
import java.math.BigInteger;
import java.util.List;
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

    public CsbffBeneficioBean() {

    }

    public void save() {
        if (csbffBeneficios.getBeneficioCodigo() > 0) {
            csbffBeneficiosService.update(csbffBeneficios);
        } else {
            csbffBeneficiosService.save(csbffBeneficios);
        }

        todosCsbffBeneficios = csbffBeneficiosService.findAll();
        this.formAtivo = false;
            
//        csbffBeneficios.setBeneficioCodigo(0);
//        String abrangencia = null;
//        csbffBeneficios.setAbrangencia(abrangencia);
//        csbffBeneficios.setBeneficioNome(abrangencia);
//        csbffBeneficiosService.save(csbffBeneficios);
    }
    public String excluir(CsbffBeneficios beneficio) {
        csbffBeneficiosService.delete(beneficio.getBeneficioCodigo());
        todosCsbffBeneficios.remove(beneficio);
        return "beneficio";
    }
 
    public String prepareEdit(CsbffBeneficios beneficio) {
        this.formAtivo = true;
        this.csbffBeneficios = beneficio;
        return "beneficio";
    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffBeneficios = null;
    }

    public void add() {
        this.formAtivo = true;
        this.csbffBeneficios = new CsbffBeneficios();
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

}
