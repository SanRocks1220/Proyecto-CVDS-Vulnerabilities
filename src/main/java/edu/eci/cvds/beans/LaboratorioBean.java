package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosLaboratorio;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;

@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")

@RequestScoped
public class LaboratorioBean extends BasePageBean{

    @Inject
    private ServiciosLaboratorio services;
    private int id;
    private String nombre;
    private String descripcion;
    private boolean de_baja;
    private Date fechaCreacion;
    private Date fechaCierre;
    private Equipo equipo;

    public ServiciosLaboratorio getServices(){
        return services;
    }
    public void setServices(ServiciosLaboratorio services){
        this.services=services;
    }

    public void registrarLaboratorio() throws PersistenceException, ExcepcionServicios{
        System.out.println("A");
        Date utilDate = new Date();
        Laboratorio laboratorio = new Laboratorio(id, nombre, descripcion, de_baja, new Date(), null);
        System.out.println(laboratorio.toString());
        String mensaje;
        try {
            services.registrarLaboratorio(laboratorio);
            mensaje = "Laboratorio creado correctamente";
            setNombre(null);
            setDescripcion(null);
        }catch (PersistenceException ex){
            mensaje = "Error al crear laboratorio";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
    }


    public void asociarEquipoConLaboratorio() throws ExcepcionServicios{
        try {
            services.asociarEquipo(id, equipo.getId());
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al asociar el equipo con laboratorio", ex);
        }
    }

    public List<Laboratorio> getLaboratorios() {
        List<Laboratorio> labs = new ArrayList<>();
        try {
            labs =  services.consultarLaboratorios();
        }catch (ExcepcionServicios ex){
            System.out.println("Error al consultar laboratorios" + ex.getMessage());
        }
        return labs;
    }

    public void addMessage(String summary){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
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
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }

    public boolean getDe_baja(){
        return de_baja;
    }

    public void setDe_baja(boolean de_baja){
        this.de_baja = de_baja;
    }

    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre(){
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre){
        this.fechaCierre = fechaCierre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}