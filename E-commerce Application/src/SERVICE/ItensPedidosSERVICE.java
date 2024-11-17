package SERVICE;

import DAO.ItensPedidosDAO;
import MODEL.ItensPedidosMODEL;
import java.util.List;

public class ItensPedidosSERVICE {
    public static void cadastrarItemPedido(int id_pedido, int id_produto, Integer id_cupom, int quantidade) {
        ItensPedidosMODEL itemPedido = new ItensPedidosMODEL(id_pedido, id_produto, id_cupom, quantidade);
        ItensPedidosDAO.insertItemPedido(itemPedido);
    }
    
    public static ItensPedidosMODEL buscarItemPedido(int id_pedido) {
        return ItensPedidosDAO.selectItempedido(id_pedido);
    }
    
    public static List<ItensPedidosMODEL> listarItensPedidos() {
        return ItensPedidosDAO.listItensPedidos();
    }
}
