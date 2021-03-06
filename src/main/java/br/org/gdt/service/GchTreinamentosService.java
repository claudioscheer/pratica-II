/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchTreinamentoDAO;
import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchTreinamentosService")
public class GchTreinamentosService {
   @Autowired
    private GchTreinamentoDAO gchTreinamentoDAO;

    @Transactional
    public void save(GchTreinamentos gchTreinamentos) {
        gchTreinamentoDAO.save(gchTreinamentos);
    }

    @Transactional
    public void update(GchTreinamentos gchTreinamentos) {
        gchTreinamentoDAO.update(gchTreinamentos);
    }

    @Transactional
    public void delete(long id) {
        gchTreinamentoDAO.delete(id);
    }

    public GchTreinamentos findById(long id) {
        return gchTreinamentoDAO.findById(id);
    }

    public List<GchTreinamentos> findAll() {
        return gchTreinamentoDAO.findAll();
    }
     
   public List<GchTreinamentos> BuscaTreinamentoPorCurso(long id){
       
       return gchTreinamentoDAO.buscaPorCurso(id);
       
   }
   
 
    
}
