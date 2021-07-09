package entities;

public class Funcionario {
	
	private int id;
	private String nome;
	private String profissao;
	private int salario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(int id, String nome, String profissao, int salario) {
		this.id = id;
		this.nome = nome;
		this.profissao = profissao;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
}
