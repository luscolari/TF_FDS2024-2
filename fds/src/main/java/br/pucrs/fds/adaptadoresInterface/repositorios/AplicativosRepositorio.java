package br.pucrs.fds.adaptadoresInterface.repositorios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.dominio.entidades.AplicativoModel;

import java.util.List;
import java.util.Optional;

import br.pucrs.fds.frameworkdriver.instancias.AplicativoBD;
import br.pucrs.fds.frameworkdriver.interfaces.IAplicativoJPA;

@Repository
@Primary
public class AplicativosRepositorio{
    private IAplicativoJPA aplicativo;

    @Autowired
    public AplicativosRepositorio(IAplicativoJPA aplicativo) {
        this.aplicativo = aplicativo;
    }
    
    public List<AplicativoModel> findAll() {
        return aplicativo.findAll().stream().map(app -> Adapter.aplicativoBD_to_Model(app)).toList();
    }

    public AplicativoModel atualizaCusto (long idApp, double custoNovo) throws Exception{
        AplicativoBD ap;
        Optional <AplicativoBD> app = aplicativo.findById(idApp);
        if(app.isPresent()){
            ap = app.get();
        }
        else{
            throw new Exception();
        }
        ap.setCMensal(custoNovo);
        return Adapter.aplicativoBD_to_Model(aplicativo.save(ap));
    }

}
