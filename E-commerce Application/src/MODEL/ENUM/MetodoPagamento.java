package MODEL.ENUM;
public enum MetodoPagamento {
    CARTAO("CARTAO"),
    BOLETO("BOLETO"),
    PIX("PIX");
    
    private String descricao;
    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
