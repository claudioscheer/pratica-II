/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchMunicipios;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */

@Repository("gchMunicipiosDAO")
public class GchMunicipiosDAO extends DAO<GchMunicipios>{

    public GchMunicipiosDAO() {
        classe = GchMunicipios.class;        
    }
    
    
    
}
