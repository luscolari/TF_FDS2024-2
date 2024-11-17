package br.pucrs.fds.frameworkdriver.interfaces;

import java.util.List;
import java.util.Optional;
import br.pucrs.fds.frameworkdriver.instancias.AplicativoBD;

import org.springframework.data.repository.CrudRepository;


public interface IAplicativoJPA extends CrudRepository<AplicativoBD,Long>{
    List<AplicativoBD> findAll();
    Optional<AplicativoBD> findById(long id);
    
}
