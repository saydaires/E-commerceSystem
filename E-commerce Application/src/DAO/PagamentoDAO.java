package DAO;

import MODEL.ENUM.MetodoPagamento;
import MODEL.PagamentoMODEL;
import UTIL.ConnectionUTIL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class PagamentoDAO {
    public static void insertPagamento(PagamentoMODEL pagamento) throws ParseException {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "INSERT INTO pagamentos(id_pedido, data_pagamento, valor_pago, metodo_pagamento) VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pagamento.getIdPedido());
            pstm.setDate(2, pagamento.getDataPagamento());
            pstm.setDouble(3, pagamento.getValorPago());
            pstm.setString(4, pagamento.getMetodoPagamento());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Pagamento REGISTRADO com sucesso!");
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static PagamentoMODEL selectPagamento(int id_pagamento) {
        try {
            Connection conn = ConnectionUTIL.connectDB();
            String sql = "SELECT * FROM pagamentos WHERE id_pagamento = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_pagamento);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            java.sql.Date dataPagamentoSQL = rs.getDate("data_pagamento");
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataPagamento = formatador.format(dataPagamentoSQL);
            
            String metodoPagamentoSQL = rs.getString("metodo_pagamento");
            MetodoPagamento metodoPagamento = null;
            
            switch(metodoPagamentoSQL) { 
                case "CARTAO":
                    metodoPagamento = MetodoPagamento.CARTAO;
                    break;
                case "BOLETO":
                    metodoPagamento = MetodoPagamento.BOLETO;
                    break;
                case "PIX" :
                    metodoPagamento = MetodoPagamento.PIX;
            }
            
            PagamentoMODEL pagamento = new PagamentoMODEL(rs.getInt("id_pedido"), dataPagamento, rs.getDouble("valor_pago"), metodoPagamento);
            pagamento.setIdPagamento(id_pagamento);
            return pagamento;
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
