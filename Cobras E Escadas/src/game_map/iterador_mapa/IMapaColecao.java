package game_map.iterador_mapa;

import game_map.casas.CasaAbstrata;

public interface IMapaColecao
{
	public void addCasa(CasaAbstrata t);
	public void removeCasa(CasaAbstrata novaCasa);
	public IIteradorMapa createIterator();
}
