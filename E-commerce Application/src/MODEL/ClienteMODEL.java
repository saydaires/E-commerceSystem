package MODEL;
import MODEL.INTERFACES_ABSTRATAS.PessoaMODEL;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ClienteMODEL extends PessoaMODEL {
    private String data_nascimento; // data_nascimento deve estar no formato "yyyy-MM-dd"
    
    public ClienteMODEL(String nome, String cpf, String data_nascimento, String email, String senha) {
        super(nome, cpf, email, senha);
        this.data_nascimento = data_nascimento;
    }
    
    @Override
    public java.sql.Date getData() throws ParseException { // o objeto do tipo 'Date' esperado como retorno e java.sql.Date
        SimpleDateFormat dataNascimentoFormatada = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date dataNascimento_JAVA = dataNascimentoFormatada.parse(data_nascimento);
        long dataNascimentoMilissegundos = dataNascimento_JAVA.getTime();
        java.sql.Date dataNascimento_SQL = new java.sql.Date(dataNascimentoMilissegundos);
        
        return dataNascimento_SQL; // dataNascimento_SQL esta pronta para ser inserida no database
    }
}
