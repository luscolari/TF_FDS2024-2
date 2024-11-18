package br.pucrs.fds.aplicacao.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.repositorios.AplicativosRepositorio;
import br.pucrs.fds.adaptadoresInterface.repositorios.AssinaturasRepositorio;
import br.pucrs.fds.adaptadoresInterface.repositorios.ClientesRepositorio;
import br.pucrs.fds.dominio.entidades.AplicativoModel;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

@Service
public class ServicoCadastro {
    private ClientesRepositorio clientes;
    private AplicativosRepositorio aplicativos;
    private AssinaturasRepositorio assinaturas;

    public ServicoCadastro (ClientesRepositorio clientes, AplicativosRepositorio aplicativos, AssinaturasRepositorio assinaturas){
        this.clientes = clientes;
        this.aplicativos = aplicativos;
        this.assinaturas = assinaturas;
    }

    /* CLIENTES */

    public List <ClienteModel> pegaTodosClientesBanco (){
        return clientes.findAll();
    }

    public ClienteModel acharCliente (long id){
       return clientes.findById(id);
    }

    /* APLICATIVOS */

    public List <AplicativoModel> pegaTodosAplicatviosBanco (){
        return aplicativos.findAll();
    }

    /* ASSINATURAS */

    public List<AssinaturaModel> pegaTodasAssinaturasBanco(){
        return assinaturas.findAll();
    }

    public List<AssinaturaModel> pegaAssinaturasCliente(long id) {
        return assinaturas.findAll().stream().filter(as -> as.getCliente().getCodigo() == id).toList();
    }

    public List<AssinaturaModel> pegaAssinaturasAplicativo(long id) {
        return assinaturas.findAll().stream().filter(as -> as.getAplicativo().getCodigo() == id).toList();
    }

    public List<AssinaturaModel> pegaAssinaturasTipo(TipoAssinatura tipo) {
        if (tipo == TipoAssinatura.TODAS){
            return pegaTodasAssinaturasBanco();
        }
        LocalDate currentDate = LocalDate.now();  
        return assinaturas.findAll().stream().filter(as -> as.valida(currentDate) == tipo).toList();
    }
}
