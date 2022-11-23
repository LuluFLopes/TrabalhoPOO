package br.com.senacsp.pattern.strategy;

public abstract class CalculoExtra implements Strategy {

    @Override
    public abstract Double calcularHoraExtra(Double salario, Integer horasTrabalhadas);

}
