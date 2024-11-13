package br.pucrs.fds.dominio.entidades;

public class ClienteModel {
    private int codigo;
    private String nome;
    private String email;

    public ClienteModel(int codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
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
        return "Cliente [ Código: " + codigo + ", Nome: " + nome + ", Email: " + email + "]";
    }


}
