package br.com.senacsp.pattern.factory;

import java.sql.Connection;

public interface Factory {
    Connection getConexao();
}
