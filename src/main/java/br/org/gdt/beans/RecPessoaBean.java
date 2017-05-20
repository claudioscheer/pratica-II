package br.org.gdt.beans;

import br.org.gdt.model.RecHabilidade;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.RecHabilidadeService;
import br.org.gdt.service.RecPessoaService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecPessoaBean {

    private boolean formAtivo = false;
    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoas;

    private List<RecHabilidade> pesHabilidades;
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    @ManagedProperty("#{recHabilidadeService}")
    private RecHabilidadeService recHabilidadeService;

    public List<RecHabilidade> completarHabilidade(String query) {
        List<RecHabilidade> allThemes = recHabilidadeService.ListarTodas();
        List<RecHabilidade> filteredThemes = new ArrayList<RecHabilidade>();

        for (int i = 0; i < allThemes.size(); i++) {
            RecHabilidade skin = allThemes.get(i);
            if (skin.getRecDescricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
        return filteredThemes;
    }

    public List<RecHabilidade> ListarHabilidades() {
        if (pesHabilidades == null) {
            pesHabilidades = recHabilidadeService.ListarTodas();
        }
        return pesHabilidades;
    }

    public RecPessoaBean() {
    }

    public String Salvar() {
        if (recPessoa.getId() > 0) {
            recPessoaService.Alterar(recPessoa);
        } else {
            recPessoaService.Inserir(recPessoa);
        }
        return "cadastro_curriculo_sucesso";
        //habilidades = recHabilidadeService.ListarTodas();
        
    }

    public String PreparaEdicao(RecPessoa pessoa) {
        this.formAtivo = true;
        this.recPessoa = pessoa;
        return "candidato_lista";
    }

    public List<RecPessoa> ListarTodas() {
        if (recPessoas == null) {
            recPessoas = recPessoaService.ListarTodas();
        }
        return recPessoas;
    }

    public String Adicionar() {
        recPessoa = new RecPessoa();
        return "cadastro_curriculo";
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getRecPessoas() {
        if (recPessoas == null) {
            recPessoas = recPessoaService.ListarTodas();
        }
        return recPessoas;
    }

    public void setRecPessoas(List<RecPessoa> recPessoas) {
        this.recPessoas = recPessoas;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public RecHabilidadeService getRecHabilidadeService() {
        return recHabilidadeService;
    }

    public void setRecHabilidadeService(RecHabilidadeService recHabilidadeService) {
        this.recHabilidadeService = recHabilidadeService;
    }

    public List<RecHabilidade> getHabilidades() {
        return pesHabilidades;
    }

    public void setHabilidades(List<RecHabilidade> habilidades) {
        this.pesHabilidades = habilidades;
    }

    public List<RecHabilidade> getPesHabilidades() {
        return pesHabilidades;
    }

    public void setPesHabilidades(List<RecHabilidade> pesHabilidades) {
        this.pesHabilidades = pesHabilidades;
    }

}
