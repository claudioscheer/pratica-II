/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchTreinamentospessoas;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */
@Repository("gchTreinamentoPessoasDAO")
public class GchTreinamentoPessoasDAO  extends DAO<GchTreinamentospessoas>{

    public GchTreinamentoPessoasDAO() {
        classe = GchTreinamentospessoas.class;
    }
    
    public List<GchTreinamentospessoas> verificaPessoa(long idTreinamento, long idPessoa){
        
        Query query = entityManager.createQuery("from GchTreinamentospessoas as t where t.recIdpessoa.recIdpessoa = :idPessoa");
        query.setParameter("idPessoa", idPessoa);
        
        
        List<GchTreinamentospessoas> lista = query.getResultList();
        
        return lista;
        
    }
    
    
    public List<GchTreinamentospessoas> verificaPessoasVinculadoTreinamento(long idTreinamento, long idPessoa){
        
        Query query = entityManager.createQuery("from GchTreinamentospessoas as t where t.treiCodigo.treiCodigo = :idTreinamento and t.recIdpessoa.recIdpessoa = :idPessoa");
        query.setParameter("idTreinamento", idTreinamento);
        query.setParameter("idPessoa", idPessoa);
        System.out.println("QUERY: " + query.toString());
        return query.getResultList();
        
    }
    
}
