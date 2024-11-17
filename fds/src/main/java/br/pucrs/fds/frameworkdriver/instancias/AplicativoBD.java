package br.pucrs.fds.frameworkdriver.instancias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AplicativoBD {
    @Id
    private long codigo;
    private String nome;
    private double custoMensal; 
    
    public AplicativoBD(long codigo, String nome, double cMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = cMensal;
    }
    protected AplicativoBD(){}

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCMensal() {
        return custoMensal;
    }

}
 
