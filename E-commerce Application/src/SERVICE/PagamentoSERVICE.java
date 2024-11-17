package SERVICE;

import DAO.PagamentoDAO;
import MODEL.ENUM.MetodoPagamento;
import MODEL.PagamentoMODEL;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class PagamentoSERVICE {
    public static void registrarPagamento(int id_pedido, String dataPagamento, double valorPago, MetodoPagamento metodoPagamento) {
        try {    
            PagamentoMODEL pagamento = new PagamentoMODEL(id_pedido, dataPagamento, valorPago, metodoPagamento);
            PagamentoDAO.insertPagamento(pagamento);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    
    public static PagamentoMODEL buscarPagamento(int id_pagamento) {
        return PagamentoDAO.selectPagamento(id_pagamento);
    }
    
    public static List<PagamentoMODEL> listarPagamentos() {
       return PagamentoDAO.listPagamentos();
    }        
}
