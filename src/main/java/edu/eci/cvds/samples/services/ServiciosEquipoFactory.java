package edu.eci.cvds.samples.services;

import java.util.Optional;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.samples.services.impl.ServiciosEquipoImpl;
import static com.google.inject.Guice.createInjector;

import org.mybatis.guice.XMLMyBatisModule;



public class ServiciosEquipoFactory {

    private static ServiciosEquipoFactory instance = new ServiciosEquipoFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);  
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);  
            }
        });
    }

    private ServiciosEquipoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosEquipo getServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosEquipo.class);
    }


    public ServiciosEquipo getServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosEquipo.class);
    }
    
    public static ServiciosEquipoFactory getInstance(){
        return instance;
    }
    

}