package SERVICE;

import DAO.PedidosDAO;
import MODEL.ENUM.StatusPedido;
import MODEL.PedidosMODEL;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosSERVICE {
    public static void cadastrarPedido(int id_cliente, String dataPedido, StatusPedido statusPedido) {
        try {
            PedidosMODEL pedido = new PedidosMODEL(id_cliente, dataPedido, statusPedido);
            PedidosDAO.insertPedido(pedido);
            
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    
    public static PedidosMODEL buscarPedido(int id_pedido) {
        return PedidosDAO.selectPedido(id_pedido);
    }
    
    public static List<PedidosMODEL> listarPedidos() {
        return PedidosDAO.listPedidos();
    }
    
    public static boolean deletarPedido(int id_pedido) {
        return PedidosDAO.deletePedido(id_pedido);
    }
    
    public static void atualizarStatusPedido(int id_pedido, StatusPedido novoStatus) {
        PedidosDAO.updateStatusPedido(id_pedido, novoStatus);
    }
}