package br.com.efit.dao;

import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efit.domain.Usuario;
 
@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {
     
    @PersistenceContext
    private EntityManager entityManager;
 
    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario); 
    }
 
    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);       
    }
 
    @Override
    public void excluir(Long id) {
        entityManager.remove(entityManager.getReference(Usuario.class, id));        
    }
 
    @Transactional(readOnly = true)
    @Override
    public Usuario getId(Long id) {
        String jpql = "from Usuario u where u.id_user = :id_user";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id_user", id);
        return query.getSingleResult();
    }
 
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getTodos() {
        String jpql = "from Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }
 
     
}