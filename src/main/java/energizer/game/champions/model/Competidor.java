package energizer.game.champions.model;

import java.util.List;

public class Competidor implements Comparable<Competidor> {

	private int id;
	private String nome;
	private int ponto;
	private String ultimaConquista;
	private Boolean isVencedorDaUltimaPartida;
	private List<Conquista> conquistas;

	/**
	 * 
	 * método construtor de um competidor
	 * 
	 * @param nome
	 *            nome do competidor
	 * @param ponto
	 *            pontos atribuidos ao competidor
	 * @param conquistas
	 *            lista de conquistas já obtidas pelo competidor
	 */
	public Competidor(String nome, int ponto, List<Conquista> conquistas) {
		super();
		this.nome = nome;
		this.ponto = ponto;
		this.conquistas = conquistas;
	}

	/**
	 * 
	 * método construtor de um competidor
	 * 
	 * @param nome
	 *            nome do competidor
	 * @param ponto
	 *            pontos atribuidos ao competidor
	 * @param conquistas
	 *            lista de conquistas já obtidas pelo competidor
	 * @param isVencedorDaUltimaPartida
	 *            informa true se o competidor venceu sua última partida e false
	 *            caso não.
	 */
	public Competidor(String nome, int ponto, List<Conquista> conquistas,
			Boolean isVencedorDaUltimaPartida) {
		super();
		this.nome = nome;
		this.ponto = ponto;
		this.conquistas = conquistas;
		this.isVencedorDaUltimaPartida = isVencedorDaUltimaPartida;
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

	public int getPonto() {
		return ponto;
	}

	public void setPonto(int ponto) {
		this.ponto = ponto;
	}

	public List<Conquista> getConquistas() {
		return conquistas;
	}

	public void setConquistas(List<Conquista> conquistas) {
		this.conquistas = conquistas;
	}

	public String getUltimaConquista() {
		return ultimaConquista;
	}

	public void setUltimaConquista(String ultimaConquista) {
		this.ultimaConquista = ultimaConquista;
	}

	public Boolean getIsVencedorDaUltimaPartida() {
		return isVencedorDaUltimaPartida;
	}

	public void setIsVencedorDaUltimaPartida(Boolean isVencedorDaUltimaPartida) {
		this.isVencedorDaUltimaPartida = isVencedorDaUltimaPartida;
	}

	@Override
	public int compareTo(Competidor competidor) {
		if (this.ponto > competidor.ponto) {
			return -1;
		} else if (this.ponto < competidor.ponto) {
			return 1;
		}
		return this.getNome().compareToIgnoreCase(competidor.getNome());
	}

	@Override
	public String toString() {
		return "Competidor [nome=" + nome + ", ponto=" + ponto
				+ ", ultimaConquista=" + ultimaConquista
				+ ", isVencedorDaUltimaPartida=" + isVencedorDaUltimaPartida
				+ "]";
	}

}
