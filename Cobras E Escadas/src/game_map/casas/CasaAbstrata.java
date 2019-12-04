package game_map.casas;

public abstract class CasaAbstrata 
{
	protected int posicao;
	protected String cor;
	
	public CasaAbstrata(int pos)
	{
		this.posicao = pos;
		cor = "ffffff";
	}
	
	public String getCor()
	{
		return cor;
	}

	public int getPosicao() 
	{
		return posicao;
	}
	
}
