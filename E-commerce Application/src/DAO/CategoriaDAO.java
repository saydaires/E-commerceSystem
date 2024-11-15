package DAO;

import MODEL.CategoriaMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {
    public static void insertCategoria(CategoriaMODEL categoria) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO categorias(nome_categoria, descricao) VALUES(?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, categoria.getNomeCategoria());
            pstm.setString(2, categoria.getDescricao());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
    }
        public static CategoriaMODEL selectCategoriaNome(String nomeCategoria) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM categorias WHERE nome_categoria = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeCategoria);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            
            Integer idCategoria = rs.getInt("id_categoria");
            String descricao = rs.getString("descricao");
            CategoriaMODEL categoria = new CategoriaMODEL(nomeCategoria, descricao);
            categoria.setId(rs.getInt("id_categoria"));
            return categoria;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public static CategoriaMODEL selectCategoriaId(int id_categoria) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM categorias WHERE id_categoria = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_categoria);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            CategoriaMODEL categoria = new CategoriaMODEL(rs.getString("nome_categoria"), rs.getString("descricao"));
            categoria.setId(id_categoria);
            return categoria;
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public static List<CategoriaMODEL> listCategorias() {
        List<CategoriaMODEL> categorias = new ArrayList<>();

        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM categorias";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                CategoriaMODEL categoria = new CategoriaMODEL(rs.getString("nome_categoria"), rs.getString("descricao"));
                categoria.setId(rs.getInt("id_categoria"));
                categorias.add(categoria);
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return categorias;
    }
}
