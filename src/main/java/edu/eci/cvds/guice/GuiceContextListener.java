package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatis.*;


import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.impl.*;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
    }
}