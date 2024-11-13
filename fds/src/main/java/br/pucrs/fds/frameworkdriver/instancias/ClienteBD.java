package frameworkDrivers.instancias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClienteBD {
    @Id
    private long codigo;
    private String nome;
    private String email;

    public ClienteBD(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    protected ClienteBD(){}

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
