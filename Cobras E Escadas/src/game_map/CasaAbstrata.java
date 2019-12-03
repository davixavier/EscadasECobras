package game_map;

public abstract class CasaAbstrata 
{
	private int posicao;
	
	public CasaAbstrata(int pos)
	{
		this.posicao = pos;
	}


	public int getPosicao() 
	{
		return posicao;
	}
	
}
