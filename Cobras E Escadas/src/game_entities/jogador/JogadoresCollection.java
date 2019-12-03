
package game_entities.jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadoresCollection implements IColecao<Jogador>
{
	private List<Jogador> jogadores;
	
	public JogadoresCollection(int quantidadeJogadores)
	{
		jogadores = new ArrayList<Jogador>();
		for (int i = 0; i < quantidadeJogadores; i++)
		{
			Jogador novoJogador = new Jogador("ff" + i*500);//TODO modificar logica de cores
			jogadores.add(novoJogador);
		}
	}

	public Jogador getJogador(int i) {
		return jogadores.get(i);
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
