package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.enums.FpTipoEvento;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.FpEventoService;
import br.org.gdt.service.FpFolhaPeriodoService;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("calcularFolha")
public class CalcularFolha {

    private final double SALARIO = 5908.33;
    private List<FpEventoPeriodo> EVENTOS_PADROES;

    @Autowired
    private FpEventoService fpEventoService;

    @Autowired
    private Eventos eventos;

    @Autowired
    private FpFolhaPeriodoService fpFolhaPeriodoService;

    private List<FpEventoPeriodo> getEventosPadroes() {
        if (EVENTOS_PADROES != null) {
            return EVENTOS_PADROES;
        }

        EVENTOS_PADROES = new ArrayList<>();

        FpEventoPeriodo eventoSalario = new FpEventoPeriodo();
        eventoSalario.setEvpEvento(fpEventoService.findById(FpEnumEventos.Salario.ordinal() + 1));
        EVENTOS_PADROES.add(eventoSalario);

        FpEventoPeriodo eventoINSS = new FpEventoPeriodo();
        eventoINSS.setEvpEvento(fpEventoService.findById(FpEnumEventos.INSS.ordinal() + 1));
        EVENTOS_PADROES.add(eventoINSS);

        FpEventoPeriodo eventoFGTS = new FpEventoPeriodo();
        eventoFGTS.setEvpEvento(fpEventoService.findById(FpEnumEventos.FGTS.ordinal() + 1));
        EVENTOS_PADROES.add(eventoFGTS);

        FpEventoPeriodo eventoIRRF = new FpEventoPeriodo();
        eventoIRRF.setEvpEvento(fpEventoService.findById(FpEnumEventos.IRRF.ordinal() + 1));
        EVENTOS_PADROES.add(eventoIRRF);

        return EVENTOS_PADROES;
    }

    public void calcularParaTodosFuncionarios() {

    }

    public void calcularFolhaPagamentoFuncionario(DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) throws RuntimeException {
        FpFolhaPeriodo fpFolhaPeriodo = new FpFolhaPeriodo();
        fpFolhaPeriodo.setForGeradaEm(Calendar.getInstance().getTime());
        fpFolhaPeriodo.setForPeriodo(dadosCalculadosDoFuncionario.getPeriodo());
        // fpFolhaPeriodo.setForPessoa(dadosCalculadosDoFuncionario.getPessoa());
        
        dadosCalculadosDoFuncionario.getEventos().addAll(getEventosPadroes());

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
        
        fpFolhaPeriodoService.save(fpFolhaPeriodo);
    }

}
