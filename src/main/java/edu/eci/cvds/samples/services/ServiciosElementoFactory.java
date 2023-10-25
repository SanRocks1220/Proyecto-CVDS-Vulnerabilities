package edu.eci.cvds.samples.services;

import java.util.Optional;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.samples.services.impl.ServiciosElementoImpl;
import static com.google.inject.Guice.createInjector;

import org.mybatis.guice.XMLMyBatisModule;



public class ServiciosElementoFactory {

    private static ServiciosElementoFactory instance = new ServiciosElementoFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);  
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);  
            }
        });
    }

    private ServiciosElementoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosElemento getServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosElemento.class);
    }


    public ServiciosElemento getServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosElemento.class);
    }
    
    public static ServiciosElementoFactory getInstance(){
        return instance;
    }
    

}