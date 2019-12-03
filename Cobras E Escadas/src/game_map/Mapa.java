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
	

	public JogadoresPosicao getJogadoresPosicao()
	{
		return jogadoresPosicao;
	}
	

	public List<CasaAbstrata> getCasas() {
		return casas;
	}

	
	public Movimentacao createIterator()
	{
		
		return null;
	}

}
