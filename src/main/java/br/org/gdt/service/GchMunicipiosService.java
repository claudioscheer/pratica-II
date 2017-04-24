/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchMunicipiosDAO;
import br.org.gdt.model.GchMunicipios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */

@Service("gchMunicipiosService")
public class GchMunicipiosService {
    @Autowired
    private GchMunicipiosDAO gchMunicipiosDAO;

    @Transactional
    public void save(GchMunicipios gchTreinamentos) {
        gchMunicipiosDAO.save(gchTreinamentos);
    }

    @Transactional
    public void update(GchMunicipios gchTreinamentos) {
        gchMunicipiosDAO.update(gchTreinamentos);
    }

    @Transactional
    public void delete(long id) {
        gchMunicipiosDAO.delete(id);
    }

    public GchMunicipios findById(long id) {
        return gchMunicipiosDAO.findById(id);
    }

    public List<GchMunicipios> findAll() {
        return gchMunicipiosDAO.findAll();
    }
     
    public List<GchMunicipios> findUfCodigo(long ufCodigo) {
        return gchMunicipiosDAO.findUfCodigo(ufCodigo);
    }
    
}
