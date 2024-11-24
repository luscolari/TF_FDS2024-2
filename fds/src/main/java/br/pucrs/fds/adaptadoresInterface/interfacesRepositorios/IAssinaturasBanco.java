package br.pucrs.fds.adaptadoresInterface.interfacesRepositorios;

import java.util.List;
import java.util.Optional;

import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.frameworkdriver.instancias.AssinaturaBD;

public interface IAssinaturasBanco {
    public Optional<AssinaturaModel> findById(long id);
    public List<AssinaturaModel> findAll();
    public AssinaturaModel cadastroAssinatura (AssinaturaBD assinaturaNova);
    
}
