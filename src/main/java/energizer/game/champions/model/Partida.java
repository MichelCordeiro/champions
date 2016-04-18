package energizer.game.champions.model;

import java.util.Calendar;
import java.util.List;

public class Partida {

	private int id;
	private Calendar dataPartida;
	private Jogo jogo;
	private List<Competidor> competidores;

	public Partida() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Calendar dataPartida) {
		this.dataPartida = dataPartida;
	}

	public List<Competidor> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(List<Competidor> competidores) {
		this.competidores = competidores;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

}
