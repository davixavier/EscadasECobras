package game_root;

public class ControladorJogo 
{
	private Jogo jogo;
	private DiretorJogo diretor;
	
	public ControladorJogo()
	{
		this.diretor = new DiretorJogo();
		this.diretor.setBuilder(new BuilderJogoConcreto());
	}

	public void comecar(int quantidadeJogadores, JogoUI jogoUI)
	{
		this.jogo = diretor.construir(quantidadeJogadores);
		this.jogo.addObservador(jogoUI);
		
		this.jogo.updateMapa();
		this.jogo.updatePosicoes(null);
	}

	public void iniciarJogoAcao(int quantidadeJogadores, JogoUI jogoUI)
	{
		comecar(quantidadeJogadores, jogoUI);
	}
	
	public void jogarTurnoAcao() 
	{
		jogo.jogarTurno();
	}
	
	public String finalizarJogo()
	{
		
		return "";
	}
}
