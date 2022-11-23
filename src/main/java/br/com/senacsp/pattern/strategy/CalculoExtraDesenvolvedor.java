package br.com.senacsp.pattern.strategy;

public class CalculoExtraDesenvolvedor extends CalculoExtra {

    @Override
    public Double calcularHoraExtra(Double salario, Integer horasTrabalhadas) {

        Double horaTrabalho = salario / 220;
        Double horaExtra = (horaTrabalho * horasTrabalhadas) * 1.5;
        return horaExtra;

    }
}
