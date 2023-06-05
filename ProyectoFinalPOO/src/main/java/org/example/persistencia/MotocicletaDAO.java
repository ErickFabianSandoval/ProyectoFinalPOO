package org.example.persistencia;

import org.example.modelo.Motocicleta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MotocicletaDAO implements InterfazDAO {
    public MotocicletaDAO() {
    }

    //Metodo invocado en el modelo en el metodo AgregarMoto
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO motos(marca,modelo,velocidad,pais,url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Motocicleta) obj).getMarca());
        pstm.setString(2, ((Motocicleta) obj).getModelo());
        pstm.setDouble(3, ((Motocicleta) obj).getVelocidad());
        pstm.setString(4, ((Motocicleta) obj).getPais());
        pstm.setString(5, ((Motocicleta) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE motos SET marca = ?,modelo = ?,velocidad = ?,pais = ?,url = ? WHERE id = ? ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Motocicleta) obj).getMarca());
        pstm.setString(2, ((Motocicleta) obj).getModelo());
        pstm.setDouble(3, ((Motocicleta) obj).getVelocidad());
        pstm.setString(4, ((Motocicleta) obj).getPais());
        pstm.setString(5, ((Motocicleta) obj).getUrl());
        pstm.setInt(6, ((Motocicleta) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo actualizarUnElemento
    public boolean updateUnElemento(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm= null;
        switch (columna){
            case 0:
                System.out.println("No se puede actualizar un id");
                break;
            case 1:
                sqlDelete = "UPDATE motos SET marca = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE motos SET modelo = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE motos SET velocidad = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setDouble(1, (Double)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE motos SET pais = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE motos SET url = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo borrarMoto
    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM motos WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, id);
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM motos";
        ArrayList<Motocicleta> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("motosDB.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Motocicleta(rst.getInt(1), rst.getString(2),
                        rst.getString(3), rst.getDouble(4), rst.getString(5),
                        rst.getString(6)));
            }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM motos WHERE id = ?";
        Motocicleta moto = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            moto = new Motocicleta(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getDouble(4), rst.getString(5),
                    rst.getString(6));

            return moto;
        }
        return null;
    }

}
