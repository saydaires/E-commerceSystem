package SERVICE;

import DAO.EnderecoDAO;
import MODEL.ClienteMODEL;
import MODEL.EnderecoMODEL;

public class EnderecoSERVICE {
    public static void cadastrarEndereco(int id_cliente, String logradouro, String numero, String complemento,
    String bairro, String cidade, String estado, String cep) {
        EnderecoMODEL endereco = new EnderecoMODEL(id_cliente, logradouro, numero, complemento, bairro, cidade, estado, cep);
        EnderecoDAO.insertEndereco(endereco);
    }
    
    public static EnderecoMODEL buscarEnderecoCliente(ClienteMODEL cliente) {
        return EnderecoDAO.selectEndereco(cliente);
    }
}
