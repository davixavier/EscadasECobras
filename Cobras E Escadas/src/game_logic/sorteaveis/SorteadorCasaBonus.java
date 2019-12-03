package game_logic.sorteaveis;

public class SorteadorCasaBonus implements Sorteavel
{
	@Override
	public int sortear()
	{
		return (int)Math.random() * 6 - 3;
	}
}
