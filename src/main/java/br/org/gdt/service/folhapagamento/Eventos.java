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

    @Autowired
    private FpTabelaService fpTabelaService;

    public FpEventoPeriodo calcularEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        fpEventoPeriodo.setEvpValor(valorDoEvento(fpEventoPeriodo, dadosCalculadosDoFuncionario));
        return fpEventoPeriodo;
    }

    private double valorDoEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        FpEnumEventos evento = FpEnumEventos.values()[(int) fpEventoPeriodo.getEvpEvento().getEveId() - 1];
        switch (evento) {
            case Salario:
                return 5000;
            //return dadosCalculadosDoFuncionario.getPessoa().getRec;

            case INSS: {
                double valorEventoIncideINSS = dadosCalculadosDoFuncionario.getEventos()
                        .stream()
                        .filter(x -> x.getEvpEvento().isEveIncideINSS())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideINSS, 1);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideINSS * (fpFaixa.getFaiValor() / 100);
            }

            case FGTS: {
                double valorEventoIncideFGTS = dadosCalculadosDoFuncionario.getEventos()
                        .stream()
                        .filter(x -> x.getEvpEvento().isEveIncideFGTS())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideFGTS, 4);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideFGTS * (fpFaixa.getFaiValor() / 100);
            }

            // Precisa ser viste de onde descontar a dedução.
            case IRRF: {
                double valorEventoIncideIRRF = dadosCalculadosDoFuncionario.getEventos()
                        .stream()
                        .filter(x -> x.getEvpEvento().isEveIncideIRRF())
                        .mapToDouble(x -> x.getEvpValor()).sum();

                FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventoIncideIRRF, 4);
                return fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                        ? fpFaixa.getFaiValor()
                        : valorEventoIncideIRRF * (fpFaixa.getFaiValor() / 100);
            }

            default:
                return fpEventoPeriodo.getEvpValor();
        }
    }

}
