package br.org.gdt.service;

import br.org.gdt.dao.CsbffCargosDAO;
import br.org.gdt.model.CsbffCargos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("csbffCargosService")
public class CsbffCargosService {

    @Autowired
    private CsbffCargosDAO csbffCargosDAO;

    @Transactional(readOnly = false)
    public void save(CsbffCargos cargos) {
        csbffCargosDAO.save(cargos);
    }

    @Transactional
    public void update(CsbffCargos cargos) {
        csbffCargosDAO.update(cargos);
    }
 
    @Transactional
    public void delete(long id) {
        csbffCargosDAO.delete(id);
    }

    public CsbffCargos findById(long id) {
        return csbffCargosDAO.findById(id);
    }
    public List<CsbffCargos> findByNome(String nome){
        
        return csbffCargosDAO.findByCargos(0);
    }
    
    public List<CsbffCargos> findByCargos(long cbo) {
        
        
        return csbffCargosDAO.findByCargos(cbo);
    }
    
    

    public List<CsbffCargos> findAll() {
        return csbffCargosDAO.findAll();
    }
}
