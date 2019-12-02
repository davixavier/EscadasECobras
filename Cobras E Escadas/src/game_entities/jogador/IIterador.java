package main.app.game_entities.jogador;

//T gen�rico
public interface IIterador<T>
{
	public T next();
	public boolean hasNext();
	public T get();
	public int nextIndex();
}
