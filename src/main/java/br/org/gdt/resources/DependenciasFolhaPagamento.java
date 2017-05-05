package br.org.gdt.resources;

import br.org.gdt.beans.FpEventoBean;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEvento;
import br.org.gdt.service.FpEventoService;

public class DependenciasFolhaPagamento {

    private FpEvento fpEvento = new FpEvento();
    private FpEventoBean fpEventoBean = new FpEventoBean();
    private FpEventoService fpEventoService = new FpEventoService();
    public void addProventos() {

        // Máximo de horas permitidas por dia= 2h
        // hora extra 50%
        fpEvento.setEveFormula("$vh*1,5*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Hora extra 50%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();
        System.out.println("Add");

        // hora extra 100%
        fpEvento.setEveFormula("$vh*2*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Hora extra 100%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Horas noturnas
        fpEvento.setEveFormula("$vh*1,2*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Horas noturnas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        //Periculosidade
        fpEvento.setEveFormula("$sf*0,30");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Periculosidade");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Insalubidade 10%
        fpEvento.setEveFormula("937 * 0,10");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Insalubridade 10%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Insalubidade 20%
        fpEvento.setEveFormula("937 * 0,20");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Insalubridade 20%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Insalubidade 30%
        fpEvento.setEveFormula("937 * 0,30");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEveNome("Insalubridade 30%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Ajuda de custo
        // Só acrescenta ao valor final, como forma de reembolso
        fpEvento.setEveFormula("$#");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Ajuda de custo");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoBean.save();
        fpEvento = new FpEvento();
    }

    public void addDescontos() {
        // DESCONTOS

        // Horas faltas
        fpEvento.setEveFormula("$hm-$#");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Horas faltas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        //Vale transporte
        fpEvento.setEveFormula("$sf*0,06");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Vale transporte");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoBean.save();
        fpEvento = new FpEvento();

        // Vale alimentação: O valor não pode exceder os 20%
        fpEvento.setEveFormula("$sf*0,15");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Vale alimentação");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoBean.save();
        fpEvento = new FpEvento();
    }
    
    public void test(){
                // Vale alimentação: O valor não pode exceder os 20%
        fpEvento.setEveFormula("$sf*0,15");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Vale alimentação");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoBean.save();
        fpEvento = new FpEvento();
    
    }
    


}
