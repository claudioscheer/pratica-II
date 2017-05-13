/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffCargos;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARCOS FELIPE
 */
@Repository("csbffCargosDAO")
public class CsbffCargosDAO extends DAO<CsbffCargos>{


    public CsbffCargosDAO() {
        classe = CsbffCargos.class;
    }
    
    public List<CsbffCargos> findByCargos(long cbo){
    
        
        Query query = entityManager.createQuery("from CsbffCargos as t where t.cargoCbo = :codigo");
        query.setParameter("codigo", cbo);
        
        return query.getResultList();
             
        
    }
    

}
