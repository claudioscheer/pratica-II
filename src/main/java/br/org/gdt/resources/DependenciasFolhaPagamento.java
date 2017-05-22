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

        // Salário
        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Salario.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Máximo de horas permitidas por dia é 2h.
        //Ajustado
        fpEvento.setEveId(FpEnumEventos.HorasExtras50.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 50%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.HorasExtras100.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas extras 100%");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.HorasNoturnas.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Horas noturnas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado
        fpEvento.setEveId(FpEnumEventos.HorasFaltas.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEveNome("Horas faltas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.INSS.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("INSS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.FGTS.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("FGTS");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.IRRF.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("IRRF");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.PensaoJudicialFixo.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Pensão judicial - fixo");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();
        
        
        fpEvento.setEveId(FpEnumEventos.PensaoJudicialMinimo.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Pensão judicial - %Salário mínimo");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        fpEvento.setEveId(FpEnumEventos.PensaoJudicialPorcentagem.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Pensão Judicial - %Salário");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        // Ajustado
        fpEvento.setEveId(FpEnumEventos.SalarioFamilia.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário família");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.SalarioMaternidade.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Salário maternidade");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Insalubridade10.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Insalubridade 10");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Insalubridade20.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Insalubridade 20");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Insalubridade40.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Insalubridade 40");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Periculosidade.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Periculosidade");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.Transporte.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale transporte");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        // Verificar se é desconto
        fpEvento.setEveId(FpEnumEventos.Alimentacao.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale alimentação");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        //Verificar se é desconto
        fpEvento.setEveId(FpEnumEventos.Refeicao.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Vale refeição");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.PlanoSaude.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Plano de saúde");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.ContribuicaoSindical.ordinal() + 1);
        fpEvento.setEveIncideFGTS(false);
        fpEvento.setEveIncideINSS(false);
        fpEvento.setEveIncideIRRF(false);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Contribuição sindical");
        fpEvento.setEveTipoEvento(FpTipoEvento.Desconto);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado
        fpEvento.setEveId(FpEnumEventos.GratificacoesDiversas.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Gratificações diversas");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();

        //Ajustado 
        //Até 15 dias
        fpEvento.setEveId(FpEnumEventos.AuxilioDoenca.ordinal() + 1);
        fpEvento.setEveIncideFGTS(true);
        fpEvento.setEveIncideINSS(true);
        fpEvento.setEveIncideIRRF(true);
        fpEvento.setEvePermiteExcluir(false);
        fpEvento.setEveNome("Auxilio doença");
        fpEvento.setEveTipoEvento(FpTipoEvento.Provento);
        fpEventoService.update(fpEvento);
        fpEvento = new FpEvento();
    }

}
