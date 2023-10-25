package edu.eci.cvds.proyecto;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Test;

import com.google.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.client.MyBatisElemento;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementosTest {
    MyBatisElemento myBatis = new MyBatisElemento();
    SqlSessionFactory sessionfact = MyBatisElemento.getSqlSessionFactory();
    SqlSession sqlss = sessionfact.openSession();

    @Inject
    ServiciosElemento servicios;

    private Elemento elemento;
    private ElementoMapper em;
    private Equipo eq;
    private Elemento el1;
    private Elemento el2;
    private Elemento el3;
    private Elemento el4;


    
    public ElementosTest() {
        servicios = ServiciosElementoFactory.getInstance().getServiciosTesting();
    }
    
    @Before
    public void setUp() {
        elemento = new Elemento(1, "Mouse", "ratoncito", TipoElemento.MOUSE);
        em = sqlss.getMapper(ElementoMapper.class);

        eq = new Equipo(20, "Equipo","Equipo con perifericos de multiples gamas");

        el1 = new Elemento(25, "Mouse", "ratoncito", TipoElemento.MOUSE);
        el2 = new Elemento(26, "Pantalla", "Pantalla 4k, 144Hz", TipoElemento.PANTALLA);
        el3 = new Elemento(27, "Teclado", "Teclado mecanico con rgb", TipoElemento.TECLADO);
        el4 = new Elemento(28, "Torre", "Intel core i9 11°, rtx 3080 ti, 32 RAM, SSD 2TB", TipoElemento.MOUSE);
    }

    @Test
    public void test1deberiaRegistrarElemento(){
        try {
            em.registrarElemento(elemento);
            Assert.assertEquals(1, em.consultarElemento(1).getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2deberiaConsultarElemento(){
        try{
            Elemento consultaElemento = em.consultarElemento(elemento.getId());
            Assert.assertTrue(elemento.getId() == consultaElemento.getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test3deberiaConsultarEquipoAsociado(){
        try{
            

            eq.setElementos(el1);
            eq.setElementos(el2);
            eq.setElementos(el3);
            eq.setElementos(el4);
            
            Equipo consulta = el1.getEquipo();
            Assert.assertEquals(eq, consulta);
            consulta = el2.getEquipo();
            Assert.assertEquals(eq, consulta);
            consulta = el3.getEquipo();
            Assert.assertEquals(eq, consulta);
            consulta = el4.getEquipo();
            Assert.assertEquals(eq, consulta);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test4deberiaConsultarElementosRegistrados(){
        try{
            List<Elemento> elementos = new ArrayList<>();
            
            elementos.add(el1);
            elementos.add(el2);
            elementos.add(el3);
            elementos.add(el4);

            eq.setElementos(el1);
            eq.setElementos(el2);
            eq.setElementos(el3);
            eq.setElementos(el4);

            List<Elemento> consultaElementos = eq.getElementos();

            for (Elemento elemento: elementos){
                Assert.assertTrue(consultaElementos.contains(elemento));
            }
            

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test5deberiaConsultarElementosRegistradosEnBD(){
        try{
            List<Elemento> elementos = new ArrayList<>();        

            List<Elemento> consultaElementos = em.consultarElementos();

            int tam = consultaElementos.size();
            Elemento ele1 = consultaElementos.get(tam-5);
            Elemento ele2 = consultaElementos.get(tam-4);
            Elemento ele3 = consultaElementos.get(tam-3);
            Elemento ele4 = consultaElementos.get(tam-2);

            elementos.add(ele1);
            elementos.add(ele2);
            elementos.add(ele3);
            elementos.add(ele4);

            for (Elemento elemento: elementos){
                Assert.assertTrue(consultaElementos.contains(elemento));
            }
            

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test6deberiaBajarElemento(){
        
        try {
            Elemento elemento = em.consultarElemento(1);
            System.out.println(elemento);
            servicios.darBajaElemento(1);
            System.out.println(elemento);
            Assert.assertFalse(elemento.DeBaja());
        } catch (Exception e) {
            Assert.assertEquals("El elemento ya fue dado de baja", e.getMessage());
        }
    }

}
