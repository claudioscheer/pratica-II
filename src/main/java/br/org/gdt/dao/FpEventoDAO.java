package br.org.gdt.dao;

import br.org.gdt.modelOld.FpEvento_old;
import org.springframework.stereotype.Repository;

@Repository("fpEventoDAO")
public class FpEventoDAO extends DAO<FpEvento_old> {

    public FpEventoDAO() {
        classe = FpEvento_old.class;
    }

}
