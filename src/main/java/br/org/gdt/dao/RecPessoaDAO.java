package br.org.gdt.dao;

import br.org.gdt.model.RecPessoa;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("recPessoaDAO")
public class RecPessoaDAO extends DAO<RecPessoa> {

    public RecPessoaDAO() {
        classe = RecPessoa.class;
    }

    public RecPessoa findByRecCpf(int recCpf) {

        TypedQuery<RecPessoa> query = entityManager.createQuery("from RecPessoa as t where t.recCpf = :recCpf", RecPessoa.class);
        query.setParameter("recCpf", recCpf);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;

        }
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
