package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
public class Incidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;
    private String nombre;
    @OneToMany
    private List<Problema> problemas;
    @ManyToOne
    private Servicio servicioReportado;
    @ManyToOne
    private Tecnico tecnicoAsignado;
    private EstadoIncidente estadoIncidente;
    private Long fechaCreacion;
    private Long fechaResolucion;

    public Incidente(String nombre, List<Problema> problemas, Servicio servicioReportado, Tecnico tecnicoAsignado, EstadoIncidente estadoIncidente, String fechaCreacion, String fechaResolucion) {
        this.nombre = nombre;
        this.problemas = problemas;
        this.servicioReportado = servicioReportado;
        this.tecnicoAsignado = tecnicoAsignado;
        this.estadoIncidente = EstadoIncidente.Abierto;
        this.fechaCreacion = Instant.now().getEpochSecond();
    }

    public Incidente() {

    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }

    public Servicio getServicioReportado() {
        return servicioReportado;
    }

    public void setServicioReportado(Servicio servicioReportado) {
        this.servicioReportado = servicioReportado;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public EstadoIncidente getEstadoIncidente() {
        return estadoIncidente;
    }

    public void tomarIncidente() {
        this.estadoIncidente = EstadoIncidente.En_Proceso;
    }

    public void cerrarIncidente() {
        this.estadoIncidente = EstadoIncidente.Resuelto;
        this.fechaResolucion = Instant.now().getEpochSecond();
    }

    public Long getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Long fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Long fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public static void agregarIncidente(Incidente incidente1) {
    }

    public boolean ocurrioHaceNdias(int n){
        Long fechaActual = Instant.now().getEpochSecond();
        fechaActual = fechaActual - 86400*n;
        return fechaResolucion >= fechaActual;
    }

    public boolean especialidadCapacitada(Especialidad e){
        boolean res = true;
        for(Problema p: problemas){
             TipoProblema tProblema = p.getTipoProblema();
             res = res && tProblema.getEspecialidades().contains(e); //
        }
        return res;
    }


    @Override
    public String toString() {
        return "Incidente {" +
                "idIncidente = " + idIncidente +
                ", nombre = '" + nombre + '\'' +
                ", problemas = " + problemas +
                ", servicioReportado = " + servicioReportado +
                ", tecnicoAsignado = " + tecnicoAsignado +
                ", estadoIncidente = " + estadoIncidente +
                ", fechaCreacion = " + fechaCreacion +
                ", fechaResolucion = " + fechaResolucion +
                '}';
    }



}