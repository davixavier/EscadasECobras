package game_entities.jogador;

import java.util.ArrayList;
import java.util.List;

public class IteradorJogador implements IIteradorJogador
{
	private List<Jogador> jogadoresCopia;
	private int contador;
	
	public IteradorJogador(List<Jogador> jogadores)
	{
		contador = 0;
		this.jogadoresCopia = new ArrayList<Jogador>(jogadores.size());
		
		//copiar tudo da lista original para uma copia para n�o afetar a ordem da lista original
		jogadores.forEach(j ->
		{
			jogadoresCopia.add(j);
		});
	}
	
	@Override
	public Jogador next()
	{
		Jogador jogador = jogadoresCopia.get(contador);
		contador++;
		
		//se o contador chegar no �ltimo reiniciar
		if (!hasNext())
		{
			contador = 0;
		}
		
		return jogador; 
	}

	@Override
	public boolean hasNext() 
	{
		return (contador < jogadoresCopia.size());
	}

	@Override
	public Jogador get() 
	{
		return jogadoresCopia.get(contador);
	}

	@Override
	public int nextIndex() 
	{
		return contador+1;
	}
	
}
