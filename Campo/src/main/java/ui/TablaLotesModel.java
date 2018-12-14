package ui;

import entidad.Lote;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mariana Rodríguez
 */
public class TablaLotesModel extends AbstractTableModel{
    private static final String[] COLUMNAS = { "Nro.", "Superficie", "Tipo De Suelo"};
    private List<Lote> lotes;

    public TablaLotesModel(List<Lote> lotes) {
        super();
        this.lotes = lotes;
    }
    
    @Override
    public int getRowCount() {
        return lotes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Lote lote = lotes.get(fila);
        
        // Según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = lote.getNro();
                break;
            case 1:
                retorno = lote.getSuperficie();
                break;
            case 2:
                retorno = lote.getTipoDeSuelo();
                break;
        }
        return retorno;        
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }
    
    public Lote obtenerPuestoEn (int fila) {
        return lotes.get(fila);
    }

    public void setPuestos(List<Lote> lotes) {
        this.lotes = lotes;
    }
    
}
