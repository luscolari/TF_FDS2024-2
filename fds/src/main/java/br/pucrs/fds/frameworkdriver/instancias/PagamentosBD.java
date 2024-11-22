package br.pucrs.fds.frameworkdriver.instancias;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PagamentosBD {

    @Id
    private long codigo;
    @ManyToOne
    private AssinaturaBD assinatura;
    private float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentosBD(long codigo, AssinaturaBD assinatura, float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    protected PagamentosBD(){}

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaBD getAssinatura() {
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
}
