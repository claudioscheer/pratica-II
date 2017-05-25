/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.GchRespostas;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego
 */
@Repository("gchRespostasDAO")
public class GchRespostasDAO  extends DAO<GchRespostas>{

    public GchRespostasDAO() {
        classe = GchRespostas.class;
    }
    
    public int findByFormulario(int id) {
        try {
            
            GchRespostas resposta = new GchRespostas();
            
            resposta =  (GchRespostas) entityManager.createQuery(
                    String.format(
                            "from GchRespostas as t where t.formCodigo = %s",
                            id)
            ).getSingleResult();
             
             if(resposta.getResCodigo() > 0){
                 
                 return 1;
             }else{
                 
                 return 0;
                 
             }
            
   
            
        } catch (Exception e) {
            return 0;
        }
    }

}
