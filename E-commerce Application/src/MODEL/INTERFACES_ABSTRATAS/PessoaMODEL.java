package MODEL.INTERFACES_ABSTRATAS;
import java.text.ParseException;

public abstract class PessoaMODEL {
    private Integer id; // o tipo wrapper Integer garante que id = null, inicialmente
    private final String nome, cpf;
    private String email, senha;
    
    public PessoaMODEL(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    
    public abstract java.sql.Date getData() throws ParseException; // getData() retorna uma data pronta para ser inserida no database
    
    public Integer getId() {
        return id;
    }
    
    public void setId(int id) { // esse metodo sera usado em caso de consultas e retornos de um objeto funcionario/cliente
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
