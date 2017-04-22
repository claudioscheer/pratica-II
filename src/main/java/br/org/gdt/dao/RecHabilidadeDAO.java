package br.org.gdt.dao;

import br.org.gdt.model.RecHabilidade;
import org.springframework.stereotype.Repository;

@Repository("recHabilidadeDAO")
public class RecHabilidadeDAO extends DAO<RecHabilidade> {

    public RecHabilidadeDAO() {
        classe = RecHabilidade.class;
    }
}
