package com.cursojava.curso.controlers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Los controladores sirven para manejar las url (dominios) */
@RestController
public class UsuarioController {

    /* Inyección de dependencias */
    /* Autowired: hace que la clase UsuarioDaoImp se crea un objeto y guarda dentro de la variable userDao */
    @Autowired
    private UsuarioDao userDao;

    @GetMapping("/users")
    public List<Usuario> getUsuarios() {
        return userDao.getUsuarios();
    }


    @DeleteMapping("/user/{id}")
    public void eliminar(@PathVariable Long id) {
        userDao.eliminar(id);
    }

    @PostMapping("/user")
    public void agregar(@RequestBody Usuario user) {
        /* RequestBody: convierte el Json que llega a un objeto Usuario  */
        userDao.agregar(user);
    }

}
