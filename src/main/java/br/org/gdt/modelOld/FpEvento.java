package br.org.gdt.modelOld;

import br.org.gdt.model.FpEventosTipoFolha;
import br.org.gdt.model.FpEventosVariaveis;
import br.org.gdt.model.FpFolhasPeriodoEventos;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq_fp_evento", sequenceName = "seq_fp_evento", allocationSize = 1)
@Table(name = "fp_evento")
public class FpEvento implements java.io.Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "eve_id")
    private Integer eveId;
    @Basic(optional = false)
    @Column(name = "eve_eventovariavel")
    private boolean eveEventovariavel;
    @Column(name = "tipo")
    private Short tipo;
    @Basic(optional = false)
    @Column(name = "eveid")
    private long eveid;
    @Basic(optional = false)
    @Column(name = "eveativo")
    private boolean eveativo;
    @Column(name = "evedescricao")
    private String evedescricao;
    @Basic(optional = false)
    @Column(name = "eveeventovariavel")
    private boolean eveeventovariavel;
    @Column(name = "eveformula")
    private String eveformula;
    @Column(name = "evenome")
    private String evenome;
    @OneToMany(mappedBy = "eveIdFpEvento")
    private List<FpEventosTipoFolha> fpEventosTipoFolhaList;
    @OneToMany(mappedBy = "eveIdFpEvento")
    private List<FpEventosVariaveis> fpEventosVariaveisList;
    @OneToMany(mappedBy = "eveIdFpEvento")
    private List<FpFolhasPeriodoEventos> fpFolhasPeriodoEventosList;

    private static final long serialVersionUID = -2790083349568956163L;
    private long eveId;
    private boolean eveEventoVariavel;
    private String eveNome;
    private String eveDescricao;
    private String eveFormula;
    private boolean eveAtivo;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento")
    public long getEveId() {
        return this.eveId;
    }

    public void setEveId(long eveId) {
        this.eveId = eveId;
    }

    public boolean isEveEventoVariavel() {
        return eveEventoVariavel;
    }

    public void setEveEventoVariavel(boolean eveEventoVariavel) {
        this.eveEventoVariavel = eveEventoVariavel;
    }

    public String getEveNome() {
        return eveNome;
    }

    public void setEveNome(String eveNome) {
        this.eveNome = eveNome;
    }

    public String getEveDescricao() {
        return eveDescricao;
    }

    public void setEveDescricao(String eveDescricao) {
        this.eveDescricao = eveDescricao;
    }

    public String getEveFormula() {
        return eveFormula;
    }

    public void setEveFormula(String eveFormula) {
        this.eveFormula = eveFormula;
    }

    public boolean isEveAtivo() {
        return eveAtivo;
    }

    public void setEveAtivo(boolean eveAtivo) {
        this.eveAtivo = eveAtivo;
    }

    public FpEvento() {
    }

    public FpEvento(Integer eveId) {
        this.eveId = eveId;
    }

    public FpEvento(Integer eveId, boolean eveEventovariavel, long eveid, boolean eveativo, boolean eveeventovariavel) {
        this.eveId = eveId;
        this.eveEventovariavel = eveEventovariavel;
        this.eveid = eveid;
        this.eveativo = eveativo;
        this.eveeventovariavel = eveeventovariavel;
    }

    public Integer getEveId() {
        return eveId;
    }

    public void setEveId(Integer eveId) {
        this.eveId = eveId;
    }

    public boolean getEveEventovariavel() {
        return eveEventovariavel;
    }

    public void setEveEventovariavel(boolean eveEventovariavel) {
        this.eveEventovariavel = eveEventovariavel;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public long getEveid() {
        return eveid;
    }

    public void setEveid(long eveid) {
        this.eveid = eveid;
    }

    public boolean getEveativo() {
        return eveativo;
    }

    public void setEveativo(boolean eveativo) {
        this.eveativo = eveativo;
    }

    public String getEvedescricao() {
        return evedescricao;
    }

    public void setEvedescricao(String evedescricao) {
        this.evedescricao = evedescricao;
    }

    public boolean getEveeventovariavel() {
        return eveeventovariavel;
    }

    public void setEveeventovariavel(boolean eveeventovariavel) {
        this.eveeventovariavel = eveeventovariavel;
    }

    public String getEveformula() {
        return eveformula;
    }

    public void setEveformula(String eveformula) {
        this.eveformula = eveformula;
    }

    public String getEvenome() {
        return evenome;
    }

    public void setEvenome(String evenome) {
        this.evenome = evenome;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpEventosTipoFolha> getFpEventosTipoFolhaList() {
        return fpEventosTipoFolhaList;
    }

    public void setFpEventosTipoFolhaList(List<FpEventosTipoFolha> fpEventosTipoFolhaList) {
        this.fpEventosTipoFolhaList = fpEventosTipoFolhaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpEventosVariaveis> getFpEventosVariaveisList() {
        return fpEventosVariaveisList;
    }

    public void setFpEventosVariaveisList(List<FpEventosVariaveis> fpEventosVariaveisList) {
        this.fpEventosVariaveisList = fpEventosVariaveisList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpFolhasPeriodoEventos> getFpFolhasPeriodoEventosList() {
        return fpFolhasPeriodoEventosList;
    }

    public void setFpFolhasPeriodoEventosList(List<FpFolhasPeriodoEventos> fpFolhasPeriodoEventosList) {
        this.fpFolhasPeriodoEventosList = fpFolhasPeriodoEventosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eveId != null ? eveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpEvento)) {
            return false;
        }
        FpEvento other = (FpEvento) object;
        if ((this.eveId == null && other.eveId != null) || (this.eveId != null && !this.eveId.equals(other.eveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpEvento[ eveId=" + eveId + " ]";
    }

}
