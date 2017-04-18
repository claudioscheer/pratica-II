package br.org.gdt.dao;

import br.org.gdt.modelOld.FpHorasTrabalhadas;
import org.springframework.stereotype.Repository;

@Repository("fpHorasTrabalhadasDAO")
public class FpHorasTrabalhadasDAO extends DAO<FpHorasTrabalhadas> {

    public FpHorasTrabalhadasDAO() {
        classe = FpHorasTrabalhadas.class;
    }
}
