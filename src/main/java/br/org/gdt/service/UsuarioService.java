package br.org.gdt.service;

import br.org.gdt.dao.UsuarioDAO;
import br.org.gdt.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Transactional
    public void update(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Transactional
    public void delete(long id) {
        usuarioDAO.delete(id);
    }

    public Usuario findById(long id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }
}
