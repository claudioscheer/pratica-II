package br.org.gdt.dao;

import br.org.gdt.model.RecExperiencia;
import org.springframework.stereotype.Repository;

@Repository("recExperienciaDAO")
public class RecExperienciaDAO extends DAO<RecExperiencia> {

    public RecExperienciaDAO() {
        classe = RecExperiencia.class;
    }

}
