package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.LaboratorioDAO;
import org.mybatis.guice.transactional.Transactional;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;
import javax.inject.Inject;



import java.util.List;

public class MyBatisLaboratorioDAO implements LaboratorioDAO {

    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Transactional
    @Override
    public void registrarLaboratorio(Laboratorio laboratorio) throws PersistenceException{
        try{
            laboratorioMapper.registrarLaboratorio(laboratorio);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al Registrar el Laboratorio " + laboratorio.toString(), e);
        }
    }

    @Override
    public Laboratorio consultarLaboratorio(int id) throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorio(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al Consultar el Laboratorio " + id, e);
        }
    }
    public List<Laboratorio> consultarLaboratorios() throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorios();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage() + "====================================");
            e.printStackTrace();
            System.out.println(e.getMessage() + "====================================");
            throw new PersistenceException("Error al Consultar los laboratorios", e);
        }
    }

    @Override
    public void asociarEquipo(int idLaboratario, int idEquipo) throws PersistenceException {
        try{
            laboratorioMapper.asociarLaboratorio(idLaboratario, idEquipo);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al asociar el equipo",ex);
        }

    }



}