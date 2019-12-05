package game_map.iterador_mapa;

import java.util.ArrayList;
import java.util.List;

import game_map.casas.CasaAbstrata;

public class IteradorMapaReverso implements IIteradorMapa
{
	private List<CasaAbstrata> casasCopia;
	private int contador;
	
	public IteradorMapaReverso(List<CasaAbstrata> casas) 
	{
		casasCopia = new ArrayList<CasaAbstrata>(casas.size());
		
		for(CasaAbstrata casa : casas)
		{
			casasCopia.add(casa);
		}
		contador = casasCopia.size();
	}

	@Override
	public CasaAbstrata next() 
	{
		contador--;
		if (contador < 0)
			return null;
		
		CasaAbstrata casa = casasCopia.get(contador);
		
		return casa;
	}

	@Override
	public boolean hasNext()
	{
		return (contador >= 0);
	}

	@Override
	public int index() 
	{
		return contador;
	}
}
