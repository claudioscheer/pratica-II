/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffCargos;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.resources.Helper;
import br.org.gdt.service.CsbffCargosService;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@RequestScoped
public class cargosBean {

    private boolean formAtivo = false;

    private CsbffCargos csbffcargos = new CsbffCargos();
    private List<CsbffCargos> todosCargos;

    @ManagedProperty("#{csbffCargosService}")
    private CsbffCargosService csbffCargosService;

    private RecPessoa recPessoa;
    
    
    public cargosBean() {
        
        
    }
    
    public String salvar() {

        String MsgNotificacao = "testando isso aqui";
        try {
            if (csbffcargos.getCargoCodigo() > 0) {

                csbffCargosService.update(csbffcargos);
                novo();

                System.out.println("******teste de código" + csbffcargos);
                MsgNotificacao = "O cargo " + csbffcargos.getCargoNome() + " foi atualizado com sucesso!";

            } else {

             novo();

        System.out.println("******teste de código" + csbffcargos);
                csbffCargosService.save(csbffcargos);
                

                MsgNotificacao = "O cargo " + csbffcargos.getCargoNome() + " foi cadastrado com sucesso!";
            }

            Helper.mostrarNotificacao("Sucesso", MsgNotificacao, "sucess");

        } catch (Exception ex) {

            MsgNotificacao = "Houve uma falha ao cadastrar o cargo " + csbffcargos.getCargoNome() + ex.getMessage() + " , tente novamente mais tarde!";
            Helper.mostrarNotificacao("Erro", MsgNotificacao, "error");
        }

        return "Cargos";

//        gchTodosCursos = gchCursoService.findAll();
//        this.formAtivo = false;
    }
    
        
    
    public void save() {
        
        System.out.println("teste teste");
        csbffcargos.setCargoCodigoSuperior(BigInteger.valueOf(1));
        csbffcargos.setCargoDataDeCriacao(new Date());
        csbffcargos.setCargoDataUltimaAlteracao(new Date());
        csbffCargosService.save(csbffcargos);

    }
    public String novo(){
       
        save();
        csbffcargos = new CsbffCargos();
        return "form_cargo";
        
        
    }
    
    public String buscaPorId(int idcargo) {

        System.out.println("Id do curso" + idcargo);

        if (idcargo != 0) {

            csbffcargos = csbffCargosService.findById(idcargo);
        }
            return "form_cargo";

        }
    
    
    
    
    

    public void cancel() {
        this.formAtivo = false;
        this.csbffcargos = new CsbffCargos();
    }

    public void add() {
        this.formAtivo = true;
        this.csbffcargos = new CsbffCargos();
    }

    public String excluir(CsbffCargos cargos) {
        csbffCargosService.delete(cargos.getCargoCodigo());
        todosCargos.remove(cargos);
        return "cargos";
    }
 
    public String prepareEdit(CsbffCargos cargos) {
        this.formAtivo = true;
        this.csbffcargos = cargos;
        return "cargos";
    }

    public CsbffCargos getCargoCodigo(){
        
        return csbffcargos;
    }
    
    
    public void setCargoCodigo(CsbffCargos cargos) {
        this.csbffcargos = cargos;
    }

    

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffCargos getCsbffcargos() {
        return csbffcargos;
    }

    public void setCsbffcargos(CsbffCargos csbffcargos) {
        this.csbffcargos = csbffcargos;
    }

    public List<CsbffCargos> getTodosCargos() {
        if (todosCargos == null) {
            todosCargos = csbffCargosService.findAll();
        }
        return todosCargos;
    }

    public void setTodosCargos(List<CsbffCargos> todosCargos) {
        this.todosCargos = todosCargos;
    }

    public CsbffCargosService getCsbffCargosService() {
        return csbffCargosService;
    }

    public void setCsbffCargosService(CsbffCargosService csbffCargosService) {
        this.csbffCargosService = csbffCargosService;
    }

    public RecPessoa getRecPessoa() {
        return recPessoa;
    }

    public void setRecPessoa(RecPessoa recPessoa) {
        this.recPessoa = recPessoa;
    }
}
