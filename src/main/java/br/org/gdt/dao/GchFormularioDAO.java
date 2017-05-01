/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchFormulario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */
@Repository("gchFormularioDAO")
public class GchFormularioDAO  extends DAO<GchFormulario>{

    public GchFormularioDAO() {
        classe = GchFormulario.class;
    }
    
    
    
}
