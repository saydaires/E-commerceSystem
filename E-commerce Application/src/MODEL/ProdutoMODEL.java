/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author aires
 */
public class ProdutoMODEL {
    private Integer id_produto;
    private int qtdEstoque;
    private final String nomeProduto, codProduto;
    private double precoUnitario;
    private final int id_categoria; // FK no banco de dados
    
    public ProdutoMODEL(String nomeProduto, String codProduto, int qtdEstoque, double precoUnitario, int id_categoria) {
        this.nomeProduto = nomeProduto;
        this.codProduto = codProduto;
        this.qtdEstoque = qtdEstoque;
        this.precoUnitario = precoUnitario;
        this.id_categoria = id_categoria;
    }
    
    public Integer getIdProduto() {
        return id_produto;
    }
    
    public int getIdCategoria() {
        return id_categoria;
    }
    
    public String getNome() {
        return nomeProduto; 
    }
    
    public String getCod() {
        return codProduto;
    }
    
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public void setPrecoUnitario(double preco) {
        this.precoUnitario = preco;
    }
    
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
