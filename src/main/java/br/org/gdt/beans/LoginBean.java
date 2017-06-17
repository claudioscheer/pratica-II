package br.org.gdt.beans;

import br.org.gdt.resources.Helper;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class LoginBean {

    private String login;
    private String senha;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        if (request.getRemoteUser() != null) {
            try {
                context.getExternalContext().redirect(request.getContextPath() + "/index.xhtml");
            } catch (IOException e) {
            }
        }
    }

    public void entrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(login, senha);
            context.getExternalContext().redirect(request.getContextPath() + "/index.xhtml");
        } catch (Exception e) {
            Helper.mostrarNotificacao("Login", "Usuário ou senha incorretos.", "error");
        }
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
