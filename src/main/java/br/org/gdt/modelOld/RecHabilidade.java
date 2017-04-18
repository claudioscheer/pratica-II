/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.modelOld;

import br.org.gdt.enums.HabilidadeNivel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_habilidade", sequenceName = "seq_habilidade", allocationSize = 1)
public class RecHabilidade implements Serializable {

    @ManyToMany(mappedBy = "vag_habilidades")
    private List<RecVaga> recVagas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habilidade")
    private int hab_id;
    private String hab_descricao;
    private HabilidadeNivel habilidadeNivel;
    @ManyToMany(mappedBy = "habilidades")
    private List<RecPessoa> recPessoas;

    public int getHab_id() {
        return hab_id;
    }

    public void setHab_id(int hab_id) {
        this.hab_id = hab_id;
    }

    public String getHab_descricao() {
        return hab_descricao;
    }

    public void setHab_descricao(String hab_descricao) {
        this.hab_descricao = hab_descricao;
    }

    public HabilidadeNivel getHabilidadeNivel() {
        return habilidadeNivel;
    }

    public void setHabilidadeNivel(HabilidadeNivel habilidadeNivel) {
        this.habilidadeNivel = habilidadeNivel;
    }
}
