package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Estimacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstimacion;
    private Integer cantidadHorasEstimadas = 0;
    @OneToOne
    private TipoProblema tipoProblema;

    public Estimacion(Integer cantidadHorasEstimadas, TipoProblema tipoProblema) {
        this.cantidadHorasEstimadas = cantidadHorasEstimadas;
        this.tipoProblema = tipoProblema;
    }

    public Estimacion() {

    }

    public Long getIdEstimacion() {
        return idEstimacion;
    }

    public void setIdEstimacion(Long idEstimacion) {
        this.idEstimacion = idEstimacion;
    }

    public Integer getCantidadHorasEstimadas() {
        return cantidadHorasEstimadas;
    }

    public void setCantidadHorasEstimadas(Integer cantidadHorasEstimadas) {
        this.cantidadHorasEstimadas = cantidadHorasEstimadas;
    }

    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }


    public void agregarEstimacion(Estimacion estimacion1) {
    }


    @Override
    public String toString() {
        return "Estimacion {" +
                "idEstimacion = " + idEstimacion +
                ", cantidadHorasEstimadas = " + cantidadHorasEstimadas +
                ", tipoProblema = '" + tipoProblema + '\'' +
                '}';
    }

}
