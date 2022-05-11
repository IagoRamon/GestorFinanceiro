package modelo;

public class Infos {

	private String nome;

	public Infos() {
	}

	public Infos(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Infos [nome=" + nome + "]";
	}

}
