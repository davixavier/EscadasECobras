package game_root;

public interface IJogoObservavel 
{
	public void addObservador(IJogoObservador o);
	public void remObservador(IJogoObservador o);
	
	public void updateMapa();
	public void updatePosicoes(MovimentoEvent movimentoEvent);
}
