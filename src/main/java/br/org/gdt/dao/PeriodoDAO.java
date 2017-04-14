package br.org.gdt.dao;

import br.org.gdt.model.Periodo;
import org.springframework.stereotype.Repository;

@Repository("periodoDAO")
public class PeriodoDAO extends DAO<Periodo> {

    public PeriodoDAO() {
        classe = Periodo.class;
    }

}
