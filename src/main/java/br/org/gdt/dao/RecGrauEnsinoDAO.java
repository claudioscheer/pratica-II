package br.org.gdt.dao;

import br.org.gdt.model.RecGrauensino;
import org.springframework.stereotype.Repository;

@Repository("recGrauEnsinoDAO")
public class RecGrauEnsinoDAO extends DAO<RecGrauensino> {
    
    public RecGrauEnsinoDAO () {
        classe = RecGrauensino.class;
    }

}
