package entidad;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mariana Rodríguez
 */
public class TipoDeSuelo implements java.io.Serializable {
    private int id;
    private String nombre;
    private List<Lote> lotes=new ArrayList<Lote>();

    public TipoDeSuelo() {
    }

    public TipoDeSuelo(int id, String nombre, List<Lote> lotes) {
        this.id = id;
        this.nombre = nombre;
        this.lotes = lotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    @Override
    public String toString() {
        return nombre;
    }  
}
