package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosUsuario;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public class ServiciosUsuarioImpl implements ServiciosUsuario {

    @Inject
    private UserDAO userDAO;

    @Override
    public boolean isAdmin(){
        try{
            Subject subject = SecurityUtils.getSubject();
            return subject.hasRole("A");
        }catch (Exception e){
            return false;
        }
    }
    @Override
    public String getEmail() throws ExcepcionServicios{
        Subject subject = SecurityUtils.getSubject();
        return subject.getPrincipals().toString();
    }
    
    @Override
    public Usuario consultarUsuario(String correo) throws ExcepcionServicios {
        return userDAO.consultarUsuario(correo);
    }


}
