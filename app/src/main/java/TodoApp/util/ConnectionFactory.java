package TodoApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver is deprecated(está descontinuado)
    public static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {// somente blocos onde podem ocorrer exceções e que sejam mais críticas
            Class.forName(DRIVER); // serve para garantir que a a classe do DRIVER seja carregada. Se não for,
            // estoura uma exception
            return DriverManager.getConnection(URL, USER, PASS); // faz a conexão
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na conexão com o banco de dados: ", e);
        }

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ", e);
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ", e);
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ", e);
        }

    }
}
