/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.service.InicializaService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@RequestScoped
public class InicializaBean {

    @ManagedProperty("#{inicializaService}")
    private InicializaService inicializaService;

    public InicializaBean() {
        
    }
    
    public String inicializar() {

        inicializaUFeMunicipios();
        
        return "InicializaSistema";
    }

    public void inicializaUFeMunicipios() {

        List<String> sqls = new ArrayList<>();
        sqls.add("INSERT INTO gch_ufs VALUES (1, 'Acre', 'AC');");
        sqls.add("INSERT INTO gch_ufs VALUES (2, 'Alagoas', 'AL');             ");
        sqls.add("INSERT INTO gch_ufs VALUES (3, 'Amazonas', 'AM');            ");
        sqls.add("INSERT INTO gch_ufs VALUES (4, 'Amapá', 'AP');               ");
        sqls.add("INSERT INTO gch_ufs VALUES (5, 'Bahia', 'BA');               ");
        sqls.add("INSERT INTO gch_ufs VALUES (6, 'Ceará', 'CE');               ");
        sqls.add("INSERT INTO gch_ufs VALUES (7, 'Distrito Federal', 'DF');    ");
        sqls.add("INSERT INTO gch_ufs VALUES (8, 'Espirito Santo', 'ES');      ");
        sqls.add("INSERT INTO gch_ufs VALUES (9, 'Goiás', 'GO');               ");
        sqls.add("INSERT INTO gch_ufs VALUES (10, 'Maranhão', 'MA');           ");
        sqls.add("INSERT INTO gch_ufs VALUES (11, 'Minas Gerais', 'MG');       ");
        sqls.add("INSERT INTO gch_ufs VALUES (12, 'Mato Grosso do Sul', 'MS'); ");
        sqls.add("INSERT INTO gch_ufs VALUES (13, 'Mato Grosso', 'MT');        ");
        sqls.add("INSERT INTO gch_ufs VALUES (14, 'Pará', 'PA');               ");
        sqls.add("INSERT INTO gch_ufs VALUES (15, 'Paraíba', 'PB');            ");
        sqls.add("INSERT INTO gch_ufs VALUES (16, 'Pernambuco', 'PE');         ");
        sqls.add("INSERT INTO gch_ufs VALUES (17, 'Piauí', 'PI');              ");
        sqls.add("INSERT INTO gch_ufs VALUES (18, 'Paraná', 'PR');             ");
        sqls.add("INSERT INTO gch_ufs VALUES (19, 'Rio de Janeiro', 'RJ');     ");
        sqls.add("INSERT INTO gch_ufs VALUES (20, 'Rio Grande do Norte', 'RN');");
        sqls.add("INSERT INTO gch_ufs VALUES (21, 'Rondônia', 'RO');           ");
        sqls.add("INSERT INTO gch_ufs VALUES (22, 'Roraima', 'RR');            ");
        sqls.add("INSERT INTO gch_ufs VALUES (23, 'Rio Grande do Sul', 'RS');  ");
        sqls.add("INSERT INTO gch_ufs VALUES (24, 'Santa Catarina', 'SC');     ");
        sqls.add("INSERT INTO gch_ufs VALUES (25, 'Sergipe', 'SE');            ");
        sqls.add("INSERT INTO gch_ufs VALUES (26, 'São Paulo', 'SP');          ");
        sqls.add("INSERT INTO gch_ufs VALUES (27, 'Tocantins', 'TO');          ");

        for (int i = 0; i < sqls.size(); i++){
        
            inicializaService.inicializar(sqls.get(i));
            
        }
        
        
    }

    public InicializaService getInicializaService() {
        return inicializaService;
    }

    public void setInicializaService(InicializaService inicializaService) {
        this.inicializaService = inicializaService;
    }
    
    

}
