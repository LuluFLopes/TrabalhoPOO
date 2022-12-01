package br.com.senacsp.model;

import br.com.senacsp.pattern.strategy.CalculoExtra;
import br.com.senacsp.pattern.strategy.CalculoExtraDesenvolvedor;
import br.com.senacsp.pattern.strategy.CalculoExtraGerente;

public abstract class Funcionario {

    private Integer id;
    private String nome;
    private Integer idade;
    private Double salario;
    private String cargo;

    public Funcionario(String nome, int idade, double salario, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public Double calcularHoraExtra(Integer horas) {

        CalculoExtra instancia = null;

        if (this.cargo.equalsIgnoreCase("Desenvolvedor")) {
             instancia   = (CalculoExtraDesenvolvedor) new CalculoExtraDesenvolvedor();
        } else if (this.cargo.equalsIgnoreCase("Gerente")) {
             instancia  =  (CalculoExtraGerente) new CalculoExtraGerente();
        } else {
            return 0.0;
        }

        return instancia.calcularHoraExtra(getSalario(), horas);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
