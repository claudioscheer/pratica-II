/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.CsbffPessoaDependenteDAO;
import br.org.gdt.model.CsbffPessoaDependente;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARCOS FELIPE
 */
@Service("csbffPessoaDependenteService")
public class CsbffPessoaDependenteService {



    @Autowired
    private CsbffPessoaDependenteDAO csbffPessoaDependenteDAO;

    @Transactional
    public void save(CsbffPessoaDependente dependente) {
         csbffPessoaDependenteDAO.save(dependente);
    }

    @Transactional
    public void update(CsbffPessoaDependente dependente) {
        csbffPessoaDependenteDAO.update(dependente);
    }

    @Transactional
    public void delete(long id) {
        csbffPessoaDependenteDAO.delete(id);
    }

    public CsbffPessoaDependente findById(long id) {
        return csbffPessoaDependenteDAO.findById(id);
    }

    public List<CsbffPessoaDependente> findAll() {
        return csbffPessoaDependenteDAO.findAll();
    }

    public CsbffPessoaDependenteDAO getCsbffPessoaDependenteDAO() {
        return csbffPessoaDependenteDAO;
    }

    public void setCsbffPessoaDependenteDAO(CsbffPessoaDependenteDAO csbffPessoaDependenteDAO) {
        this.csbffPessoaDependenteDAO = csbffPessoaDependenteDAO;
    }
    
}
    
