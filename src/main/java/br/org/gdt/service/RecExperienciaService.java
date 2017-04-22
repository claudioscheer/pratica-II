package br.org.gdt.service;

import br.org.gdt.dao.RecExperienciaDAO;
import br.org.gdt.model.RecExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RecExperienciaService {

    @Autowired
    private RecExperienciaDAO experienciaDao;

    @Transactional
    public void Inserir(RecExperiencia exp) {
        experienciaDao.save(exp);
    }

    @Transactional
    public void Alterar(RecExperiencia exp) {
        experienciaDao.save(exp);
    }

    @Transactional
    public void Excluir(int id) {
        experienciaDao.delete(id);
    }

    @Transactional
    public RecExperiencia BuscarId(int id) {
        return experienciaDao.findById(id);
    }

    @Transactional
    public List<RecExperiencia> ListarTodas() {
        return experienciaDao.findAll();
    }
}
