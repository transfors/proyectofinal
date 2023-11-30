package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    private String nombreServicio;
    private String descripcionServicio;
//    @OneToMany
////    @JoinColumn(name = "idIncidente", referencedColumnName = "idProblema")
//    private List<Problema> tipoProblema = new ArrayList<>();

    public Servicio(String nombreServicio, String descripcionServicio) {
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
    }

    public Servicio() {

    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

//    // METODO PARA AGREGAR LOS TIPOS DE PROBLEMAS
//    public void agregarListaProblemas(Problema problema) {
//        this.tipoProblema.add(problema);
//    }


    @Override
    public String toString() {
        return "Servicio {" +
                "idServicio = " + idServicio +
                ", nombreServicio = '" + nombreServicio + '\'' +
                ", descripcionServicio = '" + descripcionServicio + '\'' +
                '}';
    }

    public void agregarListaProblemas(TipoProblema tipoProblema1) {
    }
}
