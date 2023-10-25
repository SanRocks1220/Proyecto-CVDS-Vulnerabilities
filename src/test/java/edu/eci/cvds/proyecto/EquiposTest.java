package edu.eci.cvds.proyecto;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELClass;

import org.junit.Test;

import com.google.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.client.MyBatisEquipo;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquiposTest {
    MyBatisEquipo myBatis = new MyBatisEquipo();
    SqlSessionFactory sessionfact = MyBatisEquipo.getSqlSessionFactory();
    SqlSession sqlss = sessionfact.openSession();

    @Inject
    ServiciosEquipo servicios;
    ServiciosElemento servicios2;

    private EquipoMapper qm;
    private Equipo eq;
    private Elemento el1;
    private Elemento el2;
    private Elemento el3;
    private Elemento el4;

    public EquiposTest() {
        servicios = ServiciosEquipoFactory.getInstance().getServiciosTesting();
    }
    
    @Before
    public void setUp() {
        qm = sqlss.getMapper(EquipoMapper.class);

        eq = new Equipo(1, "Equipo","Equipo con perifericos de multiples gamas");

        el1 = new Elemento(3, "Mouse", "ratoncito", TipoElemento.MOUSE);
        el2 = new Elemento(4, "Pantalla", "Pantalla 4k, 144Hz", TipoElemento.PANTALLA);
        el3 = new Elemento(5, "Teclado", "Teclado mecanico con rgb", TipoElemento.TECLADO);
        el4 = new Elemento(6, "Torre", "Intel core i9 11°, rtx 3080 ti, 32 RAM, SSD 2TB", TipoElemento.TORRE);

        eq.darBaja();
    }

    @Test
    public void test1deberiaRegistrarEquipo(){
        try{
            qm.registrarEquipo(eq);
            Assert.assertEquals(2, qm.consultarEquipo(2).getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test 
    public void test2deberiaAnadirElementosAEquipo(){
        try {

            List<Elemento> elementos = new ArrayList<>();

            eq.setElementos(el1);
            elementos.add(el1);
            Assert.assertEquals(elementos, eq.getElementos());
            
            eq.setElementos(el2);
            elementos.add(el2);
            Assert.assertEquals(elementos, eq.getElementos());
            
            eq.setElementos(el3);
            elementos.add(el3);
            Assert.assertEquals(elementos, eq.getElementos());
              
            eq.setElementos(el4);
            elementos.add(el4);
            Assert.assertEquals(elementos, eq.getElementos());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test3deberiaConsultarEquipo(){
        try {
            
            Equipo consulta = qm.consultarEquipo(eq.getId());

            Assert.assertEquals(eq.getId(), consulta.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test 
    public void test4deberiaDarBajaEquipo(){
        try{
            Equipo consulta = qm.consultarEquipo(eq.getId());
            Assert.assertEquals(true, eq.getBaja());

        }catch(Exception e){
            fail(e.getMessage());
        }
    }



    // Pedir ayuda, porque no entiendo el error
    // @Test
    // public void testdeberiaAsociarElementoConEquipo(){
    //}
    // @Test
    // public void test5deberiaAsociarElementoConEquipo(){
    //     try {
    //         eq.setElementos(el1);
    //         qm.registrarEquipo(eq);

    //         el1.setEquipoAsociado(eq.getId());
    //         qm.asociarElementoConEquipo(1, 3);
    // @Test
    // public void test5deberiaAsociarElementoConEquipo(){
    //     try {

    //         el1.setEquipoAsociado(eq.getId());
    //         qm.asociarElementoConEquipo(0, 0);
            
    //         Assert.assertEquals(el1.getEquipoAsociado(), eq.getId());
        
    //     }catch (Exception e){
    //         fail(e.getMessage());
    //     }
    // }

    // // Pedir ayuda, porque no entiendo el error
    // @Test
    // public void test5deberiaAsociarElementoConEquipo(){
    //     try {
    //         eq.setElementos(el1);
    //         qm.registrarEquipo(eq);

    //         el1.setEquipoAsociado(eq.getId());
    //         qm.asociarElementoConEquipo(1, 3);
            
    //         Assert.assertEquals(el1.getEquipoAsociado(), eq.getId());
        
    //     }catch (Exception e){
    //         fail(e.getMessage());
    //     }
    // }
    
}
