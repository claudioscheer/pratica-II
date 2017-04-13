package br.org.gdt.beans;

import br.org.gdt.enums.TipoValorFaixa;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class DadosComuns {

    private TipoValorFaixa[] tipoValorFaixas;

    public TipoValorFaixa[] getTipoValorFaixas() {
        return TipoValorFaixa.values();
    }

}
