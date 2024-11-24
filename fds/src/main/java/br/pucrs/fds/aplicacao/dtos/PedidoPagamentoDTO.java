package br.pucrs.fds.aplicacao.dtos;

public class PedidoPagamentoDTO {
    private long codigo;
    private String dataPedido;
    private double valorPago;
    private String desconto;

    public PedidoPagamentoDTO(long codigo, String dataPedido, double valorPago, String desconto) {
        this.codigo = codigo;
        this.dataPedido = dataPedido;
        this.valorPago = valorPago;
        this.desconto = desconto;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDataPedido() {
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
        return "Pedido Pagamento [ Código: " + codigo + ", Data do Pedido: " + dataPedido + ", Valor Pago: " + valorPago + "]";
    }
}
