package br.pucrs.fds.frameworkdriver.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.pucrs.fds.dominio.entidades.ClienteModel;
//import frameworkdriver.instancias.ClienteBD;
import br.pucrs.fds.frameworkdriver.instancias.ClienteBD;

//--> 
public interface IClienteJPA extends CrudRepository<ClienteBD,Long> {
    List<ClienteBD> findAll();
    Optional<ClienteBD> findById(long id);
    //List<ClienteModel> getAll();
    //List<String> getCodigo();
    //List<String> getNome();
    //List<String> getEmail();
}