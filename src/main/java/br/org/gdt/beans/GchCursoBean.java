package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.service.GchCadastroCursoService;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Diego
 */
@ManagedBean

@RequestScoped

public class GchCursoBean {

    private boolean formAtivo = false;

    private GchCursos gchCurso = new GchCursos();
    private List<GchCursos> gchTodosCursos;

    @ManagedProperty("#{gchCadastroCursoService}")
    private GchCadastroCursoService gchCursoService;

    public GchCursoBean() {

    }

    public void test() {

        System.console().writer().print("Oiiiiiiiii");

    }

    public void save() {

        System.out.println("Entrouuuu" + gchCurso.getCurNome());

        if (gchCurso.getCurCodigo() > 0) {

            gchCursoService.update(gchCurso);
        } else {
            gchCursoService.save(gchCurso);
        }
        gchTodosCursos = gchCursoService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchCurso = new GchCursos();
    }

    public void add() {

        this.formAtivo = true;
        this.gchCurso = new GchCursos();

        save();
    }

    public String excluir(GchCursos gchCurso) {
        gchCursoService.delete(gchCurso.getCurCodigo());
        gchTodosCursos.remove(gchCurso);
        return "eventos";
    }

    public String prepareEdit(GchCursos gchCurso) {
        this.formAtivo = true;
        this.gchCurso = gchCurso;
        return "eventos";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchCursos getGchCurso() {
        return gchCurso;
    }

    public void setGchCurso(GchCursos gchCurso) {
        this.gchCurso = gchCurso;
    }

    public List<GchCursos> getGchTodosCursos() {

        if (gchTodosCursos == null) {

            gchTodosCursos = gchCursoService.findAll();

        }

        return gchTodosCursos;
    }

    public void setGchTodosCursos(List<GchCursos> gchTodosCursos) {
        this.gchTodosCursos = gchTodosCursos;
    }

    public GchCadastroCursoService getGchCursoService() {
        return gchCursoService;
    }

    public void setGchCursoService(GchCadastroCursoService gchCursoService) {
        this.gchCursoService = gchCursoService;
    }

}
