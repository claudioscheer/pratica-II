package br.org.gdt.dao;

import br.org.gdt.model.FpTipoFolha;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Larissa Guder <lariguder10@gmail.com>
 */
@Repository("fpTipoFolhaDAO")
public class FpTipoFolhaDAO extends DAO<FpTipoFolha> {

    public FpTipoFolhaDAO() {
        classe = FpTipoFolha.class;
    }

}
