package br.ufpb.dsc.lab1.entidade;

public class disciplina {
	private int id;
	private String nome;
	private double nota;
	
	public disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public disciplina(int id, String nome, double nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		disciplina other = (disciplina) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
