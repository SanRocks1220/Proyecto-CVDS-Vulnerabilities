package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Interfaz Mapper para el usuario
 * @author Daniela Garcia - Team Developer
 */

public interface UserMapper {

    public List<Usuario> consultarUsuarios();

    public Usuario infoUsuario(@Param("email") int id);

    public int id(@Param("email") String usuario);

    public Usuario consultarUsuario(@Param("email") String email);


}