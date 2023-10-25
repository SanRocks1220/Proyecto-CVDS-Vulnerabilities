package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.PersistenceException;


/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public interface ServiciosUsuario {

    public boolean isAdmin();

    public String getEmail() throws ExcepcionServicios;

    public Usuario consultarUsuario(String email) throws ExcepcionServicios, PersistenceException;

}