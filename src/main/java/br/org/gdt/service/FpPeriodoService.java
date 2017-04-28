package br.org.gdt.service;

import br.org.gdt.dao.FpPeriodoDAO;
import br.org.gdt.model.FpPeriodo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpPeriodoService")
public class FpPeriodoService {

    @Autowired
    private FpPeriodoDAO fpPeriodoDAO;

    @Transactional
    public void save(FpPeriodo fpPeriodo) {
        fpPeriodoDAO.save(fpPeriodo);
    }

    @Transactional
    public void update(FpPeriodo fpPeriodo) {
        fpPeriodoDAO.update(fpPeriodo);
    }

    @Transactional
    public void delete(long id) {
        fpPeriodoDAO.delete(id);
    }

    public FpPeriodo findById(long id) {
        return fpPeriodoDAO.findById(id);
    }

    public List<FpPeriodo> findAll() {
        return fpPeriodoDAO.findAll();
    }

    public FpPeriodo getPeriodoAtivo() {
        return fpPeriodoDAO.getPeriodoAtivo();
    }

    public boolean temPeriodoAtivo() {
        return fpPeriodoDAO.getPeriodoAtivo() != null;
    }
}
