package main.app.game_entities.jogador;

//coleção genérica
public interface IColeção<T>
{
	public void add(T t);
	public void remove(T t);
	public void remove(int index);
	public IIterador<T> createIterator();
}
