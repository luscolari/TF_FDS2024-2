package br.pucrs.fds.aplicacao.dtos;

import br.pucrs.fds.dominio.extras.TipoAssinatura;

public class AssinaturaDTO {
    private long codigo;
    private AplicativoDTO aplicativo;
    private ClienteDTO cliente;
    private String inicioVigencia;
    private String fimVigencia;
    private TipoAssinatura ativa;

    public AssinaturaDTO(long codigo, AplicativoDTO aplicativo, ClienteDTO cliente, String inicioVigencia, String fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public AplicativoDTO getAplicativo() {
        return aplicativo;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public String getInicioV(){
        return inicioVigencia;
    }

    public String getFimV(){
        return fimVigencia;
    }

    public TipoAssinatura getAtiva() {
        return ativa;
    }

    public void setAtiva(TipoAssinatura ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "AssinaturaDTO [ Código: " + codigo + ", Aplicativo: " + aplicativo + ", Cliente: " + cliente + "Vigência: " + inicioVigencia + "-" + fimVigencia + "Ativa: " + this.ativa + "]";
    }
    
}
