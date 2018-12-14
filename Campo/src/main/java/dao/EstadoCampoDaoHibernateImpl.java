package dao;

import entidad.EstadoCampo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariana Rodríguez
 */
public class EstadoCampoDaoHibernateImpl implements EstadoCampoDao {
    private final SessionFactory sessionFactory;

    public EstadoCampoDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public EstadoCampo obtenerCreado() {
        Session session = sessionFactory.openSession();
        EstadoCampo creado = session.get(EstadoCampo.class, 1);
        session.close();
        return creado;
    }
}
