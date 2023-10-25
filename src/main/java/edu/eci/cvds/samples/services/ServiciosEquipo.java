package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.entities.*;

public interface ServiciosEquipo {

    /**
     * @param equipo
     * @throws ExcepcionServicios
     */
    void registrarEquipo(Equipo equipo) throws ExcepcionServicios;

    /**
     * 
     * @param i
     * @return
     * @throws ExcepcionServicios
     */
    Equipo consultarEquipo(int id) throws ExcepcionServicios;

    /**
     * 
     * @return
     * @throws ExcepcionServicios
     */
    List<Equipo> consultarEquipos() throws ExcepcionServicios;

    /**
     * Asociar un elemento a un equipo
     * @param idEquipo Identidicador del equipo al cual se va a asociar el elemento
     * @param idElemento Identidicador del eleemento que se asociará a un equipo
     * @throws ExcepcionServicios
     */
    void asociarElementoConEquipo(int idEquipo, int idElemento) throws ExcepcionServicios;

     /**
     * Vuelve invisible un equipo de la base de datos
     * @param idEquipo Identidicador del equipo al cual se va a asociar el elemento
     * @param idElemento Identidicador del eleemento que se asociará a un equipo
     * @throws ExcepcionServicios
     */
    void darDeBajaEquipo(int idEquipo) throws ExcepcionServicios;

    /**
     * Retorna todos los equipos disponibles para aociarle un elemento
     * @return lista de los equipos disponibles
     * @throws ExcepcionServicios
     */
    List<Equipo> consultarEquiposDisponibles() throws ExcepcionServicios;

    List<Equipo> consultarEquiposActivos();

    
}
