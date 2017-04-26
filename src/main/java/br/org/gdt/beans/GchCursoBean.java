package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.service.GchCursoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GchCursoBean {

    
    private boolean formAtivo = false;

    private GchCursos gchCurso = new GchCursos();
    private List<GchCursos> gchListaCursos;

    @ManagedProperty("#{gchCursoService}")
    private GchCursoService gchCursoService;

    public GchCursoBean() {

    }

    public void save() {
        if (gchCurso.getCurCodigo() > 0) {
            gchCursoService.update(gchCurso);
        } else {
            gchCursoService.save(gchCurso);
        }
        gchListaCursos = gchCursoService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchCurso = new GchCursos();
    }

    public void add() {
        this.formAtivo = true;
        this.gchCurso = new GchCursos();
    }

    public String excluir(GchCursos gchCurso) {
        gchCursoService.delete(gchCurso.getCurCodigo());
        gchListaCursos.remove(gchCurso);
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

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public GchCursos getGchCurso() {
        return gchCurso;
    }

    public void setGchCurso(GchCursos gchCurso) {
        this.gchCurso = gchCurso;
    }

    public List<GchCursos> getGchListaCursos() {
        return gchListaCursos;
    }

    public void setGchListaCursos(List<GchCursos> gchListaCursos) {
        this.gchListaCursos = gchListaCursos;
    }

    public GchCursoService getGchCursoService() {
        return gchCursoService;
    }

    public void setGchCursoService(GchCursoService gchCursoService) {
        this.gchCursoService = gchCursoService;
    }

}
