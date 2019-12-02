package game_entities.jogador;

//T generico
public interface IIterador<T>
{
	public T next();
	public boolean hasNext();
	public T get();
	public int nextIndex();
}
