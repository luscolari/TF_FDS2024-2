package br.pucrs.fds;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private IAcervoRepository livros;

    @Autowired
    public Controller(IAcervoRepository livros) {
        this.livros = livros; 
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String inicio(){
        return "Teste";
    }

    @GetMapping("/clientes")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return livros.getAll();
    }
  
}