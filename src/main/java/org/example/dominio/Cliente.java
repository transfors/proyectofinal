package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Miembro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String razonSocial;
    private String cuit;
    private String mail;
    @ManyToMany
    private List<Servicio> servicioContratados = new ArrayList<>();

    public Cliente(String razonSocial, String cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public Cliente() {

    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Servicio> getServiciosContratados() {
        return servicioContratados;
    }

    public List<Servicio> getServicioContratados() {
        return servicioContratados;
    }

    public void setServicioContratados(List<Servicio> servicioContratados) {
        this.servicioContratados = servicioContratados;
    }

    public void setServiciosContratados(List<Servicio> servicioContratados) {
        this.servicioContratados = servicioContratados;
    }

    // METODO PARA AGREGAR LOS SERVICIOS CONTRATADOS
    public void agregarServiciosContratados(Servicio servicio) {
        this.servicioContratados.add(servicio);
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "idCliente = " + idCliente +
                ", razonSocial = '" + razonSocial + '\'' +
                ", cuit = '" + cuit + '\'' +
                ", mail = '" + mail + '\'' +
                ", servicioContratados = " + servicioContratados +
                '}';
    }



}