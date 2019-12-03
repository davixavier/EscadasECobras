package game_logic.sorteaveis;

public class SorteadorCasaBonus implements Sorteavel
{
	@Override
	public int sortear()
	{
		int rand = (int)Math.random() * 6 - 3;
		
		if (rand == 0)
			rand = -3;
		
		return rand;
	}
}
