package SERVICE;
import MODEL.ClienteMODEL;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;
import java.text.ParseException;

public class ClienteSERVICE {
    public static void cadastrarCliente(String nome, String cpf, String data_nascimento, String email, String senha) {
        
        try {    
            ClienteMODEL cliente = new ClienteMODEL(nome, cpf, data_nascimento, email, senha);
            ClienteDAO.insertCliente(cliente);
            
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    
    public static void atualizarCliente(ClienteMODEL clienteExistente, String email, String senha) {
        clienteExistente.setEmail(email);
        clienteExistente.setSenha(senha);

        ClienteDAO.updateCliente(clienteExistente);
    }
}
