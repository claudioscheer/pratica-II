/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;


import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.RecPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juliano
 */
@Repository("csbffBeneficioDAO")
public class CsbffBeneficioDAO extends DAO<CsbffBeneficios>{
    public CsbffBeneficioDAO() {
        classe = CsbffBeneficios.class;
    }

    public List<CsbffBeneficios> findAll(long nomeBeneficio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CsbffBeneficios> buscaBeneficiosPessoa(RecPessoa pessoa){
        
        Query query = entityManager.createQuery("from CsbffBeneficios as t where t.recIdpessoa.recIdpessoa = :idPessoa");
        query.setParameter("idPessoa", pessoa.getRecIdpessoa());
        
        List<CsbffBeneficios> lista = query.getResultList();
        
        if(lista.isEmpty()){  
            return new ArrayList<>();   
        }
        
        return lista;

    }
    
}
