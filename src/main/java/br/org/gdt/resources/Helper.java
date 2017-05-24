package br.org.gdt.resources;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import org.primefaces.context.RequestContext;

public class Helper {

    public static void setMensagemDeErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    // tipos possíveis: success, info, error
    public static void mostrarNotificacao(String titulo, String mensagem, String tipo) {
        executarScript(String.format("showNotification('%s', '%s', '%s');", titulo, mensagem, tipo));
    }

    public static void executarScript(String script) {
        RequestContext.getCurrentInstance().execute(script);
//        FacesContext ctx = FacesContext.getCurrentInstance();
//        ExternalContext extContext = ctx.getExternalContext();
//        if (ctx.getPartialViewContext().isAjaxRequest()) {
//            try {
//                extContext.setResponseContentType("text/xml");
//                extContext.addResponseHeader("Cache - Control ", "no - cache");
//                PartialResponseWriter writer = ctx.getPartialViewContext().getPartialResponseWriter();
//                writer.startDocument();
//                writer.startEval();
//                writer.write(script);
//                writer.endEval();
//                writer.endDocument();
//                writer.flush();
//                ctx.responseComplete();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
    }

}
