package br.pucrs.fds.aplicacao.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.aplicacao.dtos.AssinaturaDTO;
import br.pucrs.fds.aplicacao.servicos.ServicoCadastro;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

@Component
public class PegaAssinaturasUC {

    private ServicoCadastro servicoCadastro;

    @Autowired
    public PegaAssinaturasUC(ServicoCadastro servicoCadastro){
        this.servicoCadastro = servicoCadastro;
    }
    public List<AssinaturaDTO> pegaAssinaturasServico() {
        return servicoCadastro.pegaTodasAssinaturasBanco().stream().map(as -> Adapter.assinaturaModel_to_DTO(as)).toList();
    }
    public List<AssinaturaDTO> pegaAssinaturasClienteServico(long id) {
        return servicoCadastro.pegaAssinaturasCliente(id).stream().map(as -> Adapter.assinaturaModel_to_DTO(as)).toList();
    }
    public List<AssinaturaDTO> pegaAssinaturasAplicativoServico(long id) {
        return servicoCadastro.pegaAssinaturasAplicativo(id).stream().map(as -> Adapter.assinaturaModel_to_DTO(as)).toList();
    }
    public List<AssinaturaDTO> pegaAssinaturasTipoServico(TipoAssinatura tipo) {
        return servicoCadastro.pegaAssinaturasTipo(tipo).stream().map(as -> Adapter.assinaturaModel_to_DTO(as)).toList();
    }

   public boolean ativoOuNao(long idAss){
        return servicoCadastro.ativoOuNao(idAss);
   }
    
}
