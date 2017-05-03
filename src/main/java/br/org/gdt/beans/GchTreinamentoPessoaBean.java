/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchTreinamentos;
import br.org.gdt.model.GchTreinamentospessoas;
import br.org.gdt.model.RecPessoa;
import br.org.gdt.service.GchTreinamentoPessoaService;
import br.org.gdt.service.GchTreinamentosService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class GchTreinamentoPessoaBean {

    private boolean formAtivo = false;

    private Map<RecPessoa, Boolean> checked = new HashMap<RecPessoa, Boolean>();

    private List<RecPessoa> pessoasVinculadas = new ArrayList<>();

    private GchTreinamentospessoas gchTreinamentospessoas = new GchTreinamentospessoas();
    private List<GchTreinamentospessoas> todosGchTreinamentosPessoas;

    @ManagedProperty("#{gchTreinamentosService}")
    private GchTreinamentosService gchTreinamentosService;

    @ManagedProperty("#{gchTreinamentoPessoaService}")
    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    public void save() {

//        if (gchTreinamentos.getTreiCodigo() > 0) {
//            gchTreinamentosService.update(gchTreinamentos);
//        } else {
        System.out.println("tyfytfy");

        gchTreinamentospessoas.setTreiCodigo(gchTreinamentosService.findById(1));

        Iterator<RecPessoa> keyIterrator = checked.keySet().iterator();

        while (keyIterrator.hasNext()) {

            RecPessoa pessoa = keyIterrator.next();
            Boolean value = checked.get(pessoa);

            System.out.println(pessoa.getRecNomecompleto() + " - " + value);

            
            if (value) {
                
                gchTreinamentospessoas.setRecIdpessoa(pessoa);
                
                gchTreinamentospessoasService.save(gchTreinamentospessoas);
            }
        }

//        System.out.println("Salvar: " + pessoasVinculadas.get(0).getRecNomecompleto());
//        gchTreinamentospessoas.setRecIdpessoa(pessoasVinculadas.get(0));
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

    public void adicionaPessoa(RecPessoa recPessoa) {

        if (recPessoa.getRecIdpessoa() == 0) {
            return;
        }

        pessoasVinculadas.add(recPessoa);

    }

    public String prepareEdit(GchTreinamentos gchTreinamentos) {
        this.formAtivo = true;

        this.gchTreinamentospessoas.setTreiCodigo(gchTreinamentos);

        return "VincularPessoasTreinamento";
    }

//     public String buscaTreinamentoPorId(long id) {
//
//        System.out.println("Id Treinamento" + id);
//
//        if (id != 0) {
//
//            gchTreinamentospessoas.setTreiCodigo(gchTreinamentosService.findById(id));
//
//            return "VincularPessoasTreinamento";
//
//        }
//        return null;
//    }
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

    public Map<RecPessoa, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<RecPessoa, Boolean> checked) {
        this.checked = checked;
    }

    public List<RecPessoa> getPessoasVinculadas() {
        return pessoasVinculadas;
    }

    public void setPessoasVinculadas(List<RecPessoa> pessoasVinculadas) {
        this.pessoasVinculadas = pessoasVinculadas;
    }

    public GchTreinamentosService getGchTreinamentosService() {
        return gchTreinamentosService;
    }

    public void setGchTreinamentosService(GchTreinamentosService gchTreinamentosService) {
        this.gchTreinamentosService = gchTreinamentosService;
    }

}
