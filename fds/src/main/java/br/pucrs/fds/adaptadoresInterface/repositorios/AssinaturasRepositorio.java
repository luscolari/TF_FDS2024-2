package br.pucrs.fds.adaptadoresInterface.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.frameworkdriver.instancias.AssinaturaBD;
import br.pucrs.fds.frameworkdriver.interfaces.IAssinaturaJPA;

import java.util.List;
import java.util.Optional;


@Repository
@Primary
public class AssinaturasRepositorio {
    private IAssinaturaJPA assinatura;

    @Autowired
    public AssinaturasRepositorio(IAssinaturaJPA assinatura) {
        this.assinatura = assinatura;
    }

    public List<AssinaturaModel> findAll() {
        return assinatura.findAll().stream().map(as -> Adapter.assinaturaBD_to_Model(as)).toList();
    }

    public Optional<AssinaturaModel> findById(long id) {
        List<AssinaturaBD> assinaturas = assinatura.findAll();
        return assinaturas.stream()
                .filter(ass -> ass.getCodigo()==id)
                .map(as -> Adapter.assinaturaBD_to_Model(as)).findFirst();
    }

    public AssinaturaModel cadastroAssinatura (AssinaturaBD assinaturaNova){
        return Adapter.assinaturaBD_to_Model(assinatura.save(assinaturaNova));
    }

   
}