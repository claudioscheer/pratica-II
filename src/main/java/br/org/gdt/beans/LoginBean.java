package br.org.gdt.beans;

import br.org.gdt.modelOld.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginBean {

    private Login login;

    public LoginBean() {
        login = new Login();
    }

    public void entrar() {
        System.out.println(String.format("LOGIN - Email = %s, Senha = %s", login.getEmailUsuario(), login.getSenhaUsuario()));
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
