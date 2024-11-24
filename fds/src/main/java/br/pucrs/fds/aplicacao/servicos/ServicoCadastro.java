package br.pucrs.fds.aplicacao.servicos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.pucrs.fds.adaptadoresInterface.adapter.Adapter;
import br.pucrs.fds.adaptadoresInterface.interfacesRepositorios.IAssinaturasBanco;
import br.pucrs.fds.adaptadoresInterface.repositorios.AplicativosRepositorio;
import br.pucrs.fds.adaptadoresInterface.repositorios.ClientesRepositorio;
import br.pucrs.fds.dominio.entidades.AplicativoModel;
import br.pucrs.fds.dominio.entidades.AssinaturaModel;
import br.pucrs.fds.dominio.entidades.ClienteModel;
import br.pucrs.fds.dominio.entidades.PagamentoModel;
import br.pucrs.fds.dominio.extras.TipoAssinatura;

@Service
public class ServicoCadastro {
    private ClientesRepositorio clientes;
    private AplicativosRepositorio aplicativos;
    private IAssinaturasBanco assinaturas;
    private long next_idAss;

    public ServicoCadastro (ClientesRepositorio clientes, AplicativosRepositorio aplicativos, IAssinaturasBanco assinaturas){
        this.clientes = clientes;
        this.aplicativos = aplicativos;
        this.assinaturas = assinaturas;
        this.next_idAss = assinaturas.findAll().size();
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

    public AssinaturaModel cadastroAssinatura (long idCliente, long idApp){
        ClienteModel cliente = acharCliente(idCliente);
        AplicativoModel app = pegaTodosAplicatviosBanco().stream().filter(ap -> ap.getCodigo() == idApp).toList().getFirst();
        LocalDate currentDate = LocalDate.now();
        LocalDate dataExpiracao = currentDate.plusDays(37);
        String s = currentDate.toString();
        String[] partes = s.split("-");
        String novaString = partes[2] + "/" + partes[1] + "/" + partes[0];
        s = dataExpiracao.toString();
        partes = s.split("-");
        String novaString2 = partes[2] + "/" + partes[1] + "/" + partes[0];
        AssinaturaModel novaAssinatura = new AssinaturaModel(next_idAss++, app, cliente, novaString, novaString2);
        return assinaturas.cadastroAssinatura(Adapter.assinaturaModel_to_BD(novaAssinatura));
    }

    public AplicativoModel atualizaCusto (long idApp, double custoNovo) throws Exception{
        return aplicativos.atualizaCusto(idApp, custoNovo);
    }

    public boolean ativoOuNao (long idAss){
        Optional<AssinaturaModel> assinaturaValida;
        AssinaturaModel ass
        ;
        assinaturaValida = assinaturas.findById(idAss);
        if(assinaturaValida.isPresent()){
            ass = assinaturaValida.get();
        } else {
            return false;
        }
        boolean resposta = (ass.valida(LocalDate.now()) == TipoAssinatura.ATIVAS) ? true : false;
        return resposta;
    }

    public AssinaturaModel atualizarDataExpiracao(PagamentoModel pagamento, LocalDate novaData){
        String s = novaData.toString();
        String[] partes = s.split("-");
        String novaString = partes[2] + "/" + partes[1] + "/" + partes[0];
  

        AssinaturaModel assinatura = pagamento.getAssinatura();
        AssinaturaModel novaAssinatura = new AssinaturaModel(assinatura.getCodigo(), assinatura.getAplicativo(), assinatura.getCliente(), assinatura.getInicioV(), novaString);
        return assinaturas.cadastroAssinatura(Adapter.assinaturaModel_to_BD(novaAssinatura));
    }
}
