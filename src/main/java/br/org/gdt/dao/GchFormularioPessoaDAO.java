package br.org.gdt.dao;

import br.org.gdt.model.GchFormularioPessoa;
import org.springframework.stereotype.Repository;


@Repository("gchFormularioPessoaDAO")
public class GchFormularioPessoaDAO extends DAO<GchFormularioPessoa> {

    public GchFormularioPessoaDAO() {
        classe = GchFormularioPessoa.class;
        System.out.println("Classe: " + classe.getName());
    }

    
}
