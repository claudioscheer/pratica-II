/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.modelOld.FpHorasTrabalhadas;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "RecPessoa_1.findAll", query = "SELECT r FROM RecPessoa_1 r")})
public class RecPessoa_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idpessoa")
    private Integer recIdpessoa;
    @Column(name = "rec_nomecompleto")
    private String recNomecompleto;
    @Column(name = "rec_cpf")
    private String recCpf;
    @Column(name = "rec_sexo")
    private Integer recSexo;
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
    private Float recPretencaosalarial;
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
    private Boolean recSegurodesemprego;
    @Basic(optional = false)
    @Column(name = "rec_insalubridade")
    private int recInsalubridade;
    @Column(name = "rec_periculosidade")
    private Boolean recPericulosidade;
    @Column(name = "rec_centrodecusto")
    private BigInteger recCentrodecusto;
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
    private List<RecHabilidade_1> recHabilidadeList;
    @ManyToMany(mappedBy = "recPessoaList")
    private List<RecExperiencia_1> recExperienciaList;
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
    private CsbffPessoaDependente csbffPessoaDependente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<FpEventosVariaveis> fpEventosVariaveisList;
    @JoinColumn(name = "cargo_codigo", referencedColumnName = "cargo_codigo")
    @ManyToOne(optional = false)
    private CsbffCargos cargoCodigo;
    @JoinColumn(name = "mun_codigo", referencedColumnName = "mun_codigo")
    @ManyToOne(optional = false)
    private GchMunicipios munCodigo;
    @JoinColumn(name = "rec_idgrauensino", referencedColumnName = "rec_idgrauensino")
    @ManyToOne(optional = false)
    private RecGrauensino recIdgrauensino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<FpHorasTrabalhadas> fpHorasTrabalhadasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<FpFolhasPeriodo> fpFolhasPeriodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<CsbffHistoricoSalario> csbffHistoricoSalarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<GchRespostas> gchRespostasList;

    public RecPessoa_1() {
    }

    public RecPessoa_1(Integer recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public RecPessoa_1(Integer recIdpessoa, int recInsalubridade) {
        this.recIdpessoa = recIdpessoa;
        this.recInsalubridade = recInsalubridade;
    }

    public Integer getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(Integer recIdpessoa) {
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

    public Integer getRecSexo() {
        return recSexo;
    }

    public void setRecSexo(Integer recSexo) {
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

    public Float getRecPretencaosalarial() {
        return recPretencaosalarial;
    }

    public void setRecPretencaosalarial(Float recPretencaosalarial) {
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

    public Boolean getRecSegurodesemprego() {
        return recSegurodesemprego;
    }

    public void setRecSegurodesemprego(Boolean recSegurodesemprego) {
        this.recSegurodesemprego = recSegurodesemprego;
    }

    public int getRecInsalubridade() {
        return recInsalubridade;
    }

    public void setRecInsalubridade(int recInsalubridade) {
        this.recInsalubridade = recInsalubridade;
    }

    public Boolean getRecPericulosidade() {
        return recPericulosidade;
    }

    public void setRecPericulosidade(Boolean recPericulosidade) {
        this.recPericulosidade = recPericulosidade;
    }

    public BigInteger getRecCentrodecusto() {
        return recCentrodecusto;
    }

    public void setRecCentrodecusto(BigInteger recCentrodecusto) {
        this.recCentrodecusto = recCentrodecusto;
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
    public List<RecHabilidade_1> getRecHabilidadeList() {
        return recHabilidadeList;
    }

    public void setRecHabilidadeList(List<RecHabilidade_1> recHabilidadeList) {
        this.recHabilidadeList = recHabilidadeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecExperiencia_1> getRecExperienciaList() {
        return recExperienciaList;
    }

    public void setRecExperienciaList(List<RecExperiencia_1> recExperienciaList) {
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

    public CsbffEscalaHoras getCsbffEscalaHoras() {
        return csbffEscalaHoras;
    }

    public void setCsbffEscalaHoras(CsbffEscalaHoras csbffEscalaHoras) {
        this.csbffEscalaHoras = csbffEscalaHoras;
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

    public CsbffPessoaDependente getCsbffPessoaDependente() {
        return csbffPessoaDependente;
    }

    public void setCsbffPessoaDependente(CsbffPessoaDependente csbffPessoaDependente) {
        this.csbffPessoaDependente = csbffPessoaDependente;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpEventosVariaveis> getFpEventosVariaveisList() {
        return fpEventosVariaveisList;
    }

    public void setFpEventosVariaveisList(List<FpEventosVariaveis> fpEventosVariaveisList) {
        this.fpEventosVariaveisList = fpEventosVariaveisList;
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
    public List<FpHorasTrabalhadas> getFpHorasTrabalhadasList() {
        return fpHorasTrabalhadasList;
    }

    public void setFpHorasTrabalhadasList(List<FpHorasTrabalhadas> fpHorasTrabalhadasList) {
        this.fpHorasTrabalhadasList = fpHorasTrabalhadasList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpFolhasPeriodo> getFpFolhasPeriodoList() {
        return fpFolhasPeriodoList;
    }

    public void setFpFolhasPeriodoList(List<FpFolhasPeriodo> fpFolhasPeriodoList) {
        this.fpFolhasPeriodoList = fpFolhasPeriodoList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recIdpessoa != null ? recIdpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecPessoa_1)) {
            return false;
        }
        RecPessoa_1 other = (RecPessoa_1) object;
        if ((this.recIdpessoa == null && other.recIdpessoa != null) || (this.recIdpessoa != null && !this.recIdpessoa.equals(other.recIdpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.RecPessoa_1[ recIdpessoa=" + recIdpessoa + " ]";
    }
    
}
