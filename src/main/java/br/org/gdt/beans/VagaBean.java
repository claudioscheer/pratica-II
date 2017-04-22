package br.org.gdt.beans;

import br.org.gdt.model.RecVaga;
import br.org.gdt.service.RecVagaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VagaBean {

    
    private RecVaga vaga = new RecVaga();    
    private List<RecVaga> vagas;

    @ManagedProperty("#{recVagaService}")
    private RecVagaService recVagaService;
    
    public VagaBean() {
    }
    
    public void Salvar() {

    }

    public List<RecVaga> ListarTodas() {
        if (vagas == null) {
            vagas = recVagaService.ListarTodas();
        }
        return vagas;
    }

    public void Editar(RecVaga vaga) {

    }

    public void Excluir(RecVaga vaga) {

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

}
