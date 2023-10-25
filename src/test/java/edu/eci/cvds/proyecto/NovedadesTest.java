package edu.eci.cvds.proyecto;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.client.MyBatisNovedad;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NovedadesTest {
    MyBatisNovedad myBatis = new MyBatisNovedad();
    SqlSessionFactory sessionfact = MyBatisNovedad.getSqlSessionFactory();
    SqlSession sqlss = sessionfact.openSession();

    @Inject
    ServiciosNovedad servicios;

    private NovedadMapper nm;

    private Elemento elemento;
    private Date date;
    private Novedad novedad;
    private Equipo eq;
    private Elemento el1;

    public NovedadesTest() {
        
    }
    
    @Before
    public void setUp() {
        nm = sqlss.getMapper(NovedadMapper.class);

        servicios = ServiciosNovedadFactory.getInstance().getServiciosTesting();
        elemento = new Elemento(11, "Mouse", "ratoncito", TipoElemento.MOUSE);
        date = new Date();
        novedad = new Novedad(1, date,"Mouse dañado", "Ya no funcionan los botones laterales");
        eq = new Equipo(4, "Equipo","Equipo con perifericos de multiples gamas");
        el1 = new Elemento(12, "Mouse", "ratoncito", TipoElemento.MOUSE);
    }

    @Test
    public void test1deberiaRegistrarNovedadEnElementoSuelto(){
        try {
            elemento.setNovedad(novedad);

            Assert.assertEquals(novedad, elemento.getNovedades().get(0));
            Assert.assertEquals(novedad.getIdElemento(), elemento.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test2deberiaRegistrarNovedadEnElementoDeEquipo(){
        try {

            el1.setNovedad(novedad);

            Assert.assertEquals(novedad, el1.getNovedades().get(0));
            Assert.assertEquals(12, novedad.getIdElemento());
            Assert.assertEquals(0, novedad.getIdEquipo());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test3deberiaRegistrarNovedadEnEquipoSinElementos(){
        try {
            eq.setNovedad(novedad);

            Assert.assertEquals(novedad, eq.getNovedades().get(0));
            Assert.assertEquals(novedad.getIdEquipo(), eq.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test4deberiaRegistrarNovedadEnEquipoConElementos(){
        try {
            el1.setNovedad(novedad);
            eq.setElementos(el1);
            eq.setNovedad(novedad);

            Assert.assertEquals(novedad.getIdElemento(), el1.getId());

            Assert.assertEquals(novedad, eq.getNovedades().get(0));
            Assert.assertEquals(novedad.getIdEquipo(), eq.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test5deberiaConsultarNovedades(){
        try {

            List<Novedad> novedadesGuardadas = new ArrayList<>();
            novedadesGuardadas.add(novedad);

            nm.registrarNovedad(novedad);

            Assert.assertNotEquals(novedadesGuardadas, nm.consultarNovedades());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
