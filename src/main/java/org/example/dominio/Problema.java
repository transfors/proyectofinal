package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Problema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblema;
    @ManyToOne
    private Servicio servicio;
    @OneToOne
    private TipoProblema tipoProblema;
    private String fechaEstResolucion;
    private String fechaResolucion;
    private String consideraciones;

    public Problema(Servicio servicio, TipoProblema tipoProblema, String fechaEstResolucion, String fechaResolucion, String consideraciones) {
        this.servicio = servicio;
        this.tipoProblema = tipoProblema;
        this.fechaEstResolucion = fechaEstResolucion;
        this.fechaResolucion = fechaResolucion;
        this.consideraciones = consideraciones;
    }

    public Problema() {

    }


    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getFechaEstResolucion() {
        return fechaEstResolucion;
    }

    public void setFechaEstResolucion(String fechaEstResolucion) {
        this.fechaEstResolucion = fechaEstResolucion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getConsideraciones() {
        return consideraciones;
    }

    public void setConsideraciones(String consideraciones) {
        this.consideraciones = consideraciones;
    }

    @Override
    public String toString() {
        return "Problema {" +
                "idProblema = " + idProblema +
                ", servicio = " + servicio +
                ", tipoProblema = " + tipoProblema +
                ", fechaEstResolucion = " + fechaEstResolucion +
                ", fechaResolucion = " + fechaResolucion +
                ", consideraciones = '" + consideraciones + '\'' +
                '}';
    }
}