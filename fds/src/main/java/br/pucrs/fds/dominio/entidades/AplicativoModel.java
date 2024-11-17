package br.pucrs.fds.dominio.entidades;

public class AplicativoModel {
    private long codigo;
    private String nome;
    private double custoMensal; 
    
    public AplicativoModel(long codigo, String nome, double cMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = cMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCMensal() {
        return custoMensal;
    }

    @Override
    public String toString() {
        return "Aplicativo [ Código: " + codigo + ", Nome: " + nome + ", CustoMensal: " + custoMensal + "]";
    }
}
