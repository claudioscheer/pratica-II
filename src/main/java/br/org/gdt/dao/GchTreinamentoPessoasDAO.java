/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    
    public List<GchTreinamentospessoas> pessoasTreinamento(long idTreinamento){
    
        TypedQuery<GchTreinamentospessoas> query = entityManager.createQuery("from GchTreinamentospessoas as t where t.treiCodigo.treiCodigo = :idTreinamento", GchTreinamentospessoas.class);
        query.setParameter("idTreinamento", idTreinamento);   
   
        return query.getResultList();
    
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
        
        return query.getResultList();
        
    }
    
    public List<GchTreinamentospessoas> treinamentosPessoa(RecPessoa pessoa){
        
     
        Query query = entityManager.createQuery("from GchTreinamentospessoas as t where t.recIdpessoa.recIdpessoa = :idPessoa");
        query.setParameter("idPessoa", pessoa.getRecIdpessoa());
        
        List<GchTreinamentospessoas> lista = query.getResultList();
        
        return lista;
   
    }
    
    
}
