package game_root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game_entities.jogador.IIteradorJogador;
import game_entities.jogador.Jogador;
import game_entities.jogador.JogadoresCollection;
import game_logic.sorteaveis.DadoD6;
import game_map.iterador_mapa.*;
import game_root.Movimentacao;

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
		
		movimentacao = new Movimentacao(new DadoD6()); //TODO passar mapa e dado
		
		turno = new ControladorTurno(jogadores.createIterator());
		observadores = new ArrayList<IJogoObservador>();
		
		updateMapa();
		updatePosicoes();
		updateTurno();
	}

	protected void setMapa(Mapa map){
		this.mapa = map;
	}
	protected JogadoresCollection getJogadores() 
	{
		return jogadores;
	}
	
	public boolean jogarTurno()
	{
		int posicao = movimentacao.moverJogador(turno.passarTurno(), mapa);
		updatePosicoes();
		
		return posicao >= 100;
	}

	//M�todos da interface de observavel
	@Override
	public void addObservador(IJogoObservador o)
	{
		observadores.add(o);
		updateMapa();
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
			//Estado
			HashMap<Integer, String> jogadoresCores = new HashMap<>();
			HashMap<Integer, Integer> jogadorPosicoes = new HashMap<>();
			
			IIteradorJogador iteradorJogador = jogadores.createIterator();
			
			//Dar s� uma volta no iterador
			while(iteradorJogador.ciclos() == 0)
			{
				int nextIndex = iteradorJogador.nextIndex();
				Jogador jogador = iteradorJogador.next();
				jogadoresCores.put(nextIndex, jogador.getCor());
				
				//pega a posi��o do jogador em inteiro por meio do mapa
				int casaAtual = mapa.getCasaIndice(mapa.getJogadoresPosicao().getCasaAtual(jogador));
				jogadorPosicoes.put(nextIndex, casaAtual);
			}
			
			observador.posicoesMudadas(jogadoresCores, jogadorPosicoes);
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

