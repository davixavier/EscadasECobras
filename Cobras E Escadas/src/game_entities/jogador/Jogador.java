package game_entities.jogador;

public class Jogador 
{
	//cor em hex
	private String cor;
	
	public Jogador(String cor) 
	{
		this.cor = cor;
	}

	public String getCor() 
	{
		return cor;
	}

	public void setCor(String cor) 
	{
		this.cor = cor;
	}
}
