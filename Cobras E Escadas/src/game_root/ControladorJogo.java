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

	public void comecar(int quantidadeJogadores)
	{
		this.jogo = diretor.construir(quantidadeJogadores);
	}

	public void iniciarJogoAcao()
	{
		
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
