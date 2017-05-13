package br.org.gdt.resources;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEvento;
import br.org.gdt.model.FpTabela;
import br.org.gdt.model.FpTabelaVigencia;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpTabelaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dependenciasFolhaPagamento")
public class DependenciasFolhaPagamento {

    @Autowired
    private FpEventoService fpEventoService;

    @Autowired
    private FpTabelaService fpTabelaService;

    public void salvarTudo() {
        salvarTodosEventos();
    }

    private void salvarTodosEventos() {
        FpEvento fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.Salario.ordinal() + 1);
        fpEvento.setEveFormula("$sf");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Máximo de horas permitidas por dia é 2h.
        fpEvento.setEveId(FpEnumEventos.HorasExtras50.ordinal() + 1);
        fpEvento.setEveFormula("$vh*1.5*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 50%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.HorasExtras100.ordinal() + 1);
        fpEvento.setEveFormula("$vh*2*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 100%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.HorasNoturnas.ordinal() + 1);
        fpEvento.setEveFormula("$vh*1.2*$#");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas noturnas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.HorasFaltas.ordinal() + 1);
        fpEvento.setEveFormula("$hm-$#");
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Horas faltas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.INSS.ordinal() + 1);
        fpEvento.setEveFormula("$t-1*$va");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("INSS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.FGTS.ordinal() + 1);
        fpEvento.setEveFormula("$t-4*$va");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("FGTS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.IRRF.ordinal() + 1);
        fpEvento.setEveFormula("$t-3*$va");
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("IRRF");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();
    }

}
