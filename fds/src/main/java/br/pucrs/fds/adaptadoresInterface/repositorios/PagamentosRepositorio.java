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
    private IPagamentosJPA pagamento;

    @Autowired
    public PagamentosRepositorio(IPagamentosJPA pagamento){
        this.pagamento = pagamento;
    } 
       
    
    public List<PagamentoModel> findAll() {
        return pagamento.findAll().stream().map(pag -> Adapter.pagamentosBD_to_Model(pag)).toList();
    }

    public PagamentoModel findById(long id) {
        Optional<PagamentosBD> pagamentoOptional = pagamento.findById(id);
        if (pagamentoOptional.isPresent()) {
            return Adapter.pagamentosBD_to_Model(pagamentoOptional.get());
        } else {
            return null; 
        }
    }
}
