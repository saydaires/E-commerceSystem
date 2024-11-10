package MODEL.ENUM;
public enum StatusPedido {
    PENDENTE("PENDENTE"),
    EM_PROCESSAMENTO("EM PROCESSAMENTO"),
    ENVIADO("ENVIADO"),
    ENTREGUE("ENTREGUE");
    
    private String descricao;
    
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
