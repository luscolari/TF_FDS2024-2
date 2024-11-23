package br.pucrs.fds.aplicacao.useCases;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.dtos.PedidoPagamentoDTO;
import br.pucrs.fds.aplicacao.dtos.RespostaPagamentoDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoPagamentos;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.extras.TipoPagamento;

@Component
public class RealizaPagamentoUC {
    private ServicoPagamentos pagamentos;

    public RealizaPagamentoUC (ServicoPagamentos pagamentos){
        this.pagamentos = pagamentos;
    }

    public RespostaPagamentoDTO realizaPagamento(PedidoPagamentoDTO pedido){
        PagamentoModel pagamento = pagamentos.validaPagamento(Adapter.pedidoPagamentoDTO_to_Model(pedido));
        if (pagamento.isInvalido()){
            // Salvar pagamento inválido
            pagamentos.salvaPagamento(pagamento);
            return new RespostaPagamentoDTO(TipoPagamento.VALOR_INCORRETO, pagamento.getDataPagamento(), pagamento.getValorPago());
        }
        pagamentos.salvaPagamento(pagamento);
        return new RespostaPagamentoDTO(TipoPagamento.PAGAMENTO_OK, pagamento.getDataPagamento(), 0);
    }

}
