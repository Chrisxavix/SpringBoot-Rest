package com.cursojava.curso.controlers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao userDao;

    @PostMapping("/login")
    public String login(@RequestBody Usuario user) {
        /* RequestBody: convierte el Json que llega a un objeto Usuario  */
        if(userDao.verificarMailUser(user)) {
            return "yes";
        } else {
            return "error";
        }
    }
}
