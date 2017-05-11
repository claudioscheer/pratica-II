package org.primefaces.showcase.view.input;
 
import br.org.gdt.model.GchAlternativas;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
 
@ManagedBean
public class BeanTeste {
         
    private List<GchAlternativas> selectedCities = new ArrayList<>();
    
    private List<GchAlternativas> cities = new ArrayList<>();
     
    @PostConstruct
    public void init() {
      
       cities = gchAlternativasService.findAll();
        
    }

    public List<GchAlternativas> getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(List<GchAlternativas> selectedCities) {
        this.selectedCities = selectedCities;
    }

    public List<GchAlternativas> getCities() {
        return cities;
    }

    public void setCities(List<GchAlternativas> cities) {
        this.cities = cities;
    }

    public GchCadastroAlternativaServiceCerto getGchAlternativasService() {
        return gchAlternativasService;
    }

    public void setGchAlternativasService(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }
    
    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;


 
}