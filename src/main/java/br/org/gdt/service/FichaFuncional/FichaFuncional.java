/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service.FichaFuncional;

import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.CsbffEscalaHoras;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.CsbffBeneficiosService;
import br.org.gdt.service.CsbffEscalaHorasService;
import br.org.gdt.service.GchTreinamentoPessoaService;
import br.org.gdt.service.GchTreinamentosService;
import br.org.gdt.service.RecPessoaService;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juliano
 */
@Service("fichaFuncional")
public class FichaFuncional {

    private final DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @Autowired
    private RecPessoaService recPessoaService;

    @Autowired
    private CsbffBeneficiosService csbffBeneficiosService;

    @Autowired
    private CsbffEscalaHorasService csbffEscalaHorasService;

    @Autowired
    private GchTreinamentosService gchTreinamentosService;

    @Autowired
    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public CsbffEscalaHorasService getCsbffEscalaHorasService() {
        return csbffEscalaHorasService;
    }

    public GchTreinamentosService getGchTreinamentosService() {
        return gchTreinamentosService;
    }

    public void setGchTreinamentosService(GchTreinamentosService gchTreinamentosService) {
        this.gchTreinamentosService = gchTreinamentosService;
    }

    public GchTreinamentoPessoaService getGchTreinamentospessoasService() {
        return gchTreinamentospessoasService;
    }

    public void setGchTreinamentospessoasService(GchTreinamentoPessoaService gchTreinamentospessoasService) {
        this.gchTreinamentospessoasService = gchTreinamentospessoasService;
    }

    public void setCsbffEscalaHorasService(CsbffEscalaHorasService csbffEscalaHorasService) {
        this.csbffEscalaHorasService = csbffEscalaHorasService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public CsbffBeneficiosService getCsbffBeneficiosService() {
        return csbffBeneficiosService;
    }

    public void setCsbffBeneficiosService(CsbffBeneficiosService csbffBeneficiosService) {
        this.csbffBeneficiosService = csbffBeneficiosService;
    }

    public void gerarFichaFuncional(RecPessoa pessoa) throws Exception {

        List<JasperPrint> relatorios = new ArrayList<>();

        FacesContext context = FacesContext.getCurrentInstance();

        String caminhoCompletoArquivo = context.getExternalContext().getRealPath("/c_s_b_f_f/report/ReportFichaFuncional.jasper");

        File fileRelatorio = new File(caminhoCompletoArquivo);

        if (!fileRelatorio.exists()) {
            throw new Exception("O arquivo não foi encontrado.");
        }

        HashMap parametros = new HashMap();
        parametros.put("empresa", "Asa Delta");
        parametros.put("cnpj", "98.039.852/0004-33");
        parametros.put("recIdpessoa", pessoa.getRecIdpessoa());
        parametros.put("recCpf", pessoa.getRecCpf());
        parametros.put("recNomecompleto", pessoa.getRecNomecompleto());
        parametros.put("recRg", pessoa.getRecRg());
        parametros.put("recDtnascimento", new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getRecDtnascimento()));
        parametros.put("recEstadocivil", pessoa.getRecEstadocivil());
        parametros.put("recSexo", pessoa.getRecSexo());
        parametros.put("recOrgaoemissor", pessoa.getRecOrgaoemissor());
        parametros.put("recDtemissao", new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getRecDtemissao()));
        parametros.put("recCor", pessoa.getRecCor());
        parametros.put("recReservista", pessoa.getRecReservista());
        parametros.put("recPesGrauEnsino", pessoa.getRecPesGrauEnsino());

        parametros.put("recNomepai", pessoa.getRecNomepai());
        parametros.put("recNomemae", pessoa.getRecNomemae());
        parametros.put("recNumCtps", pessoa.getRecNumCtps());
        parametros.put("recPispasep", pessoa.getRecPispasep());
        parametros.put("recEndereco", pessoa.getRecEndereco());
        parametros.put("recNumero", pessoa.getRecNumero());
        parametros.put("recBairro", pessoa.getRecBairro());
        parametros.put("recEmail", pessoa.getRecEmail());
        parametros.put("recTelefone", pessoa.getRecTelefone());
        parametros.put("recCelular", pessoa.getRecCelular());

        parametros.put("cargoCodigo", pessoa.getCargoCodigo().getCargoNome());
        parametros.put("cargoValorSalario", pessoa.getCargoValorSalario());
        parametros.put("recDtaAdmissao", new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getRecDtaAdmissao()));
        parametros.put("recDtaDemissao", new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getRecDtaDemissao()));
        parametros.put("insalubridade", pessoa.getInsalubridade());
        parametros.put("recPericulosidade", pessoa.getRecPericulosidade());
        parametros.put("recNumTituEleitor", pessoa.getRecNumTituEleitor());

        parametros.put("recNomeBanco", pessoa.getRecNomeBanco());
        parametros.put("recAgenciaBancaria", pessoa.getRecAgenciaBancaria());
        parametros.put("recNumeroContaBanco", pessoa.getRecNumeroContaBanco());

        //Dependentes do colaborador
        List<CsbffDependentes> dependentes = recPessoaService.findAllDependentesPessoa(pessoa);

        JRBeanCollectionDataSource dependentesCollection = new JRBeanCollectionDataSource(dependentes);

        parametros.put("dependentePessoa", dependentesCollection);

        //Benefícios do colaborador
        List<CsbffBeneficios> beneficios = csbffBeneficiosService.TodosBeneficiosPessoa(pessoa);

//        beneficios = csbffBeneficiosService.TodosBeneficiosPessoa(pessoa);
        
        JRBeanCollectionDataSource beneficiosCollection = new JRBeanCollectionDataSource(beneficios);
        
        parametros.put("beneficioPessoa", beneficiosCollection);
        
        //escalas do colaborador
        List<CsbffEscalaHoras> escalas = csbffEscalaHorasService.buscarEscalasPessoa(pessoa);

        JRBeanCollectionDataSource escalasCollection = new JRBeanCollectionDataSource(escalas);

        parametros.put("escalaHorarios", escalasCollection);

//        List<GchTreinamentospessoas> treinamentosPessoa = gchTreinamentospessoasService.treinamentosPessoa(pessoa);
//
//        List<Treinamentos> treinamentos = new ArrayList<>();
//
//        for (GchTreinamentospessoas tp : treinamentosPessoa) {
//
//            GchTreinamentos treinamento = gchTreinamentosService.findById(tp.getTreiCodigo().getTreiCodigo());
//
//            treinamento.getTreiNome();
//
//            Treinamentos novo = new Treinamentos();
//
//            novo.setTreinamentoNome(treinamento.getTreiNome());
//
//            treinamentos.add(novo);
//
//        }
//
//        JRBeanCollectionDataSource treinamentosCollection = new JRBeanCollectionDataSource(treinamentos);
//
//        parametros.put("treinamentos", treinamentosCollection);
        JasperPrint jasperPrint = JasperFillManager.fillReport(fileRelatorio.getPath(), parametros, new JREmptyDataSource());
        relatorios.add(jasperPrint);
//        relatorios.add(jasperPrint);

        //Retorna o PDFF via HTTP Response
        HTTPResponseReturnPDF(relatorios, caminhoCompletoArquivo);

    }

    public void HTTPResponseReturnPDF(List<JasperPrint> relatorios, String nomeArquivo) throws IOException, JRException {

        FacesContext context = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("", "filename=" + nomeArquivo + ".pdf");
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

}
