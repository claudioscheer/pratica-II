package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpStatusFolhaPeriodo;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("calcularFolha")
public class CalcularFolha {

    @Autowired
    private FpEventoService fpEventoService;

    @Autowired
    private Eventos eventos;

    @Autowired
    private FpFolhaPeriodoService fpFolhaPeriodoService;

    private List<FpEventoPeriodo> getEventosPadroes() {
        List<FpEventoPeriodo> eventosPadroes = new ArrayList<>();

        FpEventoPeriodo eventoSalario = new FpEventoPeriodo();
        eventoSalario.setEvpEvento(fpEventoService.findById(FpEnumEventos.Salario.ordinal() + 1));
        eventoSalario.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoSalario);

        FpEventoPeriodo eventoINSS = new FpEventoPeriodo();
        eventoINSS.setEvpEvento(fpEventoService.findById(FpEnumEventos.INSS.ordinal() + 1));
        eventoINSS.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoINSS);

        FpEventoPeriodo eventoFGTS = new FpEventoPeriodo();
        eventoFGTS.setEvpEvento(fpEventoService.findById(FpEnumEventos.FGTS.ordinal() + 1));
        eventoFGTS.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoFGTS);

        FpEventoPeriodo eventoIRRF = new FpEventoPeriodo();
        eventoIRRF.setEvpEvento(fpEventoService.findById(FpEnumEventos.IRRF.ordinal() + 1));
        eventoIRRF.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoIRRF);

        FpEventoPeriodo eventoDSR = new FpEventoPeriodo();
        eventoDSR.setEvpEvento(fpEventoService.findById(FpEnumEventos.DSR.ordinal() + 1));
        eventoDSR.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoDSR);

        FpEventoPeriodo eventoSalarioFamilia = new FpEventoPeriodo();
        eventoSalarioFamilia.setEvpEvento(fpEventoService.findById(FpEnumEventos.SalarioFamilia.ordinal() + 1));
        eventoSalarioFamilia.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoSalarioFamilia);

        FpEventoPeriodo eventoInsalubridade = new FpEventoPeriodo();
        eventoInsalubridade.setEvpEvento(fpEventoService.findById(FpEnumEventos.Insalubridade.ordinal() + 1));
        eventoInsalubridade.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoInsalubridade);

        FpEventoPeriodo eventoPericulosidade = new FpEventoPeriodo();
        eventoPericulosidade.setEvpEvento(fpEventoService.findById(FpEnumEventos.Periculosidade.ordinal() + 1));
        eventoPericulosidade.setEvpEventoPadrao(true);
        eventosPadroes.add(eventoPericulosidade);

        return eventosPadroes;
    }

    public void calcularParaTodosFuncionarios() {

    }

    public FpFolhaPeriodo calcularFolhaPagamentoFuncionario(DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws RuntimeException, Exception {
        fpFolhaPeriodoService.deleteByPessoaEPeriodo(dadosCalculadosDoFuncionario.getPeriodo(), dadosCalculadosDoFuncionario.getPessoa());

        FpFolhaPeriodo fpFolhaPeriodo = new FpFolhaPeriodo();
        fpFolhaPeriodo.setForGeradaEm(Calendar.getInstance().getTime());
        fpFolhaPeriodo.setForPeriodo(dadosCalculadosDoFuncionario.getPeriodo());
        fpFolhaPeriodo.setForPessoa(dadosCalculadosDoFuncionario.getPessoa());

        if (!dadosCalculadosDoFuncionario.isRecalculando()) {
            dadosCalculadosDoFuncionario.getEventos().addAll(getEventosPadroes());
        }

        dadosCalculadosDoFuncionario.getEventos().stream()
                .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                .forEach((ev) -> {
                    try {
                        fpFolhaPeriodo.addForEvento(eventos.calcularEvento(ev, dadosCalculadosDoFuncionario));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
        dadosCalculadosDoFuncionario.getEventos().stream()
                .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Desconto)
                .forEach((ev) -> {
                    try {
                        fpFolhaPeriodo.addForEvento(eventos.calcularEvento(ev, dadosCalculadosDoFuncionario));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
        fpFolhaPeriodo.setForStatusFolhaPeriodo(
                dadosCalculadosDoFuncionario.isRecalculando()
                ? FpStatusFolhaPeriodo.Validada
                : FpStatusFolhaPeriodo.Calculada);

        fpFolhaPeriodo.setForEventos(
                fpFolhaPeriodo.getForEventos().stream()
                        .filter(x -> x.getEvpValor() != 0d)
                        .collect(Collectors.toList())
        );

        fpFolhaPeriodo.setForValorBaseFGTS(dadosCalculadosDoFuncionario.getValorBaseFGTS());
        fpFolhaPeriodo.setForValorBaseINSS(dadosCalculadosDoFuncionario.getValorBaseINSS());
        fpFolhaPeriodo.setForValorBaseIRRF(dadosCalculadosDoFuncionario.getValorBaseIRRF());

        fpFolhaPeriodo.setForValorFGTS(eventos.getValorEventoDosEventosDoFuncionario(FpEnumEventos.FGTS, dadosCalculadosDoFuncionario));

        fpFolhaPeriodo.setForTotalDescontos(
                fpFolhaPeriodo.getForEventos().stream()
                        .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Desconto && !x.getEvpEvento().isEveNaoAlteraFolha())
                        .mapToDouble(x -> x.getEvpValor())
                        .sum());

        fpFolhaPeriodo.setForTotalVencimentos(
                fpFolhaPeriodo.getForEventos().stream()
                        .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento && !x.getEvpEvento().isEveNaoAlteraFolha())
                        .mapToDouble(x -> x.getEvpValor())
                        .sum());

        // E se o valor ficar negativo?
        fpFolhaPeriodo.setForTotalLiquido(fpFolhaPeriodo.getForTotalVencimentos() - fpFolhaPeriodo.getForTotalDescontos());

        fpFolhaPeriodoService.update(fpFolhaPeriodo);

        return fpFolhaPeriodo;
    }

}
