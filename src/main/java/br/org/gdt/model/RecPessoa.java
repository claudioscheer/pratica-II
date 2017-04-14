
package br.org.gdt.model;

import br.org.gdt.enums.EstadoCivil;
import br.org.gdt.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
public class RecPessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private int                     pes_id;
    private String                  pes_nomecompleto;
    private String                  pes_cpf;
    private Sexo                    pes_sexo;
    private EstadoCivil             pes_estadocivil;
    private String                  pes_rg;
    private String                  pes_orgaoemissor;
    @Temporal(TemporalType.DATE)
    private Date                    pes_dataemissao;
    private String                  pes_nomepai;
    private String                  pes_nomemae;
    @Temporal(TemporalType.DATE)
    private Date                    pes_dtnascimento;
    private String                  pes_email;
    private String                  pes_celular;
    private String                  pes_telefone;
    private String                  pes_objprofissional;
    private String                  pes_autoavaliacao;
    private String                  pes_pretencaosalarial;
    private String                  pes_foto;
    private String                  pes_pispasep;
    private String                  pes_reservista;
    private String                  pes_endereco;
    private String                  pes_bairro;
    private String                  pes_numero;
    private String                  pes_cor;
    private String                  pes_cidade;
    private boolean                 pes_funcionario;
    @ManyToMany
    private List<RecExperiencia>    experiencias;    
    @ManyToMany
    private List<RecHabilidade>     habilidades;

    public List<RecHabilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<RecHabilidade> habilidades) {
        this.habilidades = habilidades;
    }
    
    public int getPes_id() {
        return pes_id;
    }

    public void setPes_id(int pes_id) {
        this.pes_id = pes_id;
    }

    public String getPes_nomecompleto() {
        return pes_nomecompleto;
    }

    public void setPes_nomecompleto(String pes_nomecompleto) {
        this.pes_nomecompleto = pes_nomecompleto;
    }

    public String getPes_cpf() {
        return pes_cpf;
    }

    public void setPes_cpf(String pes_cpf) {
        this.pes_cpf = pes_cpf;
    }

    public Sexo getPes_sexo() {
        return pes_sexo;
    }

    public void setPes_sexo(Sexo pes_sexo) {
        this.pes_sexo = pes_sexo;
    }

    public EstadoCivil getPes_estadocivil() {
        return pes_estadocivil;
    }

    public void setPes_estadocivil(EstadoCivil pes_estadocivil) {
        this.pes_estadocivil = pes_estadocivil;
    }

    public String getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(String pes_rg) {
        this.pes_rg = pes_rg;
    }

    public String getPes_orgaoemissor() {
        return pes_orgaoemissor;
    }

    public void setPes_orgaoemissor(String pes_orgaoemissor) {
        this.pes_orgaoemissor = pes_orgaoemissor;
    }

    public Date getPes_dataemissao() {
        return pes_dataemissao;
    }

    public void setPes_dataemissao(Date pes_dataemissao) {
        this.pes_dataemissao = pes_dataemissao;
    }

    public String getPes_nomepai() {
        return pes_nomepai;
    }

    public void setPes_nomepai(String pes_nomepai) {
        this.pes_nomepai = pes_nomepai;
    }

    public String getPes_nomemae() {
        return pes_nomemae;
    }

    public void setPes_nomemae(String pes_nomemae) {
        this.pes_nomemae = pes_nomemae;
    }

    public Date getPes_dtnascimento() {
        return pes_dtnascimento;
    }

    public void setPes_dtnascimento(Date pes_dtnascimento) {
        this.pes_dtnascimento = pes_dtnascimento;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public String getPes_celular() {
        return pes_celular;
    }

    public void setPes_celular(String pes_celular) {
        this.pes_celular = pes_celular;
    }

    public String getPes_telefone() {
        return pes_telefone;
    }

    public void setPes_telefone(String pes_telefone) {
        this.pes_telefone = pes_telefone;
    }

    public String getPes_objprofissional() {
        return pes_objprofissional;
    }

    public void setPes_objprofissional(String pes_objprofissional) {
        this.pes_objprofissional = pes_objprofissional;
    }

    public String getPes_autoavaliacao() {
        return pes_autoavaliacao;
    }

    public void setPes_autoavaliacao(String pes_autoavaliacao) {
        this.pes_autoavaliacao = pes_autoavaliacao;
    }

    public String getPes_pretencaosalarial() {
        return pes_pretencaosalarial;
    }

    public void setPes_pretencaosalarial(String pes_pretencaosalarial) {
        this.pes_pretencaosalarial = pes_pretencaosalarial;
    }

    public String getPes_foto() {
        return pes_foto;
    }

    public void setPes_foto(String pes_foto) {
        this.pes_foto = pes_foto;
    }

    public String getPes_pispasep() {
        return pes_pispasep;
    }

    public void setPes_pispasep(String pes_pispasep) {
        this.pes_pispasep = pes_pispasep;
    }

    public String getPes_reservista() {
        return pes_reservista;
    }

    public void setPes_reservista(String pes_reservista) {
        this.pes_reservista = pes_reservista;
    }

    public String getPes_endereco() {
        return pes_endereco;
    }

    public void setPes_endereco(String pes_endereco) {
        this.pes_endereco = pes_endereco;
    }

    public String getPes_bairro() {
        return pes_bairro;
    }

    public void setPes_bairro(String pes_bairro) {
        this.pes_bairro = pes_bairro;
    }

    public String getPes_numero() {
        return pes_numero;
    }

    public void setPes_numero(String pes_numero) {
        this.pes_numero = pes_numero;
    }

    public String getPes_cor() {
        return pes_cor;
    }

    public void setPes_cor(String pes_cor) {
        this.pes_cor = pes_cor;
    }

    public String getPes_cidade() {
        return pes_cidade;
    }

    public void setPes_cidade(String pes_cidade) {
        this.pes_cidade = pes_cidade;
    }

    public boolean isPes_funcionario() {
        return pes_funcionario;
    }

    public void setPes_funcionario(boolean pes_funcionario) {
        this.pes_funcionario = pes_funcionario;
    }

    public List<RecExperiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<RecExperiencia> experiencias) {
        this.experiencias = experiencias;
    }
}
