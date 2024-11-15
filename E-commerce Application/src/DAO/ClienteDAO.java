package DAO;
import MODEL.ClienteMODEL; // importo somente a classe ClienteMODEL
import UTIL.ConnectionUTIL; // importando a classe de conexao com o banco de dados
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public static void insertCliente(ClienteMODEL cliente) throws ParseException { // o metodo pode lancar essa excecao devido ao cliente.getData()
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
    
    public static void updateCliente(ClienteMODEL cliente) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "UPDATE clientes SET email = ?, senha = ? WHERE cpf = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente.getEmail());
            pstm.setString(2, cliente.getSenha());
            pstm.setString(3, cliente.getCpf());
            pstm.executeUpdate();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Os dados do Cliente foram atualizados com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void deleteCliente(ClienteMODEL cliente) {
         try {
             Connection conn = ConnectionUTIL.connectDB();
             String sql = "DELETE FROM clientes WHERE id_cliente = ?";
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setInt(1, cliente.getId());
             pstm.executeUpdate();
             pstm.close();
             JOptionPane.showMessageDialog(null, "Cliente DELETADO com sucesso!");
             
         } catch(SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }
    
    public static ClienteMODEL selectClienteNome(String nomeCliente) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM clientes WHERE nome_cliente = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeCliente);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            java.sql.Date dataNascimentoSQL = rs.getDate("data_nascimento");
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascimento = formatador.format(dataNascimentoSQL);
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String senha = rs.getString("senha");

            ClienteMODEL cliente = new ClienteMODEL(nomeCliente, cpf, dataNascimento, email, senha);
            cliente.setId(rs.getInt("id_cliente"));
            return cliente;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    
    public static ClienteMODEL selectCliente(int id_cliente) { // chamar esse metodo em SERVICE no metodo buscarFuncionario
       try {
           Connection conn = ConnectionUTIL.connectDB();
           String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setInt(1, id_cliente);
           ResultSet rs = pstm.executeQuery();
           rs.first();

           Integer idCliente = id_cliente;
           String nome = rs.getString("nome_cliente");
           String cpf = rs.getString("cpf");
           String email = rs.getString("email");
           String senha = rs.getString("senha");
           java.sql.Date data_nascimentoSQL = rs.getDate("data_nascimento"); 
           SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
           String dataNascimento = formatador.format(data_nascimentoSQL);
           ClienteMODEL cliente = new ClienteMODEL(nome, cpf, dataNascimento, email, senha);
           cliente.setId(idCliente); 
           return cliente;

        } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
           return null;
        }
    }
    
    public static List<ClienteMODEL> listClientes() { 
        List<ClienteMODEL> clientes = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM clientes";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Integer id = rs.getInt("id_cliente");
                String nome = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                java.sql.Date data_nascimentoSQL = rs.getDate("data_nascimento"); 
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                String dataNascimento = formatador.format(data_nascimentoSQL);
                ClienteMODEL cliente = new ClienteMODEL(nome, cpf, dataNascimento, email, senha);
                cliente.setId(id);
                clientes.add(cliente);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado em clientes!");
        }
        return clientes; // funcionario.isEmpty() pode ser verdadeiro se o fluxo cair no bloco catch()
    }  
}