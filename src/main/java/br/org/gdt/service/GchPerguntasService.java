/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchPerguntasDAO;
import br.org.gdt.model.GchPerguntas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchPerguntaService")
public class GchPerguntasService {
   @Autowired
    private GchPerguntasDAO gchPerguntasDAO;

    @Transactional
    public void save(GchPerguntas gchPerguntas) {
        gchPerguntasDAO.save(gchPerguntas);
    }

    @Transactional
    public void update(GchPerguntas gchPerguntas) {
        gchPerguntasDAO.update(gchPerguntas);
    }

    @Transactional
    public void delete(long id) {
        gchPerguntasDAO.delete(id);
    }

    public GchPerguntas findById(long id) {
        return gchPerguntasDAO.findById(id);
    }

    public List<GchPerguntas> findAll() {
        return gchPerguntasDAO.findAll();
    }
    
    public boolean ExcluirPerguntasFormulario(int id){
        
        return gchPerguntasDAO.ExcluirPerguntasFormulario(id);
        
        
    }
  
}
