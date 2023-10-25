/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de equipos
 *
 * @author Gabriela Castro - Product Owner / Team Developer
 */
public class Equipo implements Serializable{
    private int id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private boolean darBaja;
    private List<Novedad> novedades;
    private List<Elemento> elementos;
    private Laboratorio laboratorio;

    /**
     * Constructor de la clase Equipo para equipo disponible
     * @param id identificador del equipo
     * @param nombre cómo se llama el equipo
     * @param descripcion detalle del equipo
     */
    public Equipo(int id, String nombre, String descripcion, boolean disponible, boolean darBaja) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        disponible = this.disponible;
        darBaja = this.darBaja;
        this.novedades = new ArrayList<Novedad>();
        this.elementos = new ArrayList<Elemento>();
        this.laboratorio = null;
    }

    public Equipo(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        disponible = true;
        darBaja = false;
        this.novedades = new ArrayList<Novedad>();
        this.elementos = new ArrayList<Elemento>();
        this.laboratorio = null;
    }

    public Equipo( String nombre, String descripcion) {
        id = 200;
        this.nombre = nombre;
        this.descripcion = descripcion;
        disponible = true;
        darBaja = false;
        this.novedades = new ArrayList<Novedad>();
        this.elementos = new ArrayList<Elemento>();
        this.laboratorio = null;
    }

    /**
     * Constructor base de la clase Equipo
     */
    public Equipo() {
        this.elementos = new ArrayList<Elemento>();
        this.novedades = new ArrayList<Novedad>();
        this.laboratorio = null;
    }

    /**
     * Retorna identificador del equipo
     * @return identificador de equipo
     */
    public int getId() {
        return id;
    }

    /**
     *Asigna un identificador al equipo
     * @param id identificador del equipo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del equipo
     * @return cómo se llama el equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nobre al equipo
     * @param nombre cómo se llama el equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna detalle del equipo
     * @return detalle del equipo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Adigna detalle al equipo
     * @param descrpcion detalle del equipo
     */
    public void setDescrpcion(String descrpcion) {
        this.descripcion = descrpcion;
    }

    /**
     * Revisa la disponibilidad del equipo
     * @return está disponible
     */
    public boolean getDisponible(){
        return disponible;
    }    

    /**
     * Asigna disponibilidad del equipo
     * @param disponible está disponible
     */
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    

    /**
     * Retorna lista de novedades asociadas al equipo
     * @return lista de novedades
     */
    public List<Novedad> getNovedades(){
        return this.novedades;
    }

    /**
     * Agrega una novedad a la lista de novedades
     * @param novedad nueva novedad del equipo
     */
    public void setNovedad(Novedad novedad){
        novedad.setIdEquipo(this.id);
        this.novedades.add(novedad);
    }

    /**
     * Retorna la lista de los elementos asociados al equipo
     * @return elementos asociados al equipo
     */
    public List<Elemento> getElementos() {
        return elementos;
    }

    /**
     * Agrega un nuevo elemento para asociarlo al equipo
     * @param elemento nuevo elemento asociado al equipo
     */
    public void setElementos(Elemento elemento) {
        elemento.setEquipo(this);
        this.elementos.add(elemento);
    }

    /**
     * Permite conocer si el equipo fue dado de baja o no
     * @return True si el equipo fue dado de baja, False en otro caso
     */
    public boolean getBaja(){
        return darBaja;
    }

    public void setDarBaja(boolean darBaja){
        this.darBaja = darBaja;
    }

    public void darBaja(){
        this.setDarBaja(true);
    }


    /**
     * Permite facil visualizacion de la informacion del equipo
     * @return id, nombre, descripcion
     */
    @Override
    public String toString() {
        return "Equipo{id = " + id + ", nombre = " + nombre + ", descripcion = " + descripcion + '}';
    }

    /**
     * Agrega un nuevo elemento para asociarlo al equipo
     * @param laboratorio nuevo laboratorio asociado al equipo
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * Retorna el laboratorio al que pertenece el equipo
     * @return Laboratorio al que pertenece el equipo
     */
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }
}
