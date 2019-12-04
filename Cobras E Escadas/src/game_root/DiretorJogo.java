package game_root;

public class DiretorJogo 
{
    private IBuilderJogo builder;

    DiretorJogo()
    {
        
    }

    protected void setBuilder(IBuilderJogo builder)
    {
        this.builder = builder;
    }
    
    public Jogo construir(int quantidadeJogadores)
    {
        builder.construirJogo(quantidadeJogadores);
        builder.construirMapa(quantidadeJogadores);
        return builder.getJogo();
    }
}