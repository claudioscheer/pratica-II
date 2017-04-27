package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.service.GchCadastroCursoService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
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

        System.out.println("Caiu no teste");
 
        
        if(gchCurso.getCurCodigo() > 0){
            
            
            
        }
//            
//            System.out.println("Update");
//            
//        }else{
//            
//            System.out.println("Create new");
//            
//        }

    }

    public void save() {

        gchCurso.setCurDatainclusao(new Date());
//        gchCurso.setCurCodigo(Long.parseLong("0"));
        System.out.println("Entrou no metodo salvar");
        
        
        if (gchCurso.getCurCodigo() > 0) {

            gchCursoService.update(gchCurso);
            
            
            
        } else {
            
            if(gchCurso == null){
                
                System.out.println("Tá nulllllllll");
                
            }else{
                
                
                System.out.println("Nao ta nullllll");
            }
            
            gchCursoService.save(gchCurso);
        }
//        gchTodosCursos = gchCursoService.findAll();
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
