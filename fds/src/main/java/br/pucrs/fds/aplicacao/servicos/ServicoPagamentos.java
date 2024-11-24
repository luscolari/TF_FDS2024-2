package br.pucrs.fds.aplicacao.servicos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.repositorios.AssinaturasRepositorio;
import br.pucrs.fds.adaptadoresInterface.repositorios.PagamentosRepositorio;
import br.pucrs.fds.aplicacao.descontos.DescontosController;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;

@Service
public class ServicoPagamentos {
    private PagamentosRepositorio pagamentos;
    private AssinaturasRepositorio assinaturas;
    @Autowired
    private DescontosController descontos;
    private long next_id;
    
    public ServicoPagamentos(PagamentosRepositorio pagamentos, AssinaturasRepositorio assinaturas, DescontosController descontos) {
        this.pagamentos = pagamentos;
        this.assinaturas = assinaturas;
        this.descontos = descontos;
        this.next_id = pagamentos.findAll().size();
    }

    public PagamentoModel validaPagamento(PedidoPagamentoModel pedido) {
        Optional<AssinaturaModel> ass = assinaturas.findById(pedido.getCodigoAssinatura());
        if(ass.isPresent()) {

            PagamentoModel pagamento = new PagamentoModel(next_id++, ass.get(), pedido.getValorPago(), pedido.getDataPedido(), pedido.getDesconto());
            if (descontos.verificaSeDescontoExiste(pedido.getDesconto())){
                BigDecimal valorPago = BigDecimal.valueOf(pedido.getValorPago());
                BigDecimal valorCorreto = BigDecimal.valueOf(descontos.calculaNovoValor(pedido));
                if(valorPago.compareTo(valorCorreto) == 0){
                    return pagamento;
                }
            }
            pagamento.setInvalido();
            return pagamento;
        }
        else{
            PagamentoModel pagamento = new PagamentoModel(next_id++, null, pedido.getValorPago(), pedido.getDataPedido(), pedido.getDesconto());
            pagamento.setInvalido();
            return pagamento;
        }
        
    }

    public void salvaPagamento(PagamentoModel pagamento){
        pagamentos.salvaPagamento(pagamento);
    }

    public LocalDate novaData(PedidoPagamentoModel pedido){
        Optional<AssinaturaModel> ass = assinaturas.findById(pedido.getCodigoAssinatura());
        if(ass.isPresent()) {

            if (descontos.verificaSeDescontoExiste(pedido.getDesconto())){
                return descontos.calculaNovaData(pedido);
            }
        }
        return null;
    }

    public DescontosController debugDescontosController(){
        return descontos;
    }

    public Boolean debugVerificaDescontoExiste(String n){
        return descontos.verificaSeDescontoExiste(n);
    }

}
