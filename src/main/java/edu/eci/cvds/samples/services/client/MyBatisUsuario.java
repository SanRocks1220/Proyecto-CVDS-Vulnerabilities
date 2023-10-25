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

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.persistence.mybatis.mappers.*;


public class MyBatisUsuario {

    @Inject
    public ServiciosUsuario serv;

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



        ElementoMapper em = sqlss.getMapper(ElementoMapper.class);
        em.registrarElemento(new Elemento(1, "raton", "raton ", TipoElemento.MOUSE));


        Elemento consulta = em.consultarElemento(1);
        System.out.println(consulta.getNombre());

    }
}
