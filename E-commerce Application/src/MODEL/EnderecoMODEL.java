package MODEL;

public class EnderecoMODEL {
    private Integer id_endereco;
    private final int id_cliente;
    private final String logradouro, numero, complemento, bairro, cidade, estado, cep;
    
    public EnderecoMODEL(int id_cliente, String logradouro, String numero, String complemento,
    String bairro, String cidade, String estado, String cep) {
        this.id_cliente = id_cliente;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    public Integer getIdEndereco() {
        return id_endereco;
    }
    
    public void setIdEndereco(int idEndereco) {
        this.id_endereco = idEndereco;
    }
    
    public int getIdCliente() {
        return id_cliente;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getCep() {
        return cep;
    }
}
