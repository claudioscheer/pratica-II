package br.org.gdt.service;

import br.org.gdt.dao.CsbffBeneficioDAO;
import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("csbffBeneficiosService")
public class CsbffBeneficiosService {

    @Autowired
    private CsbffBeneficioDAO csbffBeneficioDAO;

    @Transactional
    public void save(CsbffBeneficios csbffBeneficios) {
        csbffBeneficioDAO.save(csbffBeneficios);
    }

    @Transactional
    public void update(CsbffBeneficios csbffBeneficios) {
        csbffBeneficioDAO.update(csbffBeneficios);
    }

    @Transactional
    public void delete(long id) {
        csbffBeneficioDAO.delete(id);
    }

    public CsbffBeneficioDAO getCsbffBeneficioDAO() {
        return csbffBeneficioDAO;
    }

    public void setCsbffBeneficioDAO(CsbffBeneficioDAO csbffBeneficioDAO) {
        this.csbffBeneficioDAO = csbffBeneficioDAO;
    }

    public CsbffBeneficios findById(long id) {
        return csbffBeneficioDAO.findById(id);
    }

    public List<CsbffBeneficios> findAll() {
        return csbffBeneficioDAO.findAll();
    }
    
    public List<CsbffBeneficios> TodosBeneficiosPessoa(RecPessoa pessoa){
        
        return csbffBeneficioDAO.buscaBeneficiosPessoa(pessoa);
        
    }
    
    
    
}
