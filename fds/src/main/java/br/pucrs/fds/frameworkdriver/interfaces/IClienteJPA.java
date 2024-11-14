package frameworkDrivers.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import frameworkDrivers.instancias.ClienteBD;

//--> extends CrudRepository<ClienteBD,Long>
public interface IClienteJPA {
    //List<ClienteBD> findAll();
    //Optional<ClienteBD> findById(long id);
    List<Livro> getAll();
    List<String> getTitulos();
    List<String> getAutores();
    List<Livro> getLivrosDoAutor(String autor);
    Livro getLivroTitulo(String titulo);
    boolean cadastraLivroNovo(Livro livro);
    boolean removeLivro(long codigo);
}