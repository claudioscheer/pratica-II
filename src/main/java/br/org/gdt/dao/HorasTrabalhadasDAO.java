package br.org.gdt.dao;

import br.org.gdt.model.HorasTrabalhadas;
import org.springframework.stereotype.Repository;

@Repository("horasTrabalhadasDAO")
public class HorasTrabalhadasDAO extends DAO<HorasTrabalhadas> {

    public HorasTrabalhadasDAO() {
        classe = HorasTrabalhadas.class;
    }
}
