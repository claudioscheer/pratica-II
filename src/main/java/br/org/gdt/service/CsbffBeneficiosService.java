/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.CsbffBeneficioDAO;
import br.org.gdt.model.CsbffBeneficios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juliano
 */
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

    public CsbffBeneficios findById(long id) {
        return csbffBeneficioDAO.findById(id);
    }

    public List<CsbffBeneficios> findAll() {
        return csbffBeneficioDAO.findAll();
    }
}
