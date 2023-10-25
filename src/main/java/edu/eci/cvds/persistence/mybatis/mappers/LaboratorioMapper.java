package edu.eci.cvds.persistence.mybatis.mappers;


import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Laboratorio;


import java.util.List;


public interface LaboratorioMapper {

    public void registrarLaboratorio(@Param("lab") Laboratorio lab);

    public Laboratorio consultarLaboratorio(@Param("id") int id);

    public List<Laboratorio> consultarLaboratorios();
    
    void eliminarAsociacion(@Param("idLab") int idLaboratorio, @Param("idEqui") int idEquipo);

    void asociarLaboratorio(@Param("idLab") int idLab, @Param("idEqui") int idEqui);

}