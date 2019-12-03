package game_root;

import game_entities.jogador.JogadoresPosicao;
import game_map.IIteradorMapa;

public interface IJogoObservador
{
	public void posicoesMudadas(JogadoresPosicao posicoes);
	public void mapaMudado(IIteradorMapa iIteradorMapa);
	public void novoTurno(String jogadoratual);
}
