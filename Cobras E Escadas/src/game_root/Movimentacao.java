package game_root;

import game_entities.jogador.Jogador;
import game_logic.sorteaveis.Sorteavel;
import game_map.iterador_mapa.Mapa;

public class Movimentacao //Movimentacao possui um iterador do mapa e do jogador
{
	private Sorteavel sorteavel;
	
	public Movimentacao(Sorteavel sorteavel) 
	{
		this.sorteavel = sorteavel;
	}
	
	public int moverJogador(Jogador jogador, Mapa map)
	{
		int offset = sorteavel.sortear();
		return map.moverJogador(jogador, offset);
	}
}
