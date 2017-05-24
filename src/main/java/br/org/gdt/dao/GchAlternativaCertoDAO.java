package br.org.gdt.dao;

import br.org.gdt.model.GchAlternativas;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository("gchAlternativaCertoDAO")
public class GchAlternativaCertoDAO extends DAO<GchAlternativas> {

    public GchAlternativaCertoDAO() {
        classe = GchAlternativas.class;
        System.out.println("Classe: " + classe.getName());
    }

    
//    public List<GchAlternativas> findByPergunta(){
//    
//          Query query = entityManager.createQuery("from GchAlternativas as t where t.ufCodigo.ufCodigo = :codigo");
//        query.setParameter("codigo", ufcodigo);
//        
//        
//    }
    
}
