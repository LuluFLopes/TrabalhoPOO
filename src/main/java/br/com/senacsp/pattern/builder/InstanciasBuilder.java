package br.com.senacsp.pattern.builder;

import br.com.senacsp.controller.Controller;
import br.com.senacsp.dao.Dao;
import br.com.senacsp.model.Desenvolvedor;
import br.com.senacsp.model.Estagiario;
import br.com.senacsp.model.Funcionario;
import br.com.senacsp.model.Gerente;
import br.com.senacsp.util.Validador;
import br.com.senacsp.view.TelaIntermediaria;

public class InstanciasBuilder implements Builder {

    @Override
    public Funcionario criaTipo(String cargo) {
        if (cargo.equalsIgnoreCase("Gerente")) {
            return new Gerente();
        } else if (cargo.equalsIgnoreCase("Estagiário")) {
            return new Estagiario();
        } else if (cargo.equalsIgnoreCase("Desenvolvedor")) {
            return new Desenvolvedor();
        } else {
            return null;
        }
    }
    @Override
    public Controller criaController(){
        return new Controller();
    }
    @Override
    public Dao criaDao(){
        return new Dao();
    }
    @Override
    public Validador criaValidador(){
        return new Validador();
    }
    @Override
    public TelaIntermediaria criaTelaIntermediaria() {
        return new TelaIntermediaria();
    }

}
