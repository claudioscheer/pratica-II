/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import br.org.gdt.enums.Insalubridade;
import br.org.gdt.enums.Periculosidade;
import br.org.gdt.enums.PossuiDependentes;
import br.org.gdt.enums.Sexo;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "rec_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecPessoa.findAll", query = "SELECT r FROM RecPessoa r")})
@SequenceGenerator(name = "seq_RecPessoa", sequenceName = "seq_RecPessoa", allocationSize = 1)
public class RecPessoa implements java.io.Serializable, SampleEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idpessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_RecPessoa")
    private long recIdpessoa;
    @Column(name = "rec_nomecompleto")
    private String recNomecompleto;
    @Column(name = "rec_cpf")
    private String recCpf;
    @Column(name = "rec_sexo")
    private Sexo recSexo;
    @Column(name = "rec_estadocivil")
    private Integer recEstadocivil;
    @Column(name = "rec_rg")
    private String recRg;
    @Column(name = "rec_orgaoemissor")
    private String recOrgaoemissor;
    @Column(name = "rec_dtemissao")
    @Temporal(TemporalType.DATE)
    private Date recDtemissao;
    @Column(name = "rec_nomepai")
    private String recNomepai;
    @Column(name = "rec_nomemae")
    private String recNomemae;
    @Column(name = "rec_dtnascimento")
    @Temporal(TemporalType.DATE)
    private Date recDtnascimento;
    @Column(name = "rec_email")
    private String recEmail;
    @Column(name = "rec_celular")
    private String recCelular;
    @Column(name = "rec_telefone")
    private String recTelefone;
    @Column(name = "rec_objprofissional")
    private String recObjprofissional;
    @Column(name = "rec_autoavaliacao")
    private String recAutoavaliacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rec_pretencaosalarial")
    private String recPretencaosalarial;
    @Lob
    @Column(name = "rec_foto")
    private byte[] recFoto;
    @Column(name = "rec_pispasep")
    private String recPispasep;
    @Column(name = "rec_reservista")
    private String recReservista;
    @Column(name = "rec_endereco")
    private String recEndereco;
    @Column(name = "rec_bairro")
    private String recBairro;
    @Column(name = "rec_numero")
    private String recNumero;
    @Column(name = "rec_cor")
    private String recCor;
    @Column(name = "rec_funcionario")
    private Boolean recFuncionario;
    @Column(name = "rec_nacionalidade")
    private String recNacionalidade;
    @Column(name = "rec_num_ctps")
    private BigInteger recNumCtps;
    @Column(name = "rec_numero_conta_banco")
    private BigInteger recNumeroContaBanco;
    @Column(name = "rec_agencia_bancaria")
    private BigInteger recAgenciaBancaria;
    @Column(name = "rec_escolaridade")
    private BigInteger recEscolaridade;
    @Column(name = "rec_dta_admissao")
    @Temporal(TemporalType.DATE)
    private Date recDtaAdmissao;
    @Column(name = "rec_segurodesemprego")
    private String recSegurodesemprego;
    @Basic(optional = true)
    @Column(name = "rec_insalubridade")
    private String recInsalubridade;
    @Column(name = "rec_periculosidade")
    private String recPericulosidade;
    @Column(name = "rec_NomeBanco")
    private String recNomeBanco;
    @Column(name = "rec_num_titu_eleitor")
    private BigInteger recNumTituEleitor;
    @Column(name = "rec_certificado_reservista")
    private BigInteger recCertificadoReservista;
    @Column(name = "rec_dta_demissao")
    @Temporal(TemporalType.DATE)
    private Date recDtaDemissao;
    @Column(name = "rec_percentual_insalubridade")
    private BigInteger recPercentualInsalubridade;
    @ManyToMany(mappedBy = "recPessoaList")
    private List<RecHabilidade> recHabilidadeList;
    @ManyToMany(mappedBy = "recPessoaList")
    private List<RecExperiencia> recExperienciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<CsbffCargosHistorico> csbffCargosHistoricoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<RecSelecao> recSelecaoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private CsbffEscalaHoras csbffEscalaHoras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<GchTreinamentospessoas> gchTreinamentospessoasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private CsbffPessoaDependente colabDepCodigo;
    @JoinColumn(name = "cargo_codigo", referencedColumnName = "cargo_codigo")
    @ManyToOne
    private CsbffCargos cargoCodigo;
    @JoinColumn(name = "mun_codigo", referencedColumnName = "mun_codigo")
    @ManyToOne(optional = true)
    private GchMunicipios munCodigo;
    @JoinColumn(name = "rec_idgrauensino", referencedColumnName = "rec_idgrauensino")
    @ManyToOne(optional = true)
    private RecGrauensino recIdgrauensino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<CsbffHistoricoSalario> csbffHistoricoSalarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<GchRespostas> gchRespostasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<GchFormularioPessoa> gchFormularioPessoas;

  
    
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
//    private List<TipoBeneficio> csbffBeneficiosList;
    @OneToMany
    private List<CsbffBeneficios> csbffBeneficiosList;
//    @OneToMany
    private Insalubridade insalubridade;
    private PossuiDependentes possuiDependente;
    @OneToMany
    private List<CsbffCargos> csbffCargosList;
    private Integer recPesGrauEnsino;

    public RecPessoa(PossuiDependentes possuiDependente) {
        this.possuiDependente = possuiDependente;
    }

    public RecPessoa(CsbffPessoaDependente colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public RecPessoa(Periculosidade periculosidade) {
        this.periculosidade = periculosidade;
    }
    private Periculosidade periculosidade;

    public RecPessoa(Insalubridade insalubridade) {
        this.insalubridade = insalubridade;
    }

    public RecPessoa(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

      public List<GchFormularioPessoa> getGchFormularioPessoas() {
        return gchFormularioPessoas;
    }

    public void setGchFormularioPessoas(List<GchFormularioPessoa> gchFormularioPessoas) {
        this.gchFormularioPessoas = gchFormularioPessoas;
    }
    
    public RecPessoa() {
    }

    public RecPessoa(Integer recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

//    public RecPessoa(List<TipoBeneficio> csbffBeneficiosList) {
//        this.csbffBeneficiosList = csbffBeneficiosList;
//    }
    public RecPessoa(Integer recIdpessoa, String recInsalubridade) {
        this.recIdpessoa = recIdpessoa;
        this.recInsalubridade = recInsalubridade;
    }

    public RecPessoa(String recNomecompleto) {
        this.recNomecompleto = recNomecompleto;
    }

    public long getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(long recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public String getRecNomecompleto() {
        return recNomecompleto;
    }

    public void setRecNomecompleto(String recNomecompleto) {
        this.recNomecompleto = recNomecompleto;
    }

    public String getRecCpf() {
        return recCpf;
    }

    public void setRecCpf(String recCpf) {
        this.recCpf = recCpf;
    }

    public Sexo getRecSexo() {
        return recSexo;
    }

    public void setRecSexo(Sexo recSexo) {
        this.recSexo = recSexo;
    }

    public Integer getRecEstadocivil() {
        return recEstadocivil;
    }

    public void setRecEstadocivil(Integer recEstadocivil) {
        this.recEstadocivil = recEstadocivil;
    }

    public String getRecRg() {
        return recRg;
    }

    public void setRecRg(String recRg) {
        this.recRg = recRg;
    }

    public String getRecOrgaoemissor() {
        return recOrgaoemissor;
    }

    public void setRecOrgaoemissor(String recOrgaoemissor) {
        this.recOrgaoemissor = recOrgaoemissor;
    }

    public Date getRecDtemissao() {
        return recDtemissao;
    }

    public void setRecDtemissao(Date recDtemissao) {
        this.recDtemissao = recDtemissao;
    }

    public String getRecNomepai() {
        return recNomepai;
    }

    public void setRecNomepai(String recNomepai) {
        this.recNomepai = recNomepai;
    }

    public String getRecNomemae() {
        return recNomemae;
    }

    public void setRecNomemae(String recNomemae) {
        this.recNomemae = recNomemae;
    }

    public Date getRecDtnascimento() {
        return recDtnascimento;
    }

    public void setRecDtnascimento(Date recDtnascimento) {
        this.recDtnascimento = recDtnascimento;
    }

    public String getRecEmail() {
        return recEmail;
    }

    public void setRecEmail(String recEmail) {
        this.recEmail = recEmail;
    }

    public String getRecCelular() {
        return recCelular;
    }

    public void setRecCelular(String recCelular) {
        this.recCelular = recCelular;
    }

    public String getRecTelefone() {
        return recTelefone;
    }

    public void setRecTelefone(String recTelefone) {
        this.recTelefone = recTelefone;
    }

    public String getRecObjprofissional() {
        return recObjprofissional;
    }

    public void setRecObjprofissional(String recObjprofissional) {
        this.recObjprofissional = recObjprofissional;
    }

    public String getRecAutoavaliacao() {
        return recAutoavaliacao;
    }

    public void setRecAutoavaliacao(String recAutoavaliacao) {
        this.recAutoavaliacao = recAutoavaliacao;
    }

    public String getRecPretencaosalarial() {
        return recPretencaosalarial;
    }

    public void setRecPretencaosalarial(String recPretencaosalarial) {
        this.recPretencaosalarial = recPretencaosalarial;
    }

    public byte[] getRecFoto() {
        return recFoto;
    }

    public void setRecFoto(byte[] recFoto) {
        this.recFoto = recFoto;
    }

    public String getRecPispasep() {
        return recPispasep;
    }

    public void setRecPispasep(String recPispasep) {
        this.recPispasep = recPispasep;
    }

    public String getRecReservista() {
        return recReservista;
    }

    public void setRecReservista(String recReservista) {
        this.recReservista = recReservista;
    }

    public String getRecEndereco() {
        return recEndereco;
    }

    public void setRecEndereco(String recEndereco) {
        this.recEndereco = recEndereco;
    }

    public String getRecBairro() {
        return recBairro;
    }

    public void setRecBairro(String recBairro) {
        this.recBairro = recBairro;
    }

    public String getRecNumero() {
        return recNumero;
    }

    public void setRecNumero(String recNumero) {
        this.recNumero = recNumero;
    }

    public String getRecCor() {
        return recCor;
    }

    public void setRecCor(String recCor) {
        this.recCor = recCor;
    }

    public Boolean getRecFuncionario() {
        return recFuncionario;
    }

    public void setRecFuncionario(Boolean recFuncionario) {
        this.recFuncionario = recFuncionario;
    }

    public String getRecNacionalidade() {
        return recNacionalidade;
    }

    public void setRecNacionalidade(String recNacionalidade) {
        this.recNacionalidade = recNacionalidade;
    }

    public BigInteger getRecNumCtps() {
        return recNumCtps;
    }

    public void setRecNumCtps(BigInteger recNumCtps) {
        this.recNumCtps = recNumCtps;
    }

    public BigInteger getRecNumeroContaBanco() {
        return recNumeroContaBanco;
    }

    public void setRecNumeroContaBanco(BigInteger recNumeroContaBanco) {
        this.recNumeroContaBanco = recNumeroContaBanco;
    }

    public BigInteger getRecAgenciaBancaria() {
        return recAgenciaBancaria;
    }

    public void setRecAgenciaBancaria(BigInteger recAgenciaBancaria) {
        this.recAgenciaBancaria = recAgenciaBancaria;
    }

    public BigInteger getRecEscolaridade() {
        return recEscolaridade;
    }

    public void setRecEscolaridade(BigInteger recEscolaridade) {
        this.recEscolaridade = recEscolaridade;
    }

    public Date getRecDtaAdmissao() {
        return recDtaAdmissao;
    }

    public void setRecDtaAdmissao(Date recDtaAdmissao) {
        this.recDtaAdmissao = recDtaAdmissao;
    }

    public String getRecSegurodesemprego() {
        return recSegurodesemprego;
    }

    public void setRecSegurodesemprego(String recSegurodesemprego) {
        this.recSegurodesemprego = recSegurodesemprego;
    }

    public String getRecInsalubridade() {
        return recInsalubridade;
    }

    public void setRecInsalubridade(String recInsalubridade) {
        this.recInsalubridade = recInsalubridade;
    }

    public String getRecPericulosidade() {
        return recPericulosidade;
    }

    public void setRecPericulosidade(String recPericulosidade) {
        this.recPericulosidade = recPericulosidade;
    }

    public String getRecNomeBanco() {
        return recNomeBanco;
    }

    public void setRecNomeBanco(String recNomeBanco) {
        this.recNomeBanco = recNomeBanco;
    }

    public BigInteger getRecNumTituEleitor() {
        return recNumTituEleitor;
    }

    public void setRecNumTituEleitor(BigInteger recNumTituEleitor) {
        this.recNumTituEleitor = recNumTituEleitor;
    }

    public BigInteger getRecCertificadoReservista() {
        return recCertificadoReservista;
    }

    public void setRecCertificadoReservista(BigInteger recCertificadoReservista) {
        this.recCertificadoReservista = recCertificadoReservista;
    }

    public Date getRecDtaDemissao() {
        return recDtaDemissao;
    }

    public void setRecDtaDemissao(Date recDtaDemissao) {
        this.recDtaDemissao = recDtaDemissao;
    }

    public BigInteger getRecPercentualInsalubridade() {
        return recPercentualInsalubridade;
    }

    public void setRecPercentualInsalubridade(BigInteger recPercentualInsalubridade) {
        this.recPercentualInsalubridade = recPercentualInsalubridade;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecHabilidade> getRecHabilidadeList() {
        return recHabilidadeList;
    }

    public void setRecHabilidadeList(List<RecHabilidade> recHabilidadeList) {
        this.recHabilidadeList = recHabilidadeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecExperiencia> getRecExperienciaList() {
        return recExperienciaList;
    }

    public void setRecExperienciaList(List<RecExperiencia> recExperienciaList) {
        this.recExperienciaList = recExperienciaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffCargosHistorico> getCsbffCargosHistoricoList() {
        return csbffCargosHistoricoList;
    }

    public void setCsbffCargosHistoricoList(List<CsbffCargosHistorico> csbffCargosHistoricoList) {
        this.csbffCargosHistoricoList = csbffCargosHistoricoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecSelecao> getRecSelecaoList() {
        return recSelecaoList;
    }

    public void setRecSelecaoList(List<RecSelecao> recSelecaoList) {
        this.recSelecaoList = recSelecaoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchTreinamentospessoas> getGchTreinamentospessoasList() {
        return gchTreinamentospessoasList;
    }

    public void setGchTreinamentospessoasList(List<GchTreinamentospessoas> gchTreinamentospessoasList) {
        this.gchTreinamentospessoasList = gchTreinamentospessoasList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffPessoaBeneficio> getCsbffPessoaBeneficioList() {
        return csbffPessoaBeneficioList;
    }

    public void setCsbffPessoaBeneficioList(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
    }

    public CsbffCargos getCargoCodigo() {
        return cargoCodigo;
    }

    public void setCargoCodigo(CsbffCargos cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public GchMunicipios getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(GchMunicipios munCodigo) {
        this.munCodigo = munCodigo;
    }

    public RecGrauensino getRecIdgrauensino() {
        return recIdgrauensino;
    }

    public void setRecIdgrauensino(RecGrauensino recIdgrauensino) {
        this.recIdgrauensino = recIdgrauensino;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffHistoricoSalario> getCsbffHistoricoSalarioList() {
        return csbffHistoricoSalarioList;
    }

    public void setCsbffHistoricoSalarioList(List<CsbffHistoricoSalario> csbffHistoricoSalarioList) {
        this.csbffHistoricoSalarioList = csbffHistoricoSalarioList;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchRespostas> getGchRespostasList() {
        return gchRespostasList;
    }

    public void setGchRespostasList(List<GchRespostas> gchRespostasList) {
        this.gchRespostasList = gchRespostasList;
    }

    public List<CsbffBeneficios> getCsbffBeneficiosList() {
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

    @Override
    public Long getId() {
        return this.recIdpessoa;
    }

    public Insalubridade getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(Insalubridade insalubridade) {
        this.insalubridade = insalubridade;
    }

    public Periculosidade getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(Periculosidade periculosidade) {
        this.periculosidade = periculosidade;
    }

    public CsbffPessoaDependente getColabDepCodigo() {
        return colabDepCodigo;
    }

    public void setColabDepCodigo(CsbffPessoaDependente colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public PossuiDependentes getPossuiDependente() {
        return possuiDependente;
    }

    public void setPossuiDependente(PossuiDependentes possuiDependente) {
        this.possuiDependente = possuiDependente;
    }

    public RecPessoa(long recIdpessoa, String recNomecompleto, String recCpf, Sexo recSexo, Integer recEstadocivil, String recRg, String recOrgaoemissor, Date recDtemissao, String recNomepai, String recNomemae, Date recDtnascimento, String recEmail, String recCelular, String recTelefone, String recObjprofissional, String recAutoavaliacao, String recPretencaosalarial, byte[] recFoto, String recPispasep, String recReservista, String recEndereco, String recBairro, String recNumero, String recCor, Boolean recFuncionario, String recNacionalidade, BigInteger recNumCtps, BigInteger recNumeroContaBanco, BigInteger recAgenciaBancaria, BigInteger recEscolaridade, Date recDtaAdmissao, String recSegurodesemprego, String recInsalubridade, String recPericulosidade, String recNomeBanco, BigInteger recNumTituEleitor, BigInteger recCertificadoReservista, Date recDtaDemissao, BigInteger recPercentualInsalubridade, List<RecHabilidade> recHabilidadeList, List<RecExperiencia> recExperienciaList, List<CsbffCargosHistorico> csbffCargosHistoricoList, List<RecSelecao> recSelecaoList, List<GchTreinamentospessoas> gchTreinamentospessoasList, List<CsbffPessoaBeneficio> csbffPessoaBeneficioList, CsbffPessoaDependente colabDepCodigo, CsbffCargos cargoCodigo, GchMunicipios munCodigo, RecGrauensino recIdgrauensino, List<CsbffHistoricoSalario> csbffHistoricoSalarioList, List<GchRespostas> gchRespostasList, List<CsbffBeneficios> csbffBeneficiosList, Insalubridade insalubridade, PossuiDependentes possuiDependente, Periculosidade periculosidade) {
        this.recIdpessoa = recIdpessoa;
        this.recNomecompleto = recNomecompleto;
        this.recCpf = recCpf;
        this.recSexo = recSexo;
        this.recEstadocivil = recEstadocivil;
        this.recRg = recRg;
        this.recOrgaoemissor = recOrgaoemissor;
        this.recDtemissao = recDtemissao;
        this.recNomepai = recNomepai;
        this.recNomemae = recNomemae;
        this.recDtnascimento = recDtnascimento;
        this.recEmail = recEmail;
        this.recCelular = recCelular;
        this.recTelefone = recTelefone;
        this.recObjprofissional = recObjprofissional;
        this.recAutoavaliacao = recAutoavaliacao;
        this.recPretencaosalarial = recPretencaosalarial;
        this.recFoto = recFoto;
        this.recPispasep = recPispasep;
        this.recReservista = recReservista;
        this.recEndereco = recEndereco;
        this.recBairro = recBairro;
        this.recNumero = recNumero;
        this.recCor = recCor;
        this.recFuncionario = recFuncionario;
        this.recNacionalidade = recNacionalidade;
        this.recNumCtps = recNumCtps;
        this.recNumeroContaBanco = recNumeroContaBanco;
        this.recAgenciaBancaria = recAgenciaBancaria;
        this.recEscolaridade = recEscolaridade;
        this.recDtaAdmissao = recDtaAdmissao;
        this.recSegurodesemprego = recSegurodesemprego;
        this.recInsalubridade = recInsalubridade;
        this.recPericulosidade = recPericulosidade;
        this.recNomeBanco = recNomeBanco;
        this.recNumTituEleitor = recNumTituEleitor;
        this.recCertificadoReservista = recCertificadoReservista;
        this.recDtaDemissao = recDtaDemissao;
        this.recPercentualInsalubridade = recPercentualInsalubridade;
        this.recHabilidadeList = recHabilidadeList;
        this.recExperienciaList = recExperienciaList;
        this.csbffCargosHistoricoList = csbffCargosHistoricoList;
        this.recSelecaoList = recSelecaoList;
        this.gchTreinamentospessoasList = gchTreinamentospessoasList;
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
        this.colabDepCodigo = colabDepCodigo;
        this.cargoCodigo = cargoCodigo;
        this.munCodigo = munCodigo;
        this.recIdgrauensino = recIdgrauensino;
        this.csbffHistoricoSalarioList = csbffHistoricoSalarioList;
        this.gchRespostasList = gchRespostasList;
        this.csbffBeneficiosList = csbffBeneficiosList;
        this.insalubridade = insalubridade;
        this.possuiDependente = possuiDependente;
        this.periculosidade = periculosidade;
    }

    public List<CsbffCargos> getCsbffCargosList() {
        return csbffCargosList;
    }

    public void setCsbffCargosList(List<CsbffCargos> csbffCargosList) {
        this.csbffCargosList = csbffCargosList;
    }

    public Integer getRecPesGrauEnsino() {
        return recPesGrauEnsino;
    }

    public void setRecPesGrauEnsino(Integer recPesGrauEnsino) {
        this.recPesGrauEnsino = recPesGrauEnsino;
    }

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        return csbffEscalaHoras;
    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
    }

}
