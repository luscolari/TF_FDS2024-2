package br.pucrs.fds.aplicacao.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoCadastro;

@Component
public class CadastroAssinaturaUC {
    private ServicoCadastro servicoCadastro;
    
    @Autowired
    public CadastroAssinaturaUC(ServicoCadastro servicoCadastro){
        this.servicoCadastro = servicoCadastro;
    }

    public AssinaturaDTO cadastroAssinatura(long idCliente, long idApp){
        return Adapter.assinaturaModel_to_DTO(servicoCadastro.cadastroAssinatura(idCliente, idApp));
    }

    public AplicativoDTO atualizaCusto(long idApp, double custoNovo) throws Exception{
        return Adapter.aplicativoModel_to_DTO(servicoCadastro.atualizaCusto(idApp, custoNovo));
    }
}
