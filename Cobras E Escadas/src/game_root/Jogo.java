package game_root;

import game_entities.jogador.JogadoresCollection;
import game_entities.jogador.JogadoresPosicao;
import game_map.ControladorMapa;

public class Jogo 
{
	private JogadoresCollection jogadores;
	private ControladorMapa controladorMapa;
	private ControladorTurno turno;
	private JogadoresPosicao posicoes;
	
	public void iniciarJogo() 
	{
		
	}
	
	public boolean jogarTurno()
	{
		return true;
	}
}

