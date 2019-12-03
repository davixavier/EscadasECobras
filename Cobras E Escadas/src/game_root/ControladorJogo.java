package game_root;

public class ControladorJogo 
{
	private Jogo jogo;

	public void iniciarJogoAcao()
	{
		jogo.iniciarJogo();
	}
	
	public void rodarDadosAcao()
	{
		jogo.jogarTurno();
	}
}
