package com.cursojava.curso.controlers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/* Los controladores sirven para manejar las url (dominios) */
@RestController
public class UsuarioController {

    /* Inyección de dependencias */
    /* Autowired: hace que la clase UsuarioDaoImp se crea un objeto y guarda dentro de la variable userDao */
    @Autowired
    private UsuarioDao userDao;

    @GetMapping("/user/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/users")
    public List<Usuario> getUsuarios() {
        return userDao.getUsuarios();
    }

    @GetMapping("/edit")
    public Usuario editar() {
        return null;
    }

    @DeleteMapping("/user/{id}")
    public void eliminar(@PathVariable Long id) {
        userDao.eliminar(id);
    }

    @GetMapping("/buscar")
    public Usuario buscar() {
        return null;
    }

}
