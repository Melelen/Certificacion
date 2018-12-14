package entidad;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Mariana Rodríguez
 */
public class Campo implements java.io.Serializable {

     private Integer idCampo;
     private String nombre;
     private int superficie;
     private EstadoCampo estadoCampo;
     private List<Lote> lotes;

    public Campo() {
    }
	
    public Campo(String nombre, int superficie, EstadoCampo estadoCampo) {
        this.idCampo=0;
        this.nombre = nombre;
        this.superficie = superficie;
        this.estadoCampo = new EstadoCampo();
        this.lotes = new ArrayList<Lote>();
    }
    
    public Campo(String nombre, int superficie, EstadoCampo estadoCampo, List<Lote> lotes) {
        this.idCampo=0;
        this.nombre = nombre;
        this.superficie = superficie;
        this.estadoCampo = estadoCampo;
        this.lotes = lotes;
    }
   
    public Integer getIdCampo() {
        return this.idCampo;
    }
    
    public void setIdCampo(Integer idCampo) {
        this.idCampo = idCampo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSuperficie() {
        return this.superficie;
    }
    
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    public EstadoCampo getEstadoCampo() {
        return this.estadoCampo;
    }
    
    public void setEstadoCampo(EstadoCampo estadoCampo) {
        this.estadoCampo = estadoCampo;
    }
    public List<Lote> getLotes() {
        return this.lotes;
    }
    
    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    @Override
    public String toString() {
        return nombre;
    }




}


