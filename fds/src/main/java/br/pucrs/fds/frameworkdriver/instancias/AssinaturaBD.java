package br.pucrs.fds.frameworkdriver.instancias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AssinaturaBD {
    @Id
    private long codigo;
    @ManyToOne
    private AplicativoBD aplicativo;
    @ManyToOne
    private ClienteBD cliente;
    private String inicioVigencia;
    private String fimVigencia;

    public AssinaturaBD(int codigo, AplicativoBD aplicativo, ClienteBD cliente, String inicioVigencia, String fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    protected AssinaturaBD(){}

    public long getCodigo() {
        return codigo;
    }

    public AplicativoBD getAplicativo() {
        return aplicativo;
    }

    public ClienteBD getCliente() {
        return cliente;
    }

    public String getInicioV(){
        return inicioVigencia;
    }

    public String getFimV(){
        return fimVigencia;
    }
}
