package game_root;

import java.util.HashMap;

import game_map.iterador_mapa.*;

public interface IJogoObservador
{
	public void posicoesMudadas(HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> jogadorPosicoes);
	public void mapaMudado(IIteradorMapa iIteradorMapa);
	public void novoTurno(String jogadoratual);
}
