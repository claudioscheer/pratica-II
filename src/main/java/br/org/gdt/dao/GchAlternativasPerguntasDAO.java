package br.org.gdt.dao;


import br.org.gdt.model.GchAlternativasperguntas;
import org.springframework.stereotype.Repository;


@Repository("gchAlternativasPerguntasDAO")
public class GchAlternativasPerguntasDAO extends DAO<GchAlternativasperguntas> {

    public GchAlternativasPerguntasDAO() {
        classe = GchAlternativasperguntas.class;
        System.out.println("Classe: " + classe.getName());
    }

    
}
