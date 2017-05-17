package org.primefaces.showcase.view.input;
 
import br.org.gdt.model.GchAlternativas;
import br.org.gdt.service.GchCadastroAlternativaServiceCerto;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
 
@ManagedBean
public class BeanTeste {
         
    @ManagedProperty("#{gchAlternativaCertoService}")
    private GchCadastroAlternativaServiceCerto gchAlternativasService;
    
    private List<GchAlternativas> selectedCities;
    
    private List<GchAlternativas> cities = gchAlternativasService.findAll();
     

    
    @PostConstruct
    public void init() {
      

        
    }

    public BeanTeste() {
        
    }

    public BeanTeste(GchCadastroAlternativaServiceCerto gchAlternativasService) {
        this.gchAlternativasService = gchAlternativasService;
    }

    public List<GchAlternativas> getSelectedCities() {
        return selectedCities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.selectedCities);
        hash = 17 * hash + Objects.hashCode(this.cities);
        hash = 17 * hash + Objects.hashCode(this.gchAlternativasService);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BeanTeste other = (BeanTeste) obj;
        if (!Objects.equals(this.selectedCities, other.selectedCities)) {
            return false;
        }
        if (!Objects.equals(this.cities, other.cities)) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasService, other.gchAlternativasService)) {
            return false;
        }
        return true;
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
   


 
}