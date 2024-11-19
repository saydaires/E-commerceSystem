package SERVICE.ADMIN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import UTIL.ConnectionUTIL;
import javax.swing.JOptionPane;

public class Login {
    public static boolean validarLogin(String email, String senha) {
        try {    
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT senha FROM funcionarios WHERE email = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Email ou Senha invalidos!");
                return false;
            }
            rs.first();
            String senhaBD = rs.getString("senha");
            if(senhaBD.equals(senha))
                return true;
            else
                JOptionPane.showMessageDialog(null, "Email ou Senha invalidos!");
            return false;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}