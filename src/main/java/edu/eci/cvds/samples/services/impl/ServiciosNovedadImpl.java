package edu.eci.cvds.samples.services.impl;

import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosNovedad;

public class ServiciosNovedadImpl implements ServiciosNovedad{

    @Inject 
    private NovedadDAO novedadDAO;

    @Override
    public List<Novedad> consultarNovedades() {
        return novedadDAO.consultarNovedades(); 
    }

    @Override
    public void registrarNovedadEquipo(Equipo equipo, Novedad novedad) throws ExcepcionServicios {
        novedadDAO.registrarNovedadEquipo(novedad); 
    }

    @Override
    public void registrarNovedadElemento(Elemento elemento, Novedad novedad) throws ExcepcionServicios {
        novedad.setIdElemento(elemento.getId());
        if (elemento.getEquipo() != null){
            novedad.setIdEquipo((elemento.getEquipo().getId()));
        }
        elemento.setNovedad(novedad);
        novedadDAO.registrarNovedadElemento(novedad);
    }

    @Override
    public List<Novedad> consultarNovedadesElemento(Elemento elemento) {
        return novedadDAO.consultarNovedadesElemento(elemento);
    }

    @Override
    public List<Novedad> consultarNovedadesEquipo(Equipo equipo) {
        return novedadDAO.consultarNovedadesEquipo(equipo);
    }

	@Override
	public void registrarNovedad(Novedad novedad) {
		novedadDAO.registrarNovedad(novedad);
	}

    
}
