/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.resources;

import br.org.gdt.model.ParametrosEmail;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;

/**
 *
 * @author Alisson Allebrandt
 */
public class GerenciadorEmail {

    public void EnviarEmail(List<ParametrosEmail> parm) throws MessagingException, MessagingException {

        if (!parm.isEmpty()) {

            Properties props = new Properties();

            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.quitwait", "false");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.user", parm.get(0).getRemetente());
            props.put("mail.smtp.password", parm.get(0).getSenha());
            props.put("mail.debug", "true");

            for (ParametrosEmail item : parm) {

                try {

                    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(parm.get(0).getRemetente(), parm.get(0).getSenha());
                        }
                    });

                    MimeMessage message = new MimeMessage(session);

                    message.setHeader("Content-Type", "text/plain; charset=UTF-8; format=flowed");
                    message.setHeader("Content-Transfer-Encoding", "16bit");
                    message.setHeader("X-Accept-Language", "pt-br, pt");
                    message.setHeader("User-Agent", "Sistema FaleConosco");
                    message.setHeader("Organization", "E4W");
                    message.setFrom(new InternetAddress(item.getRemetente()));
                    message.setRecipients(Message.RecipientType.TO, item.getDestinatario());
                    message.setSubject(item.getAssunto());
                    message.setText(item.getMensagem(), "utf-8", "html");
                    Transport.send(message);

                } catch (Exception ex) {
                    Logger.getLogger(GerenciadorEmail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean enviarEmail(String destinatario, String assunto, String mensagem) {

        String emailResponsavel = "murphyrhnotifica@gmail.com";
        String senha = "murphy2017";

        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.quitwait", "false");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.user", emailResponsavel);
        props.put("mail.smtp.password", senha);
        props.put("mail.debug", "true");
        
        
        try {

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailResponsavel, senha);
                }
            });

            MimeMessage message = new MimeMessage(session);

            message.setHeader("Content-Type", "text/plain; charset=UTF-8; format=flowed");
            message.setHeader("Content-Transfer-Encoding", "16bit");
            message.setHeader("X-Accept-Language", "pt-br, pt");
            message.setHeader("User-Agent", "Sistema FaleConosco");
            message.setHeader("Organization", "E4W");
            message.setFrom(new InternetAddress(emailResponsavel));
            message.setRecipients(Message.RecipientType.TO, destinatario);
            message.setSubject(assunto);
            message.setText(mensagem, "utf-8", "html");
            Transport.send(message);

            return true;
            
        } catch (Exception ex) {
            System.err.println("Ocorreu erro ao enviar e-mail: " + ex.getMessage());
            return false;
        }

    }

}
