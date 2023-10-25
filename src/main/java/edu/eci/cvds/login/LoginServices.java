package edu.eci.cvds.login;

import edu.eci.cvds.samples.services.ExcepcionServicios;

/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public interface LoginServices {

    public void singIn(String email, String clave) throws ExcepcionServicios;

    public boolean isLoggedIn();

    public void logOut();
}