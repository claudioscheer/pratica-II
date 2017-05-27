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
    
}
