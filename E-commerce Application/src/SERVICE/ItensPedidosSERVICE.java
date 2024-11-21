package SERVICE;

import DAO.ItensPedidosDAO;
import MODEL.ItensPedidosMODEL;
import java.util.List;

public class ItensPedidosSERVICE {
    public static void cadastrarItemPedido(int id_pedido, int id_produto, Integer id_cupom, int quantidade, double precoUnitario, double valorTotal) {
        ItensPedidosMODEL itemPedido = new ItensPedidosMODEL(id_pedido, id_produto, id_cupom, quantidade, precoUnitario, valorTotal);
        ItensPedidosDAO.insertItemPedido(itemPedido);
    }
    
    public static ItensPedidosMODEL buscarItemPedido(int id_item_pedido) {
        return ItensPedidosDAO.selectItempedido(id_item_pedido);
    }
    
    public static List<ItensPedidosMODEL> listarItensPedidos() {
        return ItensPedidosDAO.listItensPedidos();
    }
    
    /*
    public static double buscarPrecoUnitario(ItensPedidosMODEL itemPedido) {
        return ItensPedidosDAO.getPrecoUnitario(itemPedido);
    }
    
    public static double calcularValorTotal(ItensPedidosMODEL itemPedido) {
        return ItensPedidosDAO.calcularValorTotal(itemPedido);
    }
    */
}
