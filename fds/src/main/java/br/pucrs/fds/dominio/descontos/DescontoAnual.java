package br.pucrs.fds.dominio.descontos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.interfacesRepositorios.IAssinaturasReadOnly;
import br.pucrs.fds.aplicacao.descontos.IDesconto;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;


@Component
public class DescontoAnual implements IDesconto{

    // Absolutamente um caso perfeito para implementar usa interface para filtrar os métodos
    private IAssinaturasReadOnly assinaturas;
    private String nome;

    public DescontoAnual (IAssinaturasReadOnly ass){
        this.assinaturas = ass;
        this.nome = "anual";
    }

    @Override
    // Método assume que o pedido é de uma assinatura existente
    public double calculaPrecoComDesconto(PedidoPagamentoModel pedido) {
        
        return assinaturas.findById(pedido.getCodigoAssinatura()).get().getAplicativo().getCMensal() * 12 * 0.6;
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
            return pedido.getDataPedido().plusDays(360);
        } 
        return antData.plusDays(360);
    }
    
}   
