package br.com.senacsp.controller;

import br.com.senacsp.dao.Dao;
import br.com.senacsp.model.Funcionario;
import br.com.senacsp.pattern.builder.FuncionarioBuilder;

import java.util.List;

public class Controller {

    private FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
    private Dao dao = funcionarioBuilder.criaDao();

    public boolean salvar(String nome, Integer idade, Double salario, String cargo) {
        Funcionario f = funcionarioBuilder.criaFuncionario(cargo);
        f.setNome(nome);
        f.setIdade(idade);
        f.setSalario(salario);
        f.setCargo(cargo);

        return dao.salvar(f);
    }

    public boolean atualizar(Integer id, String nome, Integer idade, Double salario, String cargo) {
        Funcionario f = funcionarioBuilder.criaFuncionario(cargo);
        f.setId(id);
        f.setNome(nome);
        f.setIdade(idade);
        f.setSalario(salario);
        f.setCargo(cargo);

        return dao.atualizar(f);
    }

    public List<Funcionario> listarTodos(String cargo) {
        return dao.listarTodos(cargo);
    }

    public List<Funcionario> listarPorNomeECargo(String nome, String cargo) {
        return dao.listarPorNomeECargo(nome, cargo);
    }

    public List<Funcionario> listarPorNome(String nome) {
        return dao.listarPorNome(nome);
    }


    public  Funcionario pesquisarPorId(Integer id, String cargo){
        return dao.pesquisarPorId(id, cargo);
    }
    
    public  Funcionario pesquisarPorNome(String nome, String cargo){
        return dao.pesquisarPorNome(nome, cargo);
    }

    public boolean excluir(Integer id) {
        return dao.excluir(id);
    }

}
