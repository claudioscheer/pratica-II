/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchFormulario;
import br.org.gdt.model.GchPerguntas;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import br.org.gdt.service.GchFormularioService;
import br.org.gdt.service.GchPerguntasService;
import br.org.gdt.service.GchRespostasService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class GchRespostaFormulario {

    private GchFormulario gchFormulario;
    private List<GchPerguntas> gchPerguntas;
    private List<GchAlternativas> gchAlternativas;

    @ManagedProperty("#{gchFormularioService}")
    private GchFormularioService gchFormularioService;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;

    @ManagedProperty("#{gchPerguntaService}")
    private GchPerguntasService gchPerguntasService;

    @ManagedProperty("#{gchRespostaService}")
    private GchRespostasService gchRespostasService;

    public GchRespostaFormulario(GchFormulario gchFormulario, List<GchPerguntas> gchPerguntas, List<GchAlternativas> gchAlternativas) {
        this.gchFormulario = gchFormulario;
        this.gchPerguntas = gchPerguntas;
        this.gchAlternativas = gchAlternativas;
    }

    public GchFormulario getGchFormulario() {
        return gchFormulario;
    }

    public void setGchFormulario(GchFormulario gchFormulario) {
        this.gchFormulario = gchFormulario;
    }

    public List<GchPerguntas> getGchPerguntas() {
        if (this.gchPerguntas == null) {

           gchPerguntas = gchPerguntasService.buscaPergutasFormulario(1);

        }

        return gchPerguntas;

    }

    public void setGchPerguntas(List<GchPerguntas> gchPerguntas) {

        this.gchPerguntas = gchPerguntas;

    }

    public List<GchAlternativas> getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(List<GchAlternativas> gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

}
