package game_entities.jogador;

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
