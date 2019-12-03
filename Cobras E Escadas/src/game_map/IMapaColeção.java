package game_map;

public interface IMapaColeção
{
	public void addCasa(CasaAbstrata t);
	public void removeCasa(CasaAbstrata novaCasa);
	public IIteradorMapa createIterator();
}
