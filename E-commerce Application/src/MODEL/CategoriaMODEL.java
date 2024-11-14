/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author aires
 */
public class CategoriaMODEL {
    private Integer id_categoria;
    private final String nomeCategoria;
    private final String descricao;
    
    public CategoriaMODEL(String nomeCategoria, String descricao) {
        this.nomeCategoria = nomeCategoria;
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id_categoria;
    }
    
      public void setId(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public String getNomeCategoria() {
        return nomeCategoria;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
