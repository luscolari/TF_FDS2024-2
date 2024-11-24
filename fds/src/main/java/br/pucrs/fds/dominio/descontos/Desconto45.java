package  br.pucrs.fds.dominio.descontos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.interfacesRepositorios.IAssinaturasReadOnly;
import br.pucrs.fds.aplicacao.descontos.IDesconto;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;

@Component
public class Desconto45 implements IDesconto{
    
    private IAssinaturasReadOnly assinaturas;
    private String nome;

    public Desconto45 (IAssinaturasReadOnly ass){
        this.assinaturas = ass;
        this.nome = "30-45";
    }
    @Override
    public double calculaPrecoComDesconto(PedidoPagamentoModel pedido) {
        return assinaturas.findById(pedido.getCodigoAssinatura()).get().getAplicativo().getCMensal();
    }

    @Override
    public String getNomeDesconto() {
        return this.nome;
    }
    @Override
    public LocalDate calculaNovoPrazo(PedidoPagamentoModel pedido) {
        String antigaData = assinaturas.findById(pedido.getCodigoAssinatura()).get().getFimV();
        LocalDate antData = LocalDate.parse(antigaData.replace("/", "-"),DateTimeFormatter.ofPattern("d-M-u"));
        if(antData.isBefore(LocalDate.now())){
            return pedido.getDataPedido().plusDays(45);
        } 
        return antData.plusDays(45);
    
    }

}