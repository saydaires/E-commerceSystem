package MODEL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PedidosEntreguesMODEL {
    private int id_pedido_entregue;
    private final int id_pedido;
    private final String data_entrega;
    
    public PedidosEntreguesMODEL(int id_pedido, String data_entrega) {
        this.id_pedido = id_pedido;
        this.data_entrega = data_entrega;
    }
    
    public int getIdPedidoEntregue() {
        return id_pedido_entregue;
    }
    
    public void setIdPedidoEntregue(int id_pedido_entregue) {
        this.id_pedido_entregue = id_pedido_entregue;
    }
    
    public int getIdPedido() {
        return id_pedido;
    }

    public java.sql.Date getData() throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataJAVA = formatador.parse(data_entrega);
        long dataJAVAMillis = dataJAVA.getTime();
        java.sql.Date dataSQL = new java.sql.Date(dataJAVAMillis);
        return dataSQL;
    }
}
