package edu.eci.cvds.samples.services.client;



import java.sql.SQLException;
import com.google.inject.Inject;
import edu.eci.cvds.samples.services.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.mybatis.mappers.*;


public class MyBatisLaboratorio {

    @Inject
    public ServiciosLaboratorio serv;

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {

        SqlSessionFactory sqlSessionFactory = null;

        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }


    public static void main(String args[]) throws SQLException{
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();



        LaboratorioMapper em = sqlss.getMapper(LaboratorioMapper.class);
        em.registrarLaboratorio(new Laboratorio(1, "Lab de prueba", "Nuevo lab", false, null, null));


        Laboratorio consulta = em.consultarLaboratorio(1);
        System.out.println(consulta.getNombre());

    }
}