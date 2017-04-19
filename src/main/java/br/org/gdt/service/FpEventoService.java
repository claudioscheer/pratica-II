package br.org.gdt.service;

import br.org.gdt.dao.FpEventoDAO;
import br.org.gdt.modelOld.FpEvento_old;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpEventoService")
public class FpEventoService {

    @Autowired
    private FpEventoDAO fpEventoDAO;

    @Transactional
    public void save(FpEvento_old fpEvento) {
        fpEventoDAO.save(fpEvento);
    }

    @Transactional
    public void update(FpEvento_old fpEvento) {
        fpEventoDAO.update(fpEvento);
    }

    @Transactional
    public void delete(long id) {
        fpEventoDAO.delete(id);
    }

    public FpEvento_old findById(long id) {
        return fpEventoDAO.findById(id);
    }

    public List<FpEvento_old> findAll() {
        return fpEventoDAO.findAll();
    }
}
