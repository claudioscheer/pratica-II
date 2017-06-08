package br.org.gdt.beans;

import br.org.gdt.model.Usuario;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    private boolean formAtivo = false;

    private Usuario usuario = new Usuario();
    private List<Usuario> todosUsuarios;
    private boolean admin;
    private boolean folha;
    private boolean capital;
    private boolean recrutamento;
    private boolean ficha;

    @ManagedProperty("#{usuarioService}")
    private UsuarioService usuarioService;

    public void save() {
        verificarAcessos();
        if (usuario.getId() > 0) {
            if (usuario.getSenha().isEmpty()) {
                Usuario usuarioSelecionado = usuarioService.findById(usuario.getId());
                if (usuarioSelecionado != null) {
                    usuario.setSenha(usuarioSelecionado.getSenha());
                }
            }
            usuarioService.update(usuario);
        } else {
            try {
                usuarioService.save(usuario);
            } catch (Exception e) {
                Helper.mostrarNotificacao("Usuário", "Já existe um usuário com este nome.", "error");
                return;
            }
        }
        todosUsuarios = usuarioService.findAll();
        this.formAtivo = false;
    }

    public void verificarAcessos() {
        usuario.getUsuarioPapeis().clear();
        if (admin) {
            usuario.addPapel("ADMIN");
        }
        if (folha) {
            usuario.addPapel("FOLHA");
        }
        if (capital) {
            usuario.addPapel("CAPITAL");
        }
        if (recrutamento) {
            usuario.addPapel("RECRUTAMENTO");
        }
        if (ficha) {
            usuario.addPapel("FICHA");
        }
    }

    public void cancel() {
        this.formAtivo = false;
        this.usuario = new Usuario();
    }

    public void add() {
        this.formAtivo = true;
        admin = false;
        folha = false;
        capital = false;
        recrutamento = false;
        ficha = false;
        this.usuario = new Usuario();
    }

    public void excluir(Usuario usuario) {
        usuarioService.delete(usuario.getId());
        todosUsuarios.remove(usuario);
        Helper.mostrarNotificacao("Usuário", "Usuário excluído.", "success");
    }

    public void prepareEdit(Usuario usuario) {
        this.formAtivo = true;
        this.usuario = usuario;
        admin = usuario.getAcessos().contains("ADMIN");
        folha = usuario.getAcessos().contains("FOLHA");
        capital = usuario.getAcessos().contains("CAPITAL");
        recrutamento = usuario.getAcessos().contains("RECRUTAMENTO");
        ficha = usuario.getAcessos().contains("FICHA");
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getTodosUsuarios() {
        if (todosUsuarios == null) {
            todosUsuarios = usuarioService.findAll();
        }
        return todosUsuarios;
    }

    public void setTodosUsuarios(List<Usuario> todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public boolean isRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(boolean recrutamento) {
        this.recrutamento = recrutamento;
    }

    public boolean isFicha() {
        return ficha;
    }

    public void setFicha(boolean ficha) {
        this.ficha = ficha;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
