package br.pucrs.fds.aplicacao.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.repositorios.AssinaturasRepositorio;
import br.pucrs.fds.adaptadoresInterface.repositorios.PagamentosRepositorio;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;

@Service
public class ServicoPagamentos {
    private PagamentosRepositorio pagamentos;
    private AssinaturasRepositorio assinaturas;
    private long next_id;
    public ServicoPagamentos(PagamentosRepositorio pagamentos, AssinaturasRepositorio assinaturas) {
        this.pagamentos = pagamentos;
        this.assinaturas = assinaturas;
        this.next_id = pagamentos.findAll().size();
    }

    public PagamentoModel validaPagamento(PedidoPagamentoModel pedido) {
        Optional<AssinaturaModel> ass = assinaturas.findById(pedido.getCodigo());
        if(ass.isPresent()) {
            PagamentoModel pagamento = new PagamentoModel(next_id++, ass.get(), pedido.getValorPago(), pedido.getDataPedido(), null);
            if(ass.get().getAplicativo().getCMensal() != pedido.getValorPago()){
                pagamento.setInvalido();
            }
            return pagamento;
        }
        else{
            PagamentoModel pagamento = new PagamentoModel(next_id++, null, pedido.getValorPago(), pedido.getDataPedido(), null);
            pagamento.setInvalido();
            return pagamento;
        }
    }

    public void salvaPagamento(PagamentoModel pagamento){
        pagamentos.salvaPagamento(pagamento);
    }

}
