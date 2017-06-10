package br.org.gdt.dao;

import br.org.gdt.model.GchFormularioPessoa;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository("gchFormularioPessoaDAO")
public class GchFormularioPessoaDAO extends DAO<GchFormularioPessoa> {

    public GchFormularioPessoaDAO() {
        classe = GchFormularioPessoa.class;
        System.out.println("Classe: " + classe.getName());
    }

    
    public int retornaPkFormularioPessoa(long idpessoa, long idformulario){
        
       Query query = entityManager.createQuery("from GchFormularioPessoa as s where s.recIdpessoa.recIdpessoa = :codigopess and s.formulario.formCodigo = :codigoform");
       query.setParameter("codigopess", idpessoa);
       query.setParameter("codigoform", idformulario);
       
       
       GchFormularioPessoa fp = new GchFormularioPessoa();
       
       fp = (GchFormularioPessoa) query.getSingleResult();
       
       return fp.getFormPesCodigo();
    }
    
    public boolean VerificaSeJaRespondeu(long idpessoa, long idformulario){
        
        Query query = entityManager.createQuery("from GchFormularioPessoa as s where s.recIdpessoa.recIdpessoa = :codigopess and s.formulario.formCodigo = :codigoform");
        query.setParameter("codigopess", idpessoa);
        query.setParameter("codigoform", idformulario);
       
       
       GchFormularioPessoa fp = new GchFormularioPessoa();
       
       fp = (GchFormularioPessoa) query.getSingleResult();
       
       return fp.isFormRespondido();
        
        
    }
    
    
}
