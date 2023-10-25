package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosElemento;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "elementoBean")

@RequestScoped
public class ElementoBean extends BasePageBean{

    @Inject
    private ServiciosElemento services;
    
    private int id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private TipoElemento tipo;
    private boolean de_baja;
    private Equipo eqps;
    private List<Elemento> elementosDarBajar;

    public ServiciosElemento getServices(){
        return services;
    }
    public void setServices(ServiciosElemento services){
        this.services=services;
    }
    

    /**
     * Registra un nuevo elemento 
     * @throws ExcepcionServicios
     **/
    public void registrarElemento() throws PersistenceException, ExcepcionServicios {
        Elemento elemento = new Elemento(id, nombre, descripcion, tipo, disponible, de_baja, eqps);
        String msg;
        try {
            services.registrarElemento(elemento);
            msg = "Elemento registrado correctamente";
            setTipoElemento(tipo);
            setNombre(null);
            setDescripcion(null);
        } catch (PersistenceException ex) {
            msg = "Fallo al registrar el elemento";
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg));
    }

    /**
     * Consulta elementos disponibles
     * @return Lista de elementos disponibles
     * @throws ExcepcionServicios
     **/
    public List<Elemento> consultarElementosDisponibles() throws ExcepcionServicios{
        try {
            return services.consultarElementosDisponibles();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar los elementos", ex);
        }
    }

    public List<Elemento> getElementos() throws ExcepcionServicios{
        try {
            return services.consultarElementos();
        }catch (PersistenceException ex){
            throw new PersistenceException("Error al consultar elementos", ex);
        }
    }


    

    /**
     * Consulta elementos que han sido dados de baja
     * @return lista de elementos dados de baja
     **/

    public List<Elemento> consultarElementosBajados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarElementosDadosDeBaja();
        }catch(ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar elementos no asociados","Error al consultar elementos no asociados"));
        }
        return elementos;
    }
    /**
     * Consulta elementos no asociados a equipos
     * @return lista de elementos no asociados
     **/
    public List<Elemento> consultarElementosNoAsociados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarElementosNoAsociados();
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar elementos no asociados","Error al consultar elementos no asociados"));
        }
        return elementos;
    }

     /**
     * Consulta ratones no asociados a equipos
     * @return lista de elementos no asociados
     **/
    public List<Elemento> consultarRatonesNoAsociados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarRatonesNoAsociados();
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar ratones no asociados","Error al consultar ratones no asociados"));
        }
        return elementos;
    }

     /**
     * Consulta torres no asociadas a equipos
     * @return lista de elementos no asociados
     **/
    public List<Elemento> consultarTorresNoAsociados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarTorresNoAsociados();
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar torres no asociadas","Error al consultar torres no asociadas"));
        }
        return elementos;
    }

     /**
     * Consulta teclados no asociados a equipos
     * @return lista de elementos no asociados
     **/
    public List<Elemento> consultarTecladosNoAsociados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarTecladosNoAsociados();
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar teclados no asociados","Error al consultar teclados no asociados"));
            }
        return elementos;
    }

     /**
     * Consulta pantallas no asociadas a equipos
     * @return lista de elementos no asociados
     **/
    public List<Elemento> consultarPantallasNoAsociados(){
        List<Elemento> elementos = null;
        try{
            elementos = services.consultarPantallasNoAsociados();
            }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al consultar pantallas no asociadas","Error al consultar elementos no asociadas"));
            }
        return elementos;
    }

    /**
     * Da de baja al elemento seleccionado
     */
    public void darBajaElemento(){
        try {
            if (elementosDarBajar.size() > 0) {
                for (Elemento elemento : elementosDarBajar){
                    services.darBajaElemento(elemento.getId());
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elementos dado de baja correctamente", "Elementos dado de baja correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccione por lo menos un elemento", "Seleccione por lo menos un elemento"));
            }
        }catch (ExcepcionServicios e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al intentar dar de baja al elemento", "Error al intentar dar de baja al elemento"));
        }
    }
    public List<Elemento> getElementosDarBajar() {
        return elementosDarBajar;
    }
    public void setElementosDarBajar(List<Elemento> elementosDarBajar) {
        this.elementosDarBajar = elementosDarBajar;
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

    public TipoElemento getTipoElemento() {
        return this.tipo;
    }

    public void setTipoElemento(TipoElemento tipo) {
        this.tipo = tipo;
    }
    
    public TipoElemento[] tipos(){
        return TipoElemento.values();
    }

}