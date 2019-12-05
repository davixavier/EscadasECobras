package game_map.iterador_mapa;

import game_map.casas.CasaAbstrata;

public interface IIteradorMapa 
{
	public CasaAbstrata next();
	public boolean hasNext();
	public int index();
}
