package com.cursojava.curso.controlers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao userDao;

    @Autowired
    private JWTutil jwtUtil;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario user) {
        /* RequestBody: convierte el Json que llega a un objeto Usuario  */
        /*if(userDao.obtenerUsuarioPorCredenciales(user)) {
            jwtUtil.create(user.getId(), user);
            return "yes";
        } else {
            return "error";
        }*/
        return null;
    }
}
