package br.pucrs.fds.aplicacao.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoCadastro;
import br.pucrs.fds.dominio.entidades.ClienteModel;

@Component
public class PegaClientesUC {
    private ServicoCadastro servicoCadastro;

    public PegaClientesUC(ServicoCadastro servicoCadastro){
        this.servicoCadastro = servicoCadastro;
    }
    
    public List <ClienteDTO> pegaClienteServico(){
        return servicoCadastro.pegaTodosClientesBanco().stream().map(cli -> Adapter.clienteModel_to_DTO(cli)).toList();
    }

    public ClienteDTO acharCliente(long id){
        ClienteModel clienteModel = servicoCadastro.acharCliente(id);
        return Adapter.clienteModel_to_DTO(clienteModel);
    }

}
