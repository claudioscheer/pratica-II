/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchPerguntas;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alisson Allebrandt
 */
public class PerguntasAlternativas {
    
    private List<GchAlternativas> alternativas; 
    private GchPerguntas pergunta;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.alternativas);
        hash = 11 * hash + Objects.hashCode(this.pergunta);
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
        final PerguntasAlternativas other = (PerguntasAlternativas) obj;
        if (!Objects.equals(this.alternativas, other.alternativas)) {
            return false;
        }
        if (!Objects.equals(this.pergunta, other.pergunta)) {
            return false;
        }
        return true;
    }

    public List<GchAlternativas> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<GchAlternativas> alternativas) {
        this.alternativas = alternativas;
    }

    public GchPerguntas getPergunta() {
        return pergunta;
    }

    public void setPergunta(GchPerguntas pergunta) {
        this.pergunta = pergunta;
    }
    
    
    
}
