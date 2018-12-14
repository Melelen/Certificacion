package dao;

import entidad.TipoDeSuelo;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariana Rodríguez
 */
public class TipoDeSueloDaoHibernateImpl implements TipoDeSueloDao {
    private final SessionFactory sessionFactory;

    public TipoDeSueloDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<TipoDeSuelo> obtenerTodas() {
        Session session = sessionFactory.openSession();
        List<TipoDeSuelo> tipos = session.createQuery("from TipoDeSuelo").list();
        session.close();
        return tipos;        
    }

    @Override
    public TipoDeSuelo buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TipoDeSuelo> query = builder.createQuery(TipoDeSuelo.class);
        Root<TipoDeSuelo> root = query.from(TipoDeSuelo.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        TipoDeSuelo tipoDeSuelo = session.createQuery(query).uniqueResult();
        session.close();   
        return tipoDeSuelo;
    }
    
}
