package org.example.repositorios;

import org.example.dominio.TipoProblema;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class TipoProblemaRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarTipoProblema(TipoProblema nuevoTipoProblema) {
        session.beginTransaction();
        session.save(nuevoTipoProblema);
        session.getTransaction().commit();
    }

    public void actualizarTipoProblema(TipoProblema nuevoTipoProblema) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoTipoProblema);
        session.getTransaction().commit();
    }

    public void eliminarTipoProblema(TipoProblema nuevoTipoProblema) {
        session.beginTransaction();
        session.delete(nuevoTipoProblema);
        session.getTransaction().commit();
    }

    public List<TipoProblema> getTipoProblema() {
        return session.createQuery("from TipoProblema ", TipoProblema.class).list();
    }

    public TipoProblema getTipoProblemaxnombre(String nombre){
        return session.createQuery("from TipoProblema where nombre = :nombre", TipoProblema.class).setParameter("nombre", nombre).list().get(0);
    }

}
