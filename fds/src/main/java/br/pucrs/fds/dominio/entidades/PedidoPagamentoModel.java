package br.pucrs.fds.dominio.entidades;

import java.time.LocalDate;

public class PedidoPagamentoModel {
    private long codigoAssinatura;
    private LocalDate dataPedido;
    private double valorPago;
    private String desconto;

    public PedidoPagamentoModel(long codigo, LocalDate dataPedido, double valorPago, String desconto) {
        this.codigoAssinatura = codigo;
        this.dataPedido = dataPedido;
        this.valorPago = valorPago;
        this.desconto = desconto;
    }

    public long getCodigoAssinatura() {
        return codigoAssinatura;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return "Pedido Pagamento [ Código: " + codigoAssinatura + ", Data do Pedido: " + dataPedido + ", Valor Pago: " + valorPago + "]";
    }
}
