
package br.org.gdt.modelOld;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_selecao", sequenceName = "seq_selecao", allocationSize = 1)
public class RecSelecao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_selecao")
    private int sel_id;
    private String sel_descricaoentrevista;
    private boolean sel_aprovado;
    @OneToOne
    private RecPessoa sel_pessoa;    
    @ManyToOne
    private RecVaga sel_vaga;

    public int getSel_id() {
        return sel_id;
    }

    public void setSel_id(int sel_id) {
        this.sel_id = sel_id;
    }

    public String getSel_descricaoentrevista() {
        return sel_descricaoentrevista;
    }

    public void setSel_descricaoentrevista(String sel_descricaoentrevista) {
        this.sel_descricaoentrevista = sel_descricaoentrevista;
    }

    public boolean isSel_aprovado() {
        return sel_aprovado;
    }

    public void setSel_aprovado(boolean sel_aprovado) {
        this.sel_aprovado = sel_aprovado;
    }

    public RecPessoa getSel_pessoa() {
        return sel_pessoa;
    }

    public void setSel_pessoa(RecPessoa sel_pessoa) {
        this.sel_pessoa = sel_pessoa;
    }

    public RecVaga getSel_vaga() {
        return sel_vaga;
    }

    public void setSel_vaga(RecVaga sel_vaga) {
        this.sel_vaga = sel_vaga;
    }


    
}
