package DAO;

import MODEL.ClienteMODEL;
import MODEL.EnderecoMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EnderecoDAO {
    public static void insertEndereco(EnderecoMODEL endereco) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO enderecos(id_cliente, logradouro, numero, complemento,"
            + " bairro, cidade, estado, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, endereco.getIdCliente());
            pstm.setString(2, endereco.getLogradouro());
            pstm.setString(3, endereco.getNumero());
            pstm.setString(4, endereco.getComplemento());
            pstm.setString(5, endereco.getBairro());
            pstm.setString(6, endereco.getCidade());
            pstm.setString(7, endereco.getEstado());
            pstm.setString(8, endereco.getCep());
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Endereco CADASTRADO com sucesso!");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static EnderecoMODEL selectEndereco(ClienteMODEL cliente) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM enderecos WHERE id_cliente = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cliente.getId());
            ResultSet rs = pstm.executeQuery();
            rs.first();
            
            EnderecoMODEL endereco = new EnderecoMODEL(rs.getInt("id_cliente"), rs.getString("logradouro"),
            rs.getString("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"),
            rs.getString("estado"), rs.getString("cep"));
            
            endereco.setIdEndereco(rs.getInt("id_endereco"));    
            return endereco;
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Endereco nao encontrado!");
            return null;
        }
    }
}
