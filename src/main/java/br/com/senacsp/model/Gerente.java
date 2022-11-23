package br.com.senacsp.model;

public class Gerente extends Funcionario {

    public Gerente(String nome, int idade, double salario, String cargo) {
        super(nome, idade, salario, cargo);
    }

    public Gerente() {
    }

    @Override
    public void calculaBonus() {
        setSalario(getSalario() * 1.4);
    }

}
