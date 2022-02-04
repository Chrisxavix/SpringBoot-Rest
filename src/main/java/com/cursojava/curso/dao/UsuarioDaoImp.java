package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/* Repository: Permite acceder al repositorio de la BD */
@Repository
/* Transactional: Permite armar consultas hacia la base de datos */
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    /* Consulta sobre Hibernate */
    /* Al hacer la consulta FROM Usuario irá contra la clase Usuario */
    @Override
    public List<Usuario> getUsuarios() {
        /* Nombre de la clase Java, models/Usuario */
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario user = entityManager.find(Usuario.class, id);
        entityManager.remove(user);
    }

    @Override
    public void agregar(Usuario user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verificarMailUser(Usuario user) {
        String query = "FROM Usuario WHERE email= :email AND password= :password";
        List<Usuario> usuario = entityManager.createQuery(query)
                        .setParameter( "email", user.getEmail())
                        .setParameter("password" , user.getPassword())
                        .getResultList();
        return !usuario.isEmpty();
    }


}
