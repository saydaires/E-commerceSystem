package DAO;
import MODEL.ClienteMODEL; // importo somente a classe ClienteMODEL
import UTIL.ConnectionUTIL; // importando a classe de conexao com o banco de dados
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.text.ParseException;

public class ClienteDAO {
    public void insertCliente(ClienteMODEL cliente) throws ParseException { // o metodo pode lancar essa excecao devido ao cliente.getData()
        try {
            Connection conn = ConnectionUTIL.connectDB(); 
            String sql = "INSERT INTO clientes(nome_cliente, cpf, email, senha, data_nascimento) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha());
            pstm.setDate(5, cliente.getData());
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
    }
}
