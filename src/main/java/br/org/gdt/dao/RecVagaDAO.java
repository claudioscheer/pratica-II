package br.org.gdt.dao;

import br.org.gdt.model.RecVaga;
import org.springframework.stereotype.Repository;

@Repository("recVagaDAO")
public class RecVagaDAO extends DAO<RecVaga> {

    public RecVagaDAO () {
        classe = RecVaga.class;
    }
}
