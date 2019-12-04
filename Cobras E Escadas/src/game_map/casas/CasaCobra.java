package game_map.casas;

public class CasaCobra extends CasaEspecialAbstrata
{
	private int cauda;

	public CasaCobra(int pos, int cau) 
	{
		super(pos);
		this.cauda = cau;
		cor = "#16632d";
	}

	public int getDestino()
	{
		return this.cauda;
	}
}
