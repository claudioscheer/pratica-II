package br.org.gdt.service;

import br.org.gdt.dao.RecHabilidadeDAO;
import br.org.gdt.model.RecHabilidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recHabilidadeService")
public class RecHabilidadeService {

    @Autowired
    private RecHabilidadeDAO habilidadeDao;

    @Transactional
    public void Inserir(RecHabilidade habilidade) {
        habilidadeDao.save(habilidade);
    }

    @Transactional
    public void Alterar(RecHabilidade habilidade) {
        habilidadeDao.save(habilidade);
    }

    @Transactional
    public void Excluir(int id) {
        habilidadeDao.delete(id);
    }

    public RecHabilidade BuscarId(int id) {
        return habilidadeDao.findById(id);
    }

    public List<RecHabilidade> ListarTodas() {
        return habilidadeDao.findAll();
    }
}
