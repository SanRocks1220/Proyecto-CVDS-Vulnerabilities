package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosEquipo;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")

@RequestScoped
public class EquipoBean extends BasePageBean{

    @Inject
    private ServiciosEquipo services;


    private int id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private boolean darBaja;
    private Elemento ele1, ele2, ele3, ele4;
    private Equipo equipo;
    private Elemento elemento;
    private List<Equipo> equiposDarBajar;

    public ServiciosEquipo getServices(){
        return services;
    }
    public void setServices(ServiciosEquipo services){
        this.services=services;
    }
    
    /**
     * Registra un nuevo equipo 
     * @throws ExcepcionServicios
     **/
    public void registrarEquipo() throws PersistenceException, ExcepcionServicios{
        Equipo equipo =  new Equipo(id, nombre, descripcion);
        try {
            addMessage("Se registro el equipo");
            services.registrarEquipo(equipo);
            setNombre(null);
            setDescripcion(null);
        }catch (PersistenceException ex){
            addMessage("No se registro el equipo");
            throw new PersistenceException("Error al registrar el elemento", ex);
        }
    }

    public List<Equipo> getEquipos() throws ExcepcionServicios{
        try {
            return services.consultarEquipos();
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al consultar elementos", ex);
        }
    }

    public List<Equipo> getEquiposActivos() throws ExcepcionServicios{
        try {
            return services.consultarEquiposActivos();  
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al consultar elementos", ex);
        }
    }

    public List<Equipo> getEquiposDisponibles() throws ExcepcionServicios{
        try {
            return services.consultarEquiposDisponibles();
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al consultar elementos", ex);
        }
    }

    /**
     * Da de baja al Equipo seleccionado
     */
    public void darBajaEquipo(){
        try {
            if (equiposDarBajar.size() > 0) {
                for (Equipo equipo : equiposDarBajar){
                    services.darDeBajaEquipo(equipo.getId());
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elementos dado de baja correctamente", "Elementos dado de baja correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccione por lo menos un elemento", "Seleccione por lo menos un elemento"));
            }
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al intentar dar de baja al elemento", "Error al intentar dar de baja al elemento"));
        }
    }

    public List<Equipo> getEquiposDarBajar() {
        return equiposDarBajar;
    }
    public void setEquiposDarBajar(List<Equipo> equiposDarBajar) {
        this.equiposDarBajar = equiposDarBajar;
    }


    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getDarBaja() {
        return this.darBaja;
    }

    public void setDarBaja(boolean darBaja) {
        this.darBaja = darBaja;
    }

    public Elemento getEle1() {
        return ele1;
    }

    public void setEle1(Elemento ele1) {
        this.ele1 = ele1;
    }

    public Elemento getEle2() {
        return ele2;
    }

    public void setEle2(Elemento ele2) {
        this.ele2 = ele2;
    }

    public Elemento getEle3() {
        return ele3;
    }

    public void setEle3(Elemento ele3) {
        this.ele3 = ele3;
    }

    public Elemento getEle4() {
        return ele4;
    }

    public void setEle4(Elemento ele4) {
        this.ele4 = ele4;
    }

    public Equipo getEquipo(){
        return this.equipo;
    }

    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }
}
