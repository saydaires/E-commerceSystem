package SERVICE;
import MODEL.ClienteMODEL;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;
import java.text.ParseException;

public class ClienteSERVICE {
    public static void CadastrarCliente(String nome, String cpf, String data_nascimento, String email, String senha) {
        
        try {    
            ClienteMODEL cliente = new ClienteMODEL(nome, cpf, data_nascimento, email, senha);
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.insertCliente(cliente);
            
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
}
