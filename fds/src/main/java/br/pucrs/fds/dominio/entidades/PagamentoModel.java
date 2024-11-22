package br.pucrs.fds.dominio.entidades;

import java.time.LocalDate;

public class PagamentoModel {
    private long codigo;
    private AssinaturaModel assinatura;
    private float valorPago;
    private LocalDate dataPagamento;
    private String promocao;
    private boolean invalido;

    public PagamentoModel(long codigo, AssinaturaModel assinatura, float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.invalido = false;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaModel getAssinatura() {
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

    public void setInvalido() {
        this.invalido = true;
    }

    public boolean isInvalido() {
        return invalido;
    }

    @Override
    public String toString() {
        return "Pagamento [ Código: " + codigo + ", Assinatura: " + assinatura + ", Valor Pago: " + valorPago +
         ", Data Pagamento: " + dataPagamento + ", Promoção: " + promocao + "]";
    }
}
