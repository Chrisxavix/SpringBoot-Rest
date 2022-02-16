package com.cursojava.curso.controlers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/* Los controladores sirven para manejar las url (dominios) */
@RestController
public class UsuarioController {

    /* Inyección de dependencias */
    /* Autowired: hace que la clase UsuarioDaoImp se crea un objeto y guarda dentro de la variable userDao */
    @Autowired
    private UsuarioDao userDao;

    @Autowired
    private JWTutil jwtUtil;

    @GetMapping("/users")
    /* @RequestHeader(value = "Authorization") String token: validación del Token para cada acción */
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String getToken) {
        if (!validateToken(getToken)) {
            return null;
        }
        return userDao.getUsuarios();
    }

    @DeleteMapping("/user/{id}")
    public void eliminar(@PathVariable Long id, @RequestHeader(value = "Authorization") String getToken) {
        if (!validateToken(getToken)) {
            return;
        }
        userDao.eliminar(id);
    }

    @PostMapping("/user")
    public void agregar(@RequestBody Usuario user) {
        /* RequestBody: convierte el Json que llega a un objeto Usuario  */
        /* No se agrega lo del token, porque aquí estoy creando y no necesito mandar en headers */
        userDao.agregar(user);
    }

    private boolean validateToken(String getToken) {
        String userId = jwtUtil.getKey(getToken);
        return userId != null;
    }
}
