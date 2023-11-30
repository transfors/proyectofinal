package org.example.repositorios;

import org.example.dominio.Cliente;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ClienteRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarCliente(Cliente nuevoCliente) {
        session.beginTransaction();
        session.save(nuevoCliente);
        session.getTransaction().commit();
    }

    public void actualizarCliente(Cliente nuevoCliente) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoCliente);
        session.getTransaction().commit();
    }

    public void eliminarCliente(Cliente nuevoCliente) {
        session.beginTransaction();
        session.delete(nuevoCliente);
        session.getTransaction().commit();
    }

    public List<Cliente> getClientes() {
        return session.createQuery("from Cliente", Cliente.class).list();
    }

    public Cliente getClientesPorCUIT(String cuit){
        return session.createQuery("from Cliente where cuit = :cuit", Cliente.class).setParameter("cuit", cuit).list().get(0);
    }

}
