package br.pucrs.fds.aplicacao.dtos;

public class AplicativoDTO {
    private long codigo;
    private String nome;
    private double custoMensal; 

    public AplicativoDTO(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    @Override
    public String toString() {
        return "AplicativoDTO [ Código: " + codigo + ", Nome: " + nome + ", CustoMensal: " + custoMensal + "]";
    }
}
