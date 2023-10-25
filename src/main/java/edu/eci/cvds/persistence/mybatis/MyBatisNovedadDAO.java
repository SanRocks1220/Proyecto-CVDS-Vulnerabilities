package edu.eci.cvds.persistence.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;

/**
 * Contenedor MyBatisNovedadDAO, inyecta NovedadMapper, para la entidad Novedad
 * 
 * @author Santiago Rocha - SCRUM Master / Team Developer
 */
public class MyBatisNovedadDAO implements NovedadDAO {

    @Inject
    private NovedadMapper novedadMapper;

    @Override
    public List<Novedad> consultarNovedades() {
        try {
            return novedadMapper.consultarNovedades();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar Novedades ", e);
        }
    }

    @Override
    public List<Novedad> consultarNovedadesEquipo(Equipo equipo) throws PersistenceException {
        try {
            return novedadMapper.consultarNovedadesEquipo(equipo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar Novedades por el Equipo " + equipo, e);
        }
    }

    @Override
    public void registrarNovedadEquipo(Novedad novedad) throws PersistenceException {
        try {
            novedadMapper.registrarNovedadEquipo(novedad);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al registrar Novedades en el Equipo " + novedad.getIdEquipo(), e);
        }
    }

    @Override
    public List<Novedad> consultarNovedadesElemento(Elemento elemento) throws PersistenceException {
        try {
            return novedadMapper.consultarNovedadesElemento(elemento);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar Novedades por el Elemento " + elemento, e);
        }
    }

    @Override
    public void registrarNovedadElemento(Novedad novedad)
            throws PersistenceException {
        try {
            novedadMapper.registrarNovedadElemento(novedad);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al registrar Novedades en el Elemento " + novedad.getIdElemento(), e);
        }
    }

	@Override
	public void registrarNovedad(Novedad novedad) {
		try {
            novedadMapper.registrarNovedad(novedad);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al registrar Novedades " + novedad.getId(), e);
        }		
	}

    

}
