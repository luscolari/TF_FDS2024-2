package br.pucrs.fds.adaptadoresInterface.adapter;

import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.dominio.entidades.AplicativoModel;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.frameworkdriver.instancias.AplicativoBD;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;

public class Adapter {
    public static ClienteModel clienteBD_to_Model(ClienteBD bd){

        return new ClienteModel(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static ClienteDTO clienteModel_to_DTO(ClienteModel bd){

        return new ClienteDTO(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static AplicativoDTO aplicativoModel_to_DTO(AplicativoModel bd){

        return new AplicativoDTO(bd.getCodigo(), bd.getNome(), bd.getCMensal());
    }

    public static AplicativoModel aplicativoBD_to_Model(AplicativoBD bd){

        return new AplicativoModel(bd.getCodigo(), bd.getNome(), bd.getCMensal());
    }
}