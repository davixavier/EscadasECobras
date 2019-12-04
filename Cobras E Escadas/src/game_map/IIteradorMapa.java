package game_map;

public interface IIteradorMapa 
{
	public CasaAbstrata next();
	public boolean hasNext();
	public int index();
	public void reset();
}
