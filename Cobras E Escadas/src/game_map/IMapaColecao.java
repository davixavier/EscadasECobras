package game_map;

public interface IMapaColecao
{
	public void addCasa(CasaAbstrata t);
	public void removeCasa(CasaAbstrata novaCasa);
	public IIteradorMapa createIterator();
}
