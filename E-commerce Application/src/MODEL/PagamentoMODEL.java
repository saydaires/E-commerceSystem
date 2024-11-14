package MODEL;
import MODEL.ENUM.MetodoPagamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PagamentoMODEL {
    private Integer id_pagamento;
    private final int id_pedido;
    private String dataPagamento;
    private double valorPago;
    private MetodoPagamento metodoPagamento;
    
    public PagamentoMODEL(int id_pedido, String dataPagamento, double valorPago, MetodoPagamento metodoPagamento) {
        this.id_pedido = id_pedido;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.metodoPagamento = metodoPagamento;
    }
    
    public Integer getIdPagamento() {
        return id_pagamento;
    }
    
    public void setIdPagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }
    
    public int getIdPedido() {
        return id_pedido;
    }
    
    public double getValorPago() {
        return valorPago;
    }
    
    public String getMetodoPagamento() {
        return metodoPagamento.getDescricao();
    }
    
    public java.sql.Date getDataPagamento() throws ParseException {
        SimpleDateFormat dataPagamentoFormatada = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dataPagamento_JAVA = dataPagamentoFormatada.parse(dataPagamento);
        long dataPagamentoMilissegundos = dataPagamento_JAVA.getTime();
        java.sql.Date dataPagamento_SQL = new java.sql.Date(dataPagamentoMilissegundos);

        return dataPagamento_SQL; 
    }
}
