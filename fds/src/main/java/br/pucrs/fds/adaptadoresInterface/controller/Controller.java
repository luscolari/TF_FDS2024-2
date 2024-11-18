package br.pucrs.fds.adaptadoresInterface.controller;
import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.useCases.PegaAplicativosUC;
import br.pucrs.fds.aplicacao.useCases.PegaAssinaturasUC;
import br.pucrs.fds.aplicacao.useCases.PegaClientesUC;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    private PegaClientesUC clientes;
    private PegaAplicativosUC aplicativos;
    private PegaAssinaturasUC assinaturas;
    
    public Controller(PegaClientesUC clientes, PegaAplicativosUC aplicativos, PegaAssinaturasUC assinaturas) {
        this.clientes = clientes; 
        this.aplicativos = aplicativos;
        this.assinaturas = assinaturas;
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

    /* Para fins de debug */
    @GetMapping("/assinaturas")
    @CrossOrigin(origins = "*")
    public List <AssinaturaDTO> getListaAssinaturas() {
        return assinaturas.pegaAssinaturasServico();
    }

    @GetMapping("/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List <AssinaturaDTO> getListaAssinaturasTipo(@PathVariable("tipo") TipoAssinatura tipo) {
        return assinaturas.pegaAssinaturasTipoServico(tipo);
    }

    @GetMapping("/asscli/{id}")
    @CrossOrigin(origins = "*")
    public List <AssinaturaDTO> getListaAssinaturasCliente(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasClienteServico(id);
    }

    @GetMapping("/assapp/{id}")
    @CrossOrigin(origins = "*")
    public List <AssinaturaDTO> getListaAssinaturasAplicativo(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasAplicativoServico(id);
    }

    @GetMapping("/acharcliente/{id}")
    @CrossOrigin(origins = "*")
    public ClienteDTO acharCliente(@PathVariable("id") long id) {
        return clientes.acharCliente(id);
    }
  
}