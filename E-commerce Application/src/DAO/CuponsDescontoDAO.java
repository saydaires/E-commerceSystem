package DAO;

import MODEL.CuponsDescontoMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CuponsDescontoDAO {
    // criar uma trigger que verifique apos cada insert ou delete
    // quais cupons passaram do prazo de validade, para exclui-los
    // da tabela cupons_desconto
    public static void insertCupom(CuponsDescontoMODEL cupom) throws ParseException {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO cupons_desconto(codigo_cupom, percentual_desconto, data_validade) VALUES(?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cupom.getCodCupom());
            pstm.setDouble(2, cupom.getPercentualDesconto());
            pstm.setDate(3, cupom.getDataValidade());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cupom de Desconto CADASTRADO com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static boolean deleteCupom(String codigo_cupom) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "DELETE FROM cupons_desconto WHERE codigo_cupom = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, codigo_cupom);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cupom de desconto DELETADO com sucesso!");
            return true;
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public static CuponsDescontoMODEL selectCupom(String codigo_cupom) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM cupons_desconto WHERE codigo_cupom = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, codigo_cupom);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            java.sql.Date data_validadeSQL = rs.getDate("data_validade"); 
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataValidade = formatador.format(data_validadeSQL);
            CuponsDescontoMODEL cupom = new CuponsDescontoMODEL(rs.getString("codigo_cupom"), rs.getDouble("percentual_desconto"), dataValidade);
            cupom.setIdCupom(rs.getInt("id_cupom"));
            return cupom;
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public static List<CuponsDescontoMODEL> listCupons() {
        List<CuponsDescontoMODEL> cupons = new ArrayList<>();

        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM cupons";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                java.sql.Date data_validadeSQL = rs.getDate("data_validade"); 
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                String dataValidade = formatador.format(data_validadeSQL);
                CuponsDescontoMODEL cupom = new CuponsDescontoMODEL(rs.getString("codigo_cupom"), rs.getDouble("percentual_desconto"), dataValidade);
                cupom.setIdCupom(rs.getInt("id_cupom"));
                cupons.add(cupom);
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cupons;
    }
}
