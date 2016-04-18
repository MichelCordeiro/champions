package TDD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import energizer.game.champions.model.Competidor;
import energizer.game.champions.model.Conquista;
import energizer.game.champions.model.Jogo;
import energizer.game.champions.model.Partida;

import static org.junit.Assert.*;

public class PartidaTest {

	private List<Competidor> competidores;
	private Jogo jogo;
	private Calendar dataPartida;
	private Partida partida;
	private static final String JOGO = "QUEM_SOU_EU";
	private static final String JOGO2 = "JOGO_DOS_CRACHAS";

	@Before
	public void init() {
		competidores = listaCompetidores();
		jogo = new Jogo(JOGO);
		dataPartida = Calendar.getInstance();
		dataPartida.set(2016, Calendar.APRIL, 12);

	}

	@Test
	public void deveValidarUmaPartida() {

		partida = new Partida();
		partida.setDataPartida(dataPartida);
		partida.setJogo(jogo);
		partida.setCompetidores(listaCompetidores());

		for (Competidor competidor : competidores) {
			if (competidor.getNome() == "Kaylo"
					|| competidor.getNome() == "Ray") {
				competidor.setPonto(competidor.getPonto() + 3);
				competidor.setIsVencedorDaUltimaPartida(true);

				System.out.println(competidor.getNome() + competidor.getPonto()
						+ " - Conquistas Antes: "
						+ competidor.getConquistas().toString());

				novasConquistas(competidor);

				System.out.println(competidor.getNome() + competidor.getPonto()
						+ " - Conquistas Novas: "
						+ competidor.getConquistas().toString());

			} else {
				competidor.setPonto(competidor.getPonto() + 1);
				competidor.setIsVencedorDaUltimaPartida(false);
			}
		}

	}

	@Test
	public void deveValidarNovasConquistas() {

	}

	@Test
	public void deveValidarConsistenciaParaTestarPartida() {

		assertEquals("Valida a quantidade de conquistas para o teste", 4, conquistas().size());
		assertEquals("Valida se existe uma conquista para um tipo de jogo diferente", true, conquistas().get(3).getJogo().getNome().contains(JOGO2));
		assertEquals("Valida se a conquista 1 é refente ao jogo tipo JOGO", true, conquistas().get(0).getJogo().getNome().contains(JOGO));
		assertEquals("Valida se a conquista 2 é refente ao jogo tipo JOGO", true, conquistas().get(1).getJogo().getNome().contains(JOGO));
		assertEquals("Valida se a conquista 3 é refente ao jogo tipo JOGO", true, conquistas().get(2).getJogo().getNome().contains(JOGO));
		
		assertEquals("Valida a quantidade de competidores para o teste", 4, listaCompetidores().size());
		assertEquals("Valida a pontuação do 1 e 3 competidor", true, listaCompetidores().get(0).getPonto() == 5 && listaCompetidores().get(2).getPonto() == 3);
		assertEquals("Valida a pontuação do 2 e 4 competidor", true, listaCompetidores().get(1).getPonto() == 10 && listaCompetidores().get(3).getPonto() == 20);
		

	}


	public List<Conquista> novasConquistas(Competidor competidor) {

		List<Conquista> conquistas = new ArrayList<Conquista>();

		Conquista cq = new Conquista("master", new Jogo(JOGO), 8);
		Conquista cq1 = new Conquista("master dos masters", new Jogo(JOGO2), 20);
		Conquista cq2 = new Conquista("super master", new Jogo(JOGO), 10);
		conquistas.addAll(conquistas());
		conquistas.add(cq);
		conquistas.add(cq1);
		conquistas.add(cq2);

		List<Conquista> novasConquistas = new ArrayList<Conquista>();

		for (Conquista conquista : conquistas) {
			if (conquista.getPontuacaoAlvo() <= competidor.getPonto()
					&& conquista.getJogo().getNome() == jogo.getNome()) {
				novasConquistas.add(conquista);
			}
		}

		int count = -1;
		for (Conquista novaConquista : novasConquistas) {
			count = count + 1;
			if (!competidor.getConquistas().get(count).getNome()
					.contains(novaConquista.getNome())
									&& novaConquista.getJogo().getNome() == jogo
											.getNome()) {
				competidor.getConquistas().add(novaConquista);
			}
		}

		return competidor.getConquistas();
	}

	private List<Competidor> listaCompetidores() {

		competidores = new ArrayList<Competidor>();
		
		Competidor c1 = new Competidor("Ray", 5, conquistas(), true);
		Competidor c2 = new Competidor("Kaylo", 10, conquistas(), false);
		Competidor c3 = new Competidor("Leia", 3, conquistas(), true);
		Competidor c4 = new Competidor("Luke", 20, conquistas(), false);
		
		competidores.add(c1);
		competidores.add(c2);
		competidores.add(c3);
		competidores.add(c4);
		
		return competidores;

	}

	private List<Conquista> conquistas() {
		Conquista c1 = new Conquista("noob", new Jogo(JOGO), 3);
		Conquista c2 = new Conquista("aprendiz", new Jogo(JOGO), 9);
		Conquista c3 = new Conquista("padawan", new Jogo(JOGO), 15);
		Conquista c4 = new Conquista("sabe tudo", new Jogo(JOGO2), 7);
		List<Conquista> conquistas = new ArrayList<Conquista>();
		conquistas.add(c1);
		conquistas.add(c2);
		conquistas.add(c3);
		conquistas.add(c4);
		return conquistas;
	}


}