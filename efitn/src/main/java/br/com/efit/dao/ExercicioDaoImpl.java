package br.com.efit.dao;

import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efit.domain.Exercicio;
 
@Repository
@Transactional
public class ExercicioDaoImpl implements ExercicioDao {
     
    @PersistenceContext
    private EntityManager entityManager;
 
    @Override
    public void salvar(Exercicio exercicio) {
        entityManager.persist(exercicio); 
    }
 
    @Override
    public void editar(Exercicio exercicio) {
        entityManager.merge(exercicio);       
    }
 
    @Override
    public void excluir(Long id) {
        entityManager.remove(entityManager.getReference(Exercicio.class, id));        
    }
 
    @Transactional(readOnly = true)
    @Override
    public Exercicio getId(Long id) {
        String jpql = "from Exercicio u where u.id_exer = :id_exer";
        TypedQuery<Exercicio> query = entityManager.createQuery(jpql, Exercicio.class);
        query.setParameter("id_exer", id);
        return query.getSingleResult();
    }
 
    @Transactional(readOnly = true)
    @Override
    public List<Exercicio> getTodos() {
        String jpql = "from Exercicio u";
        TypedQuery<Exercicio> query = entityManager.createQuery(jpql, Exercicio.class);
        return query.getResultList();
    }
 
     
}