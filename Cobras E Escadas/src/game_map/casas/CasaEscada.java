package game_map.casas;

public class CasaEscada extends CasaEspecialAbstrata
{
	private int ultimoDegrau;
	
	public CasaEscada(int pos, int ultimo) 
	{
		super(pos);
		this.ultimoDegrau = ultimo;
		cor = "#805f18";
	}

	public int getDestino()
	{
		return this.ultimoDegrau;
	}
}
