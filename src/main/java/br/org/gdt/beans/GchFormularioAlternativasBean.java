/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.GchAlternativas;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
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
 * @author Alisson Allebrandt
 */
@ManagedBean
@SessionScoped
public class GchFormularioAlternativasBean {

    private boolean formAtivo = false;

    private Map<GchAlternativas, Boolean> checked = new HashMap<GchAlternativas, Boolean>();

    private List<GchAlternativas> alternativasVinculadas = new ArrayList<>();

    private GchAlternativas gchalternativas = new GchAlternativas();
//    private List<GchTreinamentospessoas> todosGchTreinamentosPessoas;

    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;
//
//    @ManagedProperty("#{gchTreinamentoPessoaService}")
//    private GchTreinamentoPessoaService gchTreinamentospessoasService;

    public GchFormularioAlternativasBean() {

    }


    
    public void addAlternativa(GchAlternativas alternativa) {

        if (alternativasVinculadas.contains(alternativa)) {

            alternativasVinculadas.remove(alternativa);

        } else {

            alternativasVinculadas.add(alternativa);

        }

        for (int i = 0; i < alternativasVinculadas.size(); i++) {
            
            System.out.println("Alternativa"+alternativasVinculadas.get(i).getAltDescricao());
            
        }
        
    }

    public void save() {

//        if (gchTreinamentos.getTreiCodigo() > 0) {
//            gchTreinamentosService.update(gchTreinamentos);
//        } else {
//        System.out.println("Teste teste: " + gchTreinamentospessoas.getTreiCodigo().getTreiNome());
        System.out.println("Entrou no método salvar");

        Iterator<GchAlternativas> keyIterrator = checked.keySet().iterator();

        while (keyIterrator.hasNext()) {

            GchAlternativas alternativa = keyIterrator.next();
            Boolean value = checked.get(alternativa);

            System.out.println(alternativa.getAltDescricao() + " - " + value);

            if (value) {

                System.out.println("valor marcado iterator" + value);

//                gchTreinamentospessoas.setRecIdpessoa(pessoa);
//
//                gchTreinamentospessoasService.save(gchTreinamentospessoas);
            }

        }
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public Map<GchAlternativas, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<GchAlternativas, Boolean> checked) {
        this.checked = checked;
    }

    public List<GchAlternativas> getAlternativasVinculadas() {
        return alternativasVinculadas;
    }

    public void setAlternativasVinculadas(List<GchAlternativas> alternativasVinculadas) {
        this.alternativasVinculadas = alternativasVinculadas;
    }

    public GchAlternativas getGchalternativas() {
        return gchalternativas;
    }

    public void setGchalternativas(GchAlternativas gchalternativas) {
        this.gchalternativas = gchalternativas;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }
}
