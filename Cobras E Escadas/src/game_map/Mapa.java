package game_map;

import java.util.List;

import game_entities.jogador.JogadoresPosicao;

public class Mapa 
{
	private List <CasaAbstrata> casas;
	private JogadoresPosicao jogadoresPosicao;

	// add, get e remove das casas

	public void addCasa(CasaAbstrata novaCasa)
	{
		casas.add(novaCasa);
	}

	public void removeCasa(CasaAbstrata novaCasa)
	{
		casas.remove(novaCasa);
	}
	
	public CasaAbstrata getCasa(int indice)
	{
		return casas.get(indice);
	}
	

	public int getCasaIndice(CasaAbstrata casa) //REVIEW Quem vai usar esse metodo?
	{
		
		return 0;
	}
	
	public IteradorMapa createIterator()
	{
		
		return null;
	}
}
