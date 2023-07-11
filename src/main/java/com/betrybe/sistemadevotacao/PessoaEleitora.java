package com.betrybe.sistemadevotacao;

/**
 * Classe PessoaEleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;


  /**
   * Construtor.
   */
  public PessoaEleitora(String nome, String cpf) {
    super.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
