package br.org.gdt.dao;

import br.org.gdt.model.FpPeriodo;
import org.springframework.stereotype.Repository;

@Repository("fpPeriodoDAO")
public class FpPeriodoDAO extends DAO<FpPeriodo> {

    public FpPeriodoDAO() {
        classe = FpPeriodo.class;
    }

}
