package TDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import energizer.game.champions.model.Competidor;
import energizer.game.champions.model.Conquista;
import energizer.game.champions.model.Jogo;
import static org.junit.Assert.*;

public class RankingTest {

	private Competidor c1;
	private Competidor c2;
	private List<Competidor> ranking;


	@Before
	public void init() {
		c1 = new Competidor("Michel Cordeiro", 15, conquistas1());
		c2 = new Competidor("João da Silva", 30, conquistas2());
		ranking = umRanking();
	}

	@Test
	public void deveTestarPontucaoDeCompetidores() {
		assertEquals("o primeiro item da lista deve ter pontuação de 30", 30,ranking.get(0).getPonto());
		assertEquals("o segundo item da lista deve ter pontuação de 15", 15,ranking.get(1).getPonto());

	}

	@Test
	public void deveTestarPrimeiroColocadoComMaiorPontuacao(){
		assertTrue("O primeiro item da lista deve ter pontuação maior que o segundo", ranking.get(0).getPonto() > ranking.get(1).getPonto());		
	}
	
	
	@Test
	public void deveTestarTamanhoRanking(){
		assertEquals("lista deve conter apenas 2 itens", 2, ranking.size());		
	}
	
	
	@Test
	public void deveExibirUltimaConquista() {
		assertEquals("Testa ultima conquista do PRIMEIRO colocado","profissional", ranking.get(0).getUltimaConquista());
		assertEquals("Testa ultima conquista do SEGUNDO colocado","super-hero", ranking.get(1).getUltimaConquista());

	}

	public List<Competidor> umRanking() {

		List<Competidor> competidores = new ArrayList<Competidor>();
		List<Competidor> ranking = new ArrayList<Competidor>();
		String ultimaConquista = "";

		competidores.add(c1);
		competidores.add(c2);

		for (Competidor competidor : competidores) {
			ultimaConquista = competidor.getConquistas()
					.get(competidor.getConquistas().size() - 1).toString();
			competidor.setUltimaConquista(ultimaConquista);

			ranking.add(competidor);
		}

		Collections.sort(ranking);

		return ranking;

	}

	private List<Conquista> conquistas1() {
		Conquista c1 = new Conquista("noob", new Jogo("JOGO1"), 3);
		Conquista c2 = new Conquista("aprendiz", new Jogo("JOGO2"), 6);
		Conquista c3 = new Conquista("marvel-man", new Jogo("JOGO3"), 15);
		Conquista c4 = new Conquista("super-hero", new Jogo("JOGO1"), 3);

		List<Conquista> conquistas = new ArrayList<Conquista>();
		conquistas.add(c1);
		conquistas.add(c2);
		conquistas.add(c3);
		conquistas.add(c4);
		return conquistas;
	}

	private List<Conquista> conquistas2() {
		Conquista c1 = new Conquista("meu heroi", new Jogo("JOGO1"), 3);
		Conquista c2 = new Conquista("aprendiz", new Jogo("JOGO1"), 3);
		Conquista c3 = new Conquista("sabe tudo", new Jogo("JOGO1"), 3);
		Conquista c4 = new Conquista("profissional", new Jogo("JOGO1"), 3);

		List<Conquista> conquistas = new ArrayList<Conquista>();
		conquistas.add(c1);
		conquistas.add(c2);
		conquistas.add(c3);
		conquistas.add(c4);
		return conquistas;

	}

}
