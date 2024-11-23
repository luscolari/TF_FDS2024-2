package br.pucrs.fds.aplicacao.dtos;

import java.time.LocalDate;

import br.pucrs.fds.dominio.extras.TipoPagamento;

public class RespostaPagamentoDTO {
    private TipoPagamento status;
    private LocalDate data;
    private double valor_estornado;

    public RespostaPagamentoDTO(TipoPagamento status, LocalDate data, double valor_estornado){
        this.status = status;
        this.data = data;
        this.valor_estornado = valor_estornado;
    }
    public LocalDate getData() {
        return data;
    }
    public TipoPagamento getStatus() {
        return status;
    }
    public double getValor_estornado() {
        return valor_estornado;
    }
    @Override
    public String toString() {
        return String.format("{%s, %s, %s}", this.status,this.data,this.valor_estornado);
    }
}
