package DAO;
import MODEL.ItensPedidosMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ItensPedidosDAO {
    
    public static void insertItemPedido(ItensPedidosMODEL itemPedido) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO itens_pedidos(id_pedido, id_produto, id_cupom, quantidade, preco_unitario, valor_total)"
            + " VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemPedido.getIdPedido());
            pstm.setInt(2, itemPedido.getIdProduto());
            pstm.setInt(3, itemPedido.getIdCupom());
            pstm.setInt(4, itemPedido.getQuantidade());
            pstm.setDouble(5, getPrecoUnitario(itemPedido)); // consulta o BD na tabela produtos
            pstm.setDouble(6, calcularPrecoTotal(itemPedido)); // consulta o BD na tabela cupons_desconto
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Pedido especificado com sucesso!");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static double calcularPrecoTotal(ItensPedidosMODEL itemPedido) {
        if(itemPedido.getIdCupom() == null) { // o itemPedido nao possui cupom de desconto
            return getPrecoUnitario(itemPedido);
        
        } else {
            try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT percentual_desconto FROM cupons_desconto WHERE id_cupom = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemPedido.getIdCupom());
            ResultSet rs = pstm.executeQuery();
            rs.first();
            Double percentual_desconto = rs.getDouble("percentual_desconto");
            
            // calculo do precoTotal
            Double desconto = (percentual_desconto/100) * (getPrecoUnitario(itemPedido) * itemPedido.getQuantidade()); 
            return (getPrecoUnitario(itemPedido) * itemPedido.getQuantidade()) - desconto; // retorna o precoTotal com desconto
            
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return getPrecoUnitario(itemPedido);
            }
        } // fim do bloco else   
    }
    
    public static Double getPrecoUnitario(ItensPedidosMODEL itemPedido) { // nao pode ser private, pois usarei o metodo para passar valores para a tabela itens_pedido
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT preco_unitario FROM produtos WHERE id_produto = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemPedido.getIdProduto());
            ResultSet rs = pstm.executeQuery();
            rs.first();
            return rs.getDouble("preco_unitario");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}