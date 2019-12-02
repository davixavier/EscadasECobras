package game_map;

public class CasaEscada extends CasaEspecialAbstrata
{
	int ultimoDegrau;
	
	CasaEscada(int pos, int ultimo) 
	{
		super(pos);
		this.ultimoDegrau = ultimo;
	}

	public int getDestino()
	{
		return this.ultimoDegrau;
	}
}
