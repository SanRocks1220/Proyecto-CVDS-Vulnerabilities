package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 * Interfaz ElementoDAO, para la entidad Elemento
 * @author Cesar Vasquez - Team Developer
 */
public interface ElementoDAO {

    /**
     * Registrar un elemento
     * @param elemento Elemento que se desea registrar
     * @throws PersistenceException
     */
    public void registrarElemento(Elemento elemento) throws PersistenceException; 

    /**
     * Consultar un elemento registrado
     * @param id Identidicador del elemento a consultar
     * @return Retorna el elemento a consultar
     * @throws PersistenceException
     */
    public Elemento consultarElemento(int id) throws PersistenceException;

    /**
     * Consultar todos los elementos 
     * @return Lista de elementos
     * @throws PersistenceException
     */
    List<Elemento> consultarElementos() throws PersistenceException;

    /**
     * Dar de baja un elemento
     * @param id Identidicador del elemento a dar de baja
     * @throws PersistenceException
     */
    void darDeBajaElemento(int id) throws PersistenceException;

    /**
     * Consultar los elementos dados de baja
     * @return Lista de elementos
     * @throws PersistenceException
     */

    List<Elemento> consultarElementosDadosDeBaja() throws PersistenceException;

    /**
     * Desasocia un elemento de un equipo
     * @param id Identidicador del elemento a desasociar
     * @throws PersistenceException
     */
    void desasociarDeEquipo(int id) throws PersistenceException;

    /**
     * Retorna la lista de elementos no asociados
     * @return
     * @throws PersistenceException
     */
    List<Elemento> consultarElementosNoAsociados() throws PersistenceException;

    /** Consultar los ratones disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    public List<Elemento> consultarRatonesNoAsociados();

    /** Consultar las torres disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    public List<Elemento> consultarTorresNoAsociados();

    /** Consultar los teclados disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    public List<Elemento> consultarTecladosNoAsociados();

    /** Consultar las pantallas disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    public List<Elemento> consultarPantallasNoAsociados();

}
