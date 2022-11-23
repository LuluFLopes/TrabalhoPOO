/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senacsp.pattern.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoFactory {

    public Connection getConexao() {

        Connection conexao = null;

        try {
            // Carregando Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Abrindo conexão.
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhopoo"
                    + "?useTimezone=true&serverTimezone=UTC&useSSL=false", "root","");
        } catch (ClassNotFoundException ex) {

            String erro = ex.getMessage();

            JOptionPane.showMessageDialog(null, "Erro de Driver" + erro);
        } catch (SQLException ex) {

            String erro = ex.getMessage();

            JOptionPane.showMessageDialog(null, "Erro de Conexão" + erro);
        }
        return conexao;
    }

}
