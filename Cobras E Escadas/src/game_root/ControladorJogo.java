package game_root;

public class ControladorJogo 
{
	private Jogo jogo;
	private DiretorJogo diretor;
	
	public ControladorJogo()
	{
		this.diretor = new DiretorJogo(new BuilderJogoConcreto());
	}

	public void comecar(int quantidadeJogadores, JogoUI jogoUI)
	{
		this.jogo = diretor.construir(quantidadeJogadores);
		this.jogo.addObservador((IJogoObservador)jogoUI);
	}

	public void iniciarJogoAcao(int quantidadeJogadores, JogoUI jogoUI)
	{
		comecar(quantidadeJogadores, jogoUI);
	}
	
	public boolean rodarDadosAcao()
	{
		
		return true;
	}
	
	public String finalizarJogo()
	{
		
		return "";
	}
}
