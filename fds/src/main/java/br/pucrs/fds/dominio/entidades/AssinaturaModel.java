package br.pucrs.fds.dominio.entidades;

public class AssinaturaModel {
    private long codigo;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private String inicioVigencia;
    private String fimVigencia;

    public AssinaturaModel(long codigo, AplicativoModel aplicativo, ClienteModel cliente, String inicioVigencia, String fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public String getInicioV(){
        return inicioVigencia;
    }

    public String getFimV(){
        return fimVigencia;
    }

    @Override
    public String toString() {
        return "Assinatura [ Código: " + codigo + ", Aplicativo: " + aplicativo + ", Cliente: " + cliente + "Vigência: " + inicioVigencia + "-" + fimVigencia + "]";
    }

}
