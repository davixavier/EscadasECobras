package game_entities.jogador;

//colecao generica
public interface IColecao<T>
{
	public void add(T t);
	public void remove(T t);
	public void remove(int index);
	public IIterador<T> createIterator();
}
