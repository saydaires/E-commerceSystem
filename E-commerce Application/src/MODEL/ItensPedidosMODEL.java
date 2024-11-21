package MODEL;
public class ItensPedidosMODEL {
    private Integer id_item_pedido;
    private final int id_pedido;
    private final int id_produto;
    private final Integer id_cupom; // id_cupom pode ser null, se a compra nao tiver cupom
    private final int quantidade;
    private  double precoUnitario; // inicializado nos metodos DAO: conexao BD com a tabela produtos
    private double valorTotal; // inicializado nos metodos DAO: conexao BD com a tabela cupons_desconto 
    
    public ItensPedidosMODEL(int id_pedido, int id_produto, Integer id_cupom, int quantidade, double precoUnitario, double valorTotal) {
        this.id_pedido = id_pedido;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.id_cupom = id_cupom;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
    }
    
    public Integer getIdItemPedido() {
        return id_item_pedido;
    }
    
    public void setIdItemPedido(int id_item_pedido) {
        this.id_item_pedido = id_item_pedido;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    public int getIdPedido() {
        return id_pedido;
    }
    
    public int getIdProduto() {
        return id_produto;
    }
    
    public Integer getIdCupom() {
        return id_cupom;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
}
