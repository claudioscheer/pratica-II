/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

/**
 *
 * @author Alisson Allebrandt
 */
public class ParametrosEmail {
    
    private String remetente;
    private String senha;
    private String destinatario;
    private String assunto;
    private String mensagem;
    private GchFormularioPessoa formularioPessoa;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public GchFormularioPessoa getFormularioPessoa() {
        return formularioPessoa;
    }

    public void setFormularioPessoa(GchFormularioPessoa formularioPessoa) {
        this.formularioPessoa = formularioPessoa;
    }
 
    
}
