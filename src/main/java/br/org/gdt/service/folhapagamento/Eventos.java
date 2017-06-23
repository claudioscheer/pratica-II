package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpEnumTabelas;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.enums.FpTipoValorFaixa;
import br.org.gdt.enums.Insalubridade;
import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFaixa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffDependentesService;
import br.org.gdt.service.FpTabelaService;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventos")
public class Eventos {

    private final int HORAS_MENSAIS = 220;

    @Autowired
    private FpTabelaService fpTabelaService;

    @Autowired
    private CsbffDependentesService csbffDependentesService;

    public FpEventoPeriodo calcularEvento(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        if (fpEventoPeriodo.isJaCalculado()) {
            return fpEventoPeriodo;
        }

        if (fpEventoPeriodo.isEventoAlteradoManualmente()) {
            fpEventoPeriodo.setJaCalculado(true);
            return fpEventoPeriodo;
        }

        int evento = FpEnumEventos.values()[(int) fpEventoPeriodo.getEvpEvento().getEveId() - 1].ordinal();
        if (evento == FpEnumEventos.Salario.ordinal()) {
            fpEventoPeriodo.setEvpValorReferencia(HORAS_MENSAIS);
            fpEventoPeriodo.setEvpValor(dadosCalculadosDoFuncionario.getPessoa().getCargoValorSalario());

        } else if (evento == FpEnumEventos.INSS.ordinal()) {
            // Proventos onde incide INSS.
            double valorEventosIncideINSS = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideINSS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor())
                    .sum();

            // Descontos onde incide INSS.
            valorEventosIncideINSS -= dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideINSS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Desconto)
                    .map((x) -> {
                        try {
                            return verificarEventoJaEstaCalculado(x, dadosCalculadosDoFuncionario);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }).
                    mapToDouble(x -> x.getEvpValor())
                    .sum();

            dadosCalculadosDoFuncionario.setValorBaseINSS(valorEventosIncideINSS);

            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventosIncideINSS, FpEnumTabelas.INSS.ordinal() + 1);
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventosIncideINSS * (fpFaixa.getFaiValor() / 100));
            fpEventoPeriodo.setEvpValorReferencia(fpFaixa.getFaiValor());

        } else if (evento == FpEnumEventos.FGTS.ordinal()) {
            // Proventos onde incide FGTS.
            double valorEventosIncideFGTS = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideFGTS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor())
                    .sum();

            // Descontos onde incide FGTS.
            valorEventosIncideFGTS -= dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideFGTS() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Desconto)
                    .map((x) -> {
                        try {
                            return verificarEventoJaEstaCalculado(x, dadosCalculadosDoFuncionario);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }).
                    mapToDouble(x -> x.getEvpValor())
                    .sum();

            dadosCalculadosDoFuncionario.setValorBaseFGTS(valorEventosIncideFGTS);

            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventosIncideFGTS, FpEnumTabelas.FGTS.ordinal() + 1);
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventosIncideFGTS * (fpFaixa.getFaiValor() / 100));
            fpEventoPeriodo.setEvpValorReferencia(fpFaixa.getFaiValor());

        } else if (evento == FpEnumEventos.IRRF.ordinal()) {
            // Proventos onde incide IRRF.
            double valorEventosIncideIRRF = dadosCalculadosDoFuncionario.getEventos().stream()
                    .filter(x -> x.getEvpEvento().isEveIncideIRRF() && x.getEvpEvento().getEveTipoEvento() == FpTipoEvento.Provento)
                    .mapToDouble(x -> x.getEvpValor())
                    .sum();

            // Descontar o valor do evento INSS.
            valorEventosIncideIRRF -= getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.INSS, dadosCalculadosDoFuncionario);

            Stream<CsbffDependentes> dependentesDaPessoa = csbffDependentesService.BuscaDependentePessoa(
                    dadosCalculadosDoFuncionario.getPessoa().getRecIdpessoa()).stream()
                    .filter(x -> Helper.getIdadeDaPessoa(x.getDependenteDataNascimento()) <= 14);

            // Quantidade de dependentes que o funcionário tem.
            int dependentes = (int) dependentesDaPessoa.count();
            if (dependentes > 0) {
                // Se o funcionário tem dependentes desconta R$ 189 por dependentes.
                FpFaixa fpFaixaValorPorDependente = fpTabelaService.encontrarFaixaDaTabela(0, FpEnumTabelas.ValorIRRFPorDependente.ordinal() + 1);
                valorEventosIncideIRRF -= fpFaixaValorPorDependente.getFaiValor() * dependentes;
            }

            dadosCalculadosDoFuncionario.setValorBaseIRRF(valorEventosIncideIRRF);

            // Joga para a tabela de IRRF.
            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorEventosIncideIRRF, FpEnumTabelas.IRRF.ordinal() + 1);
            double valor = fpFaixa.getFaiTipoValor() == FpTipoValorFaixa.Decimal
                    ? fpFaixa.getFaiValor()
                    : valorEventosIncideIRRF * (fpFaixa.getFaiValor() / 100);

            // Desconta o valor de dedução da faixa.
            valor -= fpFaixa.getFaiValorDeducao();

            fpEventoPeriodo.setEvpValor(valor);
            fpEventoPeriodo.setEvpValorReferencia(fpFaixa.getFaiValor());

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

        } else if (evento == FpEnumEventos.DSR.ordinal()) {
            double valorHorasExtras50 = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.HorasExtras50, dadosCalculadosDoFuncionario);
            double valorHorasExtras100 = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.HorasExtras100, dadosCalculadosDoFuncionario);
            double valorHorasNoturnas = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.HorasNoturnas, dadosCalculadosDoFuncionario);

            double valorHorasExtras = valorHorasExtras50 + valorHorasExtras100 + valorHorasNoturnas;
            double valorReferencia = (double) dadosCalculadosDoFuncionario.getPeriodo().getPerDiasNaoUteis() / dadosCalculadosDoFuncionario.getPeriodo().getPerDiasUteis();

            fpEventoPeriodo.setEvpValor(valorHorasExtras * valorReferencia);
            fpEventoPeriodo.setEvpValorReferencia(valorReferencia);

        } else if (evento == FpEnumEventos.SalarioFamilia.ordinal()) {
            double valorSalario = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.Salario, dadosCalculadosDoFuncionario);
            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(valorSalario, FpEnumTabelas.SalarioFamilia.ordinal() + 1);
            // Buscar a quantidade de filhos abaixo de 14 anos.
            int quantidadeFilhos = 1;
            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiValor() * quantidadeFilhos);
            fpEventoPeriodo.setEvpValorReferencia(quantidadeFilhos);

        } else if (evento == FpEnumEventos.Insalubridade.ordinal() && dadosCalculadosDoFuncionario.getPessoa().getInsalubridade() != null) {
            FpFaixa fpFaixa = fpTabelaService.encontrarFaixaDaTabela(0, FpEnumTabelas.SalarioMinimo.ordinal() + 1);

            double nivelInsalubridade = 0.0;
            switch (dadosCalculadosDoFuncionario.getPessoa().getInsalubridade()) {
                case Alto:
                    nivelInsalubridade = 0.4;
                    break;

                case Médio:
                    nivelInsalubridade = 0.2;
                    break;

                case Baixo:
                    nivelInsalubridade = 0.1;
                    break;
            }

            fpEventoPeriodo.setEvpValor(fpFaixa.getFaiValor() * nivelInsalubridade);
            fpEventoPeriodo.setEvpValorReferencia(nivelInsalubridade);

        } else if (evento == FpEnumEventos.Periculosidade.ordinal() && dadosCalculadosDoFuncionario.getPessoa().getRecPericulosidade() != null) {
            double valorSalario = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.Salario, dadosCalculadosDoFuncionario);

            double nivelPericulosidade = 0.0;
            switch (dadosCalculadosDoFuncionario.getPessoa().getRecPericulosidade()) {
                case Sim:
                    nivelPericulosidade = 0.3;
                    break;
            }

            fpEventoPeriodo.setEvpValor(valorSalario * nivelPericulosidade);
            fpEventoPeriodo.setEvpValorReferencia(nivelPericulosidade);

        }

        fpEventoPeriodo.setJaCalculado(true);
        return fpEventoPeriodo;
    }

    public double getValorHoraFuncionario(DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        double fpEventoPeriodoSalario = getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos.Salario, dadosCalculadosDoFuncionario);
        return fpEventoPeriodoSalario / HORAS_MENSAIS;
    }

    public Optional<FpEventoPeriodo> getEventoDosEventosDoFuncionario(FpEnumEventos evento, List<FpEventoPeriodo> eventos) throws Exception {
        return eventos.stream()
                .filter(x -> x.getEvpEvento().getEveId() == evento.ordinal() + 1)
                .findFirst();
    }

    public double getValorEventoDosEventosDoFuncionario(FpEnumEventos evento, List<FpEventoPeriodo> eventos) throws Exception {
        Optional<FpEventoPeriodo> optionalEventoPeriodo = getEventoDosEventosDoFuncionario(evento, eventos);
        return !optionalEventoPeriodo.isPresent() ? 0 : optionalEventoPeriodo.get().getEvpValor();
    }

    public double getValorEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos evento, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        FpEventoPeriodo fpEventoPeriodo = getEventoDosEventosDoFuncionarioVerificarJaCalculado(evento, dadosCalculadosDoFuncionario);
        return fpEventoPeriodo == null ? 0 : fpEventoPeriodo.getEvpValor();
    }

    public FpEventoPeriodo getEventoDosEventosDoFuncionarioVerificarJaCalculado(FpEnumEventos evento, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        Optional<FpEventoPeriodo> optionalEventoPeriodo = getEventoDosEventosDoFuncionario(evento, dadosCalculadosDoFuncionario.getEventos());
        if (!optionalEventoPeriodo.isPresent()) {
            return null;
        }
        return verificarEventoJaEstaCalculado(optionalEventoPeriodo.get(), dadosCalculadosDoFuncionario);
    }

    public FpEventoPeriodo verificarEventoJaEstaCalculado(FpEventoPeriodo fpEventoPeriodo, DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws Exception {
        if (fpEventoPeriodo == null || fpEventoPeriodo.isJaCalculado()) {
            return fpEventoPeriodo;
        }
        return calcularEvento(fpEventoPeriodo, dadosCalculadosDoFuncionario);
    }

}
