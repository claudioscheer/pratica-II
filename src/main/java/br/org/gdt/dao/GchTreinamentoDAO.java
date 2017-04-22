/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchTreinamentos;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */
@Repository("gchTreinamentoDAO")
public class GchTreinamentoDAO extends DAO<GchTreinamentos> {

    public GchTreinamentoDAO() {
    
        classe = GchTreinamentos.class;
        
    }
    
    
    
}
