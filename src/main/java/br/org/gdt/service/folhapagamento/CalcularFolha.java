package br.org.gdt.service.folhapagamento;

import br.org.gdt.enums.FpEnumEventos;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.FpEventoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("calcularFolha")
public class CalcularFolha {

    private final double SALARIO = 5908.33;
    private List<FpEventoPeriodo> EVENTOS_PADROES;

    @Autowired
    private FpEventoService fpEventoService;

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

    // Falta pedir o parâmetro da pessoa e do período.
    public void calcularFuncionario(List<FpEventoPeriodo> eventosVariaveis) {
        DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario = new DadosCalculadosDoFuncionario();

        dadosCalculadosDoFuncionario.getEventos().addAll(getEventosPadroes());
        dadosCalculadosDoFuncionario.getEventos().addAll(eventosVariaveis);
        dadosCalculadosDoFuncionario.ordenarEventosParaCalcular();       
        
        
    }

}
