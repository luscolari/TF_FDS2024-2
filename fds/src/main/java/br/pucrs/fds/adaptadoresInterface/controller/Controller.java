package br.pucrs.fds.adaptadoresInterface.controller;
import br.pucrs.fds.adaptadoresInterface.repositorios.ClientesRepositorio;
import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.useCases.PegaAplicativosUC;
import br.pucrs.fds.aplicacao.useCases.PegaClientesUC;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.fds.frameworkdriver.interfaces.IClienteJPA;

@RestController
public class Controller {

    private PegaClientesUC clientes;
    private PegaAplicativosUC aplicativos;
    
    public Controller(PegaClientesUC clientes, PegaAplicativosUC aplicativos) {
        this.clientes = clientes; 
        this.aplicativos = aplicativos;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio(){
        return "Teste";
    }

    @GetMapping("/clientes")
    @CrossOrigin(origins = "*")
    public List <ClienteDTO> getListaClientes() {
        return clientes.pegaClienteServico();
    }

    @GetMapping("/aplicativos")
    @CrossOrigin(origins = "*")
    public List <AplicativoDTO> getListaAplicativos() {
        return aplicativos.pegaAppsServico();
    }

    @GetMapping("/acharcliente/{id}")
    @CrossOrigin(origins = "*")
    public ClienteDTO acharCliente(@PathVariable("id") long id) {
        return clientes.acharCliente(id);
    }
  
}