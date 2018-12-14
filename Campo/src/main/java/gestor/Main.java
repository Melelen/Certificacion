package gestor;

import entidad.Campo;
import entidad.EstadoCampo;
import entidad.Lote;
import entidad.TipoDeSuelo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Melelen
 */
public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()  
			.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            throw e;
	}
        // inicializamos el caso de uso
        new GestorCampo(sessionFactory).run();
    }
}
