
package br.org.gdt.service;

import br.org.gdt.dao.CsbffBeneficioDAO;
import br.org.gdt.model.CsbffBeneficios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("csbffBeneficiosService")
public class CsbffBeneficiosService {
    
    @Autowired
    private CsbffBeneficioDAO csbffBeneficioDAO;

    @Transactional
    public void save(CsbffBeneficios beneficio) {
        csbffBeneficioDAO.save(beneficio);
    }

    @Transactional
    public void update(CsbffBeneficios beneficio) {
        csbffBeneficioDAO.update(beneficio);
    }

    @Transactional
    public void delete(long id) {
        csbffBeneficioDAO.delete(id);
    }

    public CsbffBeneficios findById(long id) {
        return csbffBeneficioDAO.findById(id);
    }
    
    public List<CsbffBeneficios> findAll(long nomeBeneficio) {
        return csbffBeneficioDAO.findAll(nomeBeneficio);
    }
   
     public List<CsbffBeneficios> findAll() {
        return csbffBeneficioDAO.findAll();
    }
}
