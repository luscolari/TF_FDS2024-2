package br.pucrs.fds.adaptadoresInterface.adapter;

import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;

public class Adapter {
    public static ClienteModel clienteBD_to_Model(ClienteBD bd){

        return new ClienteModel(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }

    public static ClienteDTO clienteModel_to_DTO(ClienteModel bd){

        return new ClienteDTO(bd.getCodigo(), bd.getNome(), bd.getEmail());
    }
}
