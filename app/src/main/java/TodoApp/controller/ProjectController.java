package TodoApp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import TodoApp.model.Project;
import TodoApp.util.ConnectionFactory;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProjectController {

    public void save(Project project) {
        String sql = "INSERT INTO PROJECTS (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT) " + "values (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        } 
        catch (SQLIntegrityConstraintViolationException e1) {
            e1.printStackTrace();
            throw new RuntimeException("Erro ao salvar a projeto: o valor name não pode ser vazio");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar projeto: " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Project project) {
        // EU poderia substituir direto. Mas não é correto, por isso que eu tenho que
        // substituir o ?
        String sql = "UPDATE projects SET NAME = ?, DESCRIPTION = ?, CREATED_AT = ?, UPDATED_AT = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar projeto: " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removerById(int id) {
        String sql = "DELETE FROM projects WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar projeto: " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Project> getAll() {
        Project project;
        String sql = "SELECT * FROM projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("ID"));
                project.setName(resultSet.getString("NAME"));
                project.setDescription(resultSet.getString("DESCRIPTION"));
                project.setCreatedAt(resultSet.getDate("CREATED_AT"));
                project.setUpdatedAt(resultSet.getDate("UPDATED_AT"));
                projects.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // se não houvesse tratamento de exceção, eu retornaria null
            throw new RuntimeException("Erro ao obter projeto(s): " + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }
}
