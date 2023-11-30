package org.example.repositorios;

import org.example.dominio.Cliente;
import org.example.dominio.Incidente;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class IncidenteRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.save(nuevoIncidente);
        session.getTransaction().commit();
    }

    public void actualizarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoIncidente);
        session.getTransaction().commit();
    }

    public void eliminarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.delete(nuevoIncidente);
        session.getTransaction().commit();
    }

    public List<Incidente> getIncidentes() {
        return session.createQuery("from Incidente", Incidente.class).list();
    }

    public Incidente getIncidentesPorNombre(String nombre){
        return session.createQuery("from Incidente where nombre = :nombre", Incidente.class).setParameter("nombre", nombre).list().get(0);
    }


}