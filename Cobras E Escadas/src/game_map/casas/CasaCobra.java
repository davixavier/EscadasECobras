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

	@Override
	public int getDestino()
	{
		return this.cauda;
	}
}
