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
    public String login(@RequestBody Usuario user) {
        /* RequestBody: convierte el Json que llega a un objeto Usuario */

        Usuario userLogueado = userDao.obtenerUsuarioPorCredenciales(user);
        if(userLogueado != null) {
            /* En base a los dos elementos enviados de tipo String nos devuelve un token */
            String tokenJWT = jwtUtil.create(String.valueOf(userLogueado.getId()), userLogueado.getEmail());
            return tokenJWT;
        } else {
            return "error";
        }
    }
}
