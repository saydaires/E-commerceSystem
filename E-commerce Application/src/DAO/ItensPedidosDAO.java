package DAO;
import MODEL.ItensPedidosMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItensPedidosDAO {
    // esse procedimento sera
    // sera automatizado com uma trigger
    
    public static void insertItemPedido(ItensPedidosMODEL itemPedido) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO itens_pedidos(id_pedido, codigo_pedido, id_produto, quantidade, preco_unitario, valor_total)"
            + " VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemPedido.getIdPedido());
            pstm.setInt(2, itemPedido.getCodigoPedido());
            pstm.setInt(3, itemPedido.getIdProduto());
            pstm.setInt(4, itemPedido.getQuantidade());
            pstm.setDouble(5, itemPedido.getPrecoUnitario()); 
            pstm.setDouble(6, itemPedido.getValorTotal());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Item Pedido especificado com sucesso!");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    // O metodo 'deleteItemPedido' nao e necessario, uma vez que um 'itemPedido' sera deletado
    // no banco de dados sempre que um pedido em 'pedidos' for deletado (ON DELETE CASCADE)

    public static ItensPedidosMODEL selectItempedido(int id_item_pedido) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM itens_pedidos WHERE id_item_pedido = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_item_pedido);
            ResultSet rs = pstm.executeQuery();
            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Dados inexistentes!");
                return null;
            }
            rs.first();
            ItensPedidosMODEL itemPedido = new ItensPedidosMODEL(rs.getInt("id_pedido"), rs.getInt("codigo_pedido"), rs.getInt("id_produto"), 
            rs.getInt("quantidade"), rs.getDouble("preco_unitario"), rs.getDouble("valor_total"));
            itemPedido.setIdItemPedido(id_item_pedido);
            return itemPedido;

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
        
    public static List<ItensPedidosMODEL> listItensPedidos() { 
        List<ItensPedidosMODEL> itensPedidos = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM itens_pedidos";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Integer id_item_pedido = rs.getInt("id_item_pedido");
                int idPedido = rs.getInt("id_pedido");
                int codigoPedido = rs.getInt("codigo_pedido");
                int idProduto = rs.getInt("id_produto");
                int quantidade = rs.getInt("quantidade");
                double precoUnitario = rs.getDouble("preco_unitario");
                double valorTotal = rs.getDouble("valor_total");
                
                ItensPedidosMODEL itemPedido = new ItensPedidosMODEL(idPedido, codigoPedido, idProduto, quantidade, precoUnitario, valorTotal);
                itemPedido.setIdItemPedido(id_item_pedido);
                itensPedidos.add(itemPedido);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado em clientes!");
        }
        return itensPedidos; 
    } 
}
