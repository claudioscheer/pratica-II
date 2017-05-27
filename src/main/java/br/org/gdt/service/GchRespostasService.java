/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchPerguntasDAO;
import br.org.gdt.dao.GchRespostasDAO;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.model.GchRespostas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchRespostaService")
public class GchRespostasService {
   @Autowired
    private GchRespostasDAO gchRespostasDAO;

    @Transactional
    public void save(GchRespostas gchRespostas) {
        gchRespostasDAO.save(gchRespostas);
    }

    @Transactional
    public void update(GchRespostas gchRespostas) {
        gchRespostasDAO.update(gchRespostas);
    }

    @Transactional
    public void delete(long id) {
        gchRespostasDAO.delete(id);
    }

    public GchRespostas findById(long id) {
        return gchRespostasDAO.findById(id);
    }

    public List<GchRespostas> findAll() {
        return gchRespostasDAO.findAll();
    }
    
    public boolean VerificaExistenciaFormulario(long id){
        
        int retorno = gchRespostasDAO.findByFormulario((int) id);
        
        
        if(retorno == 0){
            
        return false;    
            
        }else{
            
         return true;   
            
        }
        
    }
    
  
}
