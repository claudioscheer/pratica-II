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

    public GchCursoBean(){
    
    
    
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
    
    
    
    public GchCursos getCurso() {
        return gchCurso;
    }

    public void setCurso(GchCursos gchCurso) {
        this.gchCurso = gchCurso;
    }

    public List<GchCursos> getTodosCursos() {
        if (gchListaCursos == null) {
            gchListaCursos = gchCursoService.findAll();
        }
        return gchListaCursos;
    }

    public void setTodosCursos(List<GchCursos> gchListaCursos) {
        this.gchListaCursos = gchListaCursos;
    }

    public GchCursoService getCursoService() {
        return gchCursoService;
    }

    public void setCursoService(GchCursoService gchCursoService) {
        this.gchCursoService = gchCursoService;
    }

}
