package br.pucrs.fds.frameworkdriver.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.fds.dominio.entidades.ClienteModel;
//import frameworkdriver.instancias.ClienteBD;

//--> extends CrudRepository<ClienteBD,Long>
public interface IClienteJPA {
    //List<ClienteBD> findAll();
    //Optional<ClienteBD> findById(long id);
    List<ClienteModel> getAll();
    List<String> getCodigo();
    List<String> getNome();
    List<String> getEmail();
}