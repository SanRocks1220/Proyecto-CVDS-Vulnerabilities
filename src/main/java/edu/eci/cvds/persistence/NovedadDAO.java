package edu.eci.cvds.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;

/**
 * Interfaz NovedadDAO, para la entidad Novedad
 * 
 * @author Santiago Rocha - SCRUM Master / Team Developer
 */
public interface NovedadDAO {

    /**
     * Consultar todas las novedades registradas en el servicio
     * @return Lista de todas las novedades registradas en el servicio
     */
    public List<Novedad> consultarNovedades();

    /**
     * Consultar Novedades por Equipo
     * 
     * @param equipo Equipo del que se desea conocer el historial de Novedades
     * @return Una lista con el historial de novedades asociadas al equipo
     */
    public List<Novedad> consultarNovedadesEquipo(Equipo equipo) throws PersistenceException;

    /**
     * Registrar novedad en un equipo
     * 
     * @param equipo  Equipo al que asociar la novedad
     * @throws PersistenceException
     */
    public void registrarNovedadEquipo(Novedad novedad) throws PersistenceException;

    /**
     * Consultar Novedades por Elemento
     * 
     * @param elemento Elemento del que se desea conocer el historial de Novedades
     * @return Una lista con el historial de novedades asociadas al elemento
     */
    public List<Novedad> consultarNovedadesElemento(Elemento elemento) throws PersistenceException;

    /**
     * Registrar novedad en un elemeto,
     * asociado al elemento y al equipo en el que
     * se encuentra asociado el elemento
     * 
     * @param elemento Elemento al que asociar la novedad
     * @throws PersistenceException
     */
    public void registrarNovedadElemento(Novedad novedad) throws PersistenceException;

    /**
     * Registra una novedad sin elementos y sin equipos
     * @param novedad Novedad a registrar en el sistema
     */
    public void registrarNovedad(Novedad novedad);

    

}
