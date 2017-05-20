/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.RecRequisicaoVaga;
import br.org.gdt.model.RecVaga;
import org.springframework.stereotype.Repository;

/**
 *
 * @author João
 */
@Repository("recRequisicaoDAO")
public class RecRequisicaoDAO extends DAO<RecRequisicaoVaga>
{

    public RecRequisicaoDAO()
    {
        classe = RecRequisicaoVaga.class;
    }

}
