package br.pucrs.fds.adaptadoresInterface.controller;

import br.pucrs.fds.aplicacao.descontos.DescontosController;
import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.dtos.ClienteDTO;
import br.pucrs.fds.aplicacao.dtos.PedidoPagamentoDTO;
import br.pucrs.fds.aplicacao.dtos.RespostaPagamentoDTO;
import br.pucrs.fds.aplicacao.useCases.CadastroAssinaturaUC;
import br.pucrs.fds.aplicacao.useCases.PegaAplicativosUC;
import br.pucrs.fds.aplicacao.useCases.PegaAssinaturasUC;
import br.pucrs.fds.aplicacao.useCases.PegaClientesUC;
import br.pucrs.fds.aplicacao.useCases.RealizaPagamentoUC;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {

    private PegaClientesUC clientes;
    private PegaAplicativosUC aplicativos;
    private PegaAssinaturasUC assinaturas;
    private CadastroAssinaturaUC cadastros;
    private RealizaPagamentoUC pagamentos;

    public Controller(PegaClientesUC clientes, PegaAplicativosUC aplicativos, PegaAssinaturasUC assinaturas,
            CadastroAssinaturaUC cadastros, RealizaPagamentoUC pagamentos) {
        this.clientes = clientes;
        this.aplicativos = aplicativos;
        this.assinaturas = assinaturas;
        this.cadastros = cadastros;
        this.pagamentos = pagamentos;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio() {
        return "Sistema de Controle de Assinaturas de Aplicativos --> Desenvolvido por: Beatriz Cavalari, Gabriel Schneider, Luisa Scolari e Leonardo Sehnem";
    }

    //Lista com todos os clientes cadastrados
    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClienteDTO> getListaClientes() {
        return clientes.pegaClienteServico();
    }

    // Lista com todos os aplicativos cadastrados
    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> getListaAplicativos() {
        return aplicativos.pegaAppsServico();
    }

    // Cria uma assinatura
    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO cadasAssinatura(@RequestBody List<Long> ids) {
        long idCliente = ids.get(0);
        long idApp = ids.get(1);

        return cadastros.cadastroAssinatura(idCliente, idApp);
    }

     // Atualizar o custo mensal do aplicativo
     @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
     @CrossOrigin(origins = "*")
     public AplicativoDTO atualizaCustoPOST(@PathVariable ("idAplicativo") long idAplicativo, @RequestBody double custo) throws Exception {
         return cadastros.atualizaCusto(idAplicativo, custo);
     }

    // Para fins de debug + lista com todas as assinaturas cadastradas
    @GetMapping("/servcad/Listaassinaturas")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturas() {
        return assinaturas.pegaAssinaturasServico();
    }

    //Retorna a lista com todas as assinaturas confirme o tipo
    @GetMapping("/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasTipo(@PathVariable("tipo") TipoAssinatura tipo) {
        return assinaturas.pegaAssinaturasTipoServico(tipo);
    }

    // Retorna a lista das assinaturas do cliente informado
    @GetMapping("/servcad/asscli/{id}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasCliente(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasClienteServico(id);
    }

    // Retorna a lista de assinaturas de um aplicativo
    @GetMapping("/servcad/assapp/{id}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> getListaAssinaturasAplicativo(@PathVariable("id") long id) {
        return assinaturas.pegaAssinaturasAplicativoServico(id);
    }

     // Solicita o registro de um pagamento
     @PostMapping("/registrarpagamento")
     @CrossOrigin(origins = "*")
     public RespostaPagamentoDTO realizaPagamento(@RequestBody PedidoPagamentoDTO pedido) {        
         return pagamentos.realizaPagamento(pedido);
     }

    // // Para fins de debug + retorna um cliente
    @GetMapping("/buscarcliente/{id}")
    @CrossOrigin(origins = "*")
    public ClienteDTO acharCliente(@PathVariable("id") long id) {
        return clientes.acharCliente(id);
    }

    // Retorna se a assinatura questionada permanece ativa
    @GetMapping("/assinvalida/{idAss}")
    @CrossOrigin(origins = "*")
    public boolean ativoOuNao (@PathVariable ("idAss") long idAss){
        return assinaturas.ativoOuNao(idAss);
    }

    
    @GetMapping("/debug")
    public String getMethodName() {
        return pagamentos.debugDescontosController().getPoliticasDesconto().get(0).getNomeDesconto();
    }

    @GetMapping("/debug/{s}")
    public Boolean getMethodName(@PathVariable("s") String s) {
        return pagamentos.debugVerificaDescontoExiste(s);
    }

    @PostMapping("/debug")
    public double getMethodName(@RequestBody PedidoPagamentoModel p) {
        return pagamentos.debugDescontosController().getPoliticasDesconto().get(0).calculaPrecoComDesconto(p);
    }
    @PostMapping("/debu2")
    public String getMethodNam(@RequestBody PedidoPagamentoModel p) {
        return p.getDesconto();
    }
    
}