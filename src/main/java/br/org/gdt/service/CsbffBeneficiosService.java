package br.org.gdt.service;

import br.org.gdt.dao.CsbffBeneficioDAO;
import br.org.gdt.model.CsbffBeneficios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("csbffBeneficiosService")
public class CsbffBeneficiosService {

    public CsbffBeneficioDAO getCsbffBeneficioDAO() {
        return csbffBeneficioDAO;
    }

    public void setCsbffBeneficioDAO(CsbffBeneficioDAO csbffBeneficioDAO) {
        this.csbffBeneficioDAO = csbffBeneficioDAO;
    }

    @Autowired
    private CsbffBeneficioDAO csbffBeneficioDAO;

    @Transactional(readOnly = false)
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

    public CsbffBeneficios findById(long id) {
        return csbffBeneficioDAO.findById(id);
    }

    public List<CsbffBeneficios> findAll() {
        return csbffBeneficioDAO.findAll();
    }
}
