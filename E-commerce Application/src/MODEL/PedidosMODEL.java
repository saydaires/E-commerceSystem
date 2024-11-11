package MODEL;
import MODEL.ENUM.StatusPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PedidosMODEL {
    private Integer id_pedido;
    private final Integer id_cliente;
    private final String dataPedido;
    private StatusPedido statusPedido;
    
    public PedidosMODEL(Integer id_cliente, String dataPedido, StatusPedido statusPedido) {
        this.id_cliente = id_cliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }
    
    public Integer getIdPedido() {
        return id_pedido;
    }
    
    public Integer getIdCliente() {
        return id_cliente;
    }
    
    public String getStatusPedido() {
        return statusPedido.getDescricao();
    }
    
    public java.sql.Date getDataPedido() throws ParseException {
        SimpleDateFormat dataPedidoFormatada = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dataPedido_JAVA = dataPedidoFormatada.parse(dataPedido);
        long dataPedidoMilissegundos = dataPedido_JAVA.getTime();
        java.sql.Date dataPedido_SQL = new java.sql.Date(dataPedidoMilissegundos);

        return dataPedido_SQL; 
    }
    
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}