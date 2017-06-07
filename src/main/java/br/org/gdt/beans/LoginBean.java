package br.org.gdt.beans;

import br.org.gdt.model.Login;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class LoginBean {

    private Login login = new Login();

    public LoginBean() {
    }

//    public void entrar() {
//        try {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.getExternalContext().redirect("index.xhtml");
//        } catch (Exception e) {
//        }
//    }
//
//    public void sair() {
//        try {
//            FacesContext context = FacesContext.getCurrentInstance();
//            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
//            request.getSession().invalidate();
//            context.getExternalContext().redirect("login.xhtml");
//        } catch (Exception e) {
//        }
//    }
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
