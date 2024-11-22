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
        int codigoAleatorio = randomNumber.nextInt(2000);
        
        PedidosSERVICE.cadastrarPedido(cliente.getId(), codigoAleatorio, dataAtualFormatada, StatusPedido.EM_PROCESSAMENTO);
        PedidosMODEL pedidoGerado = PedidosSERVICE.buscarPedidoCodigo(codigoAleatorio);
        
        double valorTotal = quantidadeProduto * produto.getPrecoUnitario();
        ItensPedidosSERVICE.cadastrarItemPedido(pedidoGerado.getIdPedido(), pedidoGerado.getCodigoPedido(), produto.getIdProduto(), quantidadeProduto, 
        produto.getPrecoUnitario(), valorTotal);
        
        EnderecoSERVICE.cadastrarEndereco(endereco.getIdCliente(), endereco.getLogradouro(), endereco.getNumero(), 
        endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }
}
