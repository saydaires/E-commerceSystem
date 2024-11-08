package UTIL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionUTIL {
    // O metodo abaixo ser 'static' permite chama-lo diretamente, sem instancia-lo
    // exemplo: 'ConnectionUTIL.connectDB()'
    public static Connection connectDB() {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/ecommerce_db?user=root";
            conn = DriverManager.getConnection(url);
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return conn;
    }
}
