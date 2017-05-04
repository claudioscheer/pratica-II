/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.CsbffDependenteDao;
import br.org.gdt.model.CsbffDependentes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARCOS FELIPE
 */
@Service("csbffDependentesService")
public class CsbffDependentesService {
    
    
    
    


    @Autowired
    private CsbffDependenteDao csbffdependenteDAO;

    @Transactional
    public void save(CsbffDependentes dependente) {
        csbffdependenteDAO.save(dependente);
    }

    @Transactional
    public void update(CsbffDependentes dependente) {
        csbffdependenteDAO.update(dependente);
    }

    @Transactional
    public void delete(long id) {
        csbffdependenteDAO.delete(id);
    }

    public CsbffDependentes findById(long id) {
        return csbffdependenteDAO.findById(id);
    }

    public List<CsbffDependentes> findAll() {
        return csbffdependenteDAO.findAll();
    }
    
}
