package br.org.gdt.service;

import br.org.gdt.dao.FpHorasTrabalhadasDAO;
import br.org.gdt.model.FpHorasTrabalhadas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpHorasTrabalhadasService")
public class FpHorasTrabalhadasService {

    @Autowired
    private FpHorasTrabalhadasDAO fpHorasTrabalhadasDAO;

    @Transactional
    public void save(FpHorasTrabalhadas fpHorasTrabalhadas) {
        fpHorasTrabalhadasDAO.save(fpHorasTrabalhadas);
    }

    @Transactional
    public void update(FpHorasTrabalhadas fpHorasTrabalhadas) {
        fpHorasTrabalhadasDAO.update(fpHorasTrabalhadas);
    }

    @Transactional
    public void delete(long id) {
        fpHorasTrabalhadasDAO.delete(id);
    }

    public FpHorasTrabalhadas findById(long id) {
        return fpHorasTrabalhadasDAO.findById(id);
    }

    public List<FpHorasTrabalhadas> findAll() {
        return fpHorasTrabalhadasDAO.findAll();
    }
}
