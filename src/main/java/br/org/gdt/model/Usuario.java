package br.org.gdt.model;

import br.org.gdt.enums.FpTipoEvento;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long id;
    private String login;
    private String senha;
    private List<UsuarioPapel> usuarioPapeis;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return usuarioPapeis;
    }

    public void setUsuarioPapeis(List<UsuarioPapel> usuarioPapeis) {
        this.usuarioPapeis = usuarioPapeis;
    }

}
