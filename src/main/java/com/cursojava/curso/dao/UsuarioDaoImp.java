package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        /* Encriptación irreversible */
        /* Mientras más iteracciones es más seguro, pero consume tiempo, por eso se define en: 1 */
        String passwordEncrypt = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(passwordEncrypt);
        entityManager.merge(user);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario user) {
        String query = "FROM Usuario WHERE email= :email";
        List<Usuario> usuario = entityManager.createQuery(query)
                .setParameter( "email", user.getEmail())
                .getResultList();
        if (usuario.isEmpty()) {
            return null;
        }
        /* Contraseña traida de la base de datos de acuerdo al correo encontrado */
        String passwordHashed = usuario.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed,user.getPassword())) {
            return usuario.get(0);
        } else {
            return null;
        }
    }
}
