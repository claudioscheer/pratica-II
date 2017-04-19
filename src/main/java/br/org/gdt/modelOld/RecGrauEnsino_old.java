package br.org.gdt.modelOld;

import br.org.gdt.enums.GrauEnsinoSituacao;
import br.org.gdt.enums.GrauEnsinoTipo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_grauensino", sequenceName = "seq_grauensino", allocationSize = 1)
public class RecGrauEnsino_old implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grauensino")
    private int                 gre_id;
    private GrauEnsinoTipo      gre_grauensinotipo;
    private GrauEnsinoSituacao  gre_grauensinosituacao;
    private String              gre_instituicao;
    @Temporal(TemporalType.DATE)
    private Date                gre_anoinicio;
    @Temporal(TemporalType.DATE)
    private Date                gre_anoconclusao;

    public int getGre_id() {
        return gre_id;
    }

    public void setGre_id(int gre_id) {
        this.gre_id = gre_id;
    }

    public GrauEnsinoTipo getGre_grauensinotipo() {
        return gre_grauensinotipo;
    }

    public void setGre_grauensinotipo(GrauEnsinoTipo gre_grauensinotipo) {
        this.gre_grauensinotipo = gre_grauensinotipo;
    }

    public GrauEnsinoSituacao getGre_grauensinosituacao() {
        return gre_grauensinosituacao;
    }

    public void setGre_grauensinosituacao(GrauEnsinoSituacao gre_grauensinosituacao) {
        this.gre_grauensinosituacao = gre_grauensinosituacao;
    }

    public String getGre_instituicao() {
        return gre_instituicao;
    }

    public void setGre_instituicao(String gre_instituicao) {
        this.gre_instituicao = gre_instituicao;
    }

    public Date getGre_anoinicio() {
        return gre_anoinicio;
    }

    public void setGre_anoinicio(Date gre_anoinicio) {
        this.gre_anoinicio = gre_anoinicio;
    }

    public Date getGre_anoconclusao() {
        return gre_anoconclusao;
    }

    public void setGre_anoconclusao(Date gre_anoconclusao) {
        this.gre_anoconclusao = gre_anoconclusao;
    }            
}
