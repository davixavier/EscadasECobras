package game_entities.jogador;

import java.util.HashMap;

import game_map.ICasa;
import game_map.Mapa;

public class JogadoresPosicao
{
	private HashMap<Jogador, ICasa> posicoes;
	
	public ICasa getCasaAtual(Jogador jogador)
	{
		return posicoes.get(jogador);
	}
	
	public ICasa setCasaAtual(Jogador jogador, ICasa casa) 
	{
		
		return null;
	}
}
