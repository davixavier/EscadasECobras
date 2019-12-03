package game_root;

import game_entities.jogador.JogadoresCollection;

public class Jogo 
{
	private JogadoresCollection jogadores;
	private Movimentacao movimentacao;
	private ControladorTurno turno;
	
	public Jogo()
	{
		jogadores = new JogadoresCollection();
		//TODO inicializar jogadores
		
		movimentacao = new Movimentacao(null, null); //TODO passar mapa e dado
		
		turno = new ControladorTurno(jogadores.createIterator());
	}
	
	public void iniciarJogo() 
	{
		
	}
	
	public boolean jogarTurno()
	{
		return true;
	}
}

