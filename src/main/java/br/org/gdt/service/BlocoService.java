package br.org.gdt.service;

import br.org.gdt.dao.BlocoDAO;
import br.org.gdt.model.Bloco;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("blocoService")
public class BlocoService {

    @Autowired
    private BlocoDAO blocoDAO;

    @Transactional
    public void save(Bloco bloco) {
        blocoDAO.save(bloco);
    }

    @Transactional
    public void update(Bloco bloco) {
        blocoDAO.update(bloco);
    }

    @Transactional
    public void delete(long id) {
        blocoDAO.delete(id);
    }

    public Bloco findById(long id) {
        return blocoDAO.findById(id);
    }

    public List<Bloco> findAll() {
        return blocoDAO.findAll();
    }
}
