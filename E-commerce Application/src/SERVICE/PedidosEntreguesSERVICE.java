package SERVICE;

import DAO.PedidosEntreguesDAO;
import MODEL.PedidosEntreguesMODEL;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosEntreguesSERVICE {
    public static void cadastrarPedidoEntregue(int id_pedido, String data_entrega) {
        try {
            PedidosEntreguesMODEL pedidoEntregue = new PedidosEntreguesMODEL(id_pedido, data_entrega);
            PedidosEntreguesDAO.insertPedidoEntregue(pedidoEntregue);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }  
    }
    
    public static PedidosEntreguesMODEL buscarPedidoEntregue(int id_pedido_entregue) {
        return PedidosEntreguesDAO.selectPedidoEntregue(id_pedido_entregue);
    }
    
    public static List<PedidosEntreguesMODEL> listarPedidosEntregues() {
        return PedidosEntreguesDAO.listPedidosEntregues();
    }
}
