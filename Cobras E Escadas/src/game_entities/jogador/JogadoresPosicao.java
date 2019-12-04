package game_entities.jogador;

import java.util.HashMap;

import game_map.casas.*;;

public class JogadoresPosicao
{
	private HashMap<Jogador, CasaAbstrata> posicoes;
	
	public JogadoresPosicao() 
	{
		posicoes = new HashMap<Jogador, CasaAbstrata>();
	}
	
	public CasaAbstrata getCasaAtual(Jogador jogador)
	{
		return posicoes.get(jogador);
	}
	
	public void setCasaAtual(Jogador jogador, CasaAbstrata casa) 
	{
		posicoes.put(jogador, casa);
	}
}
