/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase de Novedades
 * @author Gabriela Castro - Product Owner / Team Developer
 * @author Santiago Rocha - SCRUM Master / Team Developer
 */
public class Novedad implements Serializable {

    private int id;
    private Date fecha;
    private String titulo;
    private String detalle;
    private int carnet;
    private int idEquipo;
    private int idElemento;

    /**
     * Constructor de la clase novedad
     * @param id identificador de la novedad
     * @param fecha fecha de creacion de la novedad
     * @param titulo nombre de la novedad
     * @param detalle descripcion de la novedad
     */
    public Novedad(int id, Date fecha, String titulo, String detalle) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.detalle = detalle;
    }

    /**
     * Constructor de la clase novedad
     * @param id identificador de la novedad
     * @param fecha fecha de creacion de la novedad
     * @param titulo nombre de la novedad
     * @param detalle descripcion de la novedad
     */
    public Novedad(int id, Date fecha, String titulo, int carnet, String detalle) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.carnet = carnet;
        this.detalle = detalle;
    }

    /**
     * Constructor base de novedades
     */
    public Novedad() {
    }


    /**
     * Retorna identificador de la novedad
     * @return identificador de la novedad
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna un identificador a la novedad
     * @param id identificador de la novedad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna la fecha de la creacion de la novedad
     * @return fecha de creacion
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * asigna fecha de creacion
     * @param fecha fecha de creacion
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna nombre de la novedad
     * @return nombre de la novedad
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Asigna un nombre a la novedad
     * @param titulo nombre de la novedad
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna el carnet de quien registró la novedad
     * @return carnet de quien registró la novedad
     */
    public int getCarnet() {
        return this.carnet;
    }

    /**
     * Asigna el carnet de quien registró la novedad
     * @param carnet numero de carnet de quien registró la novedad
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * Retorna descripcion de la novedad
     * @return detalle de novedad
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Asigna descripcion a novedad
     * @param detalle descripcion de la novedad
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * Retorna identificador de Equipo asociado a la novedad
     * @return identificador de equipo asociado
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Asigna un identificador del equipo asociado a la novedad
     * @param idEquipo identificador del equipo asociado
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna identificador del elemento asociado a la novedad
     * @return identificador del elemento asocido
     */
    public int getIdElemento() {
        return idElemento;
    }

    /**
     * Asigna un identificador de elemento asociado a la novedad
     * @param idElemento identificador del elemento
     */
    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Permite facil visualizacion de la novedad
     * @return id, fecha, titulo, detalle
     */
    @Override
    public String toString() {
        return "Novedad{" + "id=" + id + ", fecha = " + fecha + ", titulo = " + titulo + ", detalle = " + detalle + '}';
    }

}
