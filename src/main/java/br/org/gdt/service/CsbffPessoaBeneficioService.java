/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.CsbffPessoaBeneficioDAO;
import br.org.gdt.model.CsbffPessoaBeneficio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Juliano
 */
@Service("csbffPessoaBeneficioService")
public class CsbffPessoaBeneficioService {

    @Autowired
    private CsbffPessoaBeneficioDAO csbffPessoaBeneficioDAO;

    @Transactional
    public void save(CsbffPessoaBeneficio csbffPessoaBeneficio) {
        csbffPessoaBeneficioDAO.save(csbffPessoaBeneficio);
    }

    @Transactional
    public void update(CsbffPessoaBeneficio csbffPessoaBeneficio) {
        csbffPessoaBeneficioDAO.update(csbffPessoaBeneficio);
    }

    @Transactional
    public void delete(long id) {
        csbffPessoaBeneficioDAO.delete(id);
    }

    public CsbffPessoaBeneficio findById(long id) {
        return csbffPessoaBeneficioDAO.findById(id);
    }

    public List<CsbffPessoaBeneficio> findAll() {
        return csbffPessoaBeneficioDAO.findAll();
    }

  
}
