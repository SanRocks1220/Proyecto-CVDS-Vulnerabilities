package edu.eci.cvds.persistence.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.*;

public interface ElementoMapper {
    
    public void registrarElemento(@Param("ele") Elemento ele);

    public Elemento consultarElemento(@Param("id") int id);

    List<Elemento> consultarElementos();

    List<Novedad> consultarNovedadesDeElemento(@Param("idElemento") int idElemento);

    public void registrarNovedadElemento(@Param("novedad") Novedad novedad);

    void setDarDeBaja(@Param("idElemento") int idElemento);

    List<Elemento> consultarElementosDadosDeBaja();

    void desasociarDeEquipo(@Param("idElemento") int idElemento);

    List<Elemento> consultarElementosNoAsociados();

    public List<Elemento> consultarRatonesNoAsociados();

    public List<Elemento> consultarTorresNoAsociados();

    public List<Elemento> consultarTecladosNoAsociados();

    public List<Elemento> consultarPantallasNoAsociados();
    
}
