package SERVICE;

import DAO.ItensPedidosDAO;
import MODEL.ItensPedidosMODEL;
import java.util.List;

public class ItensPedidosSERVICE {
    public static void cadastrarItemPedido(int id_pedido, int codigoPedido, int id_produto, int quantidade, double precoUnitario, double valorTotal) {
        ItensPedidosMODEL itemPedido = new ItensPedidosMODEL(id_pedido, codigoPedido, id_produto, quantidade, precoUnitario, valorTotal);
        ItensPedidosDAO.insertItemPedido(itemPedido);
    }
    
    public static ItensPedidosMODEL buscarItemPedido(int id_item_pedido) {
        return ItensPedidosDAO.selectItempedido(id_item_pedido);
    }
    
    public static List<ItensPedidosMODEL> listarItensPedidos() {
        return ItensPedidosDAO.listItensPedidos();
    }
}
