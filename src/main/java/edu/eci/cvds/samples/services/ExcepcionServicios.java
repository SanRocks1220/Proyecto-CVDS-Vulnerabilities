package edu.eci.cvds.samples.services;

public class ExcepcionServicios extends Exception{

    public ExcepcionServicios(String message){super(message);}
    public ExcepcionServicios(){super();}
    public ExcepcionServicios(String message, Exception e) {
        super(message, e);
    }
}
