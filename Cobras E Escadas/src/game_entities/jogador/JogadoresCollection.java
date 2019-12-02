
package main.app.game_entities.jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadoresCollection implements IColeção<Jogador>
{
	private List<Jogador> jogadores;
	
	public JogadoresCollection()
	{
		jogadores = new ArrayList<Jogador>();
	}
	
	public void add(Jogador jogador)
	{
		this.jogadores.add(jogador);
	}
	
	public void remove(Jogador jogador)
	{
		this.jogadores.remove(jogador);
	}
	
	public void remove(int i)
	{
		this.jogadores.remove(i);
	}

	@Override
	public IteradorJogador createIterator()
	{
		return new IteradorJogador(jogadores);
	}
}
