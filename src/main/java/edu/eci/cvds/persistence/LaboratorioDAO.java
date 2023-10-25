package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Laboratorio;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

/**
 * Interfaz LaboratorioDAO, para la entidad Laboratorio
 * @author Gabriela Castro - Product Owner / Team Developer
 */
public interface LaboratorioDAO {
    /**
     * Registrar un equipo
     * @param laboratorio Laboratorio que se desea registrar
     * @throws PersistenceException
     */
    public void registrarLaboratorio(Laboratorio laboratorio) throws PersistenceException;

    /**
     * Consultar un equipo
     * @param id Identificador del equipo a consultar
     * @return Retorna el equipo a consultar
     * @throws PersistenceException
     */
    public Laboratorio consultarLaboratorio(int id) throws PersistenceException;

    public List<Laboratorio> consultarLaboratorios() throws PersistenceException;

    /**
     * Asociar un equipo a un laboratorio
     * @param idLaboratorio Identidicador del laboratorio al cual se va a asociar el equipo
     * @param idEquipo Identidicador del equipo que se asociará a un laboratorio
     * @throws PersistenceException
     */
    void asociarEquipo(int idLaboratorio, int idEquipo) throws PersistenceException;


}