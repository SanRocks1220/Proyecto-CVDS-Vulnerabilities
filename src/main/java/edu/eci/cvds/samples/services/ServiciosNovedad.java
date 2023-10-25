package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.entities.*;

public interface ServiciosNovedad {
    /**
     * Consultar todas las novedades registradas en el servicio
     * @return Lista de todas las novedades registradas en el servicio
     */
    List<Novedad> consultarNovedades();

    /**
     * Registrar una novedad asociada a un Elemento
     * @param novedad Novedad a asociar a un elemento
     * @param elemento elemento al que se asociará la novedad
     * @throws ExcepcionServicios
     */
    void registrarNovedadElemento(Elemento elemento, Novedad novedad) throws ExcepcionServicios;

    /**
     * Registrar una novedad asociada a un Equipo
     * @param novedad Novedad a asociar a un equipo
     * @param equipo equipo al que se asociará la novedad
     * @throws ExcepcionServicios
     */
    void registrarNovedadEquipo(Equipo equipo, Novedad novedad) throws ExcepcionServicios;

    /**
     * Consultar las novedades asociadas a un Elemento
     * @param elemento Elemento del que se desean conocer las novedades
     * @throws ExcepcionServicios
     */
    List<Novedad> consultarNovedadesElemento(Elemento elemento);

    /**
     * Consultar las novedades asociadas a un Equipo
     * @param equipo Equipo del que se desean conocer las novedades
     * @throws ExcepcionServicios
     */
    List<Novedad> consultarNovedadesEquipo(Equipo equipo);

    /**
     * Registra una novedad sin elementos y sin equipos
     * @param novedad Novedad a registrar en el sistema
     */
	void registrarNovedad(Novedad novedad);

    
}
