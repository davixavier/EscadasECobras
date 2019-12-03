package game_map;

import game_entities.jogador.Jogador;
import game_logic.sorteaveis.Sorteavel;

public class Movimentacao //Movimentacao possui um iterador do mapa e do jogador
{
	private Mapa mapa;
	private Sorteavel sorteavel;
	
	public Movimentacao(Mapa mapa, Sorteavel sorteavel) 
	{
		this.mapa = mapa;
	}
	
	public void moverJogador(Jogador jogador)
	{
		CasaAbstrata casaAtual = mapa.getJogadoresPosicao().getCasaAtual(jogador);
		int indiceCasaAtual = mapa.getCasaIndice(casaAtual);
		
		indiceCasaAtual += sorteavel.sortear();
		if (indiceCasaAtual < 0)
		{
			indiceCasaAtual = 0;
		}
		else if(indiceCasaAtual > 100)
		{
			indiceCasaAtual = 100;
		}
		
		CasaAbstrata proximaCasa = mapa.getCasa(indiceCasaAtual);
		mapa.getJogadoresPosicao().setCasaAtual(jogador, proximaCasa);
	}
}
