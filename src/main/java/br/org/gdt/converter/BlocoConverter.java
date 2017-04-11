package br.org.gdt.converter;

import br.org.gdt.model.Bloco;
import br.org.gdt.service.BlocoService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("blocoConverter")
@ManagedBean
public class BlocoConverter implements Converter {

    @ManagedProperty("#{blocoService}")
    private BlocoService blocoService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return blocoService.findById(Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return "" + ((Bloco) o).getId();
    }

    public BlocoService getBlocoService() {
        return blocoService;
    }

    public void setBlocoService(BlocoService blocoService) {
        this.blocoService = blocoService;
    }

}
