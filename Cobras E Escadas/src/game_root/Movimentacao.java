package game_root;

import game_entities.jogador.Jogador;
import game_logic.sorteaveis.Sorteavel;
import game_map.iterador_mapa.Mapa;

public class Movimentacao //Movimentacao possui um iterador do mapa e do jogador
{
	private Sorteavel sorteavel;
	
	public Movimentacao(Sorteavel sorteavel) 
	{
		this.sorteavel = sorteavel;
	}
	
	public MovimentoEvent moverJogador(Jogador jogador, Mapa map)
	{
		int offset = sorteavel.sortear();
		
		MovimentoEvent event = new MovimentoEvent();
		event.setCasaInicial(map.getCasaIndice(map.getJogadoresPosicao().getCasaAtual(jogador)));
		event.setMovimentoDado(offset);
		event.setMovimentoEspecial(map.moverJogador(jogador, offset));
		event.setCasaFinal(event.getCasaFinal() + event.getMovimentoDado() + event.getMovimentoEspecial());
		
		return event;
	}
}
