package game_map;

public abstract class CasaAbstrata 
{
	int posicao;
	
	CasaAbstrata(int pos)
	{
		this.posicao = pos;
	}


	public int getPosicao() 
	{
		return posicao;
	}
	
}
