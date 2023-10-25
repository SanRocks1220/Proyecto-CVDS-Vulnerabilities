package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UserMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;
/**
 * Tipos de elementos posibles
 * @author Daniela Garcia - Team Developer
 */

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper userMapper;

    @Override
    public List<Usuario> consultarUsuarios() {
        try{
            return userMapper.consultarUsuarios();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el usuario", e);
        }
    }
    @Override
    public Usuario infoUsuario(int id) throws PersistenceException{
        try{
            return userMapper.infoUsuario(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar la informacion del usuario", e);
        }
    }

    @Override
    public int id(String usuario) throws PersistenceException{
        try{
            return userMapper.id(usuario);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al buscar el id del usuario", e);
        }
    }

    @Override
    public Usuario consultarUsuario(String email) throws PersistenceException {
        try{
            return userMapper.consultarUsuario(email);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException(persistenceException.getMessage());
        }
    }

}