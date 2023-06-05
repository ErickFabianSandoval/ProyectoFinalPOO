package org.example.modelo;

import org.example.persistencia.MotocicletaDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaMoto implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Motocicleta> datos;
    private MotocicletaDAO mtdao;

    public ModeloTablaMoto() {
        mtdao = new MotocicletaDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaMoto(ArrayList<Motocicleta> datos) {
        this.datos = datos;
        mtdao = new MotocicletaDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Marca";
            case 2:
                return "Modelo";
            case 3:
                return "Velocidad Max (Km/hr)";
            case 4:
                return "Pais";
            case 5:
                return "Foton(URL)";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Motocicleta tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getMarca();
            case 2:
                return tmp.getModelo();
            case 3:
                return tmp.getVelocidad();
            case 4:
                return tmp.getPais();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setMarca((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setModelo((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setVelocidad((Double) aValue);
                break;
            case 4:
                datos.get(rowIndex).setPais((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    //Metodo que se invoca en el controlador para boton cargar:
    public void cargarDatos(){
        try {
            ArrayList<Motocicleta> tirar = mtdao.obtenerTodo();
            System.out.println(tirar);
            datos = mtdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    //Metodo que se invoca en el controlador para boton agregar:
    public boolean agregarMoto(Motocicleta moto){
        boolean resultado = false;
        try{
            if(mtdao.insertar(moto)){
                datos.add(moto);
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Motocicleta getMotoAtIndex(int idx){
        return datos.get(idx);
    }

    //Metodo que se invoca en el controlador para boton delete:
    public boolean borrarMoto(int id) {
        boolean resultado = false;
        try {
            if (mtdao.delete(id)) {
                resultado = true;
            }else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

    //Metodo que se invoca en el controlador para boton Actualizar:
    public boolean actualizarUnElemento(Object o, int id, int columna){
        boolean resultado = false;
        try {
            if (mtdao.updateUnElemento(o,id,columna)) {
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

}
