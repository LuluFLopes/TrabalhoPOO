package br.com.senacsp.pattern.strategy;

public class CalculoExtraGerente extends CalculoExtra {

    @Override
    public Double calcularHoraExtra(Double salario, Integer horasTrabalhadas) {

        Double horaTrabalho = salario / 220;
        Double horaExtra = (horaTrabalho * horasTrabalhadas) * 1.7;
        return horaExtra;

    }
}
