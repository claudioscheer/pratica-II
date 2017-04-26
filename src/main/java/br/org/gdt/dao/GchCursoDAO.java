package br.org.gdt.dao;

import br.org.gdt.model.GchCursos;
import org.springframework.stereotype.Repository;


@Repository("gchCursoDAO")
public class GchCursoDAO extends DAO<GchCursos> {

    public GchCursoDAO() {
        classe = GchCursos.class;
    }

    
}
