package game_root;

public class DiretorJogo 
{
    private IBuilderJogo builder;

    DiretorJogo(IBuilderJogo builderJogo)
    {
        this.builder = builderJogo;
    }
    
    public Jogo construir(int quantidadeJogadores)
    {
        builder.construirJogo(quantidadeJogadores);
        return builder.getJogo();
    }
}