package br.pucrs.fds.aplicacao.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.repositorios.AplicativosRepositorio;
import br.pucrs.fds.dominio.entidades.AplicativoModel;

@Service
public class ServicoTesteApp {
    private AplicativosRepositorio aplicativos;

    public ServicoTesteApp (AplicativosRepositorio aplicativos){
        this.aplicativos = aplicativos;
    }

    public List <AplicativoModel> pegaTodosAplicatviosBanco (){
        return aplicativos.findAll();
    }

}
