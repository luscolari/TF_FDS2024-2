package br.pucrs.fds.aplicacao.dtos;

import java.time.LocalDate;

public class PagamentoDTO {
    private long codigo;
    private AssinaturaDTO assinatura;
    private float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoDTO(long codigo, AssinaturaDTO assinatura, float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaDTO getAssinatura() {
        return assinatura;
    }

    public float getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    @Override
    public String toString() {
        return "Pagamento [ Código: " + codigo + ", Assinatura: " + assinatura + ", Valor Pago: " + valorPago +
         ", Data Pagamento: " + dataPagamento + ", Promoção: " + promocao + "]";
    }
}
