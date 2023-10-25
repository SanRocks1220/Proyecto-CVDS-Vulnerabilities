package edu.eci.cvds.persistence.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;

public interface EquipoMapper {
    
    public void registrarEquipo(@Param("eq") Equipo eq);

    public Equipo consultarEquipo(@Param("id") int id);

    public void registrarNovedadElemento(@Param("novedad") Novedad novedad);

    public List<Equipo> consultarEquipos();
    
    void eliminarAsociacion(@Param("idEqui") int idEquipo, @Param("idElem") int idElemento);

    void asociarElementoConEquipo(@Param("idEqui") int idEquipo, @Param("idElem") int idElemento);

    public void darDeBajaEquipo(@Param("idEqui")int idEquipo);

    public List<Equipo> consultarEquiposDisponibles();

    public List<Equipo> consultarEquiposActivos();
    
}
