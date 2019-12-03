package game_map;

public abstract class CasaEspecialAbstrata extends CasaAbstrata 
{
	public CasaEspecialAbstrata(int pos) 
	{
		super(pos);
	}

	public abstract int getDestino();
}
