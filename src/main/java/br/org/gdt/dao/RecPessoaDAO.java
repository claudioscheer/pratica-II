package br.org.gdt.dao;

import br.org.gdt.enums.Sexo;
import br.org.gdt.model.CsbffBeneficios;
import br.org.gdt.model.CsbffDependentes;
import br.org.gdt.model.CsbffPessoaBeneficio;
import br.org.gdt.model.CsbffPessoaDependente;
import br.org.gdt.model.RecHabilidade;
import br.org.gdt.model.RecPessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("recPessoaDAO")
public class RecPessoaDAO extends DAO<RecPessoa> {

    public RecPessoaDAO() {
        classe = RecPessoa.class;
    }

    public RecPessoa findByRecCpf(String recCpf) {

        TypedQuery<RecPessoa> query = entityManager.createQuery("from RecPessoa as p left join fetch p.csbffPessoaBeneficioList where p.recCpf = :recCpf", RecPessoa.class);
        query.setParameter("recCpf", recCpf);
        try {
            RecPessoa pessoa = query.getSingleResult();

//            List<CsbffPessoaBeneficio> beneficiosPessoa = new ArrayList<>();
//            for (CsbffPessoaBeneficio pb : pessoa.getCsbffPessoaBeneficioList() ){
//                beneficiosPessoa.add(pb);
//            }
//                    
//            pessoa.setCsbffPessoaBeneficioList(beneficiosPessoa);
            return pessoa;

        } catch (NoResultException e) {
            return null;

        }
    }

    public RecPessoa findByIdCompleto(long id) {
        TypedQuery<RecPessoa> query = entityManager.createQuery("from RecPessoa as "
                + "p where p.recIdpessoa = :recIdpessoa", RecPessoa.class);
        query.setParameter("recIdpessoa", id);
        try {
            RecPessoa pessoa = query.getSingleResult();
            List<RecHabilidade> lista = new ArrayList<>();
            for (RecHabilidade h : pessoa.getRecHabilidadeList()) {
                lista.add(h);
            }
            pessoa.setRecHabilidadeList(lista);
            return pessoa;

        } catch (NoResultException e) {
            return null;

        }
    }

    public List<RecPessoa> FiltroPessoa(int grauEnsino, int sexo, String nome, int estadoCivil, int cor) {
        String busca = "from RecPessoa as p where 1 = 1";
        busca += grauEnsino == 0    ? "" : " and p.recPesGrauEnsino = :recPesGrauEnsino";
        busca += sexo == 0          ? "" : " and p.recSexo = :recSexo";
        busca += nome.isEmpty()     ? "" : " and p.recNomecompleto like :recNomecompleto";
        busca += estadoCivil == 0   ? "" : " and p.recEstadocivil = :recEstadocivil";
        busca += cor == 0           ? "" : " and p.recCor = :recCor";
        TypedQuery<RecPessoa> query = entityManager.createQuery(busca, RecPessoa.class);
        if (grauEnsino != 0) {                        
            query.setParameter("recPesGrauEnsino", grauEnsino);
        }
        if (sexo != 0) {
            Sexo s;
            if(sexo == 1){
                s = Sexo.Masculino;
            }else{
                s = Sexo.Feminino;
            }
            query.setParameter("recSexo", s);
        }
        if (!nome.isEmpty()) {
            query.setParameter("recNomecompleto", nome);
        }
        if (estadoCivil != 0) {
            query.setParameter("recEstadocivil", estadoCivil);
        }
        if (cor != 0) {
            query.setParameter("recCor", cor);
        }
        query = entityManager.createQuery(busca, RecPessoa.class);
        return query.getResultList();
    }

    public List<RecPessoa> buscarNomes(String select) { //usado em um sugest
        Query query = entityManager.createQuery("from RecPessoa as p where (upper(p.recNomecompleto) like :recQuery or p.recCpf like :recQuery) and p.recFuncionario = true");
        query.setParameter("recQuery", "%" + select.toUpperCase() + "%");

        return query.getResultList();
    }

    public RecPessoa BuscarPessoaCFP(String cpf) {
        TypedQuery<RecPessoa> query = entityManager.createQuery("from RecPessoa where recCpf like :busca", RecPessoa.class);
        query.setParameter("busca", cpf);
        return query.getSingleResult();
    }

    public List<CsbffDependentes> findAllDependentesPessoa(long pessoa) {

        Query query = entityManager.createQuery("from CsbffDependentes as t where t.vinculoPessoa = :pessoa");
        query.setParameter("pessoa", pessoa);

        List<CsbffDependentes> todosDependentes = query.getResultList();

//        return todosDependentes.stream()
//                .map(x -> x.getDependenteCod())
//                .collect(Collectors.toList());
        return todosDependentes;
    }

    public List<RecPessoa> buscarColaboradores() {
        TypedQuery<RecPessoa> query = entityManager.createQuery("from RecPessoa as p where p.recFuncionario = true", RecPessoa.class);

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
