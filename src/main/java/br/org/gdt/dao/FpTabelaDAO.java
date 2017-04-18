package br.org.gdt.dao;

import br.org.gdt.modelOld.FpTabela;
import org.springframework.stereotype.Repository;

@Repository("fpTabelaDAO")
public class FpTabelaDAO extends DAO<FpTabela> {

    public FpTabelaDAO() {
        classe = FpTabela.class;
    }
}
