package org.example.repositorios;

import org.example.dominio.Tecnico;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TecnicoRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarTecnico(Tecnico nuevoTecnico) {
        session.beginTransaction();
        session.save(nuevoTecnico);
        session.getTransaction().commit();
    }

    public void actualizarTecnico(Tecnico nuevoTecnico) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoTecnico);
        session.getTransaction().commit();
    }

    public void eliminarTecnico(Tecnico nuevoTecnico) {
        session.beginTransaction();
        session.delete(nuevoTecnico);
        session.getTransaction().commit();
    }

    public List<Tecnico> getTecnicos() {
        return session.createQuery("from Tecnico ", Tecnico.class).list();
    }

    public Tecnico getNombreTecnico(String nombre){
        return session.createQuery("from Tecnico where nombre = :nombre", Tecnico.class).setParameter("nombre", nombre).list().get(0);
    }

}
