/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffCargos;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARCOS FELIPE
 */
@Repository("csbffCargos")
public class CsbffCargosDAO extends DAO<CsbffCargos>{


    public CsbffCargosDAO() {
        classe = CsbffCargos.class;
    }

}
