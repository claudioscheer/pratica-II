/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffDependentes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARCOS FELIPE
 */
@Repository("csbffDependenteDAO")
public class CsbffDependenteDao extends DAO<CsbffDependentes>{
  
    public CsbffDependenteDao() {
        classe = CsbffDependentes.class;
    }
    
    public List<CsbffDependentes> BuscaDependentesPessoa(long idPessoa){
        
        Query query = entityManager.createQuery("from CsbffDependentes as s where s.vinculoPessoa = :codigoPessoa");
        query.setParameter("codigoPessoa", idPessoa);
       
        List<CsbffDependentes> fp = new ArrayList<>();
       
        fp = (List<CsbffDependentes>) query.getResultList();
       
       return fp;
 
        
    }
    
    
}
