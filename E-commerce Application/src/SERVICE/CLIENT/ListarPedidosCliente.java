
package SERVICE.CLIENT;

import MODEL.ClienteMODEL;
import MODEL.ENUM.StatusPedido;
import MODEL.ItensPedidosMODEL;
import MODEL.PedidosMODEL;
import UTIL.ConnectionUTIL;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListarPedidosCliente {
    public static List<PedidosMODEL> listar(ClienteMODEL clienteLogado) {
        List<PedidosMODEL> listaPedidos = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM pedidos WHERE id_cliente = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, clienteLogado.getId());
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                int idCliente = rs.getInt("id_cliente");
                int codigoPedido= rs.getInt("codigo_pedido");
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
                    break;
                case "ENTREGUE":
                    statusPedido = StatusPedido.ENTREGUE;
                }
                
                java.util.Date dataPedido = rs.getDate("data_pedido");
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                String dataFormatada = formatador.format(dataPedido);
                
                PedidosMODEL pedido = new PedidosMODEL(idCliente, codigoPedido, dataFormatada, statusPedido);
                pedido.setIdPedido(idPedido);
                listaPedidos.add(pedido);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado em pedidos!");
        }
        return listaPedidos; 
    }
}
