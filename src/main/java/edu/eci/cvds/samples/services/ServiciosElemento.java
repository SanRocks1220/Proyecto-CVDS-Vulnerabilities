package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.entities.*;

public interface ServiciosElemento {
    /**
     * Registrar un elemento
     * @param elemento Elemento que se desea registrar
     * @throws ExcepcionServicios
     */
    void registrarElemento(Elemento elemento) throws ExcepcionServicios;

    /**
     * Consultar un elemento registrado
     * @param id Identidicador del elemento a consultar
     * @return Retorna el elemento a consultar
     * @throws ExcepcionServicios
     */
    Elemento consultarElemento(int id) throws ExcepcionServicios;

    /** Consultar todos los elementos disponibles
     * @return Lista de elementos disponibles
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarElementosDisponibles() throws ExcepcionServicios;

    /** Consultar todos los elementos
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarElementos() throws ExcepcionServicios;

    /** Dar de baja a un elemento
     * @param id Identidicador del elemento que se dará de baja
     * @throws ExcepcionServicios
     */
    void darBajaElemento(int id) throws ExcepcionServicios;
    ;
    /** Consultar los elementos dados de baja
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarElementosDadosDeBaja() throws ExcepcionServicios;

    /**
     * Desasocia un elemento de un equipo
     * @param id Identidicador del elemento a desasociar
     * @throws ExcepcionServicios
     */
    void desasociarDeEquipo(int id) throws ExcepcionServicios;

    /**
     * Consulta lo elementos no asociados
     * @return Lista de elementos no asociados
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarElementosNoAsociados() throws ExcepcionServicios;

    /** Consultar los ratones disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarRatonesNoAsociados() throws ExcepcionServicios;

    /** Consultar las torres disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarTorresNoAsociados() throws ExcepcionServicios;

    /** Consultar los teclados disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarTecladosNoAsociados() throws ExcepcionServicios;

    /** Consultar las pantallas disponibles
     * @return Lista de elementos
     * @throws ExcepcionServicios
     */
    List<Elemento> consultarPantallasNoAsociados() throws ExcepcionServicios;
}
