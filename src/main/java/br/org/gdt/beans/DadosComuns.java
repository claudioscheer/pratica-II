package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.enums.FpTipoValorFaixa;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class DadosComuns {

    private FpTipoValorFaixa[] tipoValorFaixas;
    private FpTipoEvento[] tipoEventos;

    public FpTipoValorFaixa[] getTipoValorFaixas() {
        return FpTipoValorFaixa.values();
    }

    public FpTipoEvento[] getTipoEventos() {
        return FpTipoEvento.values();
    }

}
