package edu.eci.cvds.persistence.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;

/**
 * Interfaz NovedadMapper, para la entidad Novedad
 * @author Santiago Rocha - SCRUM Master / Team Developer
 */
public interface NovedadMapper {

    /**
     * Consultar Novedades 
     * @return Una lista con el historial de novedades
     */
    public List<Novedad> consultarNovedades();

    /**
     * Registrar Novedades 
     * @param novedad novedad a registrar
     */
    public void registrarNovedad(@Param("novedad") Novedad novedad);
    
    /**
     * Consultar Novedades por Equipo
     * @param equipo Equipo del que se desea conocer el historial de Novedades
     * @return Una lista con el historial de novedades asociadas al equipo
     */
    public List<Novedad> consultarNovedadesEquipo(@Param("equipo") Equipo equipo);

    /**
     * Registrar novedad en un equipo
     * @param novedad Novedad que se asociará a un equipo
     */
    public void registrarNovedadEquipo(@Param("novedad") Novedad novedad);


    /**
     * Consultar Novedades por Elemento
     * @param elemento Elemento del que se desea conocer el historial de Novedades
     * @return Una lista con el historial de novedades asociadas al elemento
     */
    public List<Novedad> consultarNovedadesElemento(@Param("elemento") Elemento elemento);
    
    /**
    /**
     * Registrar novedad en un elemeto, 
     * asociado al elemento y al equipo en el que 
     * se encuentra asociado el elemento
     * @param novedad Novedad que se asociará a un elemento
     */
    public void registrarNovedadElemento(@Param("novedad") Novedad novedad);


    
}
