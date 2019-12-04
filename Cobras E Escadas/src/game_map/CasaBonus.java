package game_map;

public class CasaBonus extends CasaEspecialAbstrata
{
	
	public CasaBonus(int pos)
	{
		super(pos);
		cor = "#bd5a1c";
	}

	public int getDestino() 
	{
		return (int) Math.random() * 3;
	}
}
