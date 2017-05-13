/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */
@Repository("inicializaDAO")
public class InicializaDAO {
    
    @PersistenceContext
    EntityManager entityManager;
    
    
    public void inicializar(String sql){
    
        Query q = entityManager.createNativeQuery(sql);
        q.executeUpdate();
     
    }
    
    
    
}
