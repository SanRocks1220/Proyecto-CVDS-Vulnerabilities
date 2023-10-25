package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Clase de Laboratorio
 *
 * @author Gabriela Castro - Product Owner / Team Developer
 */
public class Laboratorio implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean de_baja;
    private List<Novedad> novedades;
    private Date fechaCreacion;
    private Date fechaCierre;
    private List<Equipo> equipos;
    /**
     * Constructor de la clase Equipo para equipo disponible
     * @param id identificador del equipo
     * @param nombre cómo se llama el equipo
     * @param descripcion detalle del equipo
     */
    public Laboratorio(int id, String nombre, String descripcion, boolean de_baja, Date fechaCreacion, Date fechaCierre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.de_baja = de_baja;
        this.fechaCierre = fechaCierre;
        this.fechaCreacion = fechaCreacion;
        this.novedades = new ArrayList<Novedad>();
        this.equipos = new ArrayList<Equipo>();
    }

    /**
     * Constructor base de la clase Laboratorio
     */
    public Laboratorio() {
        this.equipos = new ArrayList<Equipo>();
        this.novedades = new ArrayList<Novedad>();
    }

    /**
     * Retorna identificador del laboratorio
     * @return identificador de laboratorio
     */
    public int getId() {
        return id;
    }

    /**
     *Asigna un identificador al laboratorio
     * @param id identificador del laboratorio
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del laboratorio
     * @return cómo se llama el laboratorio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al laboratorio
     * @param nombre cómo se llama el laaboratorio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna detalle del laboratorio
     * @return detalle del laboratorio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Adigna detalle al laboratorio
     * @param descripcion detalle del laboratorio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Revisa la disponibilidad del laboratorio
     * @return está disponible
     */
    public boolean getDeBaja(){
        return de_baja;
    }

    /**
     * Asigna disponibilidad del laboratorio
     * @param de_baja está disponible
     */
    public void setDeBaja(boolean de_baja){
        this.de_baja = de_baja;
    }


    /**
     * Retorna lista de novedades asociadas al laboratorio
     * @return lista de novedades
     */
    public List<Novedad> getNovedades(){
        return this.novedades;
    }

    /**
     * Agrega una novedad a la lista de novedades
     * @param novedad nueva novedad del laboratorio
     */
    public void setNovedad(Novedad novedad){
        novedad.setIdEquipo(this.id);
        this.novedades.add(novedad);
    }

    /**
     * Retorna la lista de los elementos asociados al laboratorio
     * @return elementos asociados al labortorio
     */
    public List<Equipo> getElementos() {
        return equipos;
    }

    /**
     * Agrega un nuevo elemento para asociarlo al laboratorio
     * @param equipo nuevo elemento asociado al laboratorio
     */
    public void setEquipo (Equipo equipo) {
        equipo.setLaboratorio(this);
        this.equipos.add(equipo);
    }

    /**
     * Retorna los equipos asociados a un laboratorio
     * @return Equipos asociados a un laboratorio
     */
    public List<Equipo> getEquipos () {
        return this.equipos;
    }

    /**
     * Permite facil visualizacion de la informacion del equipo
     * @return id, nombre, descripcion
     */
    @Override
    public String toString() {
        return "Laboratorio{" + ", id = " + id + ", nombre = " + nombre + ", descripcion = " + descripcion +
                "fechaCierre" + String.valueOf(fechaCierre) + "fechaCreacion" + String.valueOf(fechaCreacion) + '}';
    }

    /**
     * Retorna la fecha de cierre del laboratorio
     * @return Fecha de cierre del laboratorio
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * Retorna la fecha de creación del laboratorio
     * @return Fecha de creación del laboratorio
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}