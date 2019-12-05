package game_root;

import game_entities.jogador.IteradorJogador;
import game_entities.jogador.Jogador;

public class ControladorTurno 
{
	private IteradorJogador iteradorJogadores;

	public ControladorTurno(IteradorJogador iteradorJogadores) 
	{
		super();
		this.iteradorJogadores = iteradorJogadores;
	}
	
	public Jogador passarTurno()
	{
		return iteradorJogadores.next();
	}
	
	public int turnoAtual()
	{
		int turno = iteradorJogadores.nextIndex()-1;
		
		return turno;
	}
}
