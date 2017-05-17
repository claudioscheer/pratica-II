package br.org.gdt.service;

import br.org.gdt.dao.RecRequisicaoDAO;
import br.org.gdt.dao.RecVagaDAO;
import br.org.gdt.model.RecRequisicaoVaga;
import br.org.gdt.model.RecVaga;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recRequisicaoVagaService")
public class RecRequisicaoVagaService {
    
    @Autowired
    private RecRequisicaoDAO recRequisicaoVagaDAO;
    
    @Transactional
    public void Inserir(RecRequisicaoVaga rec_vaga) {
        recRequisicaoVagaDAO.save(rec_vaga);
    }
    @Transactional
    public void Alterar(RecRequisicaoVaga rec_vaga) {
        recRequisicaoVagaDAO.update(rec_vaga);
    }
    @Transactional
    public void Excluir(Long id) {
        recRequisicaoVagaDAO.delete(id);
    }
    
    public RecRequisicaoVaga BuscarId(int id){
        return recRequisicaoVagaDAO.findById(id);
    }
    
    public List<RecRequisicaoVaga> ListarTodas() {
        return recRequisicaoVagaDAO.findAll();
    }
}
