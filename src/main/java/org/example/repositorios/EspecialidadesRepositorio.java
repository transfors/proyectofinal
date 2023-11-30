package org.example.repositorios;

import org.example.dominio.Especialidad;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class EspecialidadesRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarEspecialidades(Especialidad nuevaEspecialidad) {
        session.beginTransaction();
        session.save(nuevaEspecialidad);
        session.getTransaction().commit();
    }

    public void actualizarEspecialidades(Especialidad nuevaEspecialidad) {
        session.beginTransaction();
        session.saveOrUpdate(nuevaEspecialidad);
        session.getTransaction().commit();
    }

    public void eliminarEspecialidades(Especialidad nuevaEspecialidad) {
        session.beginTransaction();
        session.delete(nuevaEspecialidad);
        session.getTransaction().commit();
    }

    public List<Especialidad> getEspecialidades() {
        return session.createQuery("from Especialidad ", Especialidad.class).list();
    }

    public Especialidad getNombreEspecialidad(String nombreEspecialidad){
        return session.createQuery("from Especialidad where nombreEspecialidad = :nombreEspecialidad", Especialidad.class).setParameter("nombreEspecialidad", nombreEspecialidad).list().get(0);
    }


}