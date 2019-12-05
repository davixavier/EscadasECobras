package game_root;

import java.util.HashMap;
import java.util.List;

public interface IJogoObservador
{
	public void posicoesMudadas(MovimentoEvent movimentoEvent, 
			HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> jogadorPosicoes);
	public void mapaMudado(List<String> coresCasas, List<Integer> destinoCasas);
}
