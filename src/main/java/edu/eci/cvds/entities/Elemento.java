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
 * Clase base Elemento
 *
 *  @author Gabriela Castro - Product Owner / Team Developer
 */

public class Elemento implements Serializable{

    private int id;
    private String nombre;
    private String descripcion;
    private TipoElemento tipoElemento;
    private boolean disponible;
    private boolean de_baja;
    private Equipo eqps;

    

    private ArrayList<Novedad> novedades;
    private int equipoAsociado;

    /**
     * Constructor base de la clase Elemennto
     */
    public Elemento() {
        this.novedades = new ArrayList<Novedad>();
    }

    /**
     * Constructor con parametros de la clase Elemento
     * @param id int que identifica el elemento
     * @param nombre String con el nombre del elemento
     * @param descripcion String con detalles del Elemento
     * @param tipoElemento puede ser Torre, Pantalla, Mouse o Teclado
     * @param disponible indica la disponibilidad del elemento
     */
    public Elemento(int id, String nombre, String descripcion, TipoElemento tipoElemento, boolean disponible,boolean de_baja, Equipo eqps) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoElemento = tipoElemento;
        this.disponible = true;
        this.de_baja = de_baja;
        this.eqps = eqps;
        this.novedades =new ArrayList<Novedad>();
    }

    /**
     * Segundo constructor de la clase Elemento, para registrar elementos que sí están disponibles
     * @param id identificador del elemento
     * @param nombre cómo se llama el elemento
     * @param descripcion detalle del elemento
     * @param tipoElemento puede ser Torre, Pantalla, Mouse o Teclado
     */
    public Elemento(int id, String nombre, String descripcion, TipoElemento tipoElemento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoElemento = tipoElemento;
        this.disponible = true;
        this.novedades =new ArrayList<Novedad>();
    }

    /**
     * Retorna id del elemento
     * @return identificador del elemento
     */
    public int getId() {
        return id;
    }

    /**
     * Asignar un id al elemento
     * @param id identificador del elemento
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Retorna la especificación del elemento
     * @return Detalle del elemento
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Asigna una especificación a un elemento
     * @param descripcion Detalle del elemento
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * Retorna el nombre del elemento
     * @return Cómo se llama el elemento
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Asigna un nombre al elemento
     * @param nombre cómo desea llamar al elemento
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Retorna el tipo de Elemento
     * @return Puede ser Torre, Pantalla, Mouse o Teclado
     */
    public TipoElemento getTipoElemento(){
        return tipoElemento;
    }

    /**
     *Asigna un tipo de elemento
     * @param tipoElemento Puede ser Torre, Pantalla, Mouse o Teclado
     */
    public void setTipoElemento(TipoElemento tipoElemento){
        this.tipoElemento = tipoElemento;
    }

    /**
     * Verifica la disponibilidad del elemento
     * @return Está disponible
     */
    public boolean getDisponible(){
        return disponible;
    }

    /**
     * Asigna una disponibilidad a un elemento
     * @param disponible Está disponible
     */
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    /**
     * Retorna las novedades asociadas al elemento
     * @return Lista de novedades
     */
    public List<Novedad> getNovedades(){
        return this.novedades;
    }

    /**
     * Agrega una nueva novedad
     * @param novedad Lista de novedades
     */
    public void setNovedad(Novedad novedad){
        novedad.setIdElemento(this.id);

        if (this.eqps != null) {
            novedad.setIdEquipo(this.eqps.getId());
        }
        
        this.novedades.add(novedad);
    }

    /**
     * Retorna el equipo al que está vinculado el elemento
     * @return equipo al que está vinculado el elemento
     */
    public Equipo getEquipo(){
        return this.eqps;
    }

    /**
     * Asigna un equipo para estar vinculado el elemento
     * @param equipo Equipo al que se asignará el elemento
     */
    public void setEquipo(Equipo equipo){
        this.eqps = equipo;
    }

    /**
     * Retorna el identidicador del equipo al cual está asociado este elemento
     * @return identidicador del equipo al cual está asociado este elemento
     */
    public int getEquipoAsociado() {
        return equipoAsociado;
    }

    /**
     * Asigna un identidicador del equipo al cual está asociado este elemento
     * @param equipoAsociado Identidicador del equipo al cual está asociado este elemento
     */
    public void setEquipoAsociado(int equipoAsociado) {
        this.equipoAsociado = equipoAsociado;
    }


    /**
     * Nos permite consultar con facilidad un elemento y sus atributos
     * @return id, nombre, descripcion, disponibilidad
     */
    @Override
    public String toString() {
        return "Elemento{" + "id = " + id + ", nombre = " + nombre + ", descripción = " + descripcion + ", disponible = " + disponible +'}';
    }

    /**
     * Saber si un elemento fue dado de baja o no
     * @return True si el elemento fue dado de baja, False en otro caso
     */
    public boolean DeBaja(){
        return de_baja;
    }

    /**
     * Acualiza el estado de_baja del elemento en cuestión
     * @param de_baja Nuevo estado del elemento
     */
    public void setDeBaja(boolean de_baja){
        this.de_baja = de_baja;
    }

}

