package edu.eci.cvds.entities;

import java.io.Serializable;

/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public class Usuario implements Serializable {

    private int id;
    private String rol;
    private String clave;
    private String email;

    /**
     * Constructor de la entidad Usuario
     * @param id Identificador del Usuario
     * @param rol Rol asignado para el usuario
     * @param clave Contraseña de ingreso para el usuario   
     * @param email Email registrado del usuario
     */
    public Usuario(int id, String rol, String clave, String email) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
        this.email = email;
    }

    /**
     * Consultar el identificador del usuario
     * @return Identificador del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Consultar el rol del usuario
     * @return Rol del usuario
     */
    public String getRol() {
        return rol;
    }

    /**
     * Consultar la contraseña del usuario
     * @return Contraseña del usuario
     */
    public String getClave() {
        return clave;
    }

    /**
     * Consultar el correo electrónico del usuario
     * @return Email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna el identificador a un usuario
     * @param id Identificador a asignar al usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Asigna el rol a un usuario
     * @param rol Rol a asignar al usuario
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Asigna la contraseña a un usuario
     * @param clave Contraseña a asignar al usuario
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Asigna el correo electrónico a un usuario
     * @param correo Email a asignar al usuario
     */
    public void setEmail(String correo) {
        this.email = correo;
    }

    @Override
    public String toString() {
        return "User{id= " + id +
                ", rol= " + rol +
                ", email= " + email +
                ", clave= " + clave +
                '}';
    }
}