package br.org.gdt.beans;

import br.org.gdt.resources.Helper;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@ViewScoped
public class LoginBean {

    private String login;
    private String senha;

    public LoginBean() {
    }

    public String entrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(login, senha);
            return "/index.xhtml";
        } catch (ServletException e) {
            Helper.mostrarNotificacao("Login", "Usuário ou senha incorretos.", "error");
        }
        return "/login.xhtml";
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

}
