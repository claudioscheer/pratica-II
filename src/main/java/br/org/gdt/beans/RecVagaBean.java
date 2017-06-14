package br.org.gdt.beans;

import br.org.gdt.model.RecHabilidade;
import br.org.gdt.model.RecRequisicaoVaga;
import br.org.gdt.model.RecVaga;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecHabilidadeService;
import br.org.gdt.service.RecVagaService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecVagaBean {

    private boolean formAtivo = false;
    private String stringBusca;

    ///DADOS DA VAGA
    private RecVaga vaga = new RecVaga();
    private List<RecVaga> vagas;
    @ManagedProperty("#{recVagaService}")
    private RecVagaService recVagaService;

    ///DADOS DA HABILIDADE
    @ManagedProperty("#{recHabilidadeService}")
    private RecHabilidadeService recHabilidadeService;
    private RecHabilidade habilidade = new RecHabilidade();
    private List<RecHabilidade> habilidades;

    public RecVagaBean() {
    }

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

    public void Salvar() {

        if (ValidarCampos()) {
            if (vaga.getRecIdvaga() > 0) {
                if (habilidades != null) {
                    vaga.setRecHabilidadeList(habilidades);
                }
                recVagaService.Alterar(vaga);
            } else {
                if (habilidades != null) {
                    vaga.setRecHabilidadeList(habilidades);
                }
                recVagaService.Inserir(vaga);
            }
            vagas = recVagaService.ListarTodas();
        }
    }

    public List<RecVaga> ListarTodas() {
        if (vagas == null) {
            vagas = recVagaService.ListarTodas();
        }
        return vagas;
    }

    public String AbrirPaginaVagas() {
        if (this.ListarTodasExternas().size() > 0) {
            return "menu_vaga_lista";
        } else {
            return "sem_vagas";
        }
    }

    public List<RecVaga> ListarTodasExternas() {
        if (vagas == null) {
            vagas = recVagaService.ListarTodasVagasExternas();
        }
        return vagas;
    }

    public List<RecHabilidade> ListarHabilidade() {
        if (habilidades == null) {
            habilidades = recHabilidadeService.ListarTodas();
        }
        return habilidades;
    }

    public List<RecVaga> PesquisarPorDescricao() {
        if (stringBusca == null) {
            vagas = recVagaService.ListarTodas();
        } else {
            vagas = recVagaService.PesquisarPorDescricao(stringBusca);
        }
        return vagas;
    }

    public String PreparaEdicao(RecVaga vaga) {
        this.formAtivo = true;
        this.vaga = vaga;
        return "vagas";
    }

    public String GerarVaga(RecRequisicaoVaga req) {
        this.formAtivo = true;        
        vaga.setRecDescricao(req.getRecDescricao());
        vaga.setRecSexo(req.getRecSexo());
        vaga.setRecGrauensino(req.getRecIdgrauensino());
        return "vagas";
    }

    public String VisualizarVaga(RecVaga vaga) {
        this.formAtivo = true;
        this.vaga = vaga;
        return "menu_vaga_lista";
    }

    public String CandidatarParaVaga() {
        return "curriculo";
    }

    public void AdicionarHabilidade() {
        this.habilidades.add(habilidade);
        this.habilidade = new RecHabilidade();
        vaga.setRecHabilidadeList(habilidades);
    }

    public String Excluir(RecVaga vaga) {
        recVagaService.Excluir(vaga.getRecIdvaga());
        return "vagas";
    }

    public void Cancelar() {
        this.formAtivo = false;
        this.vaga = new RecVaga();
    }

    public void Adicionar() {
        this.formAtivo = true;
        this.vaga = new RecVaga();
    }

    public RecVagaService getRecVagaService() {
        return recVagaService;
    }

    public void setRecVagaService(RecVagaService recVagaService) {
        this.recVagaService = recVagaService;
    }

    public List<RecVaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<RecVaga> vagas) {
        this.vagas = vagas;
    }

    public RecVaga getVaga() {
        return vaga;
    }

    public void setVaga(RecVaga vaga) {
        this.vaga = vaga;
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

    public RecHabilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(RecHabilidade habilidade) {
        this.habilidade = habilidade;
    }

    public List<RecHabilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<RecHabilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public String getStringBusca() {
        return stringBusca;
    }

    public void setStringBusca(String stringBusca) {
        this.stringBusca = stringBusca;
    }

    public boolean ValidarCampos() {
        if (vaga.getRecDescricao().isEmpty()) {
            Helper.mostrarNotificacao("Descrição", "Preencha a Descrição da Vaga", "error");
            return false;
        }
        if (vaga.getRecSexo() == null) {
            Helper.mostrarNotificacao("Sexo", "Selecione o Sexo", "error");
            return false;
        }
        if (vaga.getRecGrauensino() == null) {
            Helper.mostrarNotificacao("Grau de Ensino", "Selecione o Sexo", "error");
            return false;
        }
        if (vaga.getRecSalario() == null) {
            Helper.mostrarNotificacao("Salário", "Preencha o Salário", "error");
            return false;
        }
        return true;
    }
}
