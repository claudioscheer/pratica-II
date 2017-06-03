/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffPessoaDependente;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARCOS FELIPE
 */
@Repository("csbffPessoaDependenteDAO")
public class CsbffPessoaDependenteDAO extends DAO<CsbffPessoaDependente>{
  
   


    public CsbffPessoaDependenteDAO() {
        classe = CsbffPessoaDependente.class;
    }
    
    
    public List<CsbffPessoaDependenteDAO> findByNome( String nome){
        Query query = entityManager.createQuery("from CsbffCargos where t.cargoNome like '%:nome%'");
        query.setParameter("nome", nome);
        
           return query.getResultList();
    }

    public List<CsbffPessoaDependenteDAO> findByPessoaDependente(long id) {

        Query query = entityManager.createQuery("from CsbffCargos as t where t.cargoCbo = :codigo" );
        query.setParameter("codigo", id);

        return query.getResultList();

    }

}


