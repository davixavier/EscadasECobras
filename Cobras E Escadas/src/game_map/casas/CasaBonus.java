package game_map.casas;

public class CasaBonus extends CasaEspecialAbstrata
{
	
	public CasaBonus(int pos)
	{
		super(pos);
		cor = "#bd5a1c";
	}

	@Override
	public int getDestino() 
	{
		return (int) Math.random() * 3;
	}
}
