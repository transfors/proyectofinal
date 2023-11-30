package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoProblema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProblema;
    private String nombre;
    private String descripcionProblema;
    private Integer maxHsResolucion = 0;

    @OneToMany(mappedBy = "idEspecialidades")
    private List<Especialidad> especialidades = new ArrayList<>();

    public TipoProblema(String nombre, String descripcionProblema, Integer maxHsResolucion, List<Especialidad> especialidades) {
        this.nombre = nombre;
        this.descripcionProblema = descripcionProblema;
        this.maxHsResolucion = maxHsResolucion;
        this.especialidades = especialidades;
    }

    public TipoProblema() {

    }

    public Long getIdTipoProblema() {
        return idTipoProblema;
    }

    public void setIdTipoProblema(Long idTipoProblema) {
        this.idTipoProblema = idTipoProblema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public Integer getMaxHsResolucion() {
        return maxHsResolucion;
    }

    public void setMaxHsResolucion(Integer maxHsResolucion) {
        this.maxHsResolucion = maxHsResolucion;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void agregarTipoProblema(TipoProblema tipoProblema1) {
    }
    @Override
    public String toString() {
        return "tipoProblema {" +
                "idTipoProblema = " + idTipoProblema +
                ", nombre = '" + nombre + '\'' +
                ", descripcionProblema = '" + descripcionProblema + '\'' +
                ", maxHsResolucion = " + maxHsResolucion +
                ", especialidades = " + especialidades +
                '}';
    }


}
