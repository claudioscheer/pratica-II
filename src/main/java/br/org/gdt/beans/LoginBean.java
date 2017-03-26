package br.org.gdt.beans;

import br.org.gdt.model.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginBean {

    private Login login;

    public LoginBean() {
        login = new Login();
    }

    public void entrar() {
        System.out.println("entrouu");
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
