package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.DependenciasFolhaPagamento;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.folhapagamento.CalcularFolha;
import br.org.gdt.service.FpFolhaPeriodoService;
import br.org.gdt.service.FpPeriodoService;
import br.org.gdt.service.RecPessoaService;
import br.org.gdt.service.folhapagamento.DadosCalculadosDoFuncionario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FpCalcularBean {

    private DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario;
    private boolean gerarTodasPessoas;
    private FpTipoFolha fpTipoFolha;
    private List<FpPeriodo> todosFpPeriodo;
    private int pessoaId;

    @ManagedProperty("#{fpPeriodoService}")
    private FpPeriodoService fpPeriodoService;

    @ManagedProperty("#{calcularFolha}")
    private CalcularFolha calcularFolha;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    public FpCalcularBean() {

    }

    public void selecionarTipoFolha() {
    }

    public void selecionarPeriodo() {
    }

    public void buscarPessoa() {
//        RecPessoa pessoa = recPessoaService.BuscarId(pessoaId);
//        if (pessoa == null) {
//            Helper.mostrarNotificacao("Dados inválidos", "A pessoa não existe!", "info");
//            recPessoa.setRecIdpessoa(0);
//            return;
//        }
//        recPessoa = pessoa;
    }

    public void calcularFolhaPagamento() {
        if (dadosCalculadosDoFuncionario.getPeriodo().getPerId() == 0) {
            Helper.mostrarNotificacao("Calcular folha", "Selecione um período. Se necessário, cadastre um novo.", "info");
            return;
        }
//        fpPeriodo = fpPeriodoService.findById(fpPeriodo.getPerId());

    }

    public DadosCalculadosDoFuncionario getDadosCalculadosDoFuncionario() {
        return dadosCalculadosDoFuncionario;
    }

    public void setDadosCalculadosDoFuncionario(DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario) {
        this.dadosCalculadosDoFuncionario = dadosCalculadosDoFuncionario;
    }

    public boolean isGerarTodasPessoas() {
        return gerarTodasPessoas;
    }

    public void setGerarTodasPessoas(boolean gerarTodasPessoas) {
        this.gerarTodasPessoas = gerarTodasPessoas;
    }

    public FpTipoFolha getFpTipoFolha() {
        return fpTipoFolha;
    }

    public void setFpTipoFolha(FpTipoFolha fpTipoFolha) {
        this.fpTipoFolha = fpTipoFolha;
    }

    public List<FpPeriodo> getTodosFpPeriodo() {
//        if (todosFpPeriodo == null) {
//            todosFpPeriodo = fpPeriodoService.findAll();
//        }
//        return todosFpPeriodo;
        return fpPeriodoService.findAll();
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public void setTodosFpPeriodo(List<FpPeriodo> todosFpPeriodo) {
        this.todosFpPeriodo = todosFpPeriodo;
    }

    public FpPeriodoService getFpPeriodoService() {
        return fpPeriodoService;
    }

    public void setFpPeriodoService(FpPeriodoService fpPeriodoService) {
        this.fpPeriodoService = fpPeriodoService;
    }

    public CalcularFolha getCalcularFolha() {
        return calcularFolha;
    }

    public void setCalcularFolha(CalcularFolha calcularFolha) {
        this.calcularFolha = calcularFolha;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

}
