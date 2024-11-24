package br.pucrs.fds.adaptadoresInterface.interfacesRepositorios;

import java.util.List;
import java.util.Optional;

import br.pucrs.fds.dominio.entidades.AssinaturaModel;

public interface IAssinaturasReadOnly {
    public Optional<AssinaturaModel> findById(long id);
    public List<AssinaturaModel> findAll();
}
