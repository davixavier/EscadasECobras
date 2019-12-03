package game_map;

import java.util.ArrayList;
import java.util.List;

import game_entities.jogador.Jogador;
import game_entities.jogador.JogadoresPosicao;

public class Mapa 
{
	private List <CasaAbstrata> casas;
	private JogadoresPosicao jogadoresPosicao;


	public Mapa()
	{
		this.casas = new ArrayList<CasaAbstrata>();
		this.jogadoresPosicao = new JogadoresPosicao();

		for (int i = 1; i < 101; i++) {
			if(i == 10){
				casas.add(new CasaEscada(i, i+50));
			}else if(i == 66){
				casas.add(new CasaCobra(i, i-65));
			}else if(i == 30){
				casas.add(new CasaBonus(i));
			}else{
				casas.add(new Casa(i));
			}
        }
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
		
		indiceCasaAtual += offset;
		if (indiceCasaAtual < 0)
		{
			indiceCasaAtual = 0;
		}
		else if(indiceCasaAtual > 100)
		{
			indiceCasaAtual = 100;
		}
		
		CasaAbstrata proximaCasa = getCasa(indiceCasaAtual);
		getJogadoresPosicao().setCasaAtual(jogador, proximaCasa);
		
		return indiceCasaAtual;
	}
	
	public int casasSize()
	{
		return casas.size();
	}
}
