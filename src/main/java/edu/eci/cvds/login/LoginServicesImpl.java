package edu.eci.cvds.login;

import edu.eci.cvds.samples.services.ExcepcionServicios;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
//import javax.faces.application.FacesMessage;

/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public class LoginServicesImpl implements LoginServices{
    private Subject subject;

    @Override
    public void singIn(String email, String clave) throws ExcepcionServicios {
        subject = SecurityUtils.getSubject();
        //FacesMessage facesMessage = new FacesMessage();
        UsernamePasswordToken token = new UsernamePasswordToken(email,clave);

        try{
            subject.login(token);
        }catch (LockedAccountException lockedAccountException){
            throw new ExcepcionServicios("Demasiados intentos", lockedAccountException);
        }catch(UnknownAccountException unknownAccountException){
            throw new ExcepcionServicios("Correo o clave incorrecto", unknownAccountException);
        }catch (IncorrectCredentialsException incorrectCredentialsException){
            throw new ExcepcionServicios("Correo o clave incorrecto", incorrectCredentialsException);
        }catch (AuthenticationException authenticationException){
            throw new ExcepcionServicios("Error al autenticar", authenticationException);
        }catch (Exception exception){
            throw new ExcepcionServicios("Ocurrio un error inesperado", exception);
        }

    }
    @Override
    public boolean isLoggedIn(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void logOut(){
        subject = SecurityUtils.getSubject();
        subject.logout();
    }



}