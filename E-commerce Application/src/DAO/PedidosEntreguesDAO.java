package DAO;

import MODEL.PedidosEntreguesMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosEntreguesDAO {
    public static void insertPedidoEntregue(PedidosEntreguesMODEL pedidoEntregue) throws ParseException {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO pedidos_entregues(id_pedido, data_entrega) VALUES(?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pedidoEntregue.getIdPedido());
            pstm.setDate(2, pedidoEntregue.getData());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Pedido Entregue REGISTRADO com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static PedidosEntreguesMODEL selectPedidoEntregue(int id_pedido_entregue) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM pedidos_entregues WHERE id_pedido_entregue = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,  id_pedido_entregue);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            java.sql.Date dataEntregaSQL = rs.getDate("data_entrega");
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataEntrega = formatador.format(dataEntregaSQL);

            PedidosEntreguesMODEL pedidoEntregue = new PedidosEntreguesMODEL(rs.getInt("id_pedido"), dataEntrega);
            pedidoEntregue.setIdPedidoEntregue(id_pedido_entregue);
            return pedidoEntregue;

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public static List<PedidosEntreguesMODEL> listPedidosEntregues() {
        List<PedidosEntreguesMODEL> pedidosEntregues = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM pedidos_entregues";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                java.sql.Date dataEntregaSQL = rs.getDate("data_entrega");
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                String dataEntrega = formatador.format(dataEntregaSQL);

                PedidosEntreguesMODEL pedidoEntregue = new PedidosEntreguesMODEL(rs.getInt("id_pedido"), dataEntrega);
                pedidoEntregue.setIdPedidoEntregue(rs.getInt("id_pedido_entregue"));
                pedidosEntregues.add(pedidoEntregue);
            }
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pedidosEntregues;
    }
}
