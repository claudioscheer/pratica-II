package br.org.gdt.dao;

import br.org.gdt.model.RecPessoa;
import org.springframework.stereotype.Repository;

@Repository("recPessoaDAO")
public class RecPessoaDAO extends DAO<RecPessoa> {

    public RecPessoaDAO() {
        classe = RecPessoa.class;
    }
}
