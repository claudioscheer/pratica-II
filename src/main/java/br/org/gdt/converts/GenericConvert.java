/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.converts;

import java.io.Serializable;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego
 */
@Component("generic")
public class GenericConvert implements Converter,Serializable {

    public GenericConvert() {
    
        System.out.println("generica");
    
    }
    
    
    
    @Override 
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
          
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override 
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null
                && !"".equals(value)) {

            SampleEntity entity = (SampleEntity) value;

            // adiciona item como atributo do componente
            this.addAttribute(component, entity);

            Long codigo = entity.getId();
            if (codigo != null) {
                System.out.println("Codigo Aqui: " + String.valueOf(codigo));
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }

    protected void addAttribute(UIComponent component, SampleEntity o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
    
}
