/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffPessoaBeneficio;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juliano
 */
 @Repository("csbffPessoaBeneficioDAO")
public class CsbffPessoaBeneficioDAO extends DAO<CsbffPessoaBeneficio>{
    
      
    public CsbffPessoaBeneficioDAO() {
        classe = CsbffPessoaBeneficio.class;
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CsbffPessoaBeneficio> findAll(long pessoaBeneficioCodigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
