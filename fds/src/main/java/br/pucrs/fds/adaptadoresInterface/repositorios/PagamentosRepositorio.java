package br.pucrs.fds.adaptadoresInterface.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.frameworkdriver.instancias.PagamentosBD;
import br.pucrs.fds.frameworkdriver.interfaces.IPagamentosJPA;

@Repository
@Primary
public class PagamentosRepositorio {
    private IPagamentosJPA pagamentos;

    @Autowired
    public PagamentosRepositorio(IPagamentosJPA pagamento){
        this.pagamentos = pagamento;
    } 
       
    
    public List<PagamentoModel> findAll() {
        return pagamentos.findAll().stream().map(pag -> Adapter.pagamentosBD_to_Model(pag)).toList();
    }

    public PagamentoModel findById(long id) {
        Optional<PagamentosBD> pagamentoOptional = pagamentos.findById(id);
        if (pagamentoOptional.isPresent()) {
            return Adapter.pagamentosBD_to_Model(pagamentoOptional.get());
        } else {
            return null; 
        }
    }

    public PagamentoModel salvaPagamento(PagamentoModel pagamento){
        return Adapter.pagamentosBD_to_Model(pagamentos.save(Adapter.pagamentosModel_to_BD(pagamento)));
    }
}
