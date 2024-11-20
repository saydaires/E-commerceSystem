package DAO;

import MODEL.ProdutoMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    public static void insertProduto(ProdutoMODEL produto) {
        try {
        Connection conn = ConnectionUTIL.connectDB();
        String sql = "INSERT INTO produtos(nome_produto, cod_produto, preco_unitario, qtd_estoque, id_categoria) "
        + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, produto.getNome());
        pstm.setString(2, produto.getCod());
        pstm.setDouble(3, produto.getPrecoUnitario());
        pstm.setInt(4, produto.getQtdEstoque());
        pstm.setInt(5, produto.getIdCategoria());
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Produto CADASTRADO com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static ProdutoMODEL selectProdutoNome(String nomeProduto) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM produtos WHERE nome_produto = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeProduto);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            
            Integer idProduto = rs.getInt("id_produto");
            String cod_produto = rs.getString("cod_produto");
            Double precoUnitario = rs.getDouble("preco_unitario");
            int qtdEstoque = rs.getInt("qtd_estoque");
            int id_categoria = rs.getInt("id_categoria");
            ProdutoMODEL produto = new ProdutoMODEL(nomeProduto, cod_produto, qtdEstoque, precoUnitario, id_categoria);
            produto.setIdProduto(idProduto);
            return produto;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto Inexistente!");
            return null;
        }
    }
    
    
    public static ProdutoMODEL selectProdutoCodigo(String cod_produto) { 
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM produtos WHERE cod_produto = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cod_produto);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            
            Integer idProduto = rs.getInt("id_produto");
            String nomeProduto = rs.getString("nome_produto");
            Double precoUnitario = rs.getDouble("preco_unitario");
            int qtdEstoque = rs.getInt("qtd_estoque");
            int id_categoria = rs.getInt("id_categoria");
            ProdutoMODEL produto = new ProdutoMODEL(nomeProduto, cod_produto, qtdEstoque, precoUnitario, id_categoria);
            produto.setIdProduto(idProduto);
            return produto;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto Inexistente!");
            return null;
        }
    }
    
    public static List<ProdutoMODEL> listProdutos() { 
        List<ProdutoMODEL> produtos = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM produtos";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Integer id = rs.getInt("id_produto");
                String nomeProduto = rs.getString("nome_produto");
                String cod_produto = rs.getString("cod_produto");
                Double precoUnitario = rs.getDouble("preco_unitario");
                int qtdEstoque = rs.getInt("qtd_estoque");
                int id_categoria = rs.getInt("id_categoria");
                
                ProdutoMODEL produto = new ProdutoMODEL(nomeProduto, cod_produto, qtdEstoque, precoUnitario, id_categoria);
                produto.setIdProduto(id);
                produtos.add(produto);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado em produtos!");
        }
        return produtos;
    }
    
    public static void updateProduto(ProdutoMODEL produto) {
       try {
           Connection conn = ConnectionUTIL.connectDB();
           String sql = "UPDATE produtos SET preco_unitario = ?, qtd_estoque = ? WHERE id_produto = ?";
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setDouble(1, produto.getPrecoUnitario());
           pstm.setInt(2, produto.getQtdEstoque());
           pstm.setInt(3, produto.getIdProduto());
           pstm.executeUpdate();
           pstm.close();
           JOptionPane.showMessageDialog(null, "Produto ATUALIZADO com sucesso!");
       
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
     public static boolean deleteProduto(ProdutoMODEL produto) {
         try {
             Connection conn = ConnectionUTIL.connectDB();
             String sql = "DELETE FROM produtos WHERE id_produto = ?";
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setInt(1, produto.getIdProduto());
             pstm.executeUpdate();
             pstm.close();
             JOptionPane.showMessageDialog(null, "Produto DELETADO com sucesso!");
             return true;
             
         } catch(SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             return false;
         }
     }
}
