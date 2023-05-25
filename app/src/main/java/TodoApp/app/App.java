package TodoApp.app;

import java.util.List;

import TodoApp.controller.ProjectController;
import TodoApp.model.Project;

public class App {
	public static void main(String[] args) {
		ProjectController projectController = new ProjectController();
//		Project project = new Project();	
//		project.setName("Projeto teste");
//		project.setDescription("descrição muito estilizada do Projeto Teste");
		
//		projectController.save(project);
//		project.setId(1);
//		project.setName("Atualização 01 do projeto teste");
		
//		projectController.update(project);
//		
//		List<Project> projects = projectController.getAll();
//		System.out.println("Lista de projetos:" + projects);
		
		projectController.removerById(1);
		
		//Testar agora as tasks
	}
}
