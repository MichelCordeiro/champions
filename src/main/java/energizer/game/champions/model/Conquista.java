package energizer.game.champions.model;

public class Conquista {

	private int id;
	private String nome;
	private Jogo jogo;
	private int pontuacaoAlvo;

	public Conquista() {
		super();
	}

	public Conquista(String nome, Jogo jogo, int pontuacaoAlvo) {
		super();
		this.nome = nome;
		this.jogo = jogo;
		this.pontuacaoAlvo = pontuacaoAlvo;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public int getPontuacaoAlvo() {
		return pontuacaoAlvo;
	}

	public void setPontuacaoAlvo(int pontuacaoAlvo) {
		this.pontuacaoAlvo = pontuacaoAlvo;
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

	@Override
	public String toString() {
		return nome + "-" + jogo.getNome();
	}
}
