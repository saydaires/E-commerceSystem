package SERVICE;

import DAO.ProdutoDAO;
import MODEL.ProdutoMODEL;
import java.util.List;

public class ProdutoSERVICE {
    public static void cadastrarProduto(String nome, String codigo, int qtdEstoque, double precoUnitario, int id_categoria) {
        ProdutoMODEL produto = new ProdutoMODEL(nome, codigo, qtdEstoque, precoUnitario, id_categoria);
        ProdutoDAO.insertProduto(produto);
    }
    
    public static ProdutoMODEL buscarProdutoCodigo(String codigo) {
        return ProdutoDAO.selectProdutoCodigo(codigo);
    }
    
    public static ProdutoMODEL buscarProdutoNome(String nome) {
        return ProdutoDAO.selectProdutoNome(nome);
    }
    
    public static List<ProdutoMODEL> listarProdutos() {
        return ProdutoDAO.listProdutos();
    }
    
    public static boolean deletarProduto(String codigo) {
        ProdutoMODEL produtoDeletar = ProdutoDAO.selectProdutoCodigo(codigo);
        return ProdutoDAO.deleteProduto(produtoDeletar);
    }
    
    public static void atualizarProduto(ProdutoMODEL produtoUpdate, double novoPreco, int novaQtdEstoque) {
        produtoUpdate.setPrecoUnitario(novoPreco);
        produtoUpdate.setQtdEstoque(novaQtdEstoque);
        ProdutoDAO.updateProduto(produtoUpdate);
    }
}
