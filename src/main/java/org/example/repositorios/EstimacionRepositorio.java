package org.example.repositorios;

import org.example.dominio.Estimacion;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class EstimacionRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.save(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public void actualizarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.saveOrUpdate(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public void eliminarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.delete(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public List<Estimacion> getEstimacion() {
        return session.createQuery("from Estimacion", Estimacion.class).list();
    }

    public Estimacion getEstimacionXCantHsEst(Integer cantHsEst){
        return session.createQuery("from Estimacion where cantidadHorasEstimadas = :cantHsEst", Estimacion.class).setParameter("cantHsEst", cantHsEst).list().get(0);
    }


}


