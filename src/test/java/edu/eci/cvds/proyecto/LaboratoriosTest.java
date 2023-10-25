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
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.client.MyBatisNovedad;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LaboratoriosTest {
    MyBatisNovedad myBatis = new MyBatisNovedad();
    SqlSessionFactory sessionfact = MyBatisNovedad.getSqlSessionFactory();
    SqlSession sqlss = sessionfact.openSession();

    @Inject
    ServiciosLaboratorio servicios;

    private LaboratorioMapper lm;

    private Elemento elemento;
    private Date date;
    private Novedad novedad;
    private Equipo eq;
    private Elemento el1;

    public LaboratoriosTest() {
        
    }
    
    @Before
    public void setUp() {
        lm = sqlss.getMapper(LaboratorioMapper.class);

        servicios = ServiciosLaboratorioFactory.getInstance().getServiciosTesting();
        elemento = new Elemento(11, "Mouse", "ratoncito", TipoElemento.MOUSE);
        date = new Date();
        novedad = new Novedad(1, date,"Mouse dañado", "Ya no funcionan los botones laterales");
        eq = new Equipo(4, "Equipo","Equipo con perifericos de multiples gamas");
        el1 = new Elemento(12, "Mouse", "ratoncito", TipoElemento.MOUSE);
    }
    
    @Test
    public void test1deberiaCrearUnLaboratorio(){
        try {
            Laboratorio laboratorio = new Laboratorio(1, "Lab test", "Lab test", false, date, date);

            Assert.assertEquals(1, laboratorio.getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2deberiaRegistarUnLaboratorio(){
        try {
            Laboratorio laboratorio = new Laboratorio(1, "Lab test", "Lab test", false, date, date);
            
            lm.registrarLaboratorio(laboratorio);
            //Laboratorio consultaLab = lm.consultarLaboratorio(1);

            //Assert.assertEquals(laboratorio.getId(), consultaLab.getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test3deberiaSetearEquipos(){
        try {
            Laboratorio laboratorio = new Laboratorio(1, "Lab test", "Lab test", false, date, date);
            laboratorio.setEquipo(eq);
            Assert.assertEquals(eq, laboratorio.getEquipos().get(0));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test4deberiaSetearNovedades(){
        try {
            Laboratorio laboratorio = new Laboratorio(1, "Lab test", "Lab test", false, date, date);
            laboratorio.setNovedad(novedad);
            Assert.assertEquals(novedad, laboratorio.getNovedades().get(0));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test5deberiaDarDeBaja(){
        try {
            Laboratorio laboratorio = new Laboratorio(1, "Lab test", "Lab test", false, date, date);
            laboratorio.setDeBaja(false);
            Assert.assertEquals(false, laboratorio.getDeBaja());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test6deberiaConsultarLaboratorios(){
        try {
            List<Laboratorio> labs = lm.consultarLaboratorios();
            Assert.assertTrue(1 >= labs.size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
