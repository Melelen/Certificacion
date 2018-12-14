package dao;

import entidad.Campo;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariana Rodriguez
 */
public class CampoDaoHibernateImpl implements CampoDao {
    private final SessionFactory sessionFactory;

    public CampoDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Campo buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Campo> query = builder.createQuery(Campo.class);
        Root<Campo> root = query.from(Campo.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        Campo campo = session.createQuery(query).uniqueResult();
        session.close();
        return campo;     
    }

    @Override
    public void guardar(Campo campo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(campo);
        session.getTransaction().commit();
        session.close();
    }
    
}
