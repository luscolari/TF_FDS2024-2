package br.pucrs.fds.dominio.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.pucrs.fds.dominio.extras.TipoAssinatura;

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

    public TipoAssinatura valida(LocalDate diaAtual){
        if (LocalDate.parse(fimVigencia.replace("/", "-"),DateTimeFormatter.ofPattern("d-M-u")).isAfter(diaAtual)){
            return TipoAssinatura.ATIVAS;
        }
        return TipoAssinatura.CANCELADAS;
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
