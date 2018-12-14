package gestor;

import dao.CampoDao;
import dao.CampoDaoHibernateImpl;
import dao.EstadoCampoDao;
import dao.EstadoCampoDaoHibernateImpl;
import dao.LoteDao;
import dao.LoteDaoHibernateImpl;
import dao.TipoDeSueloDao;
import dao.TipoDeSueloDaoHibernateImpl;
import entidad.Campo;
import entidad.EstadoCampo;
import entidad.Lote;
import entidad.TipoDeSuelo;
import java.util.List;
import org.hibernate.SessionFactory;
import ui.PantallaRegistarCampo;
/**
 *
 * @author Mariana Rodríguez
 */
public class GestorCampo {
    private PantallaRegistarCampo pantalla;
    private final EstadoCampoDao estadoCampoDao;
    private final TipoDeSueloDao tipoDeSueloDao;
    private final CampoDao campoDao; 
    private final LoteDao loteDao;

    public GestorCampo(SessionFactory sessionFactory) {
        this.estadoCampoDao = new EstadoCampoDaoHibernateImpl(sessionFactory);
        this.tipoDeSueloDao = new TipoDeSueloDaoHibernateImpl(sessionFactory);
        this.loteDao = new LoteDaoHibernateImpl(sessionFactory);
        this.campoDao = new CampoDaoHibernateImpl(sessionFactory);
    }
    
    public void run () {
        List<TipoDeSuelo> tipos = tipoDeSueloDao.obtenerTodas();
        EstadoCampo creado = estadoCampoDao.obtenerCreado();
        pantalla = new PantallaRegistarCampo(tipos, creado, this);
        pantalla.setVisible(true);
    }
    
    public boolean campoExistente(String nombre){
        Campo campo=campoDao.buscarPorNombre(nombre);
        if(campo!=null)
            return true;
        else
            return false;
    }

    public int agregarCampo(Campo campo, List<Lote> lotes) {
        campoDao.guardar(campo);
        for(Lote lote:lotes){
            loteDao.guardar(lote);
        }
        return campo.getIdCampo();
    }

}
