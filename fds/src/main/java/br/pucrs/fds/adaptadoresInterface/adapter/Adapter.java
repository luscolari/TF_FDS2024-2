package br.pucrs.fds.adaptadoresInterface.adapter;

import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.dominio.entidades.AplicativoModel;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.frameworkdriver.instancias.AplicativoBD;
import br.pucrs.fds.frameworkdriver.instancias.AssinaturaBD;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;

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
}