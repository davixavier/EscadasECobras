package game_entities.jogador;

//colecao generica
public interface IColecaoJogador
{
	public void add(Jogador t);
	public void remove(Jogador t);
	public void remove(int index);
	public IIteradorJogador createIterator();
}
