package entidad;
/**
 *
 * @author Mariana Rodríguez
 */
public class Lote implements java.io.Serializable{
    private int nro;
    private int superficie;
    private TipoDeSuelo tipoDeSuelo;
    private Campo campo;

    public Lote() {
    }

    public Lote(int nro, int superficie, TipoDeSuelo tipoDeSuelo, Campo campo) {
        this.nro = nro;
        this.superficie = superficie;
        this.tipoDeSuelo = tipoDeSuelo;
        this.campo = campo;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public TipoDeSuelo getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    public void setTipoDeSuelo(TipoDeSuelo tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }
    
    @Override
    public String toString() {
        return Integer.toString(nro);
    }    
}
