package br.org.gdt.dao;


import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository("gchAlternativasPerguntasDAO")
public class GchAlternativasPerguntasDAO extends DAO<GchAlternativasperguntas> {

    public GchAlternativasPerguntasDAO() {
        classe = GchAlternativasperguntas.class;
        System.out.println("Classe: " + classe.getName());
    }

    
    public List<GchAlternativas> buscaAlternativasPerguntas(){
    
        
       entityManager.createQuery("from GchAlternativasperguntas as s where s.altPerCodigo.");
//       return entityManager[].
        
    }
    
}
