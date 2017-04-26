package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.service.GchCadastroCursoService;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;




@ManagedBean
public class GchCursoBean {
     private boolean formAtivo = false;
 
    private GchCursos gchCurso = new GchCursos();
    private List<GchCursos> gchListaCursos;
    
    @ManagedProperty("#{servicoCurso}")
   
    private GchCadastroCursoService gchCursoService;

    public GchCursoBean(){
    
    
    
}

    public void test(){
        
        System.console().writer().print("Oiiiiiiiii");
        
    }
    
    
  public void save() {
       
      
      
      System.out.println("Entrouuuu"+gchCurso.getCurNome());
      
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
        
        
        save();
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

    public GchCadastroCursoService getCursoService() {
        return gchCursoService;
    }

    public void setCursoService(GchCadastroCursoService gchCursoService) {
        this.gchCursoService = gchCursoService;
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

    public GchCadastroCursoService getGchCursoService() {
        return gchCursoService;
    }

    public void setGchCursoService(GchCadastroCursoService gchCursoService) {
        this.gchCursoService = gchCursoService;
    }

}
