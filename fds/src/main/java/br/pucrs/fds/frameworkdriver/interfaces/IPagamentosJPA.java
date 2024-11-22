package br.pucrs.fds.frameworkdriver.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.fds.frameworkdriver.instancias.PagamentosBD;

public interface IPagamentosJPA extends CrudRepository<PagamentosBD,Long>{
    List<PagamentosBD> findAll();
    Optional<PagamentosBD> findById(long id);
}
