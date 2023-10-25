package edu.eci.cvds.samples.services;

import java.util.Optional;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.samples.services.impl.ServiciosUsuarioImpl;

import static com.google.inject.Guice.createInjector;

import org.mybatis.guice.XMLMyBatisModule;



public class ServiciosUsuarioFactory {

    private static ServiciosUsuarioFactory instance = new ServiciosUsuarioFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UserDAO.class).to(MyBatisUserDAO.class);     
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);  
            }
        });
    }

    private ServiciosUsuarioFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosUsuario getServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosUsuario.class);
    }


    public ServiciosUsuario getServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosUsuario.class);
    }
    
    public static ServiciosUsuarioFactory getInstance(){
        return instance;
    }
    

}