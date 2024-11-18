package br.pucrs.fds.frameworkdriver.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.fds.frameworkdriver.instancias.AssinaturaBD;

public interface IAssinaturaJPA extends CrudRepository<AssinaturaBD,Long>{
    List<AssinaturaBD> findAll();
    Optional<AssinaturaBD> findById(long id);
}
