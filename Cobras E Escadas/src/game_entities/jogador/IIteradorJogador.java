package game_entities.jogador;

//T generico
public interface IIteradorJogador
{
	public Jogador next();
	public boolean hasNext();
	public Jogador get();
	public int nextIndex();
	public int ciclos();
}
