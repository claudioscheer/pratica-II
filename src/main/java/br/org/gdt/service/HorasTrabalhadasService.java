package br.org.gdt.service;

import br.org.gdt.dao.HorasTrabalhadasDAO;
import br.org.gdt.model.HorasTrabalhadas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("horasTrabalhadasService")
public class HorasTrabalhadasService {

    @Autowired
    private HorasTrabalhadasDAO horasTrabalhadasDAO;

    @Transactional
    public void save(HorasTrabalhadas horasTrabalhadas) {
        System.out.println(horasTrabalhadas.toString());
        horasTrabalhadasDAO.save(horasTrabalhadas);
    }

    @Transactional
    public void update(HorasTrabalhadas horasTrabalhadas) {
        horasTrabalhadasDAO.update(horasTrabalhadas);
    }

    @Transactional
    public void delete(long id) {
        horasTrabalhadasDAO.delete(id);
    }

    public HorasTrabalhadas findById(long id) {
        return horasTrabalhadasDAO.findById(id);
    }

    public List<HorasTrabalhadas> findAll() {
        return horasTrabalhadasDAO.findAll();
    }
}
