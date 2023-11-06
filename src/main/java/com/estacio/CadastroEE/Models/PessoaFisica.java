package com.estacio.CadastroEE.Models;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class PessoaFisica extends Pessoa implements Serializable {
     private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}