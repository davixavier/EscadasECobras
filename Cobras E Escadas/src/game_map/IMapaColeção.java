package game_map;

public interface IMapaCole��o
{
	public void addCasa(CasaAbstrata t);
	public void removeCasa(CasaAbstrata novaCasa);
	public IIteradorMapa createIterator();
}
