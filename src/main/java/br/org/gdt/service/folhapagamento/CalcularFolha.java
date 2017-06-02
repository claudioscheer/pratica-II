package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpStatusFolhaPeriodo;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpEventoPeriodoRelatorio;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("calcularFolha")
public class CalcularFolha {

    private final DecimalFormat decimalFormat = new DecimalFormat("#0.00");

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
                        .map((x) -> {
                            try {
                                x.setEvpValor(decimalFormat.parse(decimalFormat.format(x.getEvpValor())).doubleValue());
                                x.setEvpValorReferencia(decimalFormat.parse(decimalFormat.format(x.getEvpValorReferencia())).doubleValue());
                            } catch (NumberFormatException | ParseException e) {
                                throw new RuntimeException(e);
                            }
                            return x;
                        })
                        .collect(Collectors.toList())
        );

        fpFolhaPeriodo.setForValorBaseFGTS(dadosCalculadosDoFuncionario.getValorBaseFGTS());
        fpFolhaPeriodo.setForValorBaseINSS(dadosCalculadosDoFuncionario.getValorBaseINSS());
        fpFolhaPeriodo.setForValorBaseIRRF(dadosCalculadosDoFuncionario.getValorBaseIRRF());

        fpFolhaPeriodo.setForValorFGTS(eventos.getValorEventoDosEventosDoFuncionario(FpEnumEventos.FGTS, fpFolhaPeriodo.getForEventos()));

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

    public void gerarFolha(FpFolhaPeriodo fpFolhaPeriodo) throws Exception {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", "Asa Delta RH");
        parametros.put("cnpj", "66.521.415/0001-19");
        parametros.put("dataAdmissao", "01/10/2013  ");
        parametros.put("cargo", "Desenvolvedor Junior e Burro");
        parametros.put("CBO", "34563456");

        String nomePessoa = fpFolhaPeriodo.getForPessoa().getRecIdpessoa() + " - " + fpFolhaPeriodo.getForPessoa().getRecNomecompleto();
        parametros.put("pessoa", nomePessoa);
        String periodo = fpFolhaPeriodo.getForPeriodo().getPerMes() + "/" + fpFolhaPeriodo.getForPeriodo().getPerAno();
        parametros.put("periodo", periodo);
        parametros.put("salarioBase", decimalFormat.format(eventos.getValorEventoDosEventosDoFuncionario(FpEnumEventos.Salario, fpFolhaPeriodo.getForEventos())));
        parametros.put("baseCalculoINSS", decimalFormat.format(fpFolhaPeriodo.getForValorBaseINSS()));
        parametros.put("baseCalculoFGTS", decimalFormat.format(fpFolhaPeriodo.getForValorBaseFGTS()));
        parametros.put("baseCalculoIRRF", decimalFormat.format(fpFolhaPeriodo.getForValorBaseIRRF()));
        parametros.put("FGTS", decimalFormat.format(fpFolhaPeriodo.getForValorFGTS()));
        parametros.put("totalVencimentos", decimalFormat.format(fpFolhaPeriodo.getForTotalVencimentos()));
        parametros.put("totalDescontos", decimalFormat.format(fpFolhaPeriodo.getForTotalDescontos()));
        parametros.put("totalLiquido", decimalFormat.format(fpFolhaPeriodo.getForTotalLiquido()));

        List<FpEventoPeriodoRelatorio> eventosPeriodoRelatorio = new ArrayList<>();

        eventosPeriodoRelatorio.addAll(
                fpFolhaPeriodo.getForEventos().stream()
                        .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                        .map(x -> new FpEventoPeriodoRelatorio(
                        x.getEvpEvento().getEveId(),
                        x.getEvpEvento().getEveNome(),
                        decimalFormat.format(x.getEvpValorReferencia()),
                        decimalFormat.format(x.getEvpValor()),
                        ""))
                        .collect(Collectors.toList()));

        eventosPeriodoRelatorio.addAll(
                fpFolhaPeriodo.getForEventos().stream()
                        .filter(x -> x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Desconto)
                        .map(x -> new FpEventoPeriodoRelatorio(
                        x.getEvpEvento().getEveId(),
                        x.getEvpEvento().getEveNome(),
                        decimalFormat.format(x.getEvpValorReferencia()),
                        "",
                        decimalFormat.format(x.getEvpValor())))
                        .collect(Collectors.toList()));

        Helper.gerarBaixarRelatorioPDF(periodo + " | " + nomePessoa, "/folhapagamento/relatorio/folha_land.jasper", parametros, eventosPeriodoRelatorio);
    }

}
