package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;

public interface AdminServices{

    public abstract void registrarElemento(Elemento elemento) throws PersistenceException;
    
    public abstract void registrarEquipo(Equipo equipo) throws PersistenceException;

    public abstract void registrarNovedadEquipo(Novedad novedad) throws PersistenceException;

    public abstract void registrarNovedadElemento(Novedad novedad) throws PersistenceException;

    public abstract void asociarElementoConEquipo(int idEquipo, int elemento) throws PersistenceException;

    


}