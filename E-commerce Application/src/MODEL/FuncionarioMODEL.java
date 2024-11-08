package MODEL;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FuncionarioMODEL extends PessoaMODEL {
    private String data_admissao; // data_admissao deve estar no formato "yyyy-MM-dd"
    
    public FuncionarioMODEL(String nome, String cpf, String data_admissao, String email, String senha) {
        super(nome, cpf, email, senha);
        this.data_admissao = data_admissao;
    }
    
    @Override
    public java.sql.Date getData() throws ParseException { // o objeto do tipo 'Date' esperado como retorno e java.sql.Date
        SimpleDateFormat dataAdmissaoFormatada = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date dataAdmissao_JAVA = dataAdmissaoFormatada.parse(data_admissao);
        long dataAdmissaoMilissegundos = dataAdmissao_JAVA.getTime();
        java.sql.Date dataAdmissao_SQL = new java.sql.Date(dataAdmissaoMilissegundos);
        
        return dataAdmissao_SQL; // dataAdmissao_SQL esta pronta para ser inserida no database
    }
}
