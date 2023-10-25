package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.entities.*;

import java.util.List;

import edu.eci.cvds.samples.services.ServiciosLaboratorio;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.ExcepcionServicios;

@Singleton
public class ServiciosLaboratorioImpl implements ServiciosLaboratorio {

    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public void registrarLaboratorio(Laboratorio laboratorio) throws ExcepcionServicios{
        try {
            laboratorioDAO.registrarLaboratorio(laboratorio);
        } catch (PersistenceException  e) {
            throw new ExcepcionServicios("Error al guardar el laboratorio" + laboratorio.getNombre()+ e);
        }
    }

    @Override
    public Laboratorio consultarLaboratorio(int id) throws ExcepcionServicios {
        try {
            return laboratorioDAO.consultarLaboratorio(id);
        }
        catch(PersistenceException e) {
            throw new ExcepcionServicios("Error al consultar el laboratorio"+ id + e);
        }
    }

    @Override
    public List<Laboratorio> consultarLaboratorios() throws ExcepcionServicios {
        try {
            return laboratorioDAO.consultarLaboratorios();
        } catch(PersistenceException e) {
            throw new ExcepcionServicios("Error al consultar laboratorios" + e);
        }
    }

    public void asociarEquipo(int idLaboratorio, int idEquipo) throws ExcepcionServicios {
        try{
            laboratorioDAO.asociarEquipo(idLaboratorio, idEquipo);
        }catch (PersistenceException  ex){
            throw new PersistenceException("No se pudo asociar el elemento al equipo", ex);
        }
    }
}