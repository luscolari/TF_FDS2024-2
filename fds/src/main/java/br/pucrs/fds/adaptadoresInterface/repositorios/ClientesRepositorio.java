package br.pucrs.fds.adaptadoresInterface.repositorios;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.pucrs.fds.frameworkdriver.interfaces.IClienteJPA;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;
import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.dominio.entidades.ClienteModel;

@Repository
@Primary
public class ClientesRepositorio {
    private IClienteJPA cliente;

    @Autowired
    public ClientesRepositorio(IClienteJPA cliente){
        this.cliente = cliente;
    } 
       
    
    public List<ClienteModel> findAll() {
        return cliente.findAll().stream().map(cli -> Adapter.clienteBD_to_Model(cli)).toList();
    }

    public ClienteModel findById(long id) {
        Optional<ClienteBD> clienteOptional = cliente.findById(id);
        if (clienteOptional.isPresent()) {
            return Adapter.clienteBD_to_Model(clienteOptional.get());
        } else {
            return null; 
        }
    }
    
}