package br.pucrs.fsd;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public Controller() {
        
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio(){
        return "Teste";
    }
  
}