package energizer.game.champions.model;

public class Jogo {

	private int id;
	private String nome;
	private String regra;

	public Jogo(String nome) {
		super();
		this.nome = nome;
	}

	public Jogo() {
		super();
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

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}


}
