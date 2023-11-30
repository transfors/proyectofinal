package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Miembro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;
    private String nombre;
//    @ElementCollection
//    private List<Notificacion> notificaciones;
    @OneToMany(mappedBy = "idEspecialidades")
    private List<Especialidad> especialidades = new ArrayList<>();
    private boolean disponible;

    public int[] IncidentesResueltos;
    @OneToMany
    private List<Estimacion> estimaciones = new ArrayList<>();

    public Tecnico(String nombre, List<Especialidad> especialidades, boolean disponible, List<Estimacion> estimaciones) {
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.disponible = disponible;
        this.estimaciones = estimaciones;
        this.IncidentesResueltos = new int[7];
    }

    public Tecnico() {

    }

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

//    public List<Notificacion> getNotificaciones() {
//        return notificaciones;
//    }
//
//    public void Notificar(Notificacion notificacion){this.notificaciones.add(notificacion);}
    public List<Estimacion> getEstimaciones() {
        return estimaciones;
    }

    public void setEstimaciones(List<Estimacion> estimaciones) {
        this.estimaciones = estimaciones;
    }

    public void agregarEspecialidad(Especialidad especialidad3) {
    }

    public void agregarHorasEstimadasResolucion(Estimacion estimacion1) {
    }

    @Override
    public String toString() {
        return "Tecnico {" +
                "idTecnico = " + idTecnico +
                ", nombre = '" + nombre + '\'' +
                ", especialidades = " + especialidades +
                ", disponible = " + disponible +
//                ", notificaciones = '" + notificaciones + '\'' +
                ", estimaciones = " + estimaciones +
                '}';
    }



}
