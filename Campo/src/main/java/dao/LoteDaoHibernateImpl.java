/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entidad.Lote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariana Rodríguez
 */
public class LoteDaoHibernateImpl implements LoteDao{
    private final SessionFactory sessionFactory;

    public LoteDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Lote lote) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(lote);
        session.getTransaction().commit();
        session.close();
    }    
}
