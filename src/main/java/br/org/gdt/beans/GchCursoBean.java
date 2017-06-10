package br.org.gdt.beans;

import br.org.gdt.model.GchCursos;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.GchCadastroCursoService;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.cxf.transport.http.HTTPSession;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;
import org.primefaces.context.RequestContext;

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

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Map<String, Object> sessionMap = externalContext.getSessionMap();
    
    
    @ManagedProperty("#{param.cursoID}")
    private String cursoID;

    public String getCursoID() {
        return cursoID;
    }

    public void setCursoID(String cursoID) {
        this.cursoID = cursoID;
    }

    public GchCursoBean() {

//        System.out.println("Id do Curso" + cursoID);

//        gchCurso = buscaPorId(cursoID);
    }
    @PostConstruct
public void init() {
   
    
}

    public String buscaPorId(int idCurso) {


        if (idCurso != 0) {

            gchCurso = gchCursoService.findById(idCurso);

            return "CadastroCurso";

        }

        return null;

    }

    public String save() {

        String MsgNotificacao = "";
        try {
            if (gchCurso.getCurCodigo() > 0) {
                
                gchCurso.setCurDatainclusao(new Date());    
                gchCursoService.update(gchCurso);

                MsgNotificacao = "O curso <b>" + gchCurso.getCurNome() + " </b>foi atualizado!";

            } else {

                gchCurso.setCurDatainclusao(new Date());

                gchCursoService.save(gchCurso);

                MsgNotificacao = "O curso <b>" + gchCurso.getCurNome() + " </b>foi cadastrado!";
            }

            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");

        } catch (Exception ex) {

            MsgNotificacao = "Houve uma falha ao cadastrar o curso <b>" + gchCurso.getCurNome() + "</b> , tente novamente mais tarde!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }
        
        return "Cursos";

    }

    public String cancel() {
        this.formAtivo = false;
        this.gchCurso = new GchCursos();
        return "Cursos";
    }

    public void add() {

        this.formAtivo = true;
        this.gchCurso = new GchCursos();

    }

    public void LancarNotificacao(){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HTTPSession session = (HTTPSession) facesContext.getExternalContext().getSession(true);
        
        String notificacao = (String) session.get("notificacao");
        
        RequestContext.getCurrentInstance().execute("<script>$.notify('"+notificacao+"','success')</script>");
        
    }
    

    
    
    public String excluir(GchCursos gchCurso) {

        String MsgNotificacao = "";

        try {

            GchTreinamentosBean verificaVinculoTreinamento = new GchTreinamentosBean();

            if(gchCurso != null){
    
            FacesContext context = FacesContext.getCurrentInstance();
      
                gchCursoService.delete(gchCurso.getCurCodigo());
                gchTodosCursos.remove(gchCurso);
                MsgNotificacao = "O curso <b> " + gchCurso.getCurNome() + "</b> foi excluído!";
                
                Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "success");
                
            }
            
        } catch (Exception ex) {
            
            
            if(ex.toString().indexOf("fk_rhln8y3gkq5s20aj63saf9234") > 0){
                
                MsgNotificacao = "Este curso está vinculado a um treinamento e não pode ser excluído!";
                
            }else{
            
            MsgNotificacao = "Uma Exceção não tratada impediu a exclusão do curso!";
            
        }

            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
            
        }
        RequestContext.getCurrentInstance().update("formCursos:tabelCursos");
        
        return "Cursos";
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
