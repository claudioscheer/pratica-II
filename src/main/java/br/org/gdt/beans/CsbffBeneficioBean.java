
package br.org.gdt.beans;

import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.service.CsbffBeneficiosService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class CsbffBeneficioBean {
private boolean formAtivo = false;

    private  CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    private List<CsbffBeneficios> todosCsbffBeneficios;

    @ManagedProperty("#{csbffBeneficiosService}")
    private CsbffBeneficiosService csbffBeneficiosService;
    
    public CsbffBeneficioBean (){
        
    }
    public void save() {
        if (csbffBeneficios.getBeneficioCodigo().doubleValue()> 0) {
            csbffBeneficiosService.update(csbffBeneficios);
        } else {
            csbffBeneficiosService.save(csbffBeneficios);
        }
        todosCsbffBeneficios = csbffBeneficiosService.findAll();
        this.formAtivo = false;
    }
    public void cancel() {
        this.formAtivo = false;
        this.csbffBeneficios = new CsbffBeneficios();
    }
}
