package br.org.gdt.dao;

import br.org.gdt.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository("usuarioDAO")
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() {
        classe = Usuario.class;
    }

}
