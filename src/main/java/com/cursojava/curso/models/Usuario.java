package com.cursojava.curso.models;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    public Usuario() {
    }

    public Usuario(Long getId, String getNombre, String getApellido, String getEmail, String getTelefono, String getPassword) {
        this.id = getId;
        this.nombre = getNombre;
        this.apellido = getApellido;
        this.email = getEmail;
        this.telefono = getTelefono;
        this.password = getPassword;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
