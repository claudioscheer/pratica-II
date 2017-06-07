package br.org.gdt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long id;
    private String login;
    private String senha;
    private List<UsuarioPapel> usuarioPapeis;
    private String acessos;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<UsuarioPapel> getUsuarioPapeis() {
        if (usuarioPapeis == null) {
            usuarioPapeis = new ArrayList<>();
        }
        return usuarioPapeis;
    }

    public void setUsuarioPapeis(List<UsuarioPapel> usuarioPapeis) {
        this.usuarioPapeis = usuarioPapeis;
    }

    public void addPapel(String papel) {
        UsuarioPapel novoPapel = new UsuarioPapel();
        novoPapel.setLogin(this.login);
        novoPapel.setPapel(papel);
        novoPapel.setUsuario(this);
        getUsuarioPapeis().add(novoPapel);
    }

    public String getAcessos() {
        return String.join(", ", getUsuarioPapeis().stream()
                .map(x -> x.getPapel())
                .collect(Collectors.toList()));
    }

    public void setAcessos(String acessos) {
        this.acessos = acessos;
    }

}
