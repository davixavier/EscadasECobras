package game_root;

public class BuilderJogoConcreto implements IBuilderJogo{

    private Jogo jogo;

    public void construirJogo(int quantidadeJogadores) { 
        
        this.jogo = new Jogo(quantidadeJogadores);
    }

    public Jogo getJogo() {
        return jogo;
    }
}