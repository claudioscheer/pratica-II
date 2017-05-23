package br.org.gdt.dao;

import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("fpFolhaPeriodoDAO")
public class FpFolhaPeriodoDAO extends DAO<FpFolhaPeriodo> {

    public FpFolhaPeriodoDAO() {
        classe = FpFolhaPeriodo.class;
    }

    public List<FpFolhaPeriodo> findAllPeriodo(FpPeriodo fpPeriodo) {
        return entityManager.createQuery(String.format(
                "from FpFolhaPeriodo as t where t.forPeriodo.perId = %s",
                fpPeriodo.getPerId()))
                .getResultList();
    }

    public FpFolhaPeriodo findByPessoaEPeriodo(FpPeriodo fpPeriodo, RecPessoa recPessoa) {
        try {
            return (FpFolhaPeriodo) entityManager.createQuery(
                    String.format(
                            "from FpFolhaPeriodo as t where t.forPeriodo.perId = %s and t.forPessoa.recIdpessoa = %s",
                            fpPeriodo.getPerId(), recPessoa.getRecIdpessoa())
            ).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
