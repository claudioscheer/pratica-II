package br.org.gdt.dao;

import br.org.gdt.model.RecSelecao;
import org.springframework.stereotype.Repository;

@Repository("recSelecaoDAO")
public class RecSelecaoDAO extends DAO<RecSelecao> {

    public RecSelecaoDAO() {
        classe = RecSelecao.class;
    }
}
