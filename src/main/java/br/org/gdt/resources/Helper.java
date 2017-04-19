package br.org.gdt.resources;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;

public class Helper {

    // tipos possíveis: success, info, error
    public static void mostrarNotificacao(String titulo, String mensagem, String tipo) {
        executarScript(String.format("showNotification('%s', '%s', '%s');", titulo, mensagem, tipo));
    }

    public static void executarScript(String script) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        if (ctx.getPartialViewContext().isAjaxRequest()) {
            try {
                extContext.setResponseContentType("text/xml");
                extContext.addResponseHeader("Cache - Control ", "no - cache");
                PartialResponseWriter writer = ctx.getPartialViewContext().getPartialResponseWriter();
                writer.startDocument();
                writer.startEval();
                writer.write(script);
                writer.endEval();
                writer.endDocument();
                writer.flush();
                ctx.responseComplete();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
