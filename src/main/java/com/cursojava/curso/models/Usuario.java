package com.cursojava.curso.models;

import lombok.Data;
import javax.persistence.*;

/* Haciendo referencia a Setters y Getters con la dependencia de Lombok */
@Data
/* Haciendo que es una entidad de la BD */
@Entity
/* Para identificar que es una tabla */
/* el name debe ser que la tabla de BD */
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "password")
    private String password;
}
