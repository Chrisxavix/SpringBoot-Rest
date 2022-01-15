package com.cursojava.curso.controlers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/* Los controladores sirven para manejar las url (dominios) */
@RestController
public class UsuarioController {

    @GetMapping("/user/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario user = new Usuario(id, "ChrisFilth", "Chillo", "chris@gmail.com", "797", "12345");
        return user;
    }

    @GetMapping("/users")
    public List<Usuario> getUsuarios() {
        Usuario user = new Usuario(1L, "ChrisFilth", "Chillo", "chris@gmail.com", "797", "12345");
        Usuario user1 = new Usuario(2L, "Dani", "Free", "dani@gmail.com", "456", "7878");
        Usuario user2 = new Usuario(3L, "Skone", "Free", "skone@gmail.com", "15", "789465");
        List<Usuario> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/edit")
    public Usuario editar() {
        Usuario user = new Usuario((long) Math.toIntExact(1), "Chris", "Chillo", "chris@gmail.com", "797", "12345");
        return user;
    }

    @GetMapping("/eliminar")
    public Usuario eliminar() {
        Usuario user = new Usuario((long) Math.toIntExact(1), "Chris", "Chillo", "chris@gmail.com", "797", "12345");
        return user;
    }

    @GetMapping("/buscar")
    public Usuario buscar() {
        Usuario user = new Usuario((long) Math.toIntExact(1), "Chris", "Chillo", "chris@gmail.com", "797", "12345");
        return user;
    }

}
