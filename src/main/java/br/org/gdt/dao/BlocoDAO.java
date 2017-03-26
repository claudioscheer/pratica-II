package br.org.gdt.dao;

import br.org.gdt.model.Bloco;
import org.springframework.stereotype.Repository;

@Repository("blocoDAO")
public class BlocoDAO extends DAO <Bloco> {
    
    public BlocoDAO () {
        classe = Bloco.class;
    }
}
