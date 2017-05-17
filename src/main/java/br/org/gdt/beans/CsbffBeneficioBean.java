package br.org.gdt.beans;

import br.org.gdt.enums.AbrangenciaBeneficio;
import br.org.gdt.enums.TipoBeneficio;
import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.service.CsbffBeneficiosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CsbffBeneficioBean {

    private int nomeBeneficio;
    private CsbffBeneficios codigoBeneficio;
    /**
     * @param tipoBeneficio the tipoBeneficio to set
     */
    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    /**
     * @return the csbffTipoBeneficiosList
     */
    public List<TipoBeneficio> getCsbffTipoBeneficiosList() {
        return csbffTipoBeneficiosList;
    }

    /**
     * @param csbffTipoBeneficiosList the csbffTipoBeneficiosList to set
     */
    public void setCsbffTipoBeneficiosList(List<TipoBeneficio> csbffTipoBeneficiosList) {
        this.csbffTipoBeneficiosList = csbffTipoBeneficiosList;
    }

    private boolean formAtivo = false;
//    private int nomeBeneficio;
    private CsbffBeneficios csbffBeneficios = new CsbffBeneficios();
    private List<CsbffBeneficios> todosCsbffBeneficios;
    private TipoBeneficio tipoBeneficio;
    private List<TipoBeneficio> csbffTipoBeneficiosList;

    public CsbffBeneficioBean(List<CsbffBeneficios> todosCsbffBeneficios, TipoBeneficio tipoBeneficio, List<TipoBeneficio> csbffTipoBeneficiosList, CsbffBeneficiosService csbffBeneficiosService) {
        this.todosCsbffBeneficios = todosCsbffBeneficios;
        this.tipoBeneficio = tipoBeneficio;
        this.csbffTipoBeneficiosList = csbffTipoBeneficiosList;
        this.csbffBeneficiosService = csbffBeneficiosService;
    }

    @ManagedProperty("#{csbffBeneficiosService}")
    private CsbffBeneficiosService csbffBeneficiosService;

//    private TipoBeneficio tipoBeneficioCombo;
    public CsbffBeneficioBean() {

    }
    public int getNomeBeneficio() {
        return nomeBeneficio;
    }
    

    public void setNomeBeneficio(int nomeBeneficio) {
        this.nomeBeneficio = nomeBeneficio;
    }
    
    public List<CsbffBeneficios> getBeneficios() {
        List<CsbffBeneficios> beneficios = new ArrayList<>();
        beneficios.add(new CsbffBeneficios());
        return beneficios;
    }
    public String buscaNome() {

        if (nomeBeneficio != 0) {
            todosCsbffBeneficios = csbffBeneficiosService.findAll(nomeBeneficio);
        }
        return "consultabeneficios";

    }
    public String prepareEdit(CsbffBeneficios csbffBeneficios) {
        this.formAtivo = true;
        this.csbffBeneficios = csbffBeneficios;
        return "beneficio";
    }

    public TipoBeneficio[] getTipoBeneficio() {
        return TipoBeneficio.values();
    }

    public AbrangenciaBeneficio[] getAbrangenciaBeneficio() {
        return AbrangenciaBeneficio.values();
    }

    public String excluir(CsbffBeneficios beneficio) {
        csbffBeneficiosService.delete(beneficio.getBeneficioCodigo());
        todosCsbffBeneficios.remove(beneficio);
        return "consultabeneficios";
    }
    public String edita(CsbffBeneficios beneficio) {
        this.csbffBeneficios = beneficio;
        select(beneficio);
        return "cadastrobeneficios";
    }
    public void select(CsbffBeneficios beneficio) {
        this.csbffBeneficios = beneficio;
        codigoBeneficio = beneficio;
        altera(beneficio);

    }
    public String altera(CsbffBeneficios beneficio) {
        codigoBeneficio = beneficio;
        csbffBeneficiosService.update(beneficio);
       
        return "cadastrobeneficios";
    }

    public void save() {
        if (csbffBeneficios.getBeneficioCodigo() > 0) {
            csbffBeneficiosService.update(csbffBeneficios);
        } else {
            csbffBeneficiosService.save(csbffBeneficios);
        }

        todosCsbffBeneficios = csbffBeneficiosService.findAll();
        this.formAtivo = true;

//        csbffBeneficios.setBeneficioCodigo(0);
//        String abrangencia = null;
//        csbffBeneficios.setAbrangencia(abrangencia);
//        csbffBeneficios.setBeneficioNome(abrangencia);
//        csbffBeneficiosService.save(csbffBeneficios);
    }

    public void cancel() {
        this.formAtivo = false;
        this.csbffBeneficios = new CsbffBeneficios();
    }

    public void add() {
        this.formAtivo = true;
        this.csbffBeneficios = new CsbffBeneficios();
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }

    public CsbffBeneficios getCsbffBeneficios() {
        return csbffBeneficios;
    }

    public void setCsbffBeneficios(CsbffBeneficios csbffBeneficios) {
        this.csbffBeneficios = csbffBeneficios;
    }

    public List<CsbffBeneficios> getTodosCsbffBeneficios() {

        if (todosCsbffBeneficios == null) {
            todosCsbffBeneficios = csbffBeneficiosService.findAll();
        }
        return todosCsbffBeneficios;
    }

    public void setTodosCsbffBeneficios(List<CsbffBeneficios> todosCsbffBeneficios) {
        this.todosCsbffBeneficios = todosCsbffBeneficios;
    }

    public CsbffBeneficiosService getCsbffBeneficiosService() {
        return csbffBeneficiosService;
    }

    public void setCsbffBeneficiosService(CsbffBeneficiosService csbffBeneficiosService) {
        this.csbffBeneficiosService = csbffBeneficiosService;
    }

}
//    public TipoBeneficio getTipoBeneficioCombo() {
//        return tipoBeneficioCombo;
//    }

//    public void setTipoBeneficioCombo(TipoBeneficio tipoBeneficioCombo) {
//        this.tipoBeneficioCombo = tipoBeneficioCombo;
//    }

