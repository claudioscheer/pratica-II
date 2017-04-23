package br.org.gdt.service;

import br.org.gdt.dao.RecGrauEnsinoDAO;
import br.org.gdt.model.RecGrauensino;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RecGrauEnsinoService {

    @Autowired
    private RecGrauEnsinoDAO grauEnsinoDao;
    @Transactional
    public void Inserir(RecGrauensino grau) {
        grauEnsinoDao.save(grau);
    }    
    @Transactional
    public void Alterar(RecGrauensino grau) {
        grauEnsinoDao.save(grau);
    }    
    @Transactional
    public void Excluir(int id) {
        grauEnsinoDao.delete(id);
    }
    @Transactional
    public RecGrauensino BuscarId(int id){
        return grauEnsinoDao.findById(id);
    }
    @Transactional
    public List<RecGrauensino> ListarTodas() {
        return grauEnsinoDao.findAll();
    }
}
