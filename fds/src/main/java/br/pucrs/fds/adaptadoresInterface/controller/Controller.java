package br.pucrs.fds.adaptadoresInterface.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.fds.frameworkdriver.interfaces.IClienteJPA;

@RestController
public class Controller {

    private IClienteJPA clientes;

    public Controller() {
        this.clientes = clientes; 
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio(){
        return "Teste";
    }

    @GetMapping("/clientes")
    @CrossOrigin(origins = "*")
    public List<IClienteJPA> getListaLivros() {
        return clientes.getAll();
    }
  
}