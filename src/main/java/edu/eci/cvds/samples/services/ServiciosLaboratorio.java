package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.entities.*;

public interface ServiciosLaboratorio {

    /**
     * @param laboratorio
     * throws ExcepcionServicios
     */
    void registrarLaboratorio(Laboratorio laboratorio) throws ExcepcionServicios;

    /**
     *
     * @param id
     * @return
     * @throws ExcepcionServicios
     */
    Laboratorio consultarLaboratorio(int id) throws ExcepcionServicios;


    List<Laboratorio> consultarLaboratorios() throws ExcepcionServicios;

    /**
     * Asociar un equipo a un laboratorio
     * @param idLaboratorio Identidicador del laboratorio al cual se va a asociar el equipo
     * @param idEquipo Identidicador del equipo que se asociará a un laboratorio
     * @throws ExcepcionServicios
     */
    void asociarEquipo(int idLaboratorio,int idEquipo) throws ExcepcionServicios;

}