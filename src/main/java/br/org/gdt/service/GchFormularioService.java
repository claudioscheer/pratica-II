/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchFormularioDAO;
import br.org.gdt.model.GchFormulario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchFormularioService")
public class GchFormularioService {
   @Autowired
    private GchFormularioDAO gchFormularioDAO;

    @Transactional
    public void save(GchFormulario gchFormulario) {
        gchFormularioDAO.save(gchFormulario);
    }

    @Transactional
    public void update(GchFormulario gchFormulario) {
        gchFormularioDAO.update(gchFormulario);
    }

    @Transactional
    public void delete(long id) {
        gchFormularioDAO.delete(id);
    }

    public GchFormulario findById(long id) {
        System.out.println("Aqui aoodjoiasjdoiasjdaa");
        return gchFormularioDAO.findById(id);
    }

    public List<GchFormulario> findAll() {
        return gchFormularioDAO.findAll();
    }
  
}
