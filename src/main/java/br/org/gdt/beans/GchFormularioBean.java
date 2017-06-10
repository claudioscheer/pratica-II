/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchFormularioPessoa;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.ParametrosEmail;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.EncryptDecryptString;
import br.org.gdt.resources.GerenciadorEmail;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchAlternativasPerguntaService;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioPessoaService;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
import br.org.gdt.service.RecPessoaService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.collections.IteratorUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioBean {

    public GchFormulario getGchFormulario() {
        return gchFormulario;
    }

    private boolean formAtivo = false;

    private long indexPerguntaItem = 0;
    private List<GchAlternativas> alternativasVinculadas;
    private GchFormulario gchFormulario = new GchFormulario();
    private List<GchFormulario> gchTodosFormularios;
    private Map<RecPessoa, Boolean> checked = new HashMap<RecPessoa, Boolean>();
    private GchFormularioPessoa gchFormulariopessoa = new GchFormularioPessoa();
    private List<RecPessoa> pessoasVinculadas = new ArrayList<>();

    private List<RecPessoa> pessoasEmail = new ArrayList<>();

    private RecPessoa id = new RecPessoa();
    private String Notificacao = "";

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    @ManagedProperty("#{gchAlternativaPerguntasService}")
    private GchAlternativasPerguntaService gchAlternativasPerguntaService;

    @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;

    @ManagedProperty("#{gchRespostaService}")
    private GchRespostasService gchRespostasService;

    @ManagedProperty("#{gchFormularioPessoaService}")
    private GchFormularioPessoaService gchFormularioPessoaService;

    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    public String getNotificacao() {
        return Notificacao;
    }

    public void setNotificacao(String Notificacao) {
        this.Notificacao = Notificacao;
    }

    public List<RecPessoa> getPessoasEmail() {

       
       pessoasEmail = recPessoaService.buscarColaboradores();

//        Iterator<RecPessoa> pessoas = pessoasencontradas.iterator();
//
//        List<GchFormularioPessoa> formPess = gchFormularioPessoaService.VerificaExistenciaFormulario(gchFormulario.getFormCodigo());
//
//        while (pessoas.hasNext()) {
//
//            RecPessoa pessoaAtual = pessoas.next();
//
//            for (GchFormularioPessoa fp : formPess) {
//
//                if (pessoaAtual.getRecIdpessoa() == fp.getRecIdpessoa().getRecIdpessoa() && fp.isFormRespondido()) {
//
//                    pessoas.remove();
//
//                }
//
//            }
//
//        }
//
//        while (pessoas.hasNext()) {
//            pessoasEmail.add(pessoas.next());
//        }

        return pessoasEmail;
    }

    public void setPessoasEmail(List<RecPessoa> pessoasEmail) {
        this.pessoasEmail = pessoasEmail;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public Map<RecPessoa, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<RecPessoa, Boolean> checked) {
        this.checked = checked;
    }

    public GchFormularioPessoa getGchFormulariopessoa() {
        return gchFormulariopessoa;
    }

    public void setGchFormulariopessoa(GchFormularioPessoa gchFormulariopessoa) {
        this.gchFormulariopessoa = gchFormulariopessoa;
    }

    public List<RecPessoa> getPessoasVinculadas() {
        return pessoasVinculadas;
    }

    public void setPessoasVinculadas(List<RecPessoa> pessoasVinculadas) {
        this.pessoasVinculadas = pessoasVinculadas;
    }

    public RecPessoa getId() {
        return id;
    }

    public void setId(RecPessoa id) {
        this.id = id;
    }

    public GchFormularioPessoaService getGchFormularioPessoaService() {
        return gchFormularioPessoaService;
    }

    public void setGchFormularioPessoaService(GchFormularioPessoaService gchFormularioPessoaService) {
        this.gchFormularioPessoaService = gchFormularioPessoaService;
    }

    public List<GchAlternativas> getAlternativasVinculadas() {
        return alternativasVinculadas;
    }

    public void setAlternativasVinculadas(List<GchAlternativas> alternativasVinculadas) {
        this.alternativasVinculadas = alternativasVinculadas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.gchFormularioService);
        hash = 83 * hash + Objects.hashCode(this.gchAlternativasService);
        hash = 83 * hash + Objects.hashCode(this.gchAlternativasPerguntaService);
        hash = 83 * hash + Objects.hashCode(this.gchPerguntasService);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GchFormularioBean other = (GchFormularioBean) obj;
        if (!Objects.equals(this.gchFormularioService, other.gchFormularioService)) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasService, other.gchAlternativasService)) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasPerguntaService, other.gchAlternativasPerguntaService)) {
            return false;
        }
        if (!Objects.equals(this.gchPerguntasService, other.gchPerguntasService)) {
            return false;
        }
        return true;
    }

    private List<PerguntasAlternativas> PergAlt;

    public GchAlternativasPerguntaService getGchAlternativasPerguntaService() {
        return gchAlternativasPerguntaService;
    }

    public void setGchAlternativasPerguntaService(GchAlternativasPerguntaService gchAlternativasPerguntaService) {
        this.gchAlternativasPerguntaService = gchAlternativasPerguntaService;
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

    public GchFormularioBean() {

    }

    public void VerificaNotificacao() {

        if (!Notificacao.isEmpty()) {

            Helper.mostrarNotificacao("Sucesso", Notificacao, "success");

            Notificacao = "";
        }

    }

    public String DirecionaGrafico(GchFormulario formulario) {

        return "Estatisticas";

    }

    public void IsSelected(long alt) {

        System.out.println("alt" + alt);

    }

    public void cancel() {
        this.formAtivo = false;
        this.gchFormulario = new GchFormulario();
    }

    public void cancelDialog() {

        this.formAtivo = false;
        this.gchFormulariopessoa = new GchFormularioPessoa();
        checked = new HashMap<RecPessoa, Boolean>();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("Formularios.xhtml");
        } catch (IOException ex) {

        }

    }

    public void add() {

        this.formAtivo = true;
        this.gchFormulario = new GchFormulario();

    }

    public void alimentarVariaveis() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("MontarPerguntasAlternativas()");

    }

    public void LeituraParametroLink() {

    }

    public String salvarPessoasFormulario() {

        if (gchFormulariopessoa != null) {

            RequestContext contextReq = RequestContext.getCurrentInstance();

            Iterator<RecPessoa> keyIterrator = checked.keySet().iterator();

            ArrayList<ParametrosEmail> parametros = new ArrayList<>();

            ParametrosEmail ItemParametro;
            FacesContext context = FacesContext.getCurrentInstance();

            EncryptDecryptString cripto = new EncryptDecryptString();

            //Configurações da caixa de e-mail padrão do sistema
            String emailResponsavel = "murphyrhnotifica@gmail.com";
            String senha = "murphy2017";
            String assunto = "Preenchimento de Formulário";
            String url = context.getExternalContext().getRequestServerName() + ":" + context.getExternalContext().getRequestServerPort() + context.getExternalContext().getApplicationContextPath() + "/ModuloCapitalHumano/ResponderFormulario.xhtml?%1s";
            String mensagem = "";

            boolean vinculou = false;
            parametros.clear();

            while (keyIterrator.hasNext()) {

                RecPessoa pessoa = keyIterrator.next();
                Boolean value = checked.get(pessoa);

                if (value) {

                    //Seta null para não dar pau no Hibernate
                    gchFormulariopessoa.setFormPesCodigo(0);

                    gchFormulariopessoa.setRecIdpessoa(pessoa);
                    gchFormulariopessoa.setFormulario(gchFormulario);
                    gchFormulariopessoa.setFormRespondido(false);

                    gchFormularioPessoaService.save(gchFormulariopessoa);

                    String parametroUrl = gchFormulario.getFormCodigo() + "&" + pessoa.getRecIdpessoa();

                    String parametroBase64 = DatatypeConverter.printBase64Binary(parametroUrl.getBytes());

                    String urlFormatada = String.format(url, "id=" + parametroBase64);

                    System.out.println("Texto Formatado" + urlFormatada);

                    String msgFormatada = "<html></br></br><div style='border:2px solid #0094ff;'><h2 style='background:#87CEEB;color:white;padding:10px;color: #222;'>Formulário " + gchFormulario.getFormNome() + "</h2><div style='color:#333;padding:10px;'><p style='font-size:120%;text-shadow: 0px 2px 3px #555;'>Você acaba de receber um formulário com algumas perguntas para que possamos lhe conhecer melhor. O prazo de respostas é até \"" + gchFormulario.getFormPrazoResposta().toString() + "\"</p></br>Para acessá-lo clique <a href='http://" + urlFormatada + "'>aqui</a></br></br><h3>Instruções de Preenchimento</h3></br><p>- Responda com sinceridade!</p><p>- Somente é possível marcar uma alternativa por pergunta!</p><p>- Só é possível responder o formulário uma única vez!</p></div><h4 style='background:#ADD8E6;padding:8px;'>Murphy RH - Todos os direitos Reservados</h4></div></html>";

                    System.out.println("Mensagem Formatada" + msgFormatada);

                    //Cria item de parametro de email
                    ItemParametro = new ParametrosEmail();

                    ItemParametro.setRemetente(emailResponsavel);
                    ItemParametro.setSenha(senha);
                    ItemParametro.setAssunto(assunto);
                    ItemParametro.setMensagem(msgFormatada);
                    ItemParametro.setDestinatario(pessoa.getRecEmail());
                    ItemParametro.setFormularioPessoa(gchFormulariopessoa);

                    parametros.add(ItemParametro);

                    vinculou = true;

                }
            }

            this.formAtivo = false;
            gchFormulariopessoa = new GchFormularioPessoa();
            checked = new HashMap<RecPessoa, Boolean>();
            keyIterrator.remove();
            //Se vinculou ao menos 1 envia e-mail
            if (vinculou) {

                System.out.println("Url absoluta " + url);

                GerenciadorEmail novoEnvio = new GerenciadorEmail();

                try {
                    novoEnvio.EnviarEmail(parametros);
                    parametros.clear();
                } catch (Exception ex) {
                    Logger.getLogger(GchFormularioBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            String MsgNotificacao = "Formulário disponibilizado para as pessoas selecionadas!";
            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");

        }
        gchTodosFormularios = null; //isso faz com que a listagem se atualize
        return "Formularios";
    }

    public String SalvarFormulario() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        //Busca parametros concatenados 
        String parametrosCapa = params.get("formFormulario:TxbParametrosCapa");
        String parametrosPerguntas = params.get("formFormulario:TxbParametrosPergunta");
        String parametrosAlternativas = params.get("formFormulario:TxbParametrosAlternativas");

        String inputsCapa[] = parametrosCapa.split("§");
        String Perguntas[] = parametrosPerguntas.split("§");
        String Alternativas[] = parametrosAlternativas.split("¬");

        GchFormulario formulario = new GchFormulario();

        Date date = null;

        if (inputsCapa.length == 0 || inputsCapa[0].isEmpty()) {

            Helper.mostrarNotificacao("Validação de Campos", "Os dados da capa do formulário devem ser preenchidos!", "error");

        } else {

            if (Perguntas.length == 0 || Perguntas[0].isEmpty()) {

                Helper.mostrarNotificacao("Validação de Campos", "É preciso inserir ao menos uma pergunta ao formulário", "error");

            } else {

                if (Alternativas.length == 0 || Alternativas[0].isEmpty()) {

                    Helper.mostrarNotificacao("Validação de Campos", "É necessário vincular ao menos uma alternativa a pergunta", "error");

                } else {

                    try {

                        // -------------- Inputs da Capa --------------------------//
                        formulario.setFormNome(inputsCapa[0]); //Nome do Formulário
                        formulario.setFormDescricao(inputsCapa[1]); // Descricao do Formulário

                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                        date = (Date) formatter.parse(inputsCapa[2]);

                        formulario.setFormPrazoResposta(date);

                        gchFormularioService.save(formulario);

                    } catch (ParseException ex) {
                        Logger.getLogger(GchFormularioBean.class.getName()).log(Level.SEVERE, null, ex);
                    }

//      Somente continua se a quantidade de linhas de perguntas for igual a de alternativas
                    if (Perguntas.length == Alternativas.length) {

                        GchPerguntas pergunta;
                        String[] altPergunta;
                        GchAlternativasperguntas altperg;

                        // ----------- Informações das perguntas ------------------//
                        for (int i = 0; i < Perguntas.length; i++) {

                            pergunta = new GchPerguntas();

                            pergunta.setPerDescricao(Perguntas[i]);
                            pergunta.setFormulario(formulario);

                            gchPerguntasService.save(pergunta);

                            /* Busca todas alternativas de cada pergunta e armazena no array
                             - O ponto de quebra é o caractere § e o mesmo é concatenado no arquivo ControleFormularios.Js
                             */
                            altPergunta = Alternativas[i].split("§");

                            //Percorre alternativas da pergunta
                            for (int j = 0; j < altPergunta.length; j++) {

                                GchAlternativas novaAlternativa = gchAlternativasService.findById(Long.parseLong(altPergunta[j]));

                                altperg = new GchAlternativasperguntas();

                                altperg.setGchAlternativas(novaAlternativa);
                                altperg.setPerCodigo(pergunta);

                                gchAlternativasPerguntaService.save(altperg);

                            }
                        }

                        //Salvou com sucesso, retorna para página de listagem
                        Notificacao = "O formulário " + gchFormulario.getFormNome() + " foi cadastrado com sucesso!";

                        gchFormulario = new GchFormulario();

                    }

                    gchTodosFormularios = null; //isso faz com que a listagem se atualiz
                    return "Formularios";

                }

            }

        }
        return null;
    }

    public void responderFormulario() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("ResponderFormulario.xhtml");
        } catch (IOException ex) {

        }
    }

    public void addNovaPergunta() {

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("AddNovaPergunta()");

    }

    public void vincularPessoas(GchFormulario formulario) {

        gchFormulario = formulario;

        if (pessoasEmail.size() > 0) {

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogSelecaoPessoas').show();");
        } else {

            Helper.mostrarNotificacao("Informação", "Nenhum colaborador disponível para enviar o formulário", "info");

        }
    }

    public void removerPergunta(int index) {

        System.out.println("indice" + index);

        this.gchFormulario.getPerguntas().remove(index);
    }

    public String excluir(GchFormulario gchFormulario) {

        String MsgNotificacao = "";

        try {

            if (gchFormulario != null) {

                // Se não encontrou formulário vinculado
                if (!VerificaExclusaoFormulario(gchFormulario.getFormCodigo())) {

                    gchFormularioService.delete(gchFormulario.getFormCodigo());
                    gchTodosFormularios.remove(gchFormulario);
                    MsgNotificacao = "O formulário <b>" + gchFormulario.getFormNome() + " </b>foi excluído com sucesso!";
                    Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");

                } else {

                    MsgNotificacao = "O formulário <b>" + gchFormulario.getFormNome() + " </b>já foi respondido e não será excluído !";
                    Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");

                }

            }

        } catch (Exception ex) {

            //Formulário já vinculado a uma pessoa
            if (ex.toString().indexOf("fk_avlxdbfi5b3pnkm06qlu5v4ax") > 0) {

                MsgNotificacao = "Este formulário já foi disponibilizado para os colaboradores!";
                Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
            } else {

                MsgNotificacao = "Uma Exceção não tratada impediu a exclusão do formulário!";
                Helper.mostrarNotificacao("Erro", MsgNotificacao + ex.toString(), "error");

            }
        }

        RequestContext.getCurrentInstance().update("formFormulario:tabelFormularios");

        return "Formularios";
    }

    public boolean VerificaExclusaoFormulario(long id) {

        return gchRespostasService.VerificaExistenciaFormulario(id);
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchFormulario> getGchTodosFormularios() {

        if (gchTodosFormularios == null) {
            gchTodosFormularios = gchFormularioService.findAll();
        }

        return gchTodosFormularios;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public long getIndexPerguntaItem() {
        return indexPerguntaItem;
    }

    public void setIndexPerguntaItem(long indexPerguntaItem) {
        this.indexPerguntaItem = indexPerguntaItem;
    }

    public List<PerguntasAlternativas> getPergAlt() {
        return PergAlt;
    }

    public void setPergAlt(List<PerguntasAlternativas> PergAlt) {
        this.PergAlt = PergAlt;
    }

    public GchFormularioService getGchFormularioService() {
        return gchFormularioService;
    }

    public void setGchFormularioService(GchFormularioService gchFormularioService) {
        this.gchFormularioService = gchFormularioService;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

}
