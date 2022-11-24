package br.com.senacsp.model;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, int idade, double salario, String cargo) {
        super(nome, idade, salario, cargo);
    }

    public Desenvolvedor(Integer id,String nome, int idade, double salario, String cargo) {
        super(nome, idade, salario, cargo);
    }

    public Desenvolvedor() {
    }
    
}
