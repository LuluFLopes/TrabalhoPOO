package br.com.senacsp.dao;

import br.com.senacsp.model.Funcionario;
import br.com.senacsp.pattern.builder.FuncionarioBuilder;
import br.com.senacsp.pattern.factory.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private ConexaoFactory conexaoFactory = new ConexaoFactory();
    private FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
    private Connection conexao;

    public boolean salvar(Funcionario f) {

        conexao = conexaoFactory.getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO FUNCIONARIOS (NOME,IDADE,SALARIO,CARGO) VALUES (?,?,?,?)");

            ps.setString(1, f.getNome());
            ps.setInt(2, f.getIdade());
            ps.setDouble(3, f.getSalario());
            ps.setString(4, f.getCargo());

            Integer resposta = ps.executeUpdate();

            if (resposta > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
            return false;
        }

    }

    public boolean atualizar(Funcionario f) {

        conexao = conexaoFactory.getConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE FUNCIONARIOS SET NOME = ? ,IDADE = ?,SALARIO = ?,CARGO = ? WHERE ID = ?");
            ps.setString(1, f.getNome());
            ps.setInt(2, f.getIdade());
            ps.setDouble(3, f.getSalario());
            ps.setString(4, f.getCargo());
            ps.setInt(5, f.getId());

            Integer resposta = ps.executeUpdate();

            if (resposta > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
            return false;
        }

    }

    public List<Funcionario> listarTodos(String cargo) {

        conexao = conexaoFactory.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Funcionario> lista = new ArrayList<>();
        Funcionario f = null;

        try {
            ps = conexao.prepareStatement("SELECT * FROM FUNCIONARIOS");
            rs = ps.executeQuery();
            while (rs.next()) {
                f = funcionarioBuilder.criaFuncionario(cargo);
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getDouble("salario"));
                f.setCargo(rs.getString("cargo"));

                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
        } catch (NullPointerException e) {
            System.out.println("O objeto está nulo.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }

        return lista;

    }

    public List<Funcionario> listarPorNomeECargo(String nome, String cargo) {

        conexao = conexaoFactory.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Funcionario> lista = new ArrayList<>();
        Funcionario f = null;

        try {
            ps = conexao.prepareStatement("SELECT * FROM FUNCIONARIOS WHERE NOME LIKE ? AND CARGO = ?");
            ps.setString(1, '%' + nome + '%');
            ps.setString(2, cargo);
            rs = ps.executeQuery();
            while (rs.next()) {
                f = funcionarioBuilder.criaFuncionario(cargo);
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getDouble("salario"));
                f.setCargo(rs.getString("cargo"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
        } catch (NullPointerException e) {
            System.out.println("O objeto está nulo.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }

    public Funcionario pesquisarPorId(Integer id, String cargo) {

        conexao = conexaoFactory.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario f = null;

        try {
            ps = conexao.prepareStatement("SELECT * FROM FUNCIONARIOS WHERE ID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                f = funcionarioBuilder.criaFuncionario(cargo);
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getDouble("salario"));
                f.setCargo(rs.getString("cargo"));
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
        } catch (NullPointerException e) {
            System.out.println("O objeto está nulo.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return f;
    }
    
    public Funcionario pesquisarPorNome(String nome, String cargo) {

        conexao = conexaoFactory.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario f = null;

        try {
            ps = conexao.prepareStatement("SELECT * FROM FUNCIONARIOS WHERE NOME = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            while (rs.next()) {

                f = funcionarioBuilder.criaFuncionario(cargo);
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setSalario(rs.getDouble("salario"));
                f.setCargo(rs.getString("cargo"));
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
        } catch (NullPointerException e) {
            System.out.println("O objeto está nulo.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return f;
    }

    public boolean excluir(Integer id) {

        conexao = conexaoFactory.getConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM FUNCIONARIOS WHERE ID = ?");
            ps.setInt(1, id);

            Integer resposta = ps.executeUpdate();

            if (resposta > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Problema relacionados ao script.");
            return false;
        }

    }

}
