package com.estacio.CadastroEE.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movimento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMovimento;
    private int quantidadeMovimento;
    private Character tipoMovimento;
    private double valorUnitario;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    private List<Produto> produtoList;

    @ManyToOne
    private PessoaFisica pessoaFisica;

    @ManyToOne
    private PessoaJuridica pessoaJuridica;

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public int getQuantidadeMovimento() {
        return quantidadeMovimento;
    }

    public void setQuantidadeMovimento(int quantidadeMovimento) {
        this.quantidadeMovimento = quantidadeMovimento;
    }

    public Character getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(Character tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}