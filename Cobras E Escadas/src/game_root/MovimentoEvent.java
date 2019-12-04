package game_root;

public class MovimentoEvent 
{
	//movimento feito somente pelo dado
	private int movimentoDado;
	//movimento feito por casas especiais
	private int movimentoEspecial;
	//espaço final do movimento
	private int casafinal;
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
	public int getCasafinal() {
		return casafinal;
	}
	public void setCasafinal(int casafinal) {
		this.casafinal = casafinal;
	}
	public int getJogador() {
		return jogador;
	}
	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
	
	
}
