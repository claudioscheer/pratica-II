package br.org.gdt.beans;

import br.org.gdt.enums.FpTipoFolha;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.folhapagamento.CalcularFolha;
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

    private boolean gerarTodasPessoas;
    private FpPeriodo fpPeriodo = new FpPeriodo();
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
//        RecPessoa recPessoa = recPessoaService.BuscarId(pessoaId);
//                if (recPessoa == null) {
//                    Helper.mostrarNotificacao("Dados inválidos", "A pessoa não existe.", "info");
//                    return;
//                }


    }

    public void calcularFolhaPagamento() {
        if (fpPeriodo.getPerId() == 0) {
            Helper.mostrarNotificacao("Calcular folha", "Selecione um período. Se necessário, cadastre um novo.", "info");
            return;
        }
        fpPeriodo = fpPeriodoService.findById(fpPeriodo.getPerId());
        if (gerarTodasPessoas) {
            calcularFolha.calcularParaTodosFuncionarios();
        } else {
            try {
                DadosCalculadosDoFuncionario dadosCalculadosDoFuncionario = new DadosCalculadosDoFuncionario();
                dadosCalculadosDoFuncionario.setPeriodo(fpPeriodo);

                RecPessoa recPessoa = recPessoaService.BuscarId(pessoaId);
//                if (recPessoa == null) {
//                    Helper.mostrarNotificacao("Dados inválidos", "A pessoa não existe.", "info");
//                    return;
//                }
                dadosCalculadosDoFuncionario.setPessoa(recPessoa);

                calcularFolha.calcularFolhaPagamentoFuncionario(dadosCalculadosDoFuncionario);
            } catch (Exception e) {
                Helper.mostrarNotificacao("Calcular folha", e.getMessage(), "info");
            }
        }
    }

    public boolean isGerarTodasPessoas() {
        return gerarTodasPessoas;
    }

    public void setGerarTodasPessoas(boolean gerarTodasPessoas) {
        this.gerarTodasPessoas = gerarTodasPessoas;
    }

    public FpPeriodo getFpPeriodo() {
        return fpPeriodo;
    }

    public void setFpPeriodo(FpPeriodo fpPeriodo) {
        this.fpPeriodo = fpPeriodo;
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
