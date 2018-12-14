package dao;

import entidad.Campo;

/**
 *
 * @author Mariana Rodríguez
 */
public interface CampoDao {
    public Campo buscarPorNombre (String nombre);
    public void guardar (Campo campo);
}
