package game_map;

public class CasaBonus extends CasaEspecialAbstrata
{
	private int destino;
	
	public CasaBonus(int pos, int des)
	{
		super(pos);
		this.destino = des;
	}

	public int getDestino() 
	{
		return this.destino;
	}
}
