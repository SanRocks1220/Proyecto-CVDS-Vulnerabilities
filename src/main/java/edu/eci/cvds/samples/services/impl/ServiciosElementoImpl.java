package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.entities.*;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosElemento;

@Singleton
public class ServiciosElementoImpl implements ServiciosElemento{

    @Inject  
    private ElementoDAO elementoDAO;
    
    @Override
    public void registrarElemento(Elemento elemento) throws ExcepcionServicios {
        try { 
            elementoDAO.registrarElemento(elemento);
        }
        catch (PersistenceException  e) {
            throw new ExcepcionServicios("Error al guardar el elemento " + elemento.getNombre(), e);
        }  
    }

    @Override
    public Elemento consultarElemento(int id) throws ExcepcionServicios {
        try { 
            return elementoDAO.consultarElemento(id);
        }
        catch (PersistenceException  ex) {
            throw new ExcepcionServicios("Error al consultar el elemento " + id, ex);  
        }  
    }

    @Override
    public List<Elemento> consultarElementos() throws ExcepcionServicios {
        try { 
            return elementoDAO.consultarElementos();
        }
        catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar los elementos disponibles ", e);
        }  
    }

    @Override
    public void darBajaElemento(int id) throws ExcepcionServicios{
        try{
            elementoDAO.darDeBajaElemento(id);
        }catch (PersistenceException e){
            throw new PersistenceException("El elemento ya fue dado de baja");
        }
    }

    @Override
    public List<Elemento> consultarElementosDadosDeBaja() throws ExcepcionServicios{
        try{
            return elementoDAO.consultarElementosDadosDeBaja();
        }
        catch(PersistenceException e){
            throw new PersistenceException("Error al consultar los elementos dados de baja ", e);
        }
    }

    @Override
    public void desasociarDeEquipo(int idElemento) throws ExcepcionServicios{
        try{
            elementoDAO.desasociarDeEquipo(idElemento);
        }catch (PersistenceException ex){
            throw new PersistenceException("No se pudo desasociar el elemento del quipo");
        }
    }

    public List<Elemento> consultarElementosDisponibles() throws ExcepcionServicios {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Elemento> consultarElementosNoAsociados() throws ExcepcionServicios{
        try{
            return elementoDAO.consultarElementosNoAsociados();
        }catch (PersistenceException ex){
            throw new ExcepcionServicios("No se pudo consultar los elementos no asociados");
        }
    }

    @Override
    public List<Elemento> consultarRatonesNoAsociados() throws ExcepcionServicios {
        try {
            return elementoDAO.consultarRatonesNoAsociados();
        } catch (Exception e) {
            throw new ExcepcionServicios("No se pudo consultar los ratones no asociados");
        }     
    }

    @Override
    public List<Elemento> consultarTorresNoAsociados() throws ExcepcionServicios {
        try {
            return elementoDAO.consultarTorresNoAsociados();
        } catch (Exception e) {
            throw   new ExcepcionServicios ("No se pudo consultar las torres no asociadas"); 
        }
    }

    @Override
    public List<Elemento> consultarTecladosNoAsociados() throws ExcepcionServicios {
        try {
            return elementoDAO.consultarTecladosNoAsociados();
        } catch (Exception e) {
            throw new ExcepcionServicios ("No se pudo consultar los teclados no asociados");
        }
    }

    @Override
    public List<Elemento> consultarPantallasNoAsociados() throws ExcepcionServicios {
        try {
            return elementoDAO.consultarPantallasNoAsociados();
        } catch (Exception e) {
            throw   new ExcepcionServicios ("No se pudo consultar las pantallas no  asociadas"); 
        }
    }
}
