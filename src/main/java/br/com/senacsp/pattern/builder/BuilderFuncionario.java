package br.com.senacsp.pattern.builder;

import br.com.senacsp.controller.Controller;
import br.com.senacsp.dao.Dao;
import br.com.senacsp.model.Desenvolvedor;
import br.com.senacsp.model.Estagiario;
import br.com.senacsp.model.Funcionario;
import br.com.senacsp.model.Gerente;

public class BuilderFuncionario {

    private Gerente gerente;
    private Estagiario estagiario;
    private Desenvolvedor desenvolvedor;
    private Controller controller;
    private Dao dao;

    public Funcionario criaFuncionario(String cargo) {

        if (cargo.equalsIgnoreCase("Gerente")) {
            return new Gerente();
        } else if (cargo.equalsIgnoreCase("Estagiario")) {
            return new Estagiario();
        } else if (cargo.equalsIgnoreCase("Desenvolvedor")) {
            return new Desenvolvedor();
        } else {
            return new Funcionario();
        }
    }

    public Controller criaController(){
        return new Controller();
    }

    public Dao criaDao(){
        return new Dao();
    }

}
