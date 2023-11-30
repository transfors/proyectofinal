package org.example.repositorios;

import org.example.dominio.Servicio;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class ServicioRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarServicio(Servicio nuevoServicio) {
        session.beginTransaction();
        session.save(nuevoServicio);
        session.getTransaction().commit();
    }

    public void actualizarServicio(Servicio nuevoServicio) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoServicio);
        session.getTransaction().commit();
    }

    public void eliminarServicio(Servicio nuevoServicio) {
        session.beginTransaction();
        session.delete(nuevoServicio);
        session.getTransaction().commit();
    }

    public List<Servicio> getServicios() {
        return session.createQuery("from Servicio", Servicio.class).list();
    }

    public Servicio getServiciosPorNombre(String nombreServicio){
        return session.createQuery("from Servicio where nombreServicio = :nombreServicio", Servicio.class).setParameter("nombreServicio", nombreServicio).list().get(0);
    }

}
