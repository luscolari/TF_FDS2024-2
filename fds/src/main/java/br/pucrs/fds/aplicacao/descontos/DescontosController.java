package br.pucrs.fds.aplicacao.descontos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.fds.dominio.entidades.PedidoPagamentoModel;

@Component
public class DescontosController {
    @Autowired
    private List<IDesconto> politicasDesconto;

    
    public DescontosController(List<IDesconto> politicas){
        this.politicasDesconto = politicas;
    }

    public Boolean verificaSeDescontoExiste(String nomeDesconto){
        for (IDesconto iDesconto : politicasDesconto) {
            if(iDesconto.getNomeDesconto().equals(nomeDesconto)){
                return true;
            } 
        }
        return false;
    }

    public double calculaNovoValor(PedidoPagamentoModel pedido){
        if (verificaSeDescontoExiste(pedido.getDesconto())){
            return encontraDesconto(pedido.getDesconto()).calculaPrecoComDesconto(pedido);
        }
        return -1.0;
    }

    private IDesconto encontraDesconto(String nomeDesconto){
        for (IDesconto iDesconto : politicasDesconto) {
            if(iDesconto.getNomeDesconto().equals(nomeDesconto)) return iDesconto;
        }
        return null;
    }
    public List<IDesconto> getPoliticasDesconto() {
        return politicasDesconto;
    }
    
}
