package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.enums.FpTipoValorFaixa;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.FpTabela;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.FpTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventos")
public class Eventos {

    private final int HORAS_MENSAIS = 220;

    @Autowired
    private FpTabelaService fpTabelaService;

    public FpEventoPeriodo calcularEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        int evento = FpEnumEventos.values()[(int) fpEventoPeriodo.getEvpEvento().getEveId() - 1].ordinal();
        if (evento == FpEnumEventos.Salario.ordinal()) {
            fpEventoPeriodo.setEvpValorReferencia(HORAS_MENSAIS);
            fpEventoPeriodo.setEvpValor(1000);

        } else if (evento == FpEnumEventos.INSS.ordinal()) {
            double valorEventoIncideINSS = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideINSS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor()).sum();

            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideINSS, 1);
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventoIncideINSS * (fpFaixa.getFaiValor() / 100));

        } else if (evento == FpEnumEventos.FGTS.ordinal()) {
            double valorEventoIncideFGTS = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideFGTS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor()).sum();

            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideFGTS, 4);
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventoIncideFGTS * (fpFaixa.getFaiValor() / 100));

        } else if (evento == FpEnumEventos.IRRF.ordinal()) {
            // Precisa ser visto de onde descontar a dedução. Tem a dedução por dependente ainda.
            double valorEventoIncideIRRF = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideIRRF() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor()).sum();

            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideIRRF, 3);
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventoIncideIRRF * (fpFaixa.getFaiValor() / 100));

        } else if (evento == FpEnumEventos.HorasExtras50.ordinal()) {
            double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
            fpEventoPeriodo.setEvpValor(valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 1.5);

        } else if (evento == FpEnumEventos.HorasExtras100.ordinal()) {
            double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
            fpEventoPeriodo.setEvpValor(valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 2);

        } else if (evento == FpEnumEventos.HorasFaltas.ordinal()) {
            double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
            fpEventoPeriodo.setEvpValor(valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia());

        } else if (evento == FpEnumEventos.HorasNoturnas.ordinal()) {
            // Trabalhadores rurais no mínimo 25%? Fonte: http://www.mcalculos.com.br/noticias/ler/32/fonte-guia-trabalhista.html.
            double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
            fpEventoPeriodo.setEvpValor(valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 1.2);

        } else {
            fpEventoPeriodo.setEvpValor(fpEventoPeriodo.getEvpValor());
        }

        fpEventoPeriodo.setJaCalculado(true);
        return fpEventoPeriodo;
    }

    private double getValorHoraFuncionario(DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        FpEventoPeriodo fpEventoPeriodoSalario = getEventoDosEventosDoFuncionario(FpEnumEventos.Salario, dadosCalculadosDoFuncionario);
        return fpEventoPeriodoSalario.getEvpValor() / HORAS_MENSAIS;
    }

    private FpEventoPeriodo getEventoDosEventosDoFuncionario(FpEnumEventos evento, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        FpEventoPeriodo fpEventoPeriodo = dadosCalculadosDoFuncionario.getEventos().stream()
                .filter(x -> x.getEvpEvento().getEveId() == evento.ordinal() + 1)
                .findFirst().get();
        return verificarEventoJaEstaCalculado(fpEventoPeriodo, dadosCalculadosDoFuncionario);
    }

    private FpEventoPeriodo verificarEventoJaEstaCalculado(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        if (fpEventoPeriodo.isJaCalculado()) {
            return fpEventoPeriodo;
        }
        return calcularEvento(fpEventoPeriodo, dadosCalculadosDoFuncionario);
    }

}
