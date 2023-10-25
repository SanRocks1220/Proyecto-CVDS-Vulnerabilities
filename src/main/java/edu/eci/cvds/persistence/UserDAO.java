package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;

import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

/**
 * Interfaz UserDAO, para la entidad Usuario
 * @author Daniela Garcia - Team Developer
 */

public interface UserDAO {

    /**
     * Consultar un usuario por su correo electrónico
     * @param email Email por el que consultar usuarios
     * @return Usuario al que corresponda el Email
     * @throws PersistenceException
     */
    public Usuario consultarUsuario(String email) throws PersistenceException;

    /**
     * Consultar la información de un usuario por su Identificador 
     * @param id Identificador por el que consultar usuarios
     * @return Usuario al que corresponda el Identificador
     * @throws PersistenceException
     */
    public Usuario infoUsuario(int id) throws PersistenceException;

    /**
     * Consulta el Identificador de un usuario dependiendo de su nombre
     * @param usuario Nombre del ususario al que consultar su Identificador
     * @return Identificador del usuario consultado
     * @throws PersistenceException
     */
    public int id(String usuario) throws PersistenceException;

    /**
     * Consulta todos los usuarios que estén registrados en el servicio / aplicación
     * @return Lista de usuarios registrados en el servicio / aplicación
     * @throws ParseException
     */
    public List<Usuario> consultarUsuarios() throws ParseException;

}