/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.service.GchTreinamentoPessoaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@RequestScoped
public class GchTreinamentoPessoaBean {

    private boolean formAtivo = false;

    private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
    
    private GchTreinamentospessoas gchTreinamentospessoas = new GchTreinamentospessoas();
    private List<GchTreinamentospessoas> todosGchTreinamentosPessoas;

    @ManagedProperty("#{gchTreinamentoPessoaService}")
    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    public void save() {

//        if (gchTreinamentos.getTreiCodigo() > 0) {
//            gchTreinamentosService.update(gchTreinamentos);
//        } else {
        gchTreinamentospessoasService.save(gchTreinamentospessoas);
//        }
        todosGchTreinamentosPessoas = gchTreinamentospessoasService.findAll();
        this.formAtivo = false;
    }

    public void cancel() {
        this.formAtivo = false;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();
    }

    public void add() {
        System.out.println("Aqui tambem ta tretando");
        this.formAtivo = true;
        this.gchTreinamentospessoas = new GchTreinamentospessoas();
    }

    public String excluir(GchTreinamentospessoas gchTreinamentosPessoas) {
        gchTreinamentospessoasService.delete(gchTreinamentosPessoas.getTreiPescodigo());
        todosGchTreinamentosPessoas.remove(gchTreinamentosPessoas);
        return "treinamentos";
    }

    public String prepareEdit(GchTreinamentos gchTreinamentos) {
        this.formAtivo = true;
        this.gchTreinamentospessoas.setTreiCodigo(gchTreinamentos); 
        return "VincularPessoasTreinamento";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public GchTreinamentospessoas getGchTreinamentospessoas() {
        return gchTreinamentospessoas;
    }

    public void setGchTreinamentospessoas(GchTreinamentospessoas gchTreinamentospessoas) {
        this.gchTreinamentospessoas = gchTreinamentospessoas;
    }

    public List<GchTreinamentospessoas> getTodosGchTreinamentosPessoas() {
        return todosGchTreinamentosPessoas;
    }

    public void setTodosGchTreinamentosPessoas(List<GchTreinamentospessoas> todosGchTreinamentosPessoas) {
        this.todosGchTreinamentosPessoas = todosGchTreinamentosPessoas;
    }

    public GchTreinamentoPessoaService getGchTreinamentospessoasService() {
        return gchTreinamentospessoasService;
    }

    public void setGchTreinamentospessoasService(GchTreinamentoPessoaService gchTreinamentospessoasService) {
        this.gchTreinamentospessoasService = gchTreinamentospessoasService;
    }

    public Map<Long, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Long, Boolean> checked) {
        this.checked = checked;
    }

}