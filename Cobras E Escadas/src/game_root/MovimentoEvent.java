package game_root;

public class MovimentoEvent 
{
	private int casaInicial;
	//movimento feito somente pelo dado
	private int movimentoDado;
	//movimento feito por casas especiais
	private int movimentoEspecial;
	//espaço final do movimento
	private int casaFinal;
	private int jogador;
	
	public int getMovimentoDado() 
	{
		return movimentoDado;
	}
	public void setMovimentoDado(int movimentoDado) 
	{
		this.movimentoDado = movimentoDado;
	}
	public int getMovimentoEspecial() 
	{
		return movimentoEspecial;
	}
	public void setMovimentoEspecial(int movimentoEspecial) 
	{
		this.movimentoEspecial = movimentoEspecial;
	}
	public int getCasaFinal() {
		return casaFinal;
	}
	public void setCasaFinal(int casafinal) {
		this.casaFinal = casafinal;
	}
	public int getJogador() {
		return jogador;
	}
	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
	public int getCasaInicial() {
		return casaInicial;
	}
	public void setCasaInicial(int casaInicial) {
		this.casaInicial = casaInicial;
	}
	
	
}
