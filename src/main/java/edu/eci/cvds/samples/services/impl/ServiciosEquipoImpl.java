package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;



import edu.eci.cvds.entities.*;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosEquipo;

@Singleton
public class ServiciosEquipoImpl implements ServiciosEquipo{

    @Inject 
    private EquipoDAO equipoDAO;

    @Override
    public void registrarEquipo(Equipo equipo) throws ExcepcionServicios{
        try {
            equipoDAO.registrarEquipo(equipo);
        } catch (PersistenceException  e) {
            throw new ExcepcionServicios("Error al guardar el equipo" + equipo.getNombre()+ e + "Here"); 
        }    
    }

    @Override
    public Equipo consultarEquipo(int id) throws ExcepcionServicios {
        try {
            return equipoDAO.consultarEquipo(id);
        } catch(PersistenceException e) {
            throw new ExcepcionServicios("Error al consultar el equipo"+ id + e);
        }
    }

    @Override
    public List<Equipo> consultarEquipos() throws ExcepcionServicios {
        try {
            return equipoDAO.consultarEquipos();
        } catch(PersistenceException e) {
            throw new ExcepcionServicios("Error al consultar equipos" + e);
        }
    }

    @Override
    public List<Equipo> consultarEquiposDisponibles() throws ExcepcionServicios {
        try {
            return equipoDAO.consultarEquiposDisponibles();
        } catch(PersistenceException e) {
            throw new ExcepcionServicios("Error al consultar equipos" + e);
        }
    }
    
    public void asociarElementoConEquipo(int idEquipo, int idElemento) throws ExcepcionServicios {
        try{
            equipoDAO.asociarElementoConEquipo(idEquipo, idElemento);
        }catch (PersistenceException  ex){
            throw new PersistenceException("No se pudo asociar el elemento al equipo", ex);
        }
    }

    public void eliminarAsociacion(int idEquipo, List<Elemento> elementos) throws ExcepcionServicios{
        try{
            equipoDAO.eliminarAsociacion(idEquipo, elementos);
        }catch (PersistenceException e){
            throw new ExcepcionServicios("No es posible desasociar un elemento", e);
        }
    }

    public void darDeBajaEquipo(int idEquipo)throws ExcepcionServicios{
        try{
            equipoDAO.darDeBajaEquipo(idEquipo);
            equipoDAO.eliminarAsociacion(idEquipo, equipoDAO.consultarEquipo(idEquipo).getElementos());
        }catch(PersistenceException e){
            throw new PersistenceException("No es posible darde baja el equipo");
        }
    }

    @Override
    public List<Equipo> consultarEquiposActivos() {
        try {
            return equipoDAO.consultarEquiposActivos();
        } catch (Exception e) {
            throw new PersistenceException("No es posible consultar los equipos activos",e);
        }
    }
}
