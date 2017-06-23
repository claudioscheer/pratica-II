package br.org.gdt.resources;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;

public class Helper {

    public static int getIdadeDaPessoa(Date dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Calendar calendarDataNascimento = Calendar.getInstance();
        calendarDataNascimento.setTime(dataNascimento);

        LocalDate dataNascimentoLocal = LocalDate.of(calendarDataNascimento.get(Calendar.YEAR), calendarDataNascimento.get(Calendar.MONTH), calendarDataNascimento.get(Calendar.DATE));
        Period periodo = Period.between(dataNascimentoLocal, dataAtual);
        return periodo.getYears();
    }

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
    }

    public static void gerarBaixarRelatorioPDF(String nomeBaixarArquivo, String caminhoArquivoRelatorio, Map<String, Object> parametros, Collection<?> dadosRelatorio) throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();

        String caminhoCompletoArquivo = context.getExternalContext().getRealPath(caminhoArquivoRelatorio);
        File fileRelatorio = new File(caminhoCompletoArquivo);
        if (!fileRelatorio.exists()) {
            throw new Exception("O arquivo não foi encontrado.");
        }

        JasperPrint jasperPrint = JasperFillManager.fillReport(fileRelatorio.getPath(), parametros, new JRBeanCollectionDataSource(dadosRelatorio));

        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + nomeBaixarArquivo + ".pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        context.renderResponse();
        context.responseComplete();
    }

}
