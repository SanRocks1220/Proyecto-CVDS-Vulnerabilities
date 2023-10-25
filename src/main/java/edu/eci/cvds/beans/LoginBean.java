package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.login.LoginServices;
import edu.eci.cvds.samples.services.ServiciosUsuario;
import edu.eci.cvds.samples.services.ExcepcionServicios;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */


@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@ApplicationScoped


public class LoginBean extends BasePageBean{

    @Inject
    private LoginServices loginServices;
    @Inject
    private ServiciosUsuario userServices;
    @Inject
    private ServiciosUsuario servicios;

    private String email;

    private String clave;


    public void singIn(String email, String clave) throws ExcepcionServicios, IOException  {
        try{
            if(email.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Correo requerido"));
            }else if(clave.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Clave requerida"));
            }else{
                loginServices.singIn(email, clave);
                this.email=email;
                FacesContext.getCurrentInstance();
            }
        }catch (ExcepcionServicios excepcionServicios){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", excepcionServicios.getMessage()));
        }
    }


    public String textlog(){
        if(loginServices.isLoggedIn()){
            return "Cerrar Sesion";
        }else{
            return"Iniciar";
        }
    }


    public Usuario consultarUsuario() throws ExcepcionServicios, PersistenceException {
        return servicios.consultarUsuario(email);
    }

    public boolean isShowColumn(){
        if (loginServices.isLoggedIn() && userServices.isAdmin()){
            return true;
        }else {
            return false;
        }
    }

    public void setUsername(String email){
        this.email= email;
    }

    public String getEmail(){
        return email;
    }

    public void setClave(String clave){
        this.clave= clave;
    }

    public String getClave(){
        return clave;
    }



}