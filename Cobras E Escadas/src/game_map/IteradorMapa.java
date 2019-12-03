package game_map;

import java.util.ArrayList;
import java.util.List;

public class IteradorMapa implements IIteradorMapa
{
	private List<CasaAbstrata> casasCopia;
	private int contador;
	
	public IteradorMapa(List<CasaAbstrata> casas) 
	{
		casasCopia = new ArrayList<CasaAbstrata>(casas.size());
		
		for(CasaAbstrata casa : casas)
		{
			casasCopia.add(casa);
		}
		contador = 0;
	}

	@Override
	public CasaAbstrata next() 
	{
		if (contador >= casasCopia.size())
			return null;
		
		CasaAbstrata casa = casasCopia.get(contador);
		contador++;
		
		return casa;
	}

	@Override
	public boolean hasNext()
	{
		return (contador < casasCopia.size());
	}

}
