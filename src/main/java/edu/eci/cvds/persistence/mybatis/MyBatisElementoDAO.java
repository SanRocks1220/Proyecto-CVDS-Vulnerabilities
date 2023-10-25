package edu.eci.cvds.persistence.mybatis;

import java.util.List;

//import com.google.inject.Inject;
import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;

public class MyBatisElementoDAO implements ElementoDAO {
    
    @Inject 
    private ElementoMapper elementoMapper; 
    
    @Transactional
    @Override public void registrarElemento(Elemento elemento) throws PersistenceException{ 
        try{  
            elementoMapper.registrarElemento(elemento);  
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){ 
            throw new PersistenceException("Error al Registrar el Elemento " + elemento.toString(), e);  
        }  
    } 
    
    @Override public Elemento consultarElemento(int id) throws PersistenceException { 
        try{ 
            return elementoMapper.consultarElemento(id); 
        }  
        catch(org.apache.ibatis.exceptions.PersistenceException e){  
            throw new PersistenceException("Error al Consultar el Elemento " + id, e);  
        } 
    } 

    @Override
    public List<Elemento> consultarElementos() throws PersistenceException {
        try{
            return elementoMapper.consultarElementos();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("No se pudo consultar los elementos disponibles", e);
        }
    }
    @Override
    public void darDeBajaElemento(int id) throws PersistenceException{
        try {
            elementoMapper.setDarDeBaja(id);
        }catch(PersistenceException e){
            System.out.println(e);
            throw new PersistenceException("El elemento ya ha sido dado de baja");
        }
    }

    @Override
    public List<Elemento> consultarElementosDadosDeBaja(){
        try{
            return elementoMapper.consultarElementosDadosDeBaja();
        }catch(PersistenceException ex){
            throw new PersistenceException("No se pudo consultar el elemento");
        }
    }
    @Override
    public void desasociarDeEquipo(int idElemento){
        try{
            elementoMapper.desasociarDeEquipo(idElemento);
        }catch(PersistenceException ex){
            throw new PersistenceException("No se puede desasociar el elemento");
        }
    }

    @Override
    public List<Elemento> consultarElementosNoAsociados(){
        try{
            return elementoMapper.consultarElementosNoAsociados();
        }catch(PersistenceException ex){
            throw new PersistenceException("No se pudo consultar elementos no asociados");
        }
    }

    @Override
    public List<Elemento> consultarRatonesNoAsociados() {
        try {
            return elementoMapper.consultarRatonesNoAsociados();
        } catch (Exception e) {
            throw new PersistenceException("No se pudo consultar ratones no asociados");
        }
    }

    @Override
    public List<Elemento> consultarTorresNoAsociados() {
        try {
            return elementoMapper.consultarTorresNoAsociados();
        } catch (Exception e) {
            throw new PersistenceException("No se pudo consultar torres no asociadas");
        }
        
    }

    @Override
    public List<Elemento> consultarTecladosNoAsociados() {
        try {
            return elementoMapper.consultarTecladosNoAsociados();
        } catch (Exception e) {
            throw new PersistenceException("No se pudo consultar teclados no asociados");
        }
        
    }

    @Override
    public List<Elemento> consultarPantallasNoAsociados() {
        try {
            return elementoMapper.consultarPantallasNoAsociados();
        } catch (Exception e) {
            throw new PersistenceException("No se pudo consultar pantallas no asociadas");
        }
    }

}
