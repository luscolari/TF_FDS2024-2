package br.pucrs.fds.aplicacao.useCases;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.descontos.DescontosController;
import br.pucrs.fds.aplicacao.dtos.PedidoPagamentoDTO;
import br.pucrs.fds.aplicacao.dtos.RespostaPagamentoDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoCadastro;
import br.pucrs.fds.aplicacao.servicos.ServicoPagamentos;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.extras.TipoPagamento;

@Component
public class RealizaPagamentoUC {
    private ServicoPagamentos pagamentos;
    private ServicoCadastro servicos;

    public RealizaPagamentoUC (ServicoPagamentos pagamentos, ServicoCadastro servicos){
        this.pagamentos = pagamentos;
        this.servicos = servicos;
    }

    public RespostaPagamentoDTO realizaPagamento(PedidoPagamentoDTO pedido){
        PagamentoModel pagamento = pagamentos.validaPagamento(Adapter.pedidoPagamentoDTO_to_Model(pedido));
        if (pagamento.isInvalido()){
            // Salvar pagamento inválido
            pagamentos.salvaPagamento(pagamento);
            return new RespostaPagamentoDTO(TipoPagamento.VALOR_INCORRETO, pagamento.getDataPagamento(), pagamento.getValorPago());
        }
        LocalDate novaData = pagamentos.novaData(Adapter.pedidoPagamentoDTO_to_Model(pedido));
        if(novaData == null){
            pagamentos.salvaPagamento(pagamento);
            return new RespostaPagamentoDTO(TipoPagamento.ERRO_DATA, pagamento.getDataPagamento(), pagamento.getValorPago());
        }
        
        servicos.atualizarDataExpiracao(pagamento, novaData);
        pagamentos.salvaPagamento(pagamento);
        return new RespostaPagamentoDTO(TipoPagamento.PAGAMENTO_OK, pagamento.getDataPagamento(), 0);
    }

    public DescontosController debugDescontosController(){
        return pagamentos.debugDescontosController();
    }

    public Boolean debugVerificaDescontoExiste(String n){
        return pagamentos.debugVerificaDescontoExiste(n);
    }

}
