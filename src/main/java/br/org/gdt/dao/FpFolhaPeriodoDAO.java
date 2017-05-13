package br.org.gdt.dao;

import br.org.gdt.model.FpFolhaPeriodo;
import org.springframework.stereotype.Repository;

@Repository("fpFolhaPeriodoDAO")
public class FpFolhaPeriodoDAO extends DAO<FpFolhaPeriodo> {

    public FpFolhaPeriodoDAO() {
        classe = FpFolhaPeriodo.class;
    }

}
