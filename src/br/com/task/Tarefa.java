package br.com.task;
import java.util.Date;

public class Tarefa {
	private String descricao;
	private boolean completo;
	private Date data;
	private int prioridade;

	// Construtor
	public Tarefa(String descricao, Date data, int prioridade) {
		this.descricao = descricao;
		this.completo = false;
		this.data = data;
		this.prioridade = prioridade;
	}

	// Getters e setters

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean atividadeCompleta() {
		return completo;
	}

	public void setCompleto(boolean completed) {
		this.completo = completed;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date dueDate) {
		this.data = dueDate;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int priority) {
		this.prioridade = priority;
	}
}
