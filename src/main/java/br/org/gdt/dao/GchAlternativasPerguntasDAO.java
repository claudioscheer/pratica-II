package br.org.gdt.dao;


import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository("gchAlternativasPerguntasDAO")
public class GchAlternativasPerguntasDAO extends DAO<GchAlternativasperguntas> {

    public GchAlternativasPerguntasDAO() {
        classe = GchAlternativasperguntas.class;
        System.out.println("Classe: " + classe.getName());
    }

    
    public List<GchAlternativas> buscaAlternativasPerguntas(long codigo){
    
        
       Query query = entityManager.createQuery("from GchAlternativasperguntas as s where s.altPerCodigo.");
       query.setParameter("codigo", codigo);
       
       return query.getResultList();
       
       
        
    }
    
}
