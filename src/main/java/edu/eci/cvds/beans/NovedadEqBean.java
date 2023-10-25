package edu.eci.cvds.beans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServicios;
import edu.eci.cvds.samples.services.ServiciosEquipo;
import edu.eci.cvds.samples.services.ServiciosNovedad;

import javax.faces.bean.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadEqBean")
@RequestScoped

public class NovedadEqBean extends BasePageBean {

    @Inject
    private ServiciosNovedad services;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    @ManagedProperty(value = "#{param.equipo}")
    private Integer idEquip;

    private Equipo equipo;



    private int id;
    private Date fecha;
    private String titulo;
    private int carnet;
    private String detalle;
    private int idEquipo;
    private int idElemento;

    private void loadEquip() {
		try {
			System.out.println("Carga inicial");
			System.out.println("Carga con " + idEquip + " y " + serviciosEquipo);
			System.out.println("Carga después");
			if (idEquip != null) {
				equipo = serviciosEquipo.consultarEquipo(idEquip);
				System.out.println("Encontró: " + equipo);
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

    public void registrarNovedadEquipo() throws PersistenceException, ExcepcionServicios {
        try {
            loadEquip();
            //TODO el equipo NUNCA está entrando a esta función, se pierde esntre el llamado del XHTML y el BEAN
            if (idEquip == null) {
				services.registrarNovedad(new Novedad(id, new Date(), titulo, carnet, detalle));
                addMessage("Confirmed", "Novedad Registrada");
			} else {
                services.registrarNovedadEquipo(equipo, new Novedad(id, new Date(), titulo, carnet, detalle));
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
            loadEquip();
            if (idEquip == null) {
				return services.consultarNovedades();
			} else {
                return services.consultarNovedadesEquipo(equipo);
            }
        } catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar la novedad", ex);
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Integer getidEquip() {
		return idEquip;
	}

	public void setIdEquip(Integer idEquip) {
		this.idEquip = idEquip;
	}

    public Equipo getEquipo() throws Exception {
		if (equipo == null && idEquip != null) {
			equipo = serviciosEquipo.consultarEquipo(idEquip);
		}
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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

    public int getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdElemento() {
        return this.idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }
}

