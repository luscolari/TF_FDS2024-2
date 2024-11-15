package br.pucrs.fds.aplicacao.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.repositorios.ClientesRepositorio;
import br.pucrs.fds.dominio.entidades.ClienteModel;

@Service
public class ServicoCadastro {
    private ClientesRepositorio clientes;

    public ServicoCadastro (ClientesRepositorio clientes){
        this.clientes = clientes;
    }

    public List <ClienteModel> pegaTodosClientesBanco (){
        return clientes.findAll();
    }
}
