package br.org.gdt.modelOld;

public class Login implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private String emailUsuario;
    private String senhaUsuario;

    public Login() {
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

}
