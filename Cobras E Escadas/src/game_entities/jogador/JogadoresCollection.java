
package game_entities.jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadoresCollection implements IColecaoJogador
{
	private List<Jogador> jogadores;
	
	public JogadoresCollection(int quantidadeJogadores)
	{
		jogadores = new ArrayList<Jogador>();
		for (int i = 0; i < quantidadeJogadores; i++)
		{
			int rand = (int)(Math.random() * 10000);
			if (rand < 1000)
				rand += 1000;
			
			Jogador novoJogador = new Jogador("#ff" + rand);//TODO modificar logica de cores
			jogadores.add(novoJogador);
		}
	}

	public Jogador getJogador(int i) {
		return jogadores.get(i);
	}
	
	@Override
	public void add(Jogador jogador)
	{
		this.jogadores.add(jogador);
	}
	
	@Override
	public void remove(Jogador jogador)
	{
		this.jogadores.remove(jogador);
	}
	
	@Override
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
