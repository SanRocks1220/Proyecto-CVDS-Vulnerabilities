package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.AdminServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@ApplicationScoped

public class AdminBean extends BasePageBean{

    @Inject
    private AdminServices services;


    private int id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private TipoElemento tipoElemento;
    private Date fecha;
    private String titulo;
    private String detalle;
    private boolean darBaja;
    private boolean de_baja;
    private Elemento elemento;
    private Equipo eqps;

    public AdminServices getServices(){
        return services;
    }
    public void setServices(AdminServices services){
        this.services=services;
    }
    public void registrarEquipo() throws PersistenceException{
        try {
            services.registrarEquipo(new Equipo(id, nombre, descripcion, disponible, darBaja));
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al registrar el equipo", ex);
        }
    }
    public void registrarElemento() throws PersistenceException{
        try {
            services.registrarElemento(new Elemento(id, nombre, descripcion, tipoElemento, disponible, de_baja, eqps));
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al registrar el elemento", ex);
        }
    }

    public void asociarElementoConEquipo() throws PersistenceException{
        try {
            services.asociarElementoConEquipo(id , elemento.getId());
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al asociar el elemento con el equipo. ", ex);
        }
    }

    public void registrarNovedadEquipo() throws PersistenceException{
        try {
            services.registrarNovedadEquipo(new Novedad(id, fecha, titulo, detalle));
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al registrar la novedad", ex);
        }
    }

    public void registrarNovedadElemento() throws PersistenceException{
        try {
            services.registrarNovedadElemento(new Novedad(id, fecha, titulo, detalle));
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al registrar la novedad", ex);
        }
    }
    public void addMessage(String summary){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }



    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha=fecha;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento=tipoElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    public boolean getDisponible() {
        return disponible;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo=titulo;
    }
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle=detalle;
    }

    public Equipo getEquipo() {
        return eqps;
    }
    public void setEquipo(Equipo eqps) {
        this.eqps=eqps;
    }

    public boolean getDeBaja() {
        return de_baja;
    }
    public void setDeBaja(Boolean de_baja) {
        this.de_baja=de_baja;
    }

}
