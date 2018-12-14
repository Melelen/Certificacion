package dao;
import entidad.TipoDeSuelo;
import java.util.List;

/**
 *
 * @author Mariana Rodríguez
 */
public interface TipoDeSueloDao {
    public TipoDeSuelo buscarPorNombre (String nombre);
    public List<TipoDeSuelo> obtenerTodas();
}
