package br.org.gdt.dao;

import br.org.gdt.model.FpTipoFolha;
import org.springframework.stereotype.Repository;

@Repository("fpTipoFolhaDAO")
public class FpTipoFolhaDAO extends DAO<FpTipoFolha> {

    public FpTipoFolhaDAO() {
        classe = FpTipoFolha.class;
    }

}
