package br.org.gdt.beans;

import br.org.gdt.enums.EstadoCivil;
import br.org.gdt.enums.Sexo;
import br.org.gdt.model.RecHabilidade;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.RecHabilidadeService;
import br.org.gdt.service.RecPessoaService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class RecPessoaBean {

    private boolean formAtivo = false;
    private RecPessoa recPessoa = new RecPessoa();
    private List<RecPessoa> recPessoas;

    private String cpfBusca;
    private String caminho;

    private List<RecHabilidade> pesHabilidades;
    @ManagedProperty("#{recPessoaService}")
    private RecPessoaService recPessoaService;

    @ManagedProperty("#{recHabilidadeService}")
    private RecHabilidadeService recHabilidadeService;

    private UploadedFile recFoto;
    private UploadedFile recAnexoCurriculo;

    private StreamedContent fotoPerfil;

    public List<RecHabilidade> completarHabilidade(String query) {
        List<RecHabilidade> allThemes = recHabilidadeService.ListarTodas();
        List<RecHabilidade> filteredThemes = new ArrayList<RecHabilidade>();

        for (int i = 0; i < allThemes.size(); i++) {
            RecHabilidade skin = allThemes.get(i);
            if (skin.getRecDescricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
        return filteredThemes;
    }

    public List<RecHabilidade> ListarHabilidades() {
        if (pesHabilidades == null) {
            pesHabilidades = recHabilidadeService.ListarTodas();
        }
        return pesHabilidades;
    }

    public RecPessoaBean() {
    }

    public String Salvar() throws IOException {
        if (ValidarCampos()) {
            if (recPessoa.getId() > 0) {
                if (recFoto != null) {
                    recPessoa.setRecFoto(FotoParaBytes());
                }
                recPessoaService.Alterar(recPessoa);
            } else {
                if (recFoto != null) {
                    recPessoa.setRecFoto(FotoParaBytes());
                    //Path origem = Paths.get(getCaminho());
                    //System.out.println("Origem" + origem);
                    //Path destino = Paths.get("C:/Temp/imagem.jpg");
                    //Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING); //copia para a pasta
                }
                if(recAnexoCurriculo != null){
                    recPessoa.setRecAnexoCurriculo(AnexoParaBytes());
                }
                recPessoaService.Inserir(recPessoa);
            }
            return "curriculo_sucesso";
        }
        return null;
    }

    public void upload(FileUploadEvent evento) {
        try {
            UploadedFile arquivo = evento.getFile();
            Path arquivoTemporario = Files.createTempFile(null, null);
            Files.copy(arquivo.getInputstream(), arquivoTemporario, StandardCopyOption.REPLACE_EXISTING);
            setCaminho(arquivoTemporario.toString());
            System.out.println("arquivo temp" + arquivoTemporario.toString());
            System.out.println("CAMINHO" + getCaminho());
        } catch (IOException ex) {

        }
    }

    public byte[] FotoParaBytes() throws IOException {
        InputStream input = recFoto.getInputstream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[10240];
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
        return output.toByteArray();
    }

    public byte[] AnexoParaBytes() throws IOException {
        InputStream input = recAnexoCurriculo.getInputstream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[10240];
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
        return output.toByteArray();
    }

    public String PreparaEdicao(RecPessoa pessoa) {
        formAtivo = true;
        this.recPessoa = recPessoaService.FindByIdCompleto(pessoa.getRecIdpessoa());
        return "candidatos";
    }
    
    public String VerCurriculo(RecPessoa pessoa) throws IOException {
        this.formAtivo = true;
        this.recPessoa = recPessoaService.FindByIdCompleto(pessoa.getRecIdpessoa());
        if (recPessoa.getRecFoto() != null) {
            fotoPerfil = RenderizarFoto(pessoa.getRecFoto());                        
        }
        return "candidatos";
    }

    public DefaultStreamedContent RenderizarFoto(byte[] img) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            if (img == null) {
                return new DefaultStreamedContent();
            } else {
                return new DefaultStreamedContent(new ByteArrayInputStream(img), "image/jpeg");
            }
        }
    }

    public String BuscarPessoa() {
        RecPessoa p = recPessoaService.BuscaPessoaCPF(cpfBusca);
        formAtivo = true;
        if (p != null) {
            this.recPessoa = p;
            return "curriculo";
        } else {
            recPessoa = new RecPessoa();
            return "curriculo";
        }
    }
    private int grauEnsinoFiltro = 0;
    private int sexoFiltro = 0;
    private String nomeFiltro;
    private int estadoCivilFiltro = 0;
    private int corFiltro = 0;
    public List<RecPessoa> FiltroPessoa(){
        recPessoas = recPessoaService.FiltroPessoa(grauEnsinoFiltro, 
                                                   sexoFiltro, 
                                                   nomeFiltro, 
                                                   estadoCivilFiltro, 
                                                   corFiltro);
        return recPessoas;
    }
    public List<RecPessoa> ListarTodas() {
        if (recPessoas == null) {
            recPessoas = recPessoaService.ListarTodas();
        }
        return recPessoas;
    }

    public String Adicionar() {
        recPessoa = new RecPessoa();
        return "curriculo";
    }
     

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }

    public List<RecPessoa> getRecPessoas() {
        if (recPessoas == null) {
            recPessoas = recPessoaService.ListarTodas();
        }
        return recPessoas;
    }

    public void setRecPessoas(List<RecPessoa> recPessoas) {
        this.recPessoas = recPessoas;
    }

    public RecPessoaService getRecPessoaService() {
        return recPessoaService;
    }

    public void setRecPessoaService(RecPessoaService recPessoaService) {
        this.recPessoaService = recPessoaService;
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public RecHabilidadeService getRecHabilidadeService() {
        return recHabilidadeService;
    }

    public void setRecHabilidadeService(RecHabilidadeService recHabilidadeService) {
        this.recHabilidadeService = recHabilidadeService;
    }

    public List<RecHabilidade> getHabilidades() {
        return pesHabilidades;
    }

    public void setHabilidades(List<RecHabilidade> habilidades) {
        this.pesHabilidades = habilidades;
    }

    public List<RecHabilidade> getPesHabilidades() {
        return pesHabilidades;
    }

    public void setPesHabilidades(List<RecHabilidade> pesHabilidades) {
        this.pesHabilidades = pesHabilidades;
    }

    public boolean ValidarCampos() {
        if (recPessoa.getRecNomecompleto().isEmpty()) {
            Helper.mostrarNotificacao("Nome Completo", "Preencha o Nome Completo", "error");
            return false;
        }
        if (recPessoa.getRecCpf().isEmpty()) {
            Helper.mostrarNotificacao("CPF", "Preencha o CPF", "error");
            return false;
        }
        if (recPessoa.getRecRg().isEmpty()) {
            Helper.mostrarNotificacao("RG", "Preencha o RG", "error");
            return false;
        }
        if (recPessoa.getRecOrgaoemissor().isEmpty()) {
            Helper.mostrarNotificacao("Orgão Emissor", "Preencha o Orgão Emissor do RG", "error");
            return false;
        }

        if (recPessoa.getRecEmail().isEmpty()) {
            Helper.mostrarNotificacao("E-mail", "Preencha o E-mail", "error");
            return false;
        }
        if (recPessoa.getRecTelefone().isEmpty()) {
            Helper.mostrarNotificacao("Telefone", "Preencha o Telefone", "error");
            return false;
        }
        if (recPessoa.getRecCelular().isEmpty()) {
            Helper.mostrarNotificacao("Celular", "Preencha o Celular", "error");
            return false;
        }
        if (recPessoa.getRecEndereco().isEmpty()) {
            Helper.mostrarNotificacao("Endereço", "Preencha o Endereço", "error");
            return false;
        }
        if (recPessoa.getRecBairro().isEmpty()) {
            Helper.mostrarNotificacao("Bairro", "Preencha o Bairro", "error");
            return false;
        }
        if (recPessoa.getRecNumero().isEmpty()) {
            Helper.mostrarNotificacao("Número", "Preencha o Número", "error");
            return false;
        }
        return true;
    }

    public UploadedFile getRecFoto() {
        return recFoto;
    }

    public EstadoCivil[] getEstadoCivil() {
        return EstadoCivil.values();
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }

    public void setRecFoto(UploadedFile recFoto) {
        this.recFoto = recFoto;
    }

    public UploadedFile getRecAnexoCurriculo() {
        return recAnexoCurriculo;
    }

    public void setRecAnexoCurriculo(UploadedFile recAnexoCurriculo) {
        this.recAnexoCurriculo = recAnexoCurriculo;
    }

    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }

    public StreamedContent getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(StreamedContent fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getGrauEnsinoFiltro() {
        return grauEnsinoFiltro;
    }

    public void setGrauEnsinoFiltro(int grauEnsinoFiltro) {
        this.grauEnsinoFiltro = grauEnsinoFiltro;
    }

    public int getSexoFiltro() {
        return sexoFiltro;
    }

    public void setSexoFiltro(int sexoFiltro) {
        this.sexoFiltro = sexoFiltro;
    }

    public String getNomeFiltro() {
        return nomeFiltro;
    }

    public void setNomeFiltro(String nomeFiltro) {
        this.nomeFiltro = nomeFiltro;
    }

    public int getEstadoCivilFiltro() {
        return estadoCivilFiltro;
    }

    public void setEstadoCivilFiltro(int estadoCivilFiltro) {
        this.estadoCivilFiltro = estadoCivilFiltro;
    }

    public int getCorFiltro() {
        return corFiltro;
    }

    public void setCorFiltro(int corFiltro) {
        this.corFiltro = corFiltro;
    }
}
