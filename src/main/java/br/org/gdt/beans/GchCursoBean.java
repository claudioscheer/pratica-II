package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchCadastroCursoService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
    
     @ManagedProperty("#{param.cursoID}")
     private String cursoID;

    public String getCursoID() {
        return cursoID;
    }

    public void setCursoID(String cursoID) {
        this.cursoID = cursoID;
    }
    
    
    public GchCursoBean() {
        
        System.out.println("Id do Curso"+cursoID);
        
//        gchCurso = buscaPorId(cursoID);
        
    }

    public String buscaPorId(int idCurso) {

        System.out.println("Id do curso"+idCurso);
        
        if(idCurso != 0){
           
         gchCurso = gchCursoService.findById(idCurso);
            
         return "CadastroCurso";
         
        }
        
        return null;
        
    }

    public void save() {

        String MsgNotificacao = "";

        gchCurso.setCurDatainclusao(new Date());

        try {
            if (gchCurso.getCurCodigo() > 0) {

                gchCursoService.update(gchCurso);

                MsgNotificacao = "O curso " + gchCurso.getCurNome() + " foi atualizado com sucesso!";

            } else {

                gchCursoService.save(gchCurso);

                MsgNotificacao = "O curso " + gchCurso.getCurNome() + " foi cadastrado com sucesso!";
            }
            
             Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

        } catch (Exception ex) {

            MsgNotificacao = "Houve uma falha ao cadastrar o curso "+gchCurso.getCurNome()+" , tente novamente mais tarde!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
       
        return;

//        gchTodosCursos = gchCursoService.findAll();
//        this.formAtivo = false;
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
        return "Cursos.xhtml";
    }

    public String prepareEdit(GchCursos gchCurso) {
        this.gchCurso = gchCurso;
       return "CadastroPlanoCarreira?faces-redirect=true";
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
