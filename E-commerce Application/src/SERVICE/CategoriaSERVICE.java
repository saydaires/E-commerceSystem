
package SERVICE;

import DAO.CategoriaDAO;
import MODEL.CategoriaMODEL;
import java.util.List;

public class CategoriaSERVICE {
    public static void cadastrarCategoria(String nomeCategoria, String descricao) {
        CategoriaMODEL categoria = new CategoriaMODEL(nomeCategoria, descricao);
        CategoriaDAO.insertCategoria(categoria);
    }
    
    public static CategoriaMODEL buscarCategoria(String nomeCategoria) {
        return CategoriaDAO.selectCategoriaNome(nomeCategoria);
    }
    
    public static List<CategoriaMODEL> listarCategorias() {
        return CategoriaDAO.listCategorias();
    }
}
