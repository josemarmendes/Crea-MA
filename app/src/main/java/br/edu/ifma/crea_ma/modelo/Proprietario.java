package br.edu.ifma.crea_ma.modelo;

import java.io.Serializable;

/**
 * Created by josemar on 14/09/17.
 */

public class Proprietario implements Serializable{
    private Long idProprietario;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Long getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Long idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return getIdProprietario() +" - "+ getNome()+ " Cpf: "+getCpf() + " - " + " Endereco: " +getEndereco();
    }
}
