package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

/* Permite la comunicación con la base de datos */
public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);
}
