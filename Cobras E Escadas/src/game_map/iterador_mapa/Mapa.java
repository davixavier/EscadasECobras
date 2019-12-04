package game_map.iterador_mapa;

import java.util.ArrayList;
import java.util.List;

import game_entities.jogador.Jogador;
import game_entities.jogador.JogadoresPosicao;
import game_map.casas.*;


public class Mapa implements IMapaColecao
{
	private List <CasaAbstrata> casas;
	private JogadoresPosicao jogadoresPosicao;

	public Mapa()
	{
		this.casas = new ArrayList<CasaAbstrata>();
		this.jogadoresPosicao = new JogadoresPosicao();
	}

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
	
	public int getCasaIndice(CasaAbstrata casa)
	{
		return casas.indexOf(casa);
	}

	public JogadoresPosicao getJogadoresPosicao()
	{
		return jogadoresPosicao;
	}
	
	public int moverJogador(Jogador jogador, int offset)
	{
		CasaAbstrata casaAtual = getJogadoresPosicao().getCasaAtual(jogador);
		int indiceCasaAtual = getCasaIndice(casaAtual);
		
		int proximaCasaIndex = indiceCasaAtual + offset;
		if (proximaCasaIndex <= 0)
		{
			proximaCasaIndex = 0;
		}
		else if(proximaCasaIndex >= 99)
		{
			proximaCasaIndex = 99;
		} 
		
		CasaAbstrata proximaCasa = getCasa(proximaCasaIndex);
		if(proximaCasa instanceof CasaEspecialAbstrata)
		{
			CasaEspecialAbstrata proximaCasaEspecial = (CasaEspecialAbstrata)(proximaCasa);
			proximaCasa = getCasa(proximaCasaEspecial.getDestino());
			proximaCasaIndex = getCasaIndice(proximaCasa);
		}
		getJogadoresPosicao().setCasaAtual(jogador, proximaCasa);
		
		return proximaCasaIndex;
	}
	
	public int casasSize()
	{
		return casas.size();
	}
	
	@Override
	public IIteradorMapa createIterator()
	{
		return new IteradorMapaReverso(casas);
	}
}
