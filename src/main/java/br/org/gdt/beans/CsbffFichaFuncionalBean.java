package br.org.gdt.beans;

import br.org.gdt.enums.EstadoCivil;
import static br.org.gdt.enums.LogModulo.FichaFuncional;
import br.org.gdt.enums.Sexo;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.FichaFuncional.FichaFuncional;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecPessoaService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.olap4j.impl.ArrayMap;

@ManagedBean
@RequestScoped
public class CsbffFichaFuncionalBean {

    private boolean formAtivo = false;
    private String recCpf;

    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoaList;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;
    private boolean colaboradorInativo;
    @ManagedProperty("#{fichaFuncional}")
    private FichaFuncional fichaFuncional;

    public CsbffFichaFuncionalBean() {

    }

    public void buscarCpf() {
        recPessoa = recPessoaService.findByRecCpf(recCpf);
        String MsgNotificacao = "";
        while (recPessoa == null) {
            MsgNotificacao = "A pessoa não existe.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "error");
            return;
        }
        if (recPessoa.colaboradorInativo == true) {
            MsgNotificacao = "O colaborador está inativo.";
            Helper.mostrarNotificacao("Atenção!", MsgNotificacao, "info");
        }
        if (recPessoa == null) {
            recPessoa = new RecPessoa();

        }

    }

    public List<RecPessoa> getPessoas() {
        List<RecPessoa> pessoas = recPessoaService.findAll();

        return pessoas;
    }

//    public String saveDadosPessoais() {
//        if (recPessoa.getRecIdpessoa() > 0) {
//            recPessoaService.update(recPessoa);
//        }
//        recPessoaList = recPessoaService.findAll();
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
//         return "dadosprofissionais";
//    }
//    public String cancel() {
//        this.formAtivo = false;
//        this.recPessoa = new RecPessoa();
//        return null;
//
//    }
    
    
    public void GerarRelatorio_FichaFuncional(RecPessoa pessoa) throws Exception{
        
            List<JasperPrint> relatorios = new ArrayList<>();

            FacesContext context = FacesContext.getCurrentInstance();

            String caminhoCompletoArquivo = context.getExternalContext().getRealPath("/folhapagamento/relatorio/folha_land.jasper");
            File fileRelatorio = new File(caminhoCompletoArquivo);
            if (!fileRelatorio.exists()) {
                throw new Exception("O arquivo não foi encontrado.");
            }
        
            Map<String,Object> parametros = new HashMap<>();
        
            
            parametros.put("empresa"          , "Asa Delta RH");
            parametros.put("cnpj"             , "98.039.852/0004-3");
            parametros.put("recIdpessoa"      ,pessoa.getRecIdpessoa());
            parametros.put("recCpf"           ,pessoa.getRecCpf());
            parametros.put("recNomecompleto"  ,pessoa.getRecNomecompleto());
            parametros.put("recRg"            ,pessoa.getRecRg());
            parametros.put("recDtnascimento"  ,pessoa.getRecDtnascimento());
            parametros.put("recEstadocivil"   ,pessoa.getRecEstadocivil());
            parametros.put("SEXO"             ,pessoa.getRecSexo());
            parametros.put("recOrgaoemissor"  ,pessoa.getRecOrgaoemissor());
            parametros.put("recDtemissao"     ,pessoa.getRecDtemissao());
            parametros.put("recNacionalidade" ,pessoa.getRecNacionalidade());
            parametros.put("recReservista"    ,pessoa.getRecReservista());
            parametros.put("recEscolaridade"  ,pessoa.getRecEscolaridade());

            parametros.put("recNomepai"       ,pessoa.getRecNomepai());
            parametros.put("recNomemae"       ,pessoa.getRecNomemae());
            parametros.put("recNumCtps"       ,pessoa.getRecNumCtps());
            parametros.put("recPispasep"      ,pessoa.getRecPispasep());
            parametros.put("recEndereco"      ,pessoa.getRecEndereco());
            parametros.put("recNumero"        ,pessoa.getRecNumero());
            parametros.put("recBairro"        ,pessoa.getRecBairro());
            parametros.put("recEmail"         ,pessoa.getRecEmail());
            parametros.put("recTelefone"      ,pessoa.getRecTelefone());
            parametros.put("recCelular"       ,pessoa.getRecCelular());

            parametros.put("cargonome"        ,pessoa.getCargoNome());
            parametros.put("cargoValorSalario",pessoa.getCargoValorSalario());
            parametros.put("recDtaAdmissao"   ,pessoa.getRecDtaAdmissao());
            parametros.put("recDtaDemissao"   ,pessoa.getRecDtaDemissao());
            parametros.put("insalubridade"    ,pessoa.getInsalubridade());
            parametros.put("recPericulosidade",pessoa.getRecPericulosidade());
        
             JasperPrint jasperPrint = JasperFillManager.fillReport(fileRelatorio.getPath(), parametros);
             relatorios.add(jasperPrint);
             relatorios.add(jasperPrint);
            
             //Retorna o PDFF via HTTP Response
             HTTPResponseReturnPDF(relatorios,caminhoCompletoArquivo);
                     
    }
    
    
    public void HTTPResponseReturnPDF(List<JasperPrint> relatorios, String nomeArquivo) throws IOException, JRException{
        
        FacesContext context = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + nomeArquivo + ".pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(SimpleExporterInput.getInstance(relatorios));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setCreatingBatchModeBookmarks(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            stream.flush();
        }
        context.renderResponse();
        context.responseComplete();
    
    }
    
    
    public void cancel() {
        this.formAtivo = false;
        this.recPessoa = new RecPessoa();

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("listaadmissao.xhtml");
        } catch (IOException ex) {

        }
    }
    public void imprimirFichaFuncional() {
        try {
//            List<FpFolhaPeriodo> folhasPeriodo = new ArrayList<>();
//            folhasPeriodo.add(fpFolhaPeriodo);
            fichaFuncional.gerarFichaFuncional();
        } catch (Exception e) {
            Helper.mostrarNotificacao("Erro", e.getMessage(), "error");
        }
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public String getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(String recCpf) {
        this.recCpf = recCpf;
    }

    public boolean isColaboradorInativo() {
        return colaboradorInativo;
    }

    public void setColaboradorInativo(boolean colaboradorInativo) {
        this.colaboradorInativo = colaboradorInativo;
    }

    public FichaFuncional getFichaFuncional() {
        return fichaFuncional;
    }

    public void setFichaFuncional(FichaFuncional fichaFuncional) {
        this.fichaFuncional = fichaFuncional;
    }

}
