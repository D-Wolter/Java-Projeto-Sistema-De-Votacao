package com.betrybe.sistemadevotacao;

/**
 * Classe PessoaCandidata.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Construtor.
   */
  public PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    votos++;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}