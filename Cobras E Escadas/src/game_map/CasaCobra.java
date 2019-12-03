package game_map;

public class CasaCobra extends CasaEspecialAbstrata
{
	private int cauda;

	public CasaCobra(int pos, int cau) 
	{
		super(pos);
		this.cauda = cau;
	}

	public int getDestino()
	{
		return this.cauda;
	}
}
