package br.pucrs.fds.adaptadoresInterface.controller;

import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.useCases.CadastroAssinaturaUC;
import br.pucrs.fds.aplicacao.useCases.PegaAplicativosUC;
import br.pucrs.fds.aplicacao.useCases.PegaAssinaturasUC;
import br.pucrs.fds.aplicacao.useCases.PegaClientesUC;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private PegaClientesUC clientes;
    private PegaAplicativosUC aplicativos;
    private PegaAssinaturasUC assinaturas;
    private CadastroAssinaturaUC cadastros;

    public Controller(PegaClientesUC clientes, PegaAplicativosUC aplicativos, PegaAssinaturasUC assinaturas,
            CadastroAssinaturaUC cadastros) {
        this.clientes = clientes;
        this.aplicativos = aplicativos;
        this.assinaturas = assinaturas;
        this.cadastros = cadastros;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio() {
        return "Teste";
    }

    // fecho
    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClienteDTO> getListaClientes() {
        return clientes.pegaClienteServico();
    }

    // fecho
    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> getListaAplicativos() {
        return aplicativos.pegaAppsServico();
    }

    /* Para fins de debug */
    @GetMapping("/servcad/Listaassinaturas")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturas() {
        return assinaturas.pegaAssinaturasServico();
    }

    // nao terminado --> precisamos ver os tipos
    @GetMapping("/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasTipo(@PathVariable("tipo") TipoAssinatura tipo) {
        return assinaturas.pegaAssinaturasTipoServico(tipo);
    }

    // feito
    @GetMapping("/servcad/asscli/{id}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasCliente(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasClienteServico(id);
    }

    // feito
    @GetMapping("/servcad/assapp/{id}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasAplicativo(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasAplicativoServico(id);
    }

    @GetMapping("/acharcliente/{id}")
    @CrossOrigin(origins = "*")
    public ClienteDTO acharCliente(@PathVariable("id") long id) {
        return clientes.acharCliente(id);
    }

    // Body data --> para receber dados no corpo da mensagem
    //arrumando para POST --> ainda não certo
    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO cadasAssinatura(@RequestBody List<Long> ids) {
        long idCliente = ids.get(0);
        long idApp = ids.get(1);

        return cadastros.cadastroAssinatura(idCliente, idApp);
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    @CrossOrigin(origins = "*")
    public AplicativoDTO atualizaCustoPOST(@PathVariable ("idAplicativo") long idAplicativo, @RequestBody double custo) throws Exception {
        return cadastros.atualizaCusto(idAplicativo, custo);
    }


    @GetMapping("/assinvalida/{idAss}")
    @CrossOrigin(origins = "*")
    public boolean ativoOuNao (@PathVariable ("idAss") long idAss){
        return assinaturas.ativoOuNao(idAss);
    }

}