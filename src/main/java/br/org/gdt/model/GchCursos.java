/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "gch_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchCursos.findAll", query = "SELECT g FROM GchCursos g")})
@SequenceGenerator(name = "seq_gch_curso", sequenceName = "seq_gch_curso", allocationSize = 1)
public class GchCursos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_curso")
    @Basic(optional = false)
    @Column(name = "cur_codigo")
    private long curCodigo;
    @Basic(optional = false)
    @Column(name = "cur_nome")
    private String curNome;
    @Basic(optional = false)
    @Column(name = "cur_descricao")
    private String curDescricao;
    @Basic(optional = false)
    @Column(name = "cur_datainclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date curDatainclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curCodigo")
    private List<GchTreinamentos> gchTreinamentosList;
    @Basic(optional = false)
    @Column(name = "cur_nome_palestrante")
    private String curNomePalestrante;
     @Basic(optional = false)
    @Column(name = "cur_email_palestrante")
    private String curEmailPalestrante;

    public GchCursos() {
    }

    public GchCursos(long curCodigo, String curNome, String curDescricao, Date curDatainclusao, List<GchTreinamentos> gchTreinamentosList, String curNomePalestrante, String curEmailPalestrante) {
        this.curCodigo = curCodigo;
        this.curNome = curNome;
        this.curDescricao = curDescricao;
        this.curDatainclusao = curDatainclusao;
        this.gchTreinamentosList = gchTreinamentosList;
        this.curNomePalestrante = curNomePalestrante;
        this.curEmailPalestrante = curEmailPalestrante;
    }

   
  
    public long getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(long curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurNome() {
        return curNome;
    }

    public void setCurNome(String curNome) {
        this.curNome = curNome;
    }

    public String getCurDescricao() {
        return curDescricao;
    }

    public void setCurDescricao(String curDescricao) {
        this.curDescricao = curDescricao;
    }

    public Date getCurDatainclusao() {
        return curDatainclusao;
    }

    public void setCurDatainclusao(Date curDatainclusao) {
        this.curDatainclusao = curDatainclusao;
    }
    
    public String getCurNomePalestrante() {
        return curNomePalestrante;
    }

    public void setCurNomePalestrante(String curNomePalestrante) {
        this.curNomePalestrante = curNomePalestrante;
    }

    public String getCurEmailPalestrante() {
        return curEmailPalestrante;
    }

    public void setCurEmailPalestrante(String curEmailPalestrante) {
        this.curEmailPalestrante = curEmailPalestrante;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchTreinamentos> getGchTreinamentosList() {
        return gchTreinamentosList;
    }

    public void setGchTreinamentosList(List<GchTreinamentos> gchTreinamentosList) {
        this.gchTreinamentosList = gchTreinamentosList;
    }
    
    


    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchCursos[ curCodigo=" + curCodigo + " ]";
    }


    
}
