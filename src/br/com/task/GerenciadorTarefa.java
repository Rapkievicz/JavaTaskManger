package br.com.task;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefa {
	private List<Tarefa> tarefa;

	public GerenciadorTarefa() {
		this.tarefa = new ArrayList<>();
	}

	public void addTarefa(Tarefa task) {
		tarefa.add(task);
	}

	public List<Tarefa> buscaTarefas() {
		return tarefa;
	}

	public void concluirTarefa(Tarefa task) {
		task.setCompleto(true);
	}

	public void apagaTarefa(Tarefa task) {
		tarefa.remove(task);
	}
}
