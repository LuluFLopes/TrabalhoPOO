package br.com.senacsp.controller;

import br.com.senacsp.dao.Dao;
import br.com.senacsp.model.Funcionario;
import br.com.senacsp.pattern.builder.InstanciasBuilder;

import java.util.List;

public class Controller {

    private InstanciasBuilder instanciasBuilder = new InstanciasBuilder();
    private Dao dao = instanciasBuilder.criaDao();

    public boolean salvar(String nome, Integer idade, Double salario, String cargo) {
        Funcionario f = instanciasBuilder.criaTipo(cargo);
        f.setNome(nome);
        f.setIdade(idade);
        f.setSalario(salario);
        f.setCargo(cargo);

        return dao.salvar(f);
    }

    public boolean atualizar(Integer id, String nome, Integer idade, Double salario, String cargo) {
        Funcionario f = instanciasBuilder.criaTipo(cargo);
        f.setId(id);
        f.setNome(nome);
        f.setIdade(idade);
        f.setSalario(salario);
        f.setCargo(cargo);

        return dao.atualizar(f);
    }

    public List<Funcionario> listarTodos() {
        return dao.listarTodos();
    }

    public List<Funcionario> listarPorNome(String nome) {
        return dao.listarPorNome(nome);
    }

    public List<Funcionario> listarPorCargo(String cargo) {
        return dao.listarPorCargo(cargo);
    }

    public Funcionario pesquisarPorId(Integer id){
        return dao.pesquisarPorId(id);
    }
    
    public  Funcionario pesquisarPorNome(String nome){
        return dao.pesquisarPorNome(nome);
    }

    public boolean excluir(Integer id) {
        return dao.excluir(id);
    }

}
