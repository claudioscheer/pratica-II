package br.org.gdt.dao;

import br.org.gdt.model.FpEventoVariavel;
import org.springframework.stereotype.Repository;

@Repository("fpEventoVariavelDAO")
public class FpEventoVariavelDAO extends DAO<FpEventoVariavel> {

    public FpEventoVariavelDAO() {
        classe = FpEventoVariavel.class;
    }

}
