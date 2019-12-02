package game_root;

import game_entities.jogador.IteradorJogador;

public class ControladorTurno 
{
	IteradorJogador iteradorJogadores;

	public ControladorTurno(IteradorJogador iteradorJogadores) 
	{
		super();
		this.iteradorJogadores = iteradorJogadores;
	}
	
	public int passarTurno()
	{
		return 0;
	}
}
