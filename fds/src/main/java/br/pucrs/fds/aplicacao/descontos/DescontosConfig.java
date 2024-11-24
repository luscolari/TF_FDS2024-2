package br.pucrs.fds.aplicacao.descontos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.pucrs.fds.dominio.descontos.Desconto45;
import br.pucrs.fds.dominio.descontos.DescontoAnual;
import br.pucrs.fds.dominio.descontos.None;

@Configuration
public class DescontosConfig {

    private DescontoAnual anual;
    private Desconto45 d45;
    private None none;
    public DescontosConfig(DescontoAnual anual, Desconto45 d45, None none){
        this.anual = anual;
        this.d45 = d45;
        this.none = none;
    }

    @Bean
    public List<IDesconto> nameList() {
        List<IDesconto> lista = new ArrayList<IDesconto>();
        lista.add(anual);
        lista.add(d45);
        lista.add(none);
        return lista;
    }
}
