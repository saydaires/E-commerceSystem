package SERVICE;

import DAO.CuponsDescontoDAO;
import MODEL.CuponsDescontoMODEL;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class CuponsDescontoSERVICE {
    public static void cadastrarCupom(String codigo_cupom, double percentualDesconto, String dataValidade) {
        try {
            CuponsDescontoMODEL cupom = new CuponsDescontoMODEL(codigo_cupom, percentualDesconto, dataValidade);
            CuponsDescontoDAO.insertCupom(cupom);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(null, "Data mal formatada!");
        }
    }
    
    public static boolean deletarCupom(String codigo_cupom) {
        return CuponsDescontoDAO.deleteCupom(codigo_cupom);
    }
    
    public static List<CuponsDescontoMODEL> listarCupons() {
        return CuponsDescontoDAO.listCupons();
    }
    
    public static CuponsDescontoMODEL buscarCupom(String codigo_cupom) {
        return CuponsDescontoDAO.selectCupom(codigo_cupom);
    }
}
