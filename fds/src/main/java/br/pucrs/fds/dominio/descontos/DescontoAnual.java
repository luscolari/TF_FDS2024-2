package br.pucrs.fds.dominio.descontos;

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
    
}
