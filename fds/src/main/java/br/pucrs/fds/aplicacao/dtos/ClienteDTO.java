package br.pucrs.fds.aplicacao.dtos;

public class ClienteDTO {
    private long codigo;
    private String nome;
    private String email;

    public ClienteDTO(long codigo, String nome, String email){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ClienteDTO [ Código: " + codigo + ", Nome: " + nome + ", Email: " + email + "]";
    }
}
