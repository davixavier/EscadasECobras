package game_map;

public class CasaCobra extends CasaEspecialAbstrata
{
	int cauda;

	CasaCobra(int pos, int cau) 
	{
		super(pos);
		this.cauda = cau;
	}

	
	public int getDestino()
	{
		return this.cauda;
	}
}
