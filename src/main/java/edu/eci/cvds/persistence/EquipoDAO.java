package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.*;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
/**
 * Interfaz EquipoDAO, para la entidad Equipo
 * @author Miguel Monroy - Team Developer
 */
public interface EquipoDAO {

    /**
     * Registrar un equipo
     * @param equipo Equipo que se desea registrar
     * @throws PersistenceException
     */
    public void registrarEquipo(Equipo equipo) throws PersistenceException; 

    /**
     * Consultar un equipo
     * @param id Identidicador del equipo a consultar
     * @return Retorna el equipo a consultar
     * @throws PersistenceException
     */
    public Equipo consultarEquipo(int id) throws PersistenceException;

    /**
     * Consultar todos los equipos
     * @return Retorna una lista de Equipos
     * @throws PersistenceException
     */
    public List<Equipo> consultarEquipos() throws PersistenceException;

    /**
     * @author Cesar Vásquez
     * Asociar un elemento a un equipo
     * @param idEquipo Identidicador del equipo al cual se va a asociar el elemento
     * @param idElemento Identidicador del eleemento que se asociará a un equipo
     * @throws PersistenceException
     */
    void asociarElementoConEquipo(int idEquipo, int idElemento) throws PersistenceException;

    /**
     * Vuelve invisible un equipo
     * @param idEquipo Identidicador del equipo a consultar
     * @throws PersistenceException
     */
    public void darDeBajaEquipo(int idEquipo) throws PersistenceException;


    /**
     * Desasociar un elemento a un equipo
     * @param idEquipo Identidicador del equipo al cual se va a asociar el elemento
     * @throws PersistenceException
     */
    public void eliminarAsociacion(int idEquipo, List<Elemento> elementos) throws PersistenceException;
    /**
     * Retorna todos los equipos disponibles para aociarle un elemento
     * @return lista de los equipos disponibles
     * @throws PersistenceException
     */
    public List<Equipo> consultarEquiposDisponibles();

    public List<Equipo> consultarEquiposActivos();
    
}


    