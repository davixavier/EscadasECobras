package main.app.game_entities.jogador;

//cole��o gen�rica
public interface ICole��o<T>
{
	public void add(T t);
	public void remove(T t);
	public void remove(int index);
	public IIterador<T> createIterator();
}
