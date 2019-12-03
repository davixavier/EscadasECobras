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
	
	public int moverJogador(Jogador jogador)
	{
		return mapa.moverJogador(jogador, sorteavel.sortear());
	}
}
