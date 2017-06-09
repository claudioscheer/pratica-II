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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
public class EstatisticasFormularios implements Serializable {
    
    private List<LineChartModel> graficosLinha;
    private BarChartModel graficosBarras;
    
    private long codigoFormulario = 0;
    
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
        if(graficosBarras == null){
            
            
            BarChartModel vazio = new BarChartModel();
            
            ChartSeries series = new ChartSeries();
            series.setLabel("seriesLabel");
            series.set("1", 0);
            
            vazio.addSeries(series);
            
            return vazio;
       
        }else{
        
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
    
    public List<LineChartModel> getGraficosLinha() {
        
        if (graficosLinha == null) {

            LineChartModel vazio = new LineChartModel();
            
            ChartSeries series = new ChartSeries();
            series.setLabel("seriesLabel");
            series.set("1", 0);
            
            vazio.addSeries(series);
            
            
            List<LineChartModel> vazio3 = new ArrayList<>();
            
            return vazio3;
        } else {
            
            return graficosLinha;
        }
    }
    

    
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
            
            LineChartModel linhaPessoa = null;
            BarChartModel barraAlternativa = null;
            
            List<GchFormularioPessoa> pessoasFormulario = new ArrayList<>();
            List<GchRespostas> respostasEncontradas = new ArrayList<>();

            //Busca todas as pessoas vinculadas as formulários, respostas e alternativas
            pessoasFormulario = gchFormularioPessoaService.findAll();
            respostasEncontradas = gchRespostasService.findAll();

            //Busca todas as alternativas possiveis para aquele formulario
            Stream<Integer> todosFormularios = respostasEncontradas.stream().map(x -> x.getFormCodigo()).distinct()
                    .filter(x -> x == codigoFormulario);
            
            Iterator<Integer> formularioIterator = todosFormularios.iterator();
            while (formularioIterator.hasNext()) {
                int codigoFormulario = formularioIterator.next();
                Stream<Long> todasPessoasFormulario = respostasEncontradas.stream()
                        .filter(x -> x.getFormCodigo() == codigoFormulario)
                        .map(x -> x.getRecIdpessoa().getRecIdpessoa())
                        .distinct();

                //Busca alternativas
                Stream<Long> todasAlternativasFormulario = respostasEncontradas.stream()
                        .filter(x -> x.getFormCodigo() == codigoFormulario)
                        .map(x -> x.getAltCodigo().getAltCodigo())
                        .distinct();
                
                barraAlternativa = new BarChartModel();
                barraAlternativa.setAnimate(true);
                barraAlternativa.setTitle("Total Respondido X Respostas");
                barraAlternativa.setLegendPosition("ne");
                
                Axis xAxis = barraAlternativa.getAxis(AxisType.X);
                xAxis.setLabel("Perguntas");
                
                Axis yAxis2 = barraAlternativa.getAxis(AxisType.Y);
                yAxis2.setLabel("Total Respondido");
                yAxis2.setMin(0);
                yAxis2.setMax(200);
                
                GchFormulario formulario = gchFormularioService.findById(codigoFormulario);
                
                linhaPessoa = new LineChartModel();
                
                linhaPessoa.setTitle(formulario.getFormNome());
                linhaPessoa.setAnimate(true);
                linhaPessoa.setLegendPosition("e");
                linhaPessoa.setShowPointLabels(false);
                linhaPessoa.setMouseoverHighlight(true);
                linhaPessoa.setShadow(true);
                linhaPessoa.getAxes().put(AxisType.X, new CategoryAxis("Perguntas"));
                linhaPessoa.getAxes().put(AxisType.Y, new CategoryAxis("Resposta"));
                Axis yAxis = linhaPessoa.getAxis(AxisType.Y);
                yAxis.setMin(0);
                yAxis.setMax(100);
                
                Iterator<Long> pessoasIterator = todasPessoasFormulario.iterator();
                while (pessoasIterator.hasNext()) {
                    long codigo = pessoasIterator.next();
                    
                    RecPessoa pessoa = recPessoasService.BuscarId((int) codigo);
                    
                    ChartSeries colaborador = new ChartSeries();
                    
                    colaborador.setLabel(pessoa.getRecNomecompleto());
                    
                    List<GchRespostas> perguntaQuePessoaRespondeu = respostasEncontradas.stream()
                            .filter(x -> x.getFormCodigo() == codigoFormulario && x.getRecIdpessoa().getRecIdpessoa() == codigo)
                            .collect(Collectors.toList());
                                      
                    for (GchRespostas respostas : perguntaQuePessoaRespondeu) {
                        
                        ChartSeries graficoAlternativa = new ChartSeries();
                        
                        GchPerguntas pergunta = gchPerguntasService.findById(respostas.getPerCodigo());
                        GchAlternativas alternativa = gchAlternativasService.findById(respostas.getAltCodigo().getAltCodigo());
                        
                        graficoAlternativa.setLabel(alternativa.getAltDescricao());
                        
                        graficoAlternativa.set(pergunta.getPerDescricao(), alternativa.getAltPrioridade());
                        
                        colaborador.set(pergunta.getPerDescricao(), alternativa.getAltPrioridade());
                        barraAlternativa.addSeries(graficoAlternativa);
                    }
                    
                    linhaPessoa.addSeries(colaborador);
                    
                }
                
                graficosLinha.add(linhaPessoa);
                graficosBarras = barraAlternativa;
                
            }
            
        } else {
            
            System.out.println("código do formulário vazio");
            
        }
    }
    
}
