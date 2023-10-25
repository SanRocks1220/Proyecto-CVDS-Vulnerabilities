package edu.eci.cvds.persistence.mybatis;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;

public class MyBatisEquipoDAO implements EquipoDAO {
    
    @Inject 
    private EquipoMapper equipoMapper; 
    
    @Transactional
    @Override public void registrarEquipo(Equipo equipo) throws PersistenceException{
        try{  
            equipoMapper.registrarEquipo(equipo);  
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){ 
            throw new PersistenceException("Error al Registrar el Equipo " + equipo.toString(), e);  
        }  
    } 
    
    @Override 
    public Equipo consultarEquipo(int id) throws PersistenceException { 
        try{ 
            return equipoMapper.consultarEquipo(id); 
        }  
        catch(org.apache.ibatis.exceptions.PersistenceException e){  
            throw new PersistenceException("Error al Consultar el Equipo " + id, e);  
        } 
    }

    @Override
    public List<Equipo> consultarEquipos() throws PersistenceException {
        try{ 
            return equipoMapper.consultarEquipos(); 
        }  
        catch(org.apache.ibatis.exceptions.PersistenceException e){  
            throw new PersistenceException("Error al Consultar los Equipos", e);  
        } 
    }

    @Override
    public List<Equipo> consultarEquiposDisponibles() {
        try{ 
            return equipoMapper.consultarEquiposDisponibles(); 
        }  
        catch(org.apache.ibatis.exceptions.PersistenceException e){  
            throw new PersistenceException("Error al Consultar los Equipos Disponibles", e);  
        } 
    }

    public void asociarElementoConEquipo(int idEquipo, int idElemento) throws PersistenceException {
        try{
            //equipoMapper.eliminarAsociacion(idEquipo, idElemento); //Eliminar anterior asociación de elemento
            equipoMapper.asociarElementoConEquipo(idEquipo, idElemento);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al asociar el elemento",ex);
        }
        
    }

    public void darDeBajaEquipo(int idEquipo) throws PersistenceException{
        try{
            equipoMapper.darDeBajaEquipo(idEquipo);
        }catch(PersistenceException e){
            throw new PersistenceException("Error al dar de baja el equipo", e);
        }
    }

    @Override
    public void eliminarAsociacion(int idEquipo, List<Elemento> elementos) throws PersistenceException {
        try{
            for(Elemento e: elementos){
                equipoMapper.eliminarAsociacion(idEquipo, e.getId());
            }
        }catch(PersistenceException e){
            throw new PersistenceException("Error al eliminar la asociacion", e);
        }
    }

    @Override
    public List<Equipo> consultarEquiposActivos() {
        try {
            return equipoMapper.consultarEquiposDisponibles();
        } catch(PersistenceException e){
            throw new PersistenceException("Error al Consultar los Equipos Activos", e);
        }
    }

}
