package br.org.gdt.service;

import br.org.gdt.dao.PeriodoDAO;
import br.org.gdt.model.Periodo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("periodoService")
public class PeriodoService {

    @Autowired
    private PeriodoDAO periodoDAO;

    @Transactional
    public void save(Periodo periodo) {
        System.out.println(periodo.toString());
        periodoDAO.save(periodo);
    }

    @Transactional
    public void update(Periodo periodo) {
        periodoDAO.update(periodo);
    }

    @Transactional
    public void delete(long id) {
        periodoDAO.delete(id);
    }

    public Periodo findById(long id) {
        return periodoDAO.findById(id);
    }

    public List<Periodo> findAll() {
        return periodoDAO.findAll();
    }
}