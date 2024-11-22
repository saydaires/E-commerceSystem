package SERVICE.CLIENT;

import MODEL.ClienteMODEL;
import MODEL.ENUM.StatusPedido;
import MODEL.EnderecoMODEL;
import MODEL.PedidosMODEL;
import MODEL.ProdutoMODEL;
import SERVICE.EnderecoSERVICE;
import SERVICE.ItensPedidosSERVICE;
import SERVICE.PedidosSERVICE;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ComprarProduto {
    public static void gerarPedido(ProdutoMODEL produto, ClienteMODEL cliente, EnderecoMODEL endereco, int quantidadeProduto) {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataAtualFormatada = dataAtual.format(formatador);
        SecureRandom randomNumber = new SecureRandom();
        int codigoAleatorio = randomNumber.nextInt(1000);
        
        PedidosSERVICE.cadastrarPedido(cliente.getId(), codigoAleatorio, dataAtualFormatada, StatusPedido.EM_PROCESSAMENTO);
        PedidosMODEL pedidoGerado = PedidosSERVICE.buscarPedidoCodigo(codigoAleatorio);
        
        ItensPedidosSERVICE.cadastrarItemPedido(pedidoGerado.getIdPedido(), produto.getIdProduto(), null, quantidadeProduto, 
        produto.getPrecoUnitario(), quantidadeProduto * produto.getPrecoUnitario());
        
        EnderecoSERVICE.cadastrarEndereco(endereco.getIdCliente(), endereco.getLogradouro(), endereco.getNumero(), 
        endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }
}
