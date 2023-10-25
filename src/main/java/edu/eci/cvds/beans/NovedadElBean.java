package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosNovedad;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadElBean")

@RequestScoped
public class NovedadElBean extends BasePageBean {

    @Inject
    private ServiciosNovedad services;

    @Inject
    private ServiciosElemento serviciosElemento;

    @ManagedProperty(value = "#{param.elementoId}")
    private Integer idElement;

    private Elemento elemento;



    private int id;
    private Date fecha;
    private String titulo;
    private int carnet;
    private String detalle;
    private int idEquipo;
    private int idElemento;

    private List<Novedad> historialNovedades;
    

    private void loadElemento() {
		try {
			System.out.println("Carga inicial");
			System.out.println("Carga con " + idElement + " y " + serviciosElemento);
			System.out.println("Carga después");
			if (idElement != null) {
				elemento = serviciosElemento.consultarElemento(idElement);
				System.out.println("Encontró: " + elemento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public ServiciosNovedad getServices() {
        return services;
    }

    public void setServices(ServiciosNovedad services) {
        this.services = services;
    }

    public void registrarNovedadElemento() throws PersistenceException, ExcepcionServicios {
        try {
            loadElemento();
            //TODO el elemento NUNCA está entrando a esta función, se pierde esntre el llamado del XHTML y el BEAN
            if (idElement == null) {
				services.registrarNovedad(new Novedad(id, new Date(), titulo, carnet, detalle));
                addMessage("Confirmed", "Novedad Registrada");
			} else {
                services.registrarNovedadElemento(elemento, new Novedad(id, new Date(), titulo, carnet, detalle));
                setCarnet(0);
                setTitulo(null);
                setDetalle(null);
                addMessage("Confirmed", "Novedad Registrada");
            }
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al registrar la novedad", ex);
        }
    }

    public List<Novedad> consultarNovedades() throws PersistenceException, ExcepcionServicios {
        try {
            loadElemento();
            if (idElement == null) {
				return services.consultarNovedades();
			} else {
                return services.consultarNovedadesElemento(elemento);
            }
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar la novedad", ex);
        }
    }

    public List<Novedad> consultarTodasNovedades() throws PersistenceException, ExcepcionServicios {
        try { 
            return services.consultarNovedades();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar las novedades", ex);
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Integer getidElement() {
		return idElement;
	}

	public void setIdElement(Integer idElement) {
		this.idElement = idElement;
	}

    public Elemento getElemento() throws Exception {
		if (elemento == null && idElement != null) {
			elemento = serviciosElemento.consultarElemento(idElement);
		}
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCarnet() {
        return this.carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdElemento() {
        return this.idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public int getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Novedad> getHistorialNovedades() throws PersistenceException, ExcepcionServicios {
        if (historialNovedades == null){
            historialNovedades = consultarNovedades();
        }
        return historialNovedades;
    }

    public void setHistorialNovedades(List<Novedad> historialNovedades) {
        this.historialNovedades = historialNovedades;
    }
}

