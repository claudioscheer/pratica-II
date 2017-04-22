/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.beans;

import br.org.gdt.model.CsbffBeneficios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author MARCOS FELIPE
 */
@ManagedBean
@RequestScoped
public class beneficioBean {
    
    





    private Session session;
    
    public beneficioBean() {
       
        System.out.println("criando objeto pBean");
        
        //session = HibernateUtil.getSessionFactory().openSession();
       
        
    }
    
    
    private CsbffBeneficios beneficio = new CsbffBeneficios();

    //private List<> produtos = new ArrayList<>();


    
    public String save(){
        
       session.getTransaction().begin();
       session.merge(beneficio);
       session.getTransaction().commit();
                
        return "produto_list";
      
    }
    public String select ( CsbffBeneficios product){
        this.beneficio = product;
        
        return "produto_form";
        
    }
    
    
    public String novo(){
        beneficio = new CsbffBeneficios();
        
        return "produto_form";
        
        
    }
    
//    
//    public void load(){
//        
//        produtos = session.createQuery("from Produto").list();
//    }
    
    public String delete(CsbffBeneficios product){
        
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
        //load();
       return "produto_list";
        
    }
}

