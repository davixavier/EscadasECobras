package game_logic.sorteaveis;

public class DadoD6 implements Sorteavel 
{
	@Override
	public int sortear() 
	{
		return (int) Math.random() * 6;
	}

}
