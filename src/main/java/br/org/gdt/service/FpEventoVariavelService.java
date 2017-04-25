package br.org.gdt.service;

import br.org.gdt.dao.FpEventoVariavelDAO;
import br.org.gdt.model.FpEventoVariavel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpEventoVariavelService")
public class FpEventoVariavelService {

    @Autowired
    private FpEventoVariavelDAO fpEventoVariavelDAO;

    @Transactional
    public void save(FpEventoVariavel fpEventoVariavel) {
        fpEventoVariavelDAO.save(fpEventoVariavel);
    }

    @Transactional
    public void update(FpEventoVariavel fpEventoVariavel) {
        fpEventoVariavelDAO.update(fpEventoVariavel);
    }

    @Transactional
    public void delete(long id) {
        fpEventoVariavelDAO.delete(id);
    }

    public FpEventoVariavel findById(long id) {
        return fpEventoVariavelDAO.findById(id);
    }

    public List<FpEventoVariavel> findAll() {
        return fpEventoVariavelDAO.findAll();
    }
}
