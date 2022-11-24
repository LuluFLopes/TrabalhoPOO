package br.com.senacsp.pattern.builder;

import br.com.senacsp.controller.Controller;
import br.com.senacsp.dao.Dao;
import br.com.senacsp.model.Funcionario;
import br.com.senacsp.util.Validador;
import br.com.senacsp.view.TelaIntermediaria;

public interface Builder {

    Funcionario criaFuncionario(String cargo);
    Controller criaController();
    Dao criaDao();
    Validador criaValidador();
    TelaIntermediaria criaTelaIntermediaria();

}
