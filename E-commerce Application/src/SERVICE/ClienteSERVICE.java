package SERVICE;
import MODEL.ClienteMODEL;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.List;

public class ClienteSERVICE {
    public static void cadastrarCliente(String nome, String cpf, String data_nascimento, String email, String senha) {
        try {    
            ClienteMODEL cliente = new ClienteMODEL(nome, cpf, data_nascimento, email, senha);
            ClienteDAO.insertCliente(cliente);
            
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    // retorna null se o cpf argumentado nao existir no banco de dados
    public static ClienteMODEL buscarCliente(String cpf) {
        return ClienteDAO.selectClienteCpf(cpf);
    }
    
    public static ClienteMODEL buscarClienteEmail(String email) {
        return ClienteDAO.selectClienteEmail(email);
    }

    public static boolean deletarCliente(String cpf) {
        ClienteMODEL clienteDeletar = ClienteDAO.selectClienteCpf(cpf);
        if(clienteDeletar == null)
            return false;
        
        return ClienteDAO.deleteCliente(clienteDeletar);
    }
    
    public static List<ClienteMODEL> listarClientes() {
        return ClienteDAO.listClientes();
    }
    
    public static void atualizarCliente(String cpf, String novaSenha) {
        ClienteMODEL clienteUpdate = ClienteDAO.selectClienteCpf(cpf);
        clienteUpdate.setSenha(novaSenha);
        ClienteDAO.updateCliente(clienteUpdate);
    }
}
