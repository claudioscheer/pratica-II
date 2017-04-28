package br.org.gdt.beans;

import br.org.gdt.model.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean {

    private Login login;

    public LoginBean() {
        login = new Login();
    }

    public void entrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
