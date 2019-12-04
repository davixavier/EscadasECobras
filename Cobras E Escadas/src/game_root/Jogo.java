package game_root;

import java.util.ArrayList;
import java.util.List;

import game_entities.jogador.JogadoresCollection;
import game_logic.sorteaveis.DadoD6;
import game_map.Mapa;
import game_map.Movimentacao;

public class Jogo implements IJogoObservavel
{
	private List<IJogoObservador> observadores;
	
	private JogadoresCollection jogadores;
	private Movimentacao movimentacao;
	private ControladorTurno turno;
	private Mapa mapa;
	
	public Jogo(int quantidadeJogadores)
	{
		//Lista de observadores
		jogadores = new JogadoresCollection(quantidadeJogadores);

		this.mapa = new Mapa();
		
		for (int i = 0; i < quantidadeJogadores; i++) {
			mapa.getJogadoresPosicao().setCasaAtual(jogadores.getJogador(i), mapa.getCasa(1));
		}

		movimentacao = new Movimentacao(new DadoD6()); //TODO passar mapa e dado
		
		turno = new ControladorTurno(jogadores.createIterator());
		observadores = new ArrayList<IJogoObservador>();
	}

	protected void setMapa(Mapa map){
		this.mapa = map;
	}

	public JogadoresCollection getJogadores() 
	{
		return jogadores;
	}
	
	public boolean jogarTurno()
	{
		int posicao = movimentacao.moverJogador(turno.passarTurno(), mapa);
		
		return posicao >= 100;
	}

	//M�todos da interface de observavel
	@Override
	public void addObservador(IJogoObservador o)
	{
		observadores.add(o);
	}
	@Override
	public void remObservador(IJogoObservador o)
	{
		observadores.remove(o);
	}
	
	@Override
	public void updateMapa() 
	{
		observadores.forEach(observador ->
		{
			observador.mapaMudado(mapa.createIterator());
		});
	}

	@Override
	public void updatePosicoes()
	{
		observadores.forEach(observador ->
		{
			observador.posicoesMudadas(mapa.getJogadoresPosicao());
		});
	}

	@Override
	public void updateTurno() 
	{
		observadores.forEach(observador ->
		{
			observador.novoTurno(turno.turnoAtual());
		});
	}
}

