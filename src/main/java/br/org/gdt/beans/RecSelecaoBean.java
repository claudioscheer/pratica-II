package br.org.gdt.beans;

import br.org.gdt.dao.RecPessoaDAO;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.model.RecSelecao;
import br.org.gdt.model.RecVaga;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecPessoaService;
import br.org.gdt.service.RecSelecaoService;
import br.org.gdt.service.RecVagaService;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecSelecaoBean
{

    private boolean formAtivo = false;
    private boolean descreverEntrevista = false;

    private RecSelecao selecao = new RecSelecao();
    private List<RecSelecao> selecoes;

    @ManagedProperty("#{recSelecaoService}")
    private RecSelecaoService recSelecaoService;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

//    @ManagedProperty("#{recVagaService}")
//    private RecVagaService recVagaService;
    public RecSelecaoBean() {
    }

    public void Salvar()
    {
//        Date data = new Date(2017, 1, 20);
//        RecPessoa p = recPessoaService.BuscarId(1);
//        System.out.println("pessoaaaaaa" + p.getRecIdpessoa());
//        RecVaga v = recVagaService.BuscarId(3);
//        RecSelecao selec = new RecSelecao(1, null, false, data, p, v);
//        recSelecaoService.Inserir(selecao);
        //if (ValidarCampos()) {

        //selecao.setRecDescricaoentrevista("dfsdafads");
        //selecao.setRecAprovado(true);
      // selecao.setRecIdpessoa(recPessoaService.FindByIdCompleto(selecao.getRecIdpessoa().getRecIdpessoa()));
        recSelecaoService.Alterar(selecao);
       
        selecoes = recSelecaoService.ListarTodas();
//        }else{
//            return;
//        }       
    }

    public List<RecSelecao> ListarTodas() {
        if (selecoes == null) {
            selecoes = recSelecaoService.ListarTodas();
        }
        return selecoes;
    }

    public String PreparaEdicao(RecSelecao selecao)
    {
        this.formAtivo = true;
        this.selecao = selecao;
        return "selecao";
    }

    public String DescreverEntrevista(RecSelecao selecao)
    {
        this.formAtivo = true;
        this.descreverEntrevista = true;
        this.selecao = selecao;
        return "selecao";
    }

    public String Excluir(RecSelecao selecao)
    {
        recSelecaoService.Excluir(selecao.getRecIdselecao());
        selecoes = recSelecaoService.ListarTodas();
        return "selecao";
    }

    public void Cancelar()
    {
        this.formAtivo = false;
        this.selecao = new RecSelecao();
    }

    public void Adicionar()
    {
        this.formAtivo = true;
        this.selecao = new RecSelecao();
        this.selecao.setRecIdvaga(new RecVaga());
    }

    public String AgendarEntrevista() {
        this.formAtivo = true;
        this.selecao = new RecSelecao();
        return "selecao";
    }

    public RecSelecao getSelecao() {
        return selecao;
    }

    public void setSelecao(RecSelecao selecao)
    {
        this.selecao = selecao;
    }

    public List<RecSelecao> getSelecoes()
    {
        return selecoes;
    }

    public void setSelecoes(List<RecSelecao> selecoes)
    {
        this.selecoes = selecoes;
    }

    public RecSelecaoService getRecSelecaoService()
    {
        return recSelecaoService;
    }

    public void setRecSelecaoService(RecSelecaoService recSelecaoService)
    {
        this.recSelecaoService = recSelecaoService;
    }

    public boolean isFormAtivo()
    {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo)
    {
        this.formAtivo = formAtivo;
    }

    public boolean ValidarCampos()
    {
        if (selecao.getRecIdpessoa() == null)
        {
            Helper.mostrarNotificacao("Candidato", "Selecione um Candidato", "error");
            return false;
        }
        if (selecao.getRecIdvaga() == null)
        {
            Helper.mostrarNotificacao("Vaga", "Selecione uma Vaga", "error");
            return false;
        }
        return true;
    }

    public boolean isDescreverEntrevista()
    {
        return descreverEntrevista;
    }

    public void setDescreverEntrevista(boolean descreverEntrevista)
    {
        this.descreverEntrevista = descreverEntrevista;
    }
    
    

//    public RecPessoaService getRecPessoaService() {
//        return recPessoaService;
//    }
//
//    public void setRecPessoaService(RecPessoaService recPessoaService) {
//        this.recPessoaService = recPessoaService;
//    }
//
//    public RecVagaService getRecVagaService() {
//        return recVagaService;
//    }
//
//    public void setRecVagaService(RecVagaService recVagaService) {
//        this.recVagaService = recVagaService;
//    }

    public RecPessoaService getRecPessoaService()
    {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService)
    {
        this.recPessoaService = recPessoaService;
    }
}
