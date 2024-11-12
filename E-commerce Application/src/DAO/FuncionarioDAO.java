package DAO;

import MODEL.FuncionarioMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    public static void insertFuncionario(FuncionarioMODEL funcionario) throws ParseException {
        try {
        Connection conn = ConnectionUTIL.connectDB();
        String sql = "INSERT INTO funcionarios(nome_funcionario, cpf, email, senha, data_admissao) "
        + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, funcionario.getNome());
        pstm.setString(2, funcionario.getCpf());
        pstm.setString(3, funcionario.getEmail());
        pstm.setString(4, funcionario.getSenha());
        pstm.setDate(5, funcionario.getData());
        pstm.execute();
        pstm.close();
        
        JOptionPane.showMessageDialog(null, "Funcionario CADASTRADO com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static FuncionarioMODEL selectFuncionario(int id_funcionario) { // chamar esse metodo em SERVICE no metodo buscarFuncionario
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_funcionario);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            
            // variaveis para criar o objeto FuncionarioMODEL e retorna-lo
            Integer idFuncionario = id_funcionario;
            String nome = rs.getString("nome_funcionario");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            java.sql.Date data_admissaoSQL = rs.getDate("data_admissao"); // tratando a data de admissao e formatando-a
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataAdmissao = formatador.format(data_admissaoSQL);
            
            // criando o objeto e retornando-o
            FuncionarioMODEL funcionario = new FuncionarioMODEL(nome, cpf, dataAdmissao, email, senha);
            funcionario.setId(idFuncionario); // settando o id do funcionario consultado
            return funcionario;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public static List<FuncionarioMODEL> listFuncionarios() { // chamar na SERVICE em listarFuncionarios
        List<FuncionarioMODEL> funcionarios = new ArrayList<>();
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM funcionarios";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Integer id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome_funcionario");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                java.sql.Date data_admissaoSQL = rs.getDate("data_admissao"); 
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                String dataAdmissao = formatador.format(data_admissaoSQL);
                FuncionarioMODEL funcionario = new FuncionarioMODEL(nome, cpf, dataAdmissao, email, senha);
                funcionario.setId(id);
                // adicionando na estrutura de dados
                funcionarios.add(funcionario);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado em funcionarios!");
        }
        return funcionarios; // funcionario.isEmpty() pode ser verdadeiro se o fluxo cair no bloco catch()
    }
    
    public static void updateFuncionario(FuncionarioMODEL funcionario) {
       try {
           Connection conn = ConnectionUTIL.connectDB();
           String sql = "UPDATE funcionarios SET email = ?, senha = ? WHERE id_funcionario = ?";
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, funcionario.getEmail());
           pstm.setString(2, funcionario.getSenha());
           pstm.setInt(3, funcionario.getId());
           pstm.executeUpdate();
           pstm.close();
           JOptionPane.showMessageDialog(null, "Funcionario ATUALIZADO com sucesso!");
       
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
     public static void deleteFuncionario(FuncionarioMODEL funcionario) {
         try {
             Connection conn = ConnectionUTIL.connectDB();
             String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setInt(1, funcionario.getId());
             pstm.executeUpdate();
             pstm.close();
             JOptionPane.showMessageDialog(null, "Funcionario DELETADO com sucesso!");
             
         } catch(SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
     }
}
