package MODEL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CuponsDescontoMODEL {
    private Integer id_cupom;
    private final String codCupom;
    private final double percentualDesconto;
    private final String dataValidade;
    
    public CuponsDescontoMODEL(String codCupom, double percentualDesconto, String dataValidade) {
        this.codCupom = codCupom;
        this.percentualDesconto = percentualDesconto;
        this.dataValidade = dataValidade;
    }
    
    public Integer getIdCupom() {
        return id_cupom;
    }
    
    public void setIdCupom(int id_cupom) {
        this.id_cupom = id_cupom;
    }
    
    public String getCodCupom() {
        return codCupom;
    }
    
    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    
    public java.sql.Date getDataValidade() throws ParseException {
        SimpleDateFormat dataValidadeFormatada = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dataValidade_JAVA = dataValidadeFormatada.parse(dataValidade);
        long dataValidadeMilissegundos = dataValidade_JAVA.getTime();
        java.sql.Date dataValidade_SQL = new java.sql.Date(dataValidadeMilissegundos);

        return dataValidade_SQL; 
    }
}
