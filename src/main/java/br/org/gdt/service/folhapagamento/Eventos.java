package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpTipoValorFaixa;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.FpTabela;
import br.org.gdt.service.FpTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventos")
public class Eventos {

    private final int HORAS_MENSAIS = 220;

    @Autowired
    private FpTabelaService fpTabelaService;

    public FpEventoPeriodo calcularEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        fpEventoPeriodo.setEvpValor(valorDoEvento(fpEventoPeriodo, dadosCalculadosDoFuncionario));
        fpEventoPeriodo.setJaCalculado(true);
        return fpEventoPeriodo;
    }

    private double valorDoEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        FpEnumEventos evento = FpEnumEventos.values()[(int) fpEventoPeriodo.getEvpEvento().getEveId() - 1];
        switch (evento) {
            case Salario:
                return 5000;
            //return dadosCalculadosDoFuncionario.getPessoa().getRec;

            case INSS: {
                double valorEventoIncideINSS = dadosCalculadosDoFuncionario.getEventos().stream()
                        .filter(x -> x.getEvpEvento().isEveIncideINSS())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideINSS, 1);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideINSS * (fpFaixa.getFaiValor() / 100);
            }

            case FGTS: {
                double valorEventoIncideFGTS = dadosCalculadosDoFuncionario.getEventos().stream()
                        .filter(x -> x.getEvpEvento().isEveIncideFGTS())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideFGTS, 4);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideFGTS * (fpFaixa.getFaiValor() / 100);
            }

            // Precisa ser visto de onde descontar a dedução. Tem a dedução por dependente ainda.
            case IRRF: {
                double valorEventoIncideIRRF = dadosCalculadosDoFuncionario.getEventos().stream()
                        .filter(x -> x.getEvpEvento().isEveIncideIRRF())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideIRRF, 4);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideIRRF * (fpFaixa.getFaiValor() / 100);
            }

            case HorasExtras50: {
                double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
                return valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 1.5;
            }

            case HorasExtras100: {
                double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
                return valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 2;
            }

            case HorasFaltas: {
                double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
                return valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia();
            }

            // Trabalhadores rurais no mínimo 25%? Fonte: http://www.mcalculos.com.br/noticias/ler/32/fonte-guia-trabalhista.html.
            case HorasNoturnas: {
                double valorHoraFuncionario = getValorHoraFuncionario(dadosCalculadosDoFuncionario);
                return valorHoraFuncionario * fpEventoPeriodo.getEvpValorReferencia() * 1.2;
            }

            default:
                return fpEventoPeriodo.getEvpValor();
        }
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
