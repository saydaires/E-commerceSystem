/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE.ADMIN;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aires
 */
public class BuscarCategoria {
    public static Integer buscarIdCategoria(String nomeCategoria) {
        try {    
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT id_categoria FROM categorias WHERE nome_categoria = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeCategoria);
            ResultSet rs = pstm.executeQuery();
            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Cadastre essa categoria!");
                return null;
            }
            rs.first();
            return rs.getInt("id_categoria");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Cadastre essa categoria!");
            return null;
        }
    }
    
    public static String buscarNomeCategoria(int id_categoria) {
        try {    
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT nome_categoria FROM categorias WHERE id_categoria = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_categoria);
            ResultSet rs = pstm.executeQuery();
            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Cadastre essa categoria!");
                return null;
            }
            rs.first();
            return rs.getString("nome_categoria");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Cadastre essa categoria!");
            return null;
        }
    }
}
