package br.pucrs.fds.aplicacao.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.dtos.AplicativoDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoTesteApp;

@Component
public class PegaAplicativosUC {
private ServicoTesteApp servicoTeste;

     public PegaAplicativosUC(ServicoTesteApp serviicoTeste){
        this.servicoTeste = serviicoTeste;
    }

    public List <AplicativoDTO> pegaAppsServico(){
        return servicoTeste.pegaTodosAplicatviosBanco().stream().map(app -> Adapter.aplicativoModel_to_DTO(app)).toList();
    }

}
