package game_root;

public interface IBuilderJogo {
    public void construirJogo(int quantidadeJogadores);
    public void construirMapa();
    public Jogo getJogo();
}