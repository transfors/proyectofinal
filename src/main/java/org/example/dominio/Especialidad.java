package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Especialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidades;
    private String nombreEspecialidad;
    private String descripcionEspecialidad;

    public Especialidad(String nombreEspecialidad, String descripcionEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.descripcionEspecialidad = descripcionEspecialidad;
    }

    public Especialidad() {

    }

    public Long getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Long idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getDescripcionEspecialidad() {
        return descripcionEspecialidad;
    }

    public void setDescripcionEspecialidad(String descripcionEspecialidad) {
        this.descripcionEspecialidad = descripcionEspecialidad;
    }

    public void agregarEspecialidad(Especialidad especialidad1) {
    }

    @Override
    public String toString() {
        return "Especialidad {" +
                "idEspecialidades = " + idEspecialidades +
                ", nombreEspecialidad = '" + nombreEspecialidad + '\'' +
                ", descripcionEspecialidad = '" + descripcionEspecialidad + '\'' +
                '}';
    }


}
