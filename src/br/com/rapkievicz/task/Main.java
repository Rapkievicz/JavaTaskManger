package br.com.rapkievicz.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static GerenciadorTarefa taskManager;
	private static SimpleDateFormat dateFormat;

	public static void main(String[] args) {
		taskManager = new GerenciadorTarefa();
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=== Gerenciador de Tarefas ===");
			System.out.println("1. Adicionar tarefa");
			System.out.println("2. Marcar tarefa como concluída");
			System.out.println("3. Remover tarefa");
			System.out.println("4. Listar tarefas");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha

			switch (option) {
			case 1:
				addTask(scanner);
				break;
			case 2:
				markTaskAsCompleted(scanner);
				break;
			case 3:
				removeTask(scanner);
				break;
			case 4:
				listTasks();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		}
	}

	private static void addTask(Scanner scanner) {
		System.out.print("Descrição da tarefa: ");
		String description = scanner.nextLine();

		System.out.print("Data de vencimento (dd/MM/yyyy): ");
		String dueDateString = scanner.nextLine();
		Date dueDate;
		try {
			dueDate = dateFormat.parse(dueDateString);
		} catch (ParseException e) {
			System.out.println("Formato de data inválido! Tarefa não adicionada.");
			System.out.println(" ");
			return;
		}

		System.out.print("Prioridade (1-5): ");
		int priority = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha

		Tarefa task = new Tarefa(description, dueDate, priority);
		taskManager.addTarefa(task);

		System.out.println("Tarefa adicionada com sucesso!");
		System.out.println(" ");
	}

	private static void markTaskAsCompleted(Scanner scanner) {
		System.out.print("Índice da tarefa a ser marcada como concluída: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha

		if (index >= 0 && index < taskManager.buscaTarefas().size()) {
			Tarefa task = taskManager.buscaTarefas().get(index);
			taskManager.concluirTarefa(task);
			System.out.println("Tarefa marcada como concluída!");
			System.out.println(" ");
		} else {
			System.out.println("Índice inválido!");
			System.out.println(" ");
		}
	}

	private static void removeTask(Scanner scanner) {
		System.out.print("Índice da tarefa a ser removida: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha

		if (index >= 0 && index < taskManager.buscaTarefas().size()) {
			Tarefa task = taskManager.buscaTarefas().get(index);
			taskManager.apagaTarefa(task);
			System.out.println("Tarefa removida!");
			System.out.println(" ");
		} else {
			System.out.println("Índice inválido!");
			System.out.println(" ");
		}
	}

	private static void listTasks() {
		List<Tarefa> tasks = taskManager.buscaTarefas();

		if (tasks.isEmpty()) {
			System.out.println("Nenhuma tarefa encontrada.");
			System.out.println(" ");
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				Tarefa task = tasks.get(i);
				System.out.println("[" + i + "] " + task.getDescricao() + " (Prioridade: " + task.getPrioridade()
						+ ", Vencimento: " + dateFormat.format(task.getData()) + ", Concluída: "
						+ task.atividadeCompleta() + ")");
				System.out.println(" ");
			}
		}
	}
}
