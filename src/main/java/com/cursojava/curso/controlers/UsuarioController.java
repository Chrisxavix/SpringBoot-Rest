package com.cursojava.curso.controlers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/* Los controladores sirven para manejar las url (dominios) */
@RestController
public class UsuarioController {

    @GetMapping("/user/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario user = new Usuario(id, "Chris", "Chillo", "chris@gmail.com", "797", "12345");
        return user;
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
