package TodoApp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TodoApp.model.Task;
import TodoApp.util.ConnectionFactory;

public class TaskController {

    public void save(Task task) {
        String sql = "INSERT INTO TASKS (IDPROJECT, NAME, DESCRIPTION, COMPLETED, NOTES, DEADLINE, CREATED_AT, UPDATED_AT)"
                // o campo id é AUTO_INCREMENT, quer dizer que a base adiciona automáticamente.
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // esse comando Sql é o que define o método save(cria as tasks)

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //estabelece a conexção com o bd
            connection = ConnectionFactory.getConnection();

            // Preparando a query
            statement = connection.prepareStatement(sql);
            // setando o valor do statement
            // os méotodos abaixo, substitui os ? do String sql pelos valores definidos de cada posição
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());

            // obs: o tipo date que ele espera é o Date do pacote sql e não do java.util
            // Para eu converter, o contrutor do sql.Date precisa de um argumento do tipo
            // long. Por isso que eu uso o getTime() do java.util.Date
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar a tarefa: " + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {
        String sql = "UPDATE TASKS SET IDPROJECT = ?, NAME = ?, DESCRIPTION = ?, NOTES = ?, COMPLETED = ?, DEADLINE = ?,"
                + " CREATED_AT = ?, UPDATED_AT = ? WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //estabelece a conexão com o bd
            connection = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connection.prepareStatement(sql);
            // setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            //Executando a query
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar tarefa: " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int taskId) throws SQLException {
        String sql = "DELETE FROM TASKS WHERE ID = ?"; // esse comando Sql é o que define o método removeById
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //estabelece a conexão com o bd
            connection = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connection.prepareStatement(sql);
            // setando o valor do statement
            statement.setInt(1, taskId); // substitui o ? do String sql pelo taskId
            //Executando a query
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao deletar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int idProject) {
        String sql = "SELECT * FROM TASKS WHERE IDPROJECT = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  // é nela que eu guardo os valores de resposta do bd.

        List<Task> tasks = new ArrayList<>();
        try {
            // estabelece a conexão com o bd
            connection = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connection.prepareStatement(sql);
            // setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            // valor retornado pela execução da query
            resultSet = statement.executeQuery(); // devolve o valor de resposta do comando String sql que aconteceu no banco de Dados;

            // Enquando houver valores a serem percorridos no resultSet
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("ID")); // pego o valor da coluna do id (pego o id)
                task.setIdProject(resultSet.getInt("IDPROJECT"));
                task.setName(resultSet.getString("NAME"));
                task.setDescription(resultSet.getString("DESCRIPTION"));
                task.setNotes(resultSet.getString("NOTES"));
                task.setCompleted(resultSet.getBoolean("COMPLETED"));
                task.setDeadLine(resultSet.getDate("DEADLINE"));
                task.setCreatedAt(resultSet.getDate("CREATED_AT"));
                task.setUpdatedAt(resultSet.getDate("UPDATED_AT"));

                tasks.add(task);
            }  
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter tarefa(s): " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        //lista de tarefas que foi criada
        return tasks;
    }
}
