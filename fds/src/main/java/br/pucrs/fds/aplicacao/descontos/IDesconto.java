package br.pucrs.fds.aplicacao.descontos;

import java.time.LocalDate;

import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;

public interface IDesconto {
    public double calculaPrecoComDesconto(PedidoPagamentoModel pedido);
    public String getNomeDesconto();
    public LocalDate calculaNovoPrazo(PedidoPagamentoModel pedido);
}
