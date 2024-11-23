package br.pucrs.fds.adaptadoresInterface.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.dtos.PedidoPagamentoDTO;
import br.pucrs.fds.dominio.entidades.AplicativoModel;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;
import br.pucrs.fds.frameworkdriver.instancias.AplicativoBD;
import br.pucrs.fds.frameworkdriver.instancias.AssinaturaBD;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;
import br.pucrs.fds.frameworkdriver.instancias.PagamentosBD;

public class Adapter {
    public static ClienteModel clienteBD_to_Model(ClienteBD bd){

        return new ClienteModel(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static ClienteDTO clienteModel_to_DTO(ClienteModel bd){

        return new ClienteDTO(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static ClienteBD clienteModel_to_BD(ClienteModel bd){

        return new ClienteBD(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static AplicativoDTO aplicativoModel_to_DTO(AplicativoModel bd){

        return new AplicativoDTO(bd.getCodigo(), bd.getNome(), bd.getCMensal());
    }

    public static AplicativoModel aplicativoBD_to_Model(AplicativoBD bd){

        return new AplicativoModel(bd.getCodigo(), bd.getNome(), bd.getCMensal());
    }

    public static AplicativoBD aplicativoModel_to_BD(AplicativoModel bd){

        return new AplicativoBD(bd.getCodigo(), bd.getNome(), bd.getCMensal());
    }

    public static AssinaturaModel assinaturaBD_to_Model(AssinaturaBD bd){
        return new AssinaturaModel(bd.getCodigo(),
                                   Adapter.aplicativoBD_to_Model(bd.getAplicativo()),
                                   Adapter.clienteBD_to_Model(bd.getCliente()),
                                   bd.getInicioV(),
                                   bd.getFimV());
    }

    public static AssinaturaDTO assinaturaModel_to_DTO(AssinaturaModel bd){
        return new AssinaturaDTO(bd.getCodigo(),
                                   Adapter.aplicativoModel_to_DTO(bd.getAplicativo()),
                                   Adapter.clienteModel_to_DTO(bd.getCliente()),
                                   bd.getInicioV(),
                                   bd.getFimV());
    }

    public static AssinaturaBD assinaturaModel_to_BD(AssinaturaModel bd){
        return new AssinaturaBD(bd.getCodigo(),
                                   Adapter.aplicativoModel_to_BD(bd.getAplicativo()),
                                   Adapter.clienteModel_to_BD(bd.getCliente()),
                                   bd.getInicioV(),
                                   bd.getFimV());
    }

    public static PagamentoModel pagamentosBD_to_Model(PagamentosBD bd){
        PagamentoModel pagamento = new PagamentoModel(bd.getCodigo(), Adapter.assinaturaBD_to_Model(bd.getAssinatura()), bd.getValorPago(), bd.getDataPagamento(), bd.getPromocao());
        if (!bd.isValida()){
            pagamento.setInvalido();
        }
        return pagamento;
    }

    public static PagamentosBD pagamentosModel_to_BD(PagamentoModel bd){
        return new PagamentosBD(bd.getCodigo(), Adapter.assinaturaModel_to_BD(bd.getAssinatura()), bd.getValorPago(), bd.getDataPagamento(), bd.getPromocao(), !bd.isInvalido());
    }

    public static PedidoPagamentoModel pedidoPagamentoDTO_to_Model(PedidoPagamentoDTO pd){
        return new PedidoPagamentoModel(pd.getCodigo(), LocalDate.parse(pd.getDataPedido(),DateTimeFormatter.ofPattern("d/M/u")), pd.getValorPago(), pd.getDesconto());
    }

}