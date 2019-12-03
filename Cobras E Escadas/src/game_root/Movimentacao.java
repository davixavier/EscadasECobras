package game_root;

import game_entities.jogador.Jogador;
import game_logic.sorteaveis.Sorteavel;
import game_map.Mapa;

public class Movimentacao 
{
    private Mapa mapa;
    private Sorteavel dado;
    
    Movimentacao(Mapa map, Sorteavel dice){
        mapa = map;
        dado = dice;
    }

    public void moverJogador(Jogador jogador){
        
    }
}
