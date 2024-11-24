package br.pucrs.fds.aplicacao.descontos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.pucrs.fds.dominio.descontos.DescontoAnual;

@Configuration
public class DescontosConfig {

    private DescontoAnual anual;
    public DescontosConfig(DescontoAnual anual){
        this.anual = anual;
    }

    @Bean
    public List<IDesconto> nameList() {
        List<IDesconto> lista = new ArrayList<IDesconto>();
        lista.add(anual);
        return lista;
    }
}
