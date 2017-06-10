/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchFormularioPessoa;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.model.GchRespostas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioPessoaService;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
import br.org.gdt.service.RecPessoaService;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class EstatisticasFormularios implements Serializable {

    private List<BarChartModel> graficosLinha = new ArrayList<>();
    private BarChartModel graficosBarras;
    
    private PieChartModel graficoPizza = null;

    private long codigoFormulario;
    
    private String NomeFormulario;

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchRespostaService}")
    private GchRespostasService gchRespostasService;

    @ManagedProperty("#{gchFormularioPessoaService}")
    private GchFormularioPessoaService gchFormularioPessoaService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoasService;

    @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;

    @PostConstruct
    public void init() {
//        createLineModels();
    }

    public PieChartModel getGraficoPizza() {
        
        
        if(graficoPizza != null){
        return graficoPizza;
        
        }else{
            
            return new PieChartModel();
            
        }
    }

    
    public String CarregarGraficoFormulario(GchFormulario formulario){  
        codigoFormulario = formulario.getFormCodigo();   
        NomeFormulario   = formulario.getFormNome();
       
       List<GchFormularioPessoa> formulariosPessoa = gchFormularioPessoaService.VerificaExistenciaFormulario(codigoFormulario);
      
       if(formulariosPessoa.size() > 0){
        gerargraficoformulariorespondidos();
        
        return "Estatisticas";
       }else{
           
           Helper.mostrarNotificacao("Informação", "Ainda não existem estatísticas para este formulário!", "info");
           return null;
       } 
        
    }
    
    
    public String cancel(){
        
        return "Formularios";
        
    }
    
    public void setGraficoPizza(PieChartModel graficoPizza) {
        this.graficoPizza = graficoPizza;
    }

    public String getNomeFormulario() {
        return NomeFormulario;
    }

    public void setNomeFormulario(String NomeFormulario) {
        this.NomeFormulario = NomeFormulario;
    }

    public RecPessoaService getRecPessoasService() {
        return recPessoasService;
    }

    public long getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(long codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public BarChartModel getGraficosBarras() {
        if (graficosBarras == null) {

            BarChartModel vazio = new BarChartModel();

            ChartSeries series = new ChartSeries();
            series.setLabel("seriesLabel");
            series.set("1", 0);

            vazio.addSeries(series);

            return vazio;

        } else {

            return graficosBarras;
        }
    }

    public void setGraficosBarras(BarChartModel graficosBarras) {
        this.graficosBarras = graficosBarras;
    }

    public void setRecPessoasService(RecPessoaService recPessoasService) {
        this.recPessoasService = recPessoasService;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    public List<BarChartModel> getGraficosLinha() {

        if (graficosLinha == null) {

            LineChartModel vazio = new LineChartModel();

            ChartSeries series = new ChartSeries();
            series.setLabel("seriesLabel");
            series.set("1", 0);

            vazio.addSeries(series);

            List<BarChartModel> vazio3 = new ArrayList<>();

            return vazio3;
        } else {

            return graficosLinha;
        }
    }

//    public String acessarGraficoLinha(GchFormulario formulario){
//
//        codigoFormulario = formulario.getFormCodigo();
//
//        return ""
//
//    }
    public GchPerguntasService getGchPerguntasService() {
        return gchPerguntasService;
    }

    public void setGchPerguntasService(GchPerguntasService gchPerguntasService) {
        this.gchPerguntasService = gchPerguntasService;
    }

    public GchRespostasService getGchRespostasService() {
        return gchRespostasService;
    }

    public void setGchRespostasService(GchRespostasService gchRespostasService) {
        this.gchRespostasService = gchRespostasService;
    }

    public GchFormularioPessoaService getGchFormularioPessoaService() {
        return gchFormularioPessoaService;
    }

    public void setGchFormularioPessoaService(GchFormularioPessoaService gchFormularioPessoaService) {
        this.gchFormularioPessoaService = gchFormularioPessoaService;
    }

    public EstatisticasFormularios() {

    }

    public void gerargraficoformulariorespondidos() {

        if (codigoFormulario != 0) {

            graficosLinha.clear();
            
            BarChartModel linhaPessoa = null;

            List<GchFormularioPessoa> pessoasFormulario = new ArrayList<>();
            List<GchRespostas> respostasEncontradas = new ArrayList<>();

            //Busca todas as pessoas vinculadas as formulários, respostas e alternativas
            pessoasFormulario = gchFormularioPessoaService.findAll();
            respostasEncontradas = gchRespostasService.findAll();

            int naoRespondido = 0;
            int Respondido = 0;

            for (GchFormularioPessoa fp : pessoasFormulario) {

                
                if(fp.getFormulario().getFormCodigo() == codigoFormulario){
                
                if (fp.isFormRespondido()) {
                    Respondido += 1;
                } else {
                    naoRespondido += 1;
                }

                }
            }

            graficoPizza = new PieChartModel();

            graficoPizza.set("Pessoas que Responderam", Respondido);
            graficoPizza.set("Pessoas que não Responderam", naoRespondido);

            graficoPizza.setTitle("Disponibilização X Pessoas que responderam");
            graficoPizza.setLegendPosition("w");

            //Busca todas as alternativas possiveis para aquele formulario
            Stream<Integer> todosFormularios = respostasEncontradas.stream().map(x -> x.getFormCodigo()).distinct()
                    .filter(x -> x == codigoFormulario);

            Iterator<Integer> formularioIterator = todosFormularios.iterator();
            while (formularioIterator.hasNext()) {
                int codigoFormulario = formularioIterator.next();
                Stream<Long> todasPessoasFormulario = respostasEncontradas.stream()
                        .filter(x -> x.getFormCodigo() == codigoFormulario)
                        .map(x -> x.getPerCodigo())
                        .distinct();

                Iterator<Long> perguntaIterator = todasPessoasFormulario.iterator();

                while (perguntaIterator.hasNext()) {

                    linhaPessoa = new BarChartModel();

                    GchFormulario formulario = gchFormularioService.findById(codigoFormulario);
                    long codigoPergunta = perguntaIterator.next();

                    GchPerguntas pergunta = gchPerguntasService.findById(codigoPergunta);

                    linhaPessoa.setTitle(pergunta.getPerDescricao());
                    linhaPessoa.setAnimate(true);
                    linhaPessoa.setLegendPosition(LegendPlacement.OUTSIDEGRID.toString());
                    linhaPessoa.setShowPointLabels(false);
                    linhaPessoa.setMouseoverHighlight(true);
                    linhaPessoa.setShadow(true);
                    linhaPessoa.getAxes().put(AxisType.Y, new CategoryAxis(""));
                    Axis yAxis = linhaPessoa.getAxis(AxisType.Y);
                    yAxis.setMin(0);
                    yAxis.setMax(100);

                    Stream<Long> todasAlternativasFormulario = respostasEncontradas.stream()
                            .filter(x -> x.getFormCodigo() == codigoFormulario && x.getPerCodigo() == codigoPergunta)
                            .map(x -> x.getAltCodigo().getAltCodigo())
                            .distinct();

                    Iterator<Long> alternativasIterator = todasAlternativasFormulario.iterator();

                    while (alternativasIterator.hasNext()) {

                        long codigoAlternativa = alternativasIterator.next();

                        GchAlternativas alternativa = gchAlternativasService.findById(codigoAlternativa);

                        ChartSeries charAlt = new ChartSeries();

                        charAlt.setLabel(alternativa.getAltDescricao());

                        Stream<Long> totalPorAlternativa = respostasEncontradas.stream()
                                .filter(x -> x.getFormCodigo() == codigoFormulario && x.getPerCodigo() == codigoPergunta && x.getAltCodigo().getAltCodigo() == codigoAlternativa)
                                .map(x -> x.getAltCodigo().getAltCodigo());

                        charAlt.set("_", totalPorAlternativa.count());

                        System.out.println("entrou uhu");

                        linhaPessoa.addSeries(charAlt);
                    }

                    graficosLinha.add(linhaPessoa);

                }

            }

        } else {

            System.out.println("código do formulário vazio");

        }
    }

}
