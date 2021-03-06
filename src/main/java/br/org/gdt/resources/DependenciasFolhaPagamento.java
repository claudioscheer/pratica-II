package br.org.gdt.resources;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEvento;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpPeriodoService;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dependenciasFolhaPagamento")
public class DependenciasFolhaPagamento {

    @Autowired
    private FpEventoService fpEventoService;

    @Autowired
    private FpPeriodoService fpPeriodoService;

    public void salvarTodosEventos() {
        FpEvento fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.Salario.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.HorasExtras50.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 50%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.HorasExtras100.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 100%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.HorasNoturnas.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas noturnas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.HorasFaltas.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Horas faltas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.INSS.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("INSS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.FGTS.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNaoAlteraFolha(true);
        fpEvento.setEveNome("FGTS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.IRRF.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("IRRF");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.SalarioFamilia.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário família");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.Insalubridade.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Insalubridade");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.Periculosidade.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Periculosidade");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.ValeTransporte.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale transporte");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.ValeAlimentacao.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale alimentação");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.ValeRefeicao.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale refeição");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.PlanoSaude.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Plano de saúde");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.ContribuicaoSindical.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Contribuição sindical");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado.
        fpEvento.setEveId(FpEnumEventos.DSR.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("DSR - Descanso Semanal Remunerado");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();
    }

    public void salvarPeriodo() {
        FpPeriodo fpPeriodo = new FpPeriodo();
        fpPeriodo.setPerAno(2017);
        fpPeriodo.setPerMes(05);

        Calendar calendarDataInicial = Calendar.getInstance();
        calendarDataInicial.set(Calendar.YEAR, 2017);
        calendarDataInicial.set(Calendar.MONTH, 4);
        calendarDataInicial.set(Calendar.DATE, 1);

        Calendar calendarDataFinal = Calendar.getInstance();
        calendarDataFinal.set(Calendar.YEAR, 2017);
        calendarDataFinal.set(Calendar.MONTH, 4);
        calendarDataFinal.set(Calendar.DATE, 31);

        fpPeriodo.setPerDataInicial(calendarDataInicial.getTime());
        fpPeriodo.setPerDataFinal(calendarDataFinal.getTime());
        fpPeriodo.setPerDiasNaoUteis(11);
        fpPeriodo.setPerDiasUteis(20);
        fpPeriodo.setPerPago(false);
        fpPeriodoService.update(fpPeriodo);
    }

}
