package SERVICE;
import MODEL.FuncionarioMODEL;
import DAO.FuncionarioDAO;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.List;

public class FuncionarioSERVICE {
    public static void cadastrarFuncionario(String nome, String cpf, String data_admissao, String email, String senha) {
        try {    
            FuncionarioMODEL funcionario = new FuncionarioMODEL(nome, cpf, data_admissao, email, senha);
            FuncionarioDAO.insertFuncionario(funcionario);
            
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    
    // retorna null se o id argumentado nao existir no banco de dados
    public static FuncionarioMODEL buscarFuncionario(int id_funcionario) {
        return FuncionarioDAO.selectFuncionario(id_funcionario);
    }

    public static boolean deletarFuncionario(int id_funcionario) {
        FuncionarioMODEL funcionarioDeletar = FuncionarioDAO.selectFuncionario(id_funcionario);
        return FuncionarioDAO.deleteFuncionario(funcionarioDeletar);
    }
    
    public static List<FuncionarioMODEL> listarFuncionarios() {
        return FuncionarioDAO.listFuncionarios();
    }
    
    public static void atualizarFuncionario(int id_funcionario, String novaSenha) {
        FuncionarioMODEL funcionarioUpdate = FuncionarioDAO.selectFuncionario(id_funcionario);
        funcionarioUpdate.setSenha(novaSenha);
        FuncionarioDAO.updateFuncionario(funcionarioUpdate);
    }
}
