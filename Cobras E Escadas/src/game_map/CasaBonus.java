package game_map;

public class CasaBonus extends CasaEspecialAbstrata
{
	
	public CasaBonus(int pos)
	{
		super(pos);
	}

	public int getDestino() 
	{
		return (int) Math.random() * 3;
	}
}
