package br.pucrs.fds.aplicacao.dtos;

import java.time.LocalDate;

public class PedidoPagamentoDTO {
    private long codigo;
    private LocalDate dataPedido;
    private float valorPago;
    private String desconto;

    public PedidoPagamentoDTO(long codigo, LocalDate dataPedido, float valorPago, String desconto) {
        this.codigo = codigo;
        this.dataPedido = dataPedido;
        this.valorPago = valorPago;
        this.desconto = desconto;
    }

    public long getCodigo() {
        return codigo;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public float getValorPago() {
        return valorPago;
    }

    public String getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return "Pedido Pagamento [ Código: " + codigo + ", Data do Pedido: " + dataPedido + ", Valor Pago: " + valorPago + "]";
    }
}
