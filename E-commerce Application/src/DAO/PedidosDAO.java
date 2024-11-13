package DAO;
import MODEL.PedidosMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import MODEL.ENUM.StatusPedido;

public class PedidosDAO {
    public static void insertPedido(PedidosMODEL pedido) throws ParseException {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO pedidos(id_cliente, data_pedido, status_pedido) VALUES(?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pedido.getIdCliente());
            pstm.setDate(2, pedido.getDataPedido());
            pstm.setString(3, pedido.getStatusPedido());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }
    
    public static PedidosMODEL selectPedido(int id_pedido) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM pedidos WHERE id_pedido = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_pedido);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            java.sql.Date dataPedidoSQL = rs.getDate("data_pedido");
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataPedido = formatador.format(dataPedidoSQL);
            
            String statusPedidoSQL = rs.getString("status_pedido");
            StatusPedido statusPedido = null;
            
            switch(statusPedidoSQL) { // atribuindo ENUM para 'statusPedido'
                case "PENDENTE":
                    statusPedido = StatusPedido.PENDENTE;
                    break;
                case "EM PROCESSAMENTO":
                    statusPedido = StatusPedido.EM_PROCESSAMENTO;
                    break;
                case "ENVIADO" :
                    statusPedido = StatusPedido.ENVIADO;
            }
            
            PedidosMODEL pedido = new PedidosMODEL(rs.getInt("id_cliente"), dataPedido, statusPedido);
            pedido.setIdPedido(id_pedido);
            return pedido;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    //listPedidos
    // deletePedido
    // updatStatusPedido --> Criar uma trigger que exclua o pedido se o status for alterado para ENTREGUE
   
}
