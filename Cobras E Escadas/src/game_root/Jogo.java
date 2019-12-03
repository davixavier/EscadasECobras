package game_root;

import game_entities.jogador.JogadoresCollection;
import game_logic.sorteaveis.DadoD6;
import game_map.Mapa;
import game_map.Movimentacao;

public class Jogo 
{
	private JogadoresCollection jogadores;
	private Movimentacao movimentacao;
	private ControladorTurno turno;
	private Mapa mapa;
	
	public Jogo(int quantidadeJogadores)
	{
		jogadores = new JogadoresCollection(quantidadeJogadores);

		this.mapa = new Mapa();
		
		for (int i = 0; i < quantidadeJogadores; i++) {
			mapa.getJogadoresPosicao().setCasaAtual(jogadores.getJogador(i), mapa.getCasa(1));
		}

		movimentacao = new Movimentacao(new DadoD6()); //TODO passar mapa e dado
		
		turno = new ControladorTurno(jogadores.createIterator());
		
	}

	public JogadoresCollection getJogadores() 
	{
		return jogadores;
	}

	public void iniciarJogo() 
	{
		
	}
	
	public boolean jogarTurno()
	{
		int posicao = movimentacao.moverJogador(turno.passarTurno(), mapa);
		
		return posicao >= 100;
	}
}

