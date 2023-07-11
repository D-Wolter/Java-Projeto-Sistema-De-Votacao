package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  /**
   * Classe cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (numeroJaCadastrado(numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
      return;
    }

    /**
     * Classe novaCandidata.
     */
    PessoaCandidata novaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novaCandidata);
  }

  /**
   * Classe cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (cpfJaCadastrado(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    /**
     * Classe novaEleitora.
     */

    PessoaEleitora novaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novaEleitora);
  }

  /**
   *  votar.
   */

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    PessoaCandidata candidata = buscarPessoaCandidata(numeroPessoaCandidata);
    if (candidata == null) {
      System.out.println("Número da pessoa candidata inválido!");
      return;
    }

    /**
     *  recebeVoto.
     */
    candidata.receberVoto();
    cpfsComputados.add(cpfPessoaEleitora);
  }

  /**
   *  mostrarResultado.
   */
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    System.out.println("Resultado da eleição:");
    for (PessoaCandidata candidata : pessoasCandidatas) {
      int votos = candidata.getVotos();
      double percentual = (votos * 100.0) / cpfsComputados.size();
      System.out.println("Nome: " + candidata.getNome() + " - " + votos
          + " votos ( " + Math.round(percentual) + "%) ");
    }
    System.out.println("Total de votos: " + cpfsComputados.size());
  }

  private boolean numeroJaCadastrado(int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        return true;
      }
    }
    return false;
  }

  private boolean cpfJaCadastrado(String cpf) {
    for (PessoaEleitora eleitora : pessoasEleitoras) {
      if (eleitora.getCpf().equals(cpf)) {
        return true;
      }
    }
    return false;
  }

  private PessoaCandidata buscarPessoaCandidata(int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        return candidata;
      }
    }
    return null;
  }
}