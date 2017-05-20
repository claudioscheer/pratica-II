package br.org.gdt.dao;

import br.org.gdt.model.RecPessoa;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository("recPessoaDAO")
public class RecPessoaDAO extends DAO<RecPessoa> {

    public RecPessoaDAO() {
        classe = RecPessoa.class;
    }

    public List<RecPessoa> findByCpf(long cpf) {

        Query query = entityManager.createQuery("from RecPessoa as t where t.recCpf = :cpf");
        query.setParameter("cpf", cpf);

        return query.getResultList();

    }

}
//    public RecPessoa findByCpf(String cpf) {
////        try {
////            return (RecPessoa) entityManager.createQuery("from RecPessoa where recCpf = " + cpf).getSingleResult();
////        } catch (Exception e) {
////            return null;
////        }
//        Query query = entityManager.createQuery("from RecPessoa as t where t.recCpf = :cpf");
//        query.setParameter("cpf", cpf);
//
//        return (RecPessoa) query.getResultList();
//    }}
